package politics;

import java.util.Vector;

import agt.Game;

public class Parlament {
	public int members, servingTime;
	public Vector<Party> parties;
	public Leader ruler;
	public Agenda rulingAgenda;

	public Parlament(int pop) {
		members = pop / 50000;
		servingTime = 0;
		parties = new Vector<Party>();
		addParties(Math.max(15, (pop / 2000000)));
		rulingAgenda = Agenda.getDefault();
		elections();
	}

	public void addParties(int num) {
		int left = members;
		int amount;
		for (int i = 0; i < num - 1; i++) {
			amount = (int) (Math.random() * left);
			parties.add(new Party(amount));
			left -= amount;
		}
		parties.add(new Party(left));
	}

	public void elections() {
		Leader max = null;
		int powerSum = 0, maxPower = 0;
		switch (rulingAgenda.choosingMethod) {
		case Agenda.DEMOCRACY:
			powerSum = 0;
			for (int i = 0; i < parties.size(); i++) {
				int power = parties.get(i).leader.charisma * (1 + (parties.get(i).modifiers / 100));
				powerSum += power;
			}
			for (int i = 0; i < parties.size(); i++) {
				int power = parties.get(i).leader.charisma * (1 + (parties.get(i).modifiers / 100));
				parties.get(i).members = power / powerSum;
			}
			decideRuler();
			decideRulingAgenda();
			break;
		case Agenda.DEMONARCHY:
			powerSum = 0;
			for (int i = 0; i < parties.size(); i++) {
				int power = parties.get(i).leader.charisma * (1 + (parties.get(i).modifiers / 100));
				powerSum += power;
			}
			for (int i = 0; i < parties.size(); i++) {
				int power = parties.get(i).leader.charisma * (1 + (parties.get(i).modifiers / 100));
				parties.get(i).members = power / powerSum;
			}

			max = parties.get(0).leader;
			maxPower = (max.charisma + max.wisdom) * (1 + (parties.get(0).modifiers / 100));
			for (int i = 1; i < parties.size(); i++) {
				int power = (parties.get(i).leader.charisma + parties.get(i).leader.wisdom)
						* (1 + (parties.get(i).modifiers / 100));
				if (power > maxPower) {
					max = parties.get(i).leader;
					maxPower = power;
				}
			}
			ruler = max;
			decideRulingAgenda();
			break;
		case Agenda.MONARCHY:
			int i = 0;
			max = parties.get(i).leader;
			maxPower = (max.charisma + max.wisdom) * (1 + (parties.get(0).modifiers / 100));
			for (i = 1; i < parties.size(); i++) {
				int power = (parties.get(i).leader.charisma + parties.get(i).leader.wisdom)
						* (1 + (parties.get(i).modifiers / 100));
				if (power > maxPower) {
					max = parties.get(i).leader;
					maxPower = power;
				}
			}
			ruler = max;
			rulingAgenda = max.personalAgenda;
			for (int j = 0; j < parties.size(); j++) {
				if (j != i) {
					parties.remove(j);
					j--;
					i--;
				}
			}
			parties.get(0).members = members;
			break;
		}
	}

	private void decideRulingAgenda() {
		voteOnBudget();
		voteOnExtern();
		voteOnAggresion();
		voteOnChoosingMethod();
		voteOnRulerAuthority();
		voteOnServiceLength();
	}

	private void voteOnBudget() {
		for (int i = 0; i < parties.size(); i++) {
			/*
			 * Game.out("ERROR: "+parties.get(i).toString()+" party, "
			 * +parties.get(i).leader+" leader");
			 * Game.out(parties.get(i).leader.personalAgenda+" leader agenda");
			 * Game.out(parties.get(i).leader.personalAgenda.budget+" budget");
			 */
			offerBudget(parties.get(i).leader.personalAgenda.budget);
		}
	}

	private void offerBudget(int budget) {
		int pros = 0, antis = 0;
		for (int i = 0; i < parties.size(); i++) {
			if (budget <= parties.get(i).leader.personalAgenda.budget)
				pros += parties.get(i).members;
			else
				antis += parties.get(i).members;
		}
		if (pros > antis) {
			rulingAgenda.budget = budget;
			Game.eNews("התקציב נקבע ל: " + budget);
		}
	}

	private void voteOnExtern() {
		for (int i = 0; i < parties.size(); i++) {
			offerExtern(parties.get(i).leader.personalAgenda.extern);
		}
	}

	private void offerExtern(int extern) {
		int pros = 0, antis = 0;
		for (int i = 0; i < parties.size(); i++) {
			if (extern <= parties.get(i).leader.personalAgenda.extern)
				pros += parties.get(i).members;
			else
				antis += parties.get(i).members;
		}
		if (pros > antis)
			rulingAgenda.extern = extern;
	}

	private void voteOnAggresion() {
		for (int i = 0; i < parties.size(); i++) {
			offerAggresion(parties.get(i).leader.personalAgenda.aggresion);
		}
	}

	private void offerAggresion(int aggresion) {
		int pros = 0, antis = 0;
		for (int i = 0; i < parties.size(); i++) {
			if (aggresion <= parties.get(i).leader.personalAgenda.aggresion)
				pros += parties.get(i).members;
			else
				antis += parties.get(i).members;
		}
		if (pros > antis)
			rulingAgenda.aggresion = aggresion;
	}

	private void voteOnChoosingMethod() {
		for (int i = 0; i < parties.size(); i++) {
			offerChoosingMethod(parties.get(i).leader.personalAgenda.choosingMethod);
		}
	}

	private void offerChoosingMethod(int choosingMethod) {
		int pros = 0, antis = 0;
		for (int i = 0; i < parties.size(); i++) {
			if (choosingMethod <= parties.get(i).leader.personalAgenda.choosingMethod)
				pros += parties.get(i).members;
			else
				antis += parties.get(i).members;
		}
		if (pros > antis)
			rulingAgenda.choosingMethod = choosingMethod;
	}

	private void voteOnRulerAuthority() {
		for (int i = 0; i < parties.size(); i++) {
			offerRulerAuthority(parties.get(i).leader.personalAgenda.rulerAuthority);
		}
	}

	private void offerRulerAuthority(int rulerAuthority) {
		int pros = 0, antis = 0;
		for (int i = 0; i < parties.size(); i++) {
			if (rulerAuthority <= parties.get(i).leader.personalAgenda.rulerAuthority)
				pros += parties.get(i).members;
			else
				antis += parties.get(i).members;
		}
		if (pros > antis)
			rulingAgenda.rulerAuthority = rulerAuthority;
	}

	private void voteOnServiceLength() {
		for (int i = 0; i < parties.size(); i++) {
			offerServiceLength(parties.get(i).leader.personalAgenda.serviceLength);
		}
	}

	private void offerServiceLength(int length) {
		int pros = 0, antis = 0;
		for (int i = 0; i < parties.size(); i++) {
			if (length <= parties.get(i).leader.personalAgenda.serviceLength)
				pros += parties.get(i).members;
			else
				antis += parties.get(i).members;
		}
		if (pros > antis)
			rulingAgenda.serviceLength = length;
	}

	private void decideRuler() {
		Party maxPower = parties.get(0);
		for (int i = 1; i < parties.size(); i++) {
			if (parties.get(i).members > maxPower.members)
				maxPower = parties.get(i);
		}
		ruler = maxPower.leader;
	}
}