package agt;

public class War {
	Empire emp1, emp2;

	public War(Empire emp1, Empire emp2) {
		this.emp1 = emp1;
		this.emp2 = emp2;
	}

	/*
	 * void infantryRound() { if (Matrix.getRelations(emp1.name, emp2.name) ==
	 * -1) { //this.finalize(); Game.wars.remove(this); return; } int emp1Power
	 * = Math.min((int) ((emp1.soldiers / 10.0) * (1 + (emp1.soldiersTech *
	 * 0.1)) * (1 + (emp1.par.ruler.wisdom / 50))), emp2.soldiers); int
	 * emp2Power = Math.min((int) ((emp2.soldiers / 10.0) * (1 +
	 * (emp2.soldiersTech * 0.1)) * (1 + (emp2.par.ruler.wisdom / 50))),
	 * emp1.soldiers); emp1.soldiers=(emp1.soldiers - emp2Power);
	 * emp2.soldiers=(emp2.soldiers - emp1Power); Game.aNews(
	 * "מערכת: בסיבוב הלחימה הנוכחי, ל" + emp1.name + " נהרגו: " + emp2Power +
	 * " חיילים ול" + emp2.name + " נהרגו: " + emp1Power + " חיילים.");
	 * absorbIfPossible(); }
	 * 
	 * void tanksRound() { int emp1Power = Math.min((int) ((emp1.tanks / 10.0) *
	 * (1 + (emp1.tanksTech * 0.1)) * (1 + (emp1.par.ruler.wisdom / 50))),
	 * emp2.tanks); int emp2Power = Math.min((int) ((emp2.tanks / 10.0) * (1 +
	 * (emp2.tanksTech * 0.1)) * (1 + (emp2.par.ruler.wisdom / 50))),
	 * emp1.tanks);
	 * 
	 * emp1.soldiers=(emp1.tanks - emp2Power / 2); emp1.tanks=(emp1.tanks -
	 * emp2Power / 2); emp2.soldiers=(emp2.tanks - emp1Power / 2);
	 * emp2.tanks=(emp2.tanks - emp1Power / 2);
	 * 
	 * Game.aNews("מערכת: בסיבוב הלחימה הנוכחי, ל" + emp1.name + " נהרגו: " +
	 * emp2Power + " חיילים ול" + emp2.name + " נהרגו: " + emp1Power +
	 * " חיילים."); absorbIfPossible(); }
	 */
	void meleeRound() {
		absorbIfPossible();
		if (Matrix.getRelations(emp1.name, emp2.name) == -1) {
			Game.wars.remove(this);
			return;
		}

		int emp1sPower = Math.max(
				(int) ((emp1.soldiers / 10.0) * (1 + (emp1.soldiersTech * 0.1)) * (1 + (emp1.par.ruler.wisdom / 50))),
				0/* emp2.soldiers */);
		int emp2sPower = Math.max(
				(int) ((emp2.soldiers / 10.0) * (1 + (emp2.soldiersTech * 0.1)) * (1 + (emp2.par.ruler.wisdom / 50))),
				0/* emp1.soldiers */);

		int emp1tPower = Math.max(
				(int) ((emp1.tanks / 10.0) * (1 + (emp1.tanksTech * 0.1)) * (1 + (emp1.par.ruler.wisdom / 50))),
				0/* emp2.tanks */);
		int emp2tPower = Math.max(
				(int) ((emp2.tanks / 10.0) * (1 + (emp2.tanksTech * 0.1)) * (1 + (emp2.par.ruler.wisdom / 50))),
				0/* emp1.tanks */);

		int e1tl = (int) (((emp2sPower + emp2tPower) * tanksPercent1()));
		int e1sl = (int) (((emp2sPower + emp2tPower) * (1 - tanksPercent1())));
		int e2tl = (int) (((emp1sPower + emp1tPower) * tanksPercent2()));
		int e2sl = (int) (((emp1sPower + emp1tPower) * (1 - tanksPercent2())));

		emp1.tanks -= e1tl;
		emp1.soldiers -= e1sl;
		emp2.tanks -= e2tl;
		emp2.soldiers -= e2sl;

		Game.wNews("מערכת: בסיבוב הלחימה הנוכחי, ל" + emp1.name + " נהרגו: " + e1sl + " חיילים ו" + e1tl
				+ " טנקים. \n ל" + emp2.name + " נהרגו: " + e2sl + " חיילים ו" + e2tl + " טנקים.");

		absorbIfPossible();
	}

	double tanksPercent1() {
		return emp1.tanks / (emp1.soldiers + emp1.tanks);
	}

	double tanksPercent2() {
		return emp2.tanks / (emp2.soldiers + emp2.tanks);
	}

	void absorbIfPossible() {
		if (absorbCheck1()) {
			emp1.absorb2(emp2);
			return;
		}
		if (absorbCheck2()) {
			emp2.absorb2(emp1);
			return;
		}
	}

	boolean absorbCheck1() {
		return (emp2.soldiers + emp2.tanks <= 0 && emp1.soldiers + emp1.tanks >= 1);
	}

	boolean absorbCheck2() {
		return (emp1.soldiers + emp1.tanks <= 0 && emp2.soldiers + emp2.tanks >= 1);
	}
}