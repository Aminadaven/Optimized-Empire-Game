package agt;

import java.awt.ComponentOrientation;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Game {
	static Vector<Empire> empires;
	static Empire player;
	static Vector<War> wars;
	static Vector<String> flyerAttacked;
	static gui g = new gui();
	static Vector<String> missilesAttacked;
	static Vector<Profile> profiles;
	static int turn = 0;

	public static void main(String[] args) {
		init();
	}

	static void warRemove(Empire emp1, Empire emp2) {
		for (int i = 0; i < wars.size(); i++) {
			War current = wars.get(i);
			if ((current.emp1.equals(emp1) && current.emp2.equals(emp2))
					|| (current.emp1.equals(emp2) && current.emp2.equals(emp1))) {
				wars.remove(current);
				i--;

			}
		}
	}

	static Vector<String> getNames() {
		Vector<String> names = new Vector<String>();
		for (int i = 0; i < profiles.size(); i++) {
			names.add(profiles.get(i).name);
		}
		return names;
	}

	static String[] getNames2() {
		Vector<String> names = new Vector<String>();
		for (int i = 0; i < profiles.size(); i++) {
			names.add(profiles.get(i).name);
		}
		Object[] oNames = names.toArray();
		String[] names2 = new String[names.size()];
		for (int i = 0; i < names2.length; i++) {
			names2[i] = (String) oNames[i];
		}
		return names2;
	}

	static Profile getProfile() {
		// int num = (int) (Math.random() * profiles.size());
		// Profile profile = profiles.get(num);
		// profiles.remove(num);
		Profile profile = profiles.get(0);
		profiles.remove(0);
		return profile;
	}

	static void init(/* int num */) {
		// Matrix.
		turn = 0;
		empires = new Vector<Empire>();
		flyerAttacked = new Vector<String>();
		missilesAttacked = new Vector<String>();
		wars = new Vector<War>();
		initNames();
		Matrix.setEmpires(getNames2());
		int pn = getNames().indexOf((JOptionPane.showInputDialog(g, null, "��� �����", JOptionPane.QUESTION_MESSAGE,
				null, getNames().toArray(), null)));
		Profile p = profiles.get(pn);
		player = new Empire(p);
		profiles.remove(pn);
		empires.add(player);
		int num = profiles.size();
		for (int i = 0; i < num; i++) {
			p = getProfile();
			empires.add(new Empire(p));
		}

		// Matrix.
		update();
		// displayEmpiresHide();
	}

	private static void initNames() {
		profiles = new Vector<Profile>();
		Profile toAdd = new Profile("�����", 7000000, 35000, 0, 0, 0, 0, 20000, 4, 4, 8, 6);
		toAdd.addBorder("�����");
		toAdd.addBorder("����� ���������");
		toAdd.addBorder("����");
		toAdd.addBorder("�����");
		toAdd.addBorder("�����");
		profiles.add(toAdd);
		toAdd = new Profile("�����", 80000000, 80000, 0, 0, 0, 0, 100000, 0, 0, 0, 0);
		toAdd.addBorder("�����");
		toAdd.addBorder("����� ���������");
		profiles.add(toAdd);
		toAdd = new Profile("����� ���������", 2000000, 1000, 0, 0, 0, 0, 2500, 0, 0, 0, 0);
		toAdd.addBorder("�����");
		toAdd.addBorder("�����");
		toAdd.addBorder("����");
		profiles.add(toAdd);
		toAdd = new Profile("�����", 4500000, 8000, 0, 0, 0, 0, 10000, 1, 1, 1, 1);
		toAdd.addBorder("�����");
		toAdd.addBorder("�����");
		profiles.add(toAdd);
		toAdd = new Profile("����", 12000000, 50000, 0, 0, 0, 0, 15000, 1, 2, 1, 2);
		toAdd.addBorder("�����");
		toAdd.addBorder("������");
		toAdd.addBorder("����");
		toAdd.addBorder("�����");
		toAdd.addBorder("����� ���������");
		profiles.add(toAdd);
		toAdd = new Profile("�����", 25000000, 70000, 0, 0, 0, 0, 50000, 2, 2, 1, 3);
		toAdd.addBorder("�����");
		toAdd.addBorder("�����");
		toAdd.addBorder("����");
		toAdd.addBorder("������");
		toAdd.addBorder("�����");
		toAdd.addBorder("����");
		profiles.add(toAdd);
		toAdd = new Profile("������", 24000000, 100000, 0, 0, 0, 0, 200000, 3, 2, 1, 0);
		toAdd.addBorder("����");
		toAdd.addBorder("����");
		toAdd.addBorder("����");
		toAdd.addBorder("�����");
		toAdd.addBorder("����");
		toAdd.addBorder("����� ��������� �������");
		profiles.add(toAdd);
		toAdd = new Profile("����", 20000000, 60000, 0, 0, 0, 0, 80000, 2, 1, 1, 2);
		toAdd.addBorder("������");
		toAdd.addBorder("�����");
		toAdd.addBorder("�����");
		toAdd.addBorder("�����");
		toAdd.addBorder("������");
		toAdd.addBorder("����");
		profiles.add(toAdd);
		toAdd = new Profile("�����", 4000000, 3000, 0, 0, 0, 0, 2000, 0, 0, 0, 0);
		toAdd.addBorder("����");
		profiles.add(toAdd);
		toAdd = new Profile("�����", 30000000, 115000, 0, 0, 0, 0, 250000, 1, 1, 5, 4);
		toAdd.addBorder("������");
		toAdd.addBorder("����");
		toAdd.addBorder("�����");
		profiles.add(toAdd);
		toAdd = new Profile("������", 70000000, 95000, 0, 0, 0, 0, 300000, 2, 2, 3, 3);
		toAdd.addBorder("�����");
		toAdd.addBorder("�����");
		toAdd.addBorder("����");
		profiles.add(toAdd);
		toAdd = new Profile("����� ��������� �������", 3400000, 10000, 0, 0, 0, 0, 40000, 2, 2, 0, 0);
		toAdd.addBorder("������");
		profiles.add(toAdd);
		toAdd = new Profile("����", 2000000, 6000, 0, 0, 0, 0, 200000, 4, 4, 0, 0);
		toAdd.addBorder("������");
		profiles.add(toAdd);
		toAdd = new Profile("����", 10000000, 15000, 0, 0, 0, 0, 12000, 1, 1, 0, 0);
		toAdd.addBorder("������");
		toAdd.addBorder("�����");
		profiles.add(toAdd);
		toAdd = new Profile("�����", 3000000, 12000, 0, 0, 0, 0, 8000, 0, 0, 0, 0);
		toAdd.addBorder("������");
		toAdd.addBorder("����");
		profiles.add(toAdd);
	}

	static void displayEmpiresHide() {
		g.viewo.setText("");
		for (int i = 0; i < empires.size(); i++) {
			view("��: " + empires.get(i).name + " �����: " + empires.get(i).power() + " ���: "
					+ nameNumber100(empires.get(i).cash)
			/*
			 * + " ���� �������: " + empires.get(i).par.rulingAgenda.aggresion +
			 * " ����� ����� ������: " + empires.get(i).par.rulingAgenda.budget
			 * + " ���� �����: " +
			 * empires.get(i).par.rulingAgenda.choosingMethod +
			 * " ���� �������: " + empires.get(i).par.rulingAgenda.extern +
			 * " ����� ������: " +
			 * empires.get(i).par.rulingAgenda.rulerAuthority +
			 * " ���� �������: " + empires.get(i).par.rulingAgenda.serviceLength
			 */);
		}
	}

	static void gameTurn() {
		turn++;

		g.neo.setText("");
		g.nrso.setText("");
		g.nrco.setText("");
		g.nspo.setText("");
		g.ndo.setText("");
		g.nwo.setText("");
		/*
		 * g.neo.setText(""); g.nao.setText(""); g.nro.setText("");
		 * g.ndo.setText("");
		 */
		for (int i = 1; i < empires.size(); i++) {
			empires.get(i).doTurn();
		}
		for (int i = 0; i < wars.size(); i++) {
			War current = wars.get(i);
			current.meleeRound();
			/*
			 * current.emp1.missilesAttack(current.emp2);
			 * current.emp1.flyersAttack(current.emp2);
			 * current.emp2.missilesAttack(current.emp1);
			 * current.emp2.flyersAttack(current.emp1);
			 */
		}
		update();
		// displayEmpiresHide();
		/*
		 * player.par.servingTime++; if (player.par.servingTime >=
		 * player.par.rulingAgenda.serviceLength) { if
		 * (player.par.parties.size() < 3) player.par.addParties(3); Game.eNews(
		 * "������� ������ " + player.name +
		 * " ���� �� ����� ������ ���� �������."); player.par.elections();
		 * Game.eNews("���'��� ����� �� ������ " + player.name +
		 * " ���� �������: " + player.par.rulingAgenda.aggresion +
		 * " ����� ����� ������: " + player.par.rulingAgenda.budget +
		 * " ���� �����: " + player.par.rulingAgenda.choosingMethod +
		 * " ���� �������: " + player.par.rulingAgenda.extern +
		 * " ����� ������: " + player.par.rulingAgenda.rulerAuthority +
		 * " ���� �������: " + player.par.rulingAgenda.serviceLength);
		 * 
		 * player.cash = player.cash - (player.par.members * 25000); Game.eNews(
		 * "������� ������ " + player.name + " �� " + player.par.members +
		 * " �����, ���� ������� ��� ������ " +
		 * Game.nameNumber(player.par.members * 25000)); }
		 */
		g.tabs.setSelectedComponent(g.sviewo);
		// g.newsTabs.setSelectedComponent(g.ne);
		
		  if (player.annexed) init();
		 
		//if (Matrix.getDiploLevelsOf(player.name, -1) > 0)
			//init();
	}

	static void update() {
		player.displayInfo();
		displayEmpiresHide();

		// economy
		g.growingl.setText("����� ��������. ���: " + player.growingLvl + " ���� ������: "
				+ Game.nameNumber100(player.growingCost()));
		g.educationl.setText(
				"�����. ���: " + player.educationLvl + " ���� ������: " + Game.nameNumber100(player.educationCost()));
		g.industryl.setText(
				"�����. ���: " + player.industryLvl + " ���� ������: " + Game.nameNumber100(player.industryCost()));
		g.millitaryIndustryl.setText("����� �����. ���: " + player.millitaryIndustryLvl + " ���� ������: "
				+ Game.nameNumber100(player.millitaryIndustryCost()));
		g.sciencel.setText(
				"���. ���: " + player.scienceLvl + " ���� ������: " + Game.nameNumber100(player.scienceCost()));
		g.cyberl.setText(
				"�����. ���: " + player.cyberTech + " ���� ������: " + Game.nameNumber100(player.cyberTechCost()));
		g.missilesProductionl.setText("����� �����. ���: " + player.missilesProductionLvl + " ���� ������: "
				+ Game.nameNumber100(player.missilesProductionCost()));
		g.mamProductionl.setText("����� ����� ��� �����. ���: " + player.mamProductionLvl + " ���� ������: "
				+ Game.nameNumber100(player.mamProductionCost()));
		g.mofetl.setText("���� ������ ��� ��� (���\"�). ���: " + player.mofetLvl + " ���� ������: "
				+ Game.nameNumber100(player.mofetCost()));

		// special projects
		g.atomicResearchl.setText("���� �����. ���: " + player.atomicResearchLvl + " ���� ������: "
				+ Game.nameNumber100(player.atomicResearchCost()));
		g.nuclearWarheadl.setText("��� ��� ������. ���: " + player.nuclearWarheadLvl + " ���� ������: "
				+ Game.nameNumber100(player.nuclearWarheadCost()));
		g.atomicEnergyl.setText("������ ������. ���: " + player.atomicEnergyLvl + " ���� ������: "
				+ Game.nameNumber100(player.atomicEnergyCost()));
		g.bioWarheadl.setText("��� ��� �������. ���: " + player.bioWarheadLvl + " ���� ������: "
				+ Game.nameNumber100(player.bioWarheadCost()));
		g.chimicWarheadl.setText("��� ��� ����. ���: " + player.chimicWarheadLvl + " ���� ������: "
				+ Game.nameNumber100(player.chimicWarheadCost()));
		g.accurateMissilesl.setText("������ ������ ��������. ���: " + player.accurateMissilesLvl + " ���� ������: "
				+ Game.nameNumber100(player.accurateMissilesCost()));

		// recruiting
		g.tanktf.setText((int) (player.cash / Empire.TANK_COST) + "");
		g.artillerytf.setText((int) (player.cash / Empire.ARTILLERY_COST) + "");
		g.aaSystemtf.setText((int) (player.cash / Empire.AASYSTEM_COST) + "");
		g.planetf.setText((int) (player.cash / Empire.PLANE_COST) + "");
		g.helicoptertf.setText((int) (player.cash / Empire.HELICOPTER_COST) + "");
		g.shiptf.setText((int) (player.cash / Empire.SHIP_COST) + "");
		g.submarinetf.setText((int) (player.cash / Empire.SUBMARINE_COST) + "");
		g.rockettf.setText((int) (player.cash / Empire.ROCKET_COST) + "");
		g.kipatBarzeltf.setText((int) (player.cash / Empire.KIPAT_BARZEL_COST) + "");
		g.flyertf.setText((int) (player.cash / Empire.FLYERS_COST) + "");
		g.kelaDavidtf.setText((int) (player.cash / Empire.KELA_DAVID_COST) + "");
		g.commandotf.setText((int) (player.cash / Empire.COMMANDO_UNIT_COST) + "");
		/*
		 * g.acml.setText(
		 * "��� ������ ������ �������� (���� ��������� ��� ��� 3): " +
		 * player.acmLvl + " /50. ���� ������: " +
		 * nameNumber(player.getAcmLvlCost())); g.gtl.setText(
		 * "��� ��������� �����: " + player.getTechG() + " ���� ������: " +
		 * nameNumber(player.getAdGCost())); g.ttl.setText("��� ����� �����: " +
		 * player.getTechT() + " ���� ������: " +
		 * nameNumber(player.getAdTCost())); g.atl.setText("��� ��������� ���: "
		 * + player.getTechA() + " ���� ������: " +
		 * nameNumber(player.getAdACost())); g.mil.setText("��� ������ ������: "
		 * + player.getMillitaryIndustry() + " ���� ������: " +
		 * nameNumber(player.getProMilCost())); g.al.setText("������ " +
		 * Game.player.getArmy() + ". ���� ���� ��� ����: 100 ���, 1 ��������");
		 * 
		 * g.fl.setText("������ " + Game.player.getFlyers() +
		 * ". ���� ����� ��� ���� �����: 500 ���"); g.kdl.setText("������ " +
		 * Game.player.getKelaDavid() +
		 * ". ���� ����� ��� ����� ��� ���: 200 ���, 3 ��������"); g.ml.setText(
		 * "������ " + Game.player.getMissiles() +
		 * ". ���� ����� ��� ���: 250 ���"); g.kbl.setText( "������ " +
		 * Game.player.getKipatBarzel() +
		 * ". ���� ����� ��� ����� ���� ����: 1000 ���, 10 ��������");
		 * g.recb.setText("���� (������� " + player.getCash() + ")");
		 * g.mb.setText("���� ����� (������� " + (int) (player.getCash() / 2.5)
		 * + ")"); g.kbb.setText("���� ������ ���� ���� (������� " +
		 * player.getCash() / 10 + ")"); g.fb.setText(
		 * "��� ����� ����� (������� " + player.getCash() / 5 + ")");
		 * g.kdb.setText("���� ������ ��� ��� (������� " + player.getCash() / 2
		 * + ")");
		 */

		// war
		g.empb.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		g.model.removeAllElements();
		for (int i = 1; i < empires.size(); i++) {
			g.model.addElement(empires.get(i).name);
		}
		g.empb.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		// diplomacy
		g.empList.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		g.elModel.removeAllElements();
		for (int i = 1; i < empires.size(); i++) {
			g.elModel.addElement(empires.get(i).name);
		}
		g.empList.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		/*
		 * if (player.getTechA() >= 3) { // out("3"); g.ml.setEnabled(true);
		 * g.mtf.setEnabled(true); g.mb.setEnabled(true);
		 * g.matkb.setEnabled(true); g.acml.setEnabled(true);
		 * g.acmb.setEnabled(true); // tabs.setSelectedComponent(war); } if
		 * (player.getTechA() >= 4) { g.kbl.setEnabled(true);
		 * g.kbtf.setEnabled(true); g.kbb.setEnabled(true); //
		 * tabs.setSelectedComponent(war); } if (player.getTechA() >= 5) {
		 * g.fl.setEnabled(true); g.ftf.setEnabled(true); g.fb.setEnabled(true);
		 * g.fatkb.setEnabled(true); // tabs.setSelectedComponent(war); } if
		 * (player.getTechA() >= 6) { g.kdl.setEnabled(true);
		 * g.kdtf.setEnabled(true); g.kdb.setEnabled(true); //
		 * tabs.setSelectedComponent(war); }
		 */
	}

	static String nameNumber(int n) {
		int x = (int) (n / 100.0);
		if (x >= 10000000)
			return (int) (x / 10000000.0) + " �������.";
		if (x >= 10000)
			return (int) (x / 10000.0) + " ������.";
		if (x >= 10)
			return (int) (x / 10.0) + " ���.";
		return x + " ����.";
	}

	static String nameNumber100(int n) {
		// int x = (int) (n / 100.0);
		int x = n;
		if (x >= 10000000)
			return (int) (x / 10000000.0) + " �������.";
		if (x >= 10000)
			return (int) (x / 10000.0) + " ������.";
		if (x >= 10)
			return (int) (x / 10.0) + " ���.";
		return x + " ����.";
	}

	public static void out(String txt) {
		g.neo.setText(g.neo.getText() + "\n" + txt);
	}

	public static void wNews(String str) {
		g.nwo.setText(g.nwo.getText() + "\n" + str);
	}

	public static void dNews(String str) {
		g.ndo.setText(g.ndo.getText() + "\n" + str);
	}

	public static void rsNews(String str) {
		g.nrso.setText(g.nrso.getText() + "\n" + str);
	}

	public static void spNews(String str) {
		g.nspo.setText(g.nspo.getText() + "\n" + str);
	}

	public static void rcNews(String str) {
		g.nrco.setText(g.nrco.getText() + "\n" + str);
	}

	public static void eNews(String str) {
		g.neo.setText(g.neo.getText() + "\n" + str);
	}

	public static void view(String str) {
		g.viewo.setText(g.viewo.getText() + "\n" + str);
	}
	/*
	void obtainNOpen() {
		AudioFormat format = new AudioFormat(0, 0, 0, false, false);
		TargetDataLine line;
		DataLine.Info info = new DataLine.Info(Clip.class, format); // format is an AudioFormat object
		if (!AudioSystem.isLineSupported(info)) {
		    // Handle the error.
		    }
		    // Obtain and open the line.
		try {
		    line = (TargetDataLine) AudioSystem.getLine(info);
		    line.open(format);
		    line.start();
		} catch (LineUnavailableException ex) {
		        // Handle the error.
		    //... 
		}
	}
	*/
}