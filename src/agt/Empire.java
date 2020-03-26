package agt;

import java.util.Vector;

import javax.swing.JOptionPane;

import politics.Agenda;
import politics.Parlament;

public class Empire {
	int pop, cash;

	int soldiers, tanks, artillery, aaSystems, planes, helicopters, ships, submarines, rockets, kipatBarzel, flyers,
			kelaDavid, missiles, mam, commandoUnits;

	int soldiersTech, tanksTech, artilleryTech, aaSystemsTech, planesTech, helicoptersTech, shipsTech, submarinesTech,
			rocketsTech, flyersTech, kelaDavidTech, kipatBarzelTech, commandoTech;

	int growingLvl, educationLvl, industryLvl, millitaryIndustryLvl, scienceLvl, cyberTech, missilesProductionLvl,
			mamProductionLvl, mofetLvl;

	int atomicResearchLvl, nuclearWarheadLvl, bioWarheadLvl, chimicWarheadLvl, atomicEnergyLvl, accurateMissilesLvl;

	// army cost
	final static int TANK_COST = 1000;
	final static int ARTILLERY_COST = 1200;
	final static int AASYSTEM_COST = 1500;
	final static int PLANE_COST = 10000;
	final static int HELICOPTER_COST = 7000;
	final static int SHIP_COST = 50000;
	final static int SUBMARINE_COST = 40000;
	final static int ROCKET_COST = 200;
	final static int KIPAT_BARZEL_COST = 20000;
	final static int FLYERS_COST = 650;
	final static int KELA_DAVID_COST = 25000;
	// final static int MISSILES_COST = 1;
	// final static int MAM_COST = 1;
	final static int COMMANDO_UNIT_COST = 3500;

	// army upkeep
	final static int SOLDIER_UPKEEP = 1;
	final static int TANK_UPKEEP = 10;
	final static int ARTILLERY_UPKEEP = 12;
	final static int AASYSTEM_UPKEEP = 15;
	final static int PLANE_UPKEEP = 100;
	final static int HELICOPTER_UPKEEP = 70;
	final static int SHIP_UPKEEP = 500;
	final static int SUBMARINE_UPKEEP = 400;
	// final static int ROCKET_UPKEEP = 1;
	final static int KIPAT_BARZEL_UPKEEP = 200;
	final static int FLYERS_UPKEEP = 7;
	final static int KELA_DAVID_UPKEEP = 250;
	// final static int MISSILES_UPKEEP = 1;
	// final static int MAM_UPKEEP = 1;
	final static int COMMANDO_UNIT_UPKEEP = 35;

	// army tech cost
	final static int SOLDIER_TECH_COST = 100000;
	final static int TANK_TECH_COST = 100000;
	final static int ARTILLERY_TECH_COST = 100000;
	final static int AASYSTEM_TECH_COST = 100000;
	final static int PLANE_TECH_COST = 100000;
	final static int HELICOPTER_TECH_COST = 100000;
	final static int SHIP_TECH_COST = 100000;
	final static int SUBMARINE_TECH_COST = 100000;
	final static int ROCKET_TECH_COST = 100000;
	final static int KIPAT_BARZEL_TECH_COST = 100000;
	final static int FLYERS_TECH_COST = 100000;
	final static int KELA_DAVID_TECH_COST = 100000;
	final static int MISSILES_TECH_COST = 100000;
	final static int MAM_TECH_COST = 100000;
	final static int COMMANDO_UNIT_TECH_COST = 100000;

	// economy tech cost
	final static int GROWING_LVL_COST = 75000;
	final static int EDUCATION_LVL_COST = 75000;
	final static int INDUSTRY_LVL_COST = 175000;
	final static int MILLITARY_INDUSTRY_LVL_COST = 175000;
	final static int SCIENCE_LVL_COST = 200000;
	final static int CYBER_TECH_COST = 175000;
	final static int MISSILES_PRODUCTION_LVL_COST = 400000;
	final static int MAM_PRODUCTION_LVL_COST = 500000;
	final static int MOFET_LVL_COST = 1000000;

	// special projects cost
	final static int ATOMIC_RESEARCH_LVL_COST = 1000000;
	final static int NUCLEAR_WARHEAD_LVL_COST = 1000000;
	final static int ATOMIC_ENERGY_LVL_COST = 1000000;
	final static int BIO_WARHEAD_LVL_COST = 1000000;
	final static int CHIMIC_WARHEAD_LVL_COST = 1000000;
	final static int ACCURATE_MISSILES_LVL_COST = 1000000;

	/*
	 * private int techT; private int techG; private int techA; private int
	 * millitaryIndustry;
	 */
	String name;
	Vector<String> borders = new Vector<String>();
	Parlament par;
	// Vector<Empire> inWar = new Vector<Empire>();
	// Vector<Relation2> relations = new Vector<Relation2>();

	// int bravery;
	boolean annexed = false;
	// int acmLvl = 0;

	/*
	 * public Empire(String name, int pop, int army, int cash) { this.name =
	 * name; this.pop = pop; this.army = army; this.cash = cash; flyers = 0;
	 * kelaDavid = 0; missiles = 0; kipatBarzel = 0; techT = (int)
	 * ((Math.random() * 20000000) / pop); techG = (int) ((Math.random() *
	 * 20000000) / pop); techA = (int) ((Math.random() * 20000000) / pop);
	 * millitaryIndustry = (int) ((Math.random() * 10000000) / pop); bravery =
	 * (int) (Math.random() * 10) - 5; }
	 * 
	 * public Empire(String name, int pop, int army, int cash, Vector<String>
	 * borders) { this.name = name; this.pop = pop; this.army = army; this.cash
	 * = cash; flyers = 0; kelaDavid = 0; missiles = 0; kipatBarzel = 0; techT =
	 * (int) ((Math.random() * 20000000) / pop); techG = (int) ((Math.random() *
	 * 20000000) / pop); techA = (int) ((Math.random() * 20000000) / pop);
	 * millitaryIndustry = (int) ((Math.random() * 10000000) / pop); bravery =
	 * (int) (Math.random() * 10) - 5; this.borders = borders; }
	 * 
	 * public Empire(Profile prof) { this.name = prof.name; this.pop = prof.pop;
	 * this.army = prof.army; this.cash = (int) (prof.cash / 100.0); flyers =
	 * prof.flyers; kelaDavid = prof.kelaDavid; missiles = prof.missiles;
	 * kipatBarzel = prof.kipatBarzel; techT = prof.techT; techG = prof.techG;
	 * techA = prof.techA; millitaryIndustry = prof.millitaryIndustry;
	 * this.borders = prof.borders; bravery = (int) (Math.random() * 10) - 5; if
	 * (name.equals("ישראל")) par = new Parlament(6000000); else par = new
	 * Parlament(pop); }
	 */

	public Empire(Profile prof) {
		this.name = prof.name;
		this.pop = prof.pop;
		cash = 0;
		/*
		 * this.soldiers = prof.soldiers; this.cash = (int) (prof.cash / 100.0);
		 * flyers = prof.flyers; kelaDavid = prof.kelaDavid; missiles =
		 * prof.missiles; kipatBarzel = prof.kipatBarzel; techT = prof.techT;
		 * techG = prof.techG; techA = prof.techA; millitaryIndustry =
		 * prof.millitaryIndustry;
		 */
		this.borders = prof.borders;

		soldiers = 0;
		tanks = 0;
		artillery = 0;
		aaSystems = 0;
		planes = 0;
		helicopters = 0;
		ships = 0;
		submarines = 0;
		rockets = 0;
		flyers = 0;
		missiles = 0;
		mam = 0;
		kelaDavid = 0;
		kipatBarzel = 0;
		commandoUnits = 0;

		soldiersTech = 1;
		tanksTech = 1;
		artilleryTech = 1;
		aaSystemsTech = 1;
		planesTech = 1;
		helicoptersTech = 1;
		shipsTech = 1;
		submarinesTech = 1;
		rocketsTech = 1;
		flyersTech = 1;
		kelaDavidTech = 1;
		kipatBarzelTech = 1;
		commandoTech = 1;

		growingLvl = 1;
		educationLvl = 1;
		industryLvl = 1;
		millitaryIndustryLvl = 1;
		scienceLvl = 1;
		cyberTech = 1;
		missilesProductionLvl = 1;
		mamProductionLvl = 1;
		mofetLvl = 1;

		atomicResearchLvl = 0;
		nuclearWarheadLvl = 0;
		bioWarheadLvl = 0;
		chimicWarheadLvl = 0;
		atomicEnergyLvl = 0;
		accurateMissilesLvl = 0;

		// bravery = (int) (Math.random() * 10) - 5;

		if (name.equals("ישראל"))
			par = new Parlament(6000000);
		else
			par = new Parlament(pop);

	}

	// weapons recruiting
	void recruitTanks(int num) {
		int cost = num * (int) (Empire.TANK_COST * ((100 - millitaryIndustryLvl) / 100.0));
		if (cash < cost) {
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		tanks += num;
		Game.rcNews("מערכת: " + name + " גייסה " + num + " טנקים!");
	}

	void recruitArtillery(int num) {
		int cost = num * (int) (Empire.ARTILLERY_COST * ((100 - millitaryIndustryLvl) / 100.0));
		if (cash < cost) {
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		artillery += num;
		Game.rcNews("מערכת: " + name + " גייסה " + num + " ארטילריה!");
	}

	void recruitAASystems(int num) {
		int cost = num * (int) (Empire.AASYSTEM_COST * ((100 - millitaryIndustryLvl) / 100.0));
		if (cash < cost) {
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		aaSystems += num;
		Game.rcNews("מערכת: " + name + " גייסה " + num + " מערכות הגנה אוירית!");
	}

	void recruitPlanes(int num) {
		int cost = num * (int) (Empire.PLANE_COST * ((100 - millitaryIndustryLvl) / 100.0));
		if (cash < cost) {
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		planes += num;
		Game.rcNews("מערכת: " + name + " גייסה " + num + " מטוסים!");
	}

	void recruitHelicopters(int num) {
		int cost = num * (int) (Empire.HELICOPTER_COST * ((100 - millitaryIndustryLvl) / 100.0));
		if (cash < cost) {
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		helicopters += num;
		Game.rcNews("מערכת: " + name + " גייסה " + num + " מסוקים!");
	}

	void recruitShips(int num) {
		int cost = num * (int) (Empire.SHIP_COST * ((100 - millitaryIndustryLvl) / 100.0));
		if (cash < cost) {
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		ships += num;
		Game.rcNews("מערכת: " + name + " גייסה " + num + " ספינות!");
	}

	void recruitSubmarines(int num) {
		int cost = num * (int) (Empire.SUBMARINE_COST * ((100 - millitaryIndustryLvl) / 100.0));
		if (cash < cost) {
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		submarines += num;
		Game.rcNews("מערכת: " + name + " גייסה " + num + " צוללות!");
	}

	void recruitRockets(int num) {
		int cost = num * (int) (Empire.ROCKET_COST * ((100 - millitaryIndustryLvl) / 100.0));
		if (cash < cost) {
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		rockets += num;
		Game.rcNews("מערכת: " + name + " גייסה " + num + " רקטות!");
	}

	void recruitKipatBarzel(int num) {
		int cost = num * (int) (Empire.KIPAT_BARZEL_COST * ((100 - millitaryIndustryLvl) / 100.0));
		if (cash < cost) {
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		kipatBarzel += num;
		Game.rcNews("מערכת: " + name + " גייסה " + num + " מערכות כיפת ברזל!");
	}

	void recruitFlyers(int num) {
		int cost = num * (int) (Empire.FLYERS_COST * ((100 - millitaryIndustryLvl) / 100.0));
		if (cash < cost) {
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		flyers += num;
		Game.rcNews("מערכת: " + name + " גייסה " + num + " רחפנים!");
	}

	void recruitKelaDavid(int num) {
		int cost = num * (int) (Empire.KELA_DAVID_COST * ((100 - millitaryIndustryLvl) / 100.0));
		if (cash < cost) {
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		kelaDavid += num;
		Game.rcNews("מערכת: " + name + " גייסה " + num + " מערכות קלע דוד!");
	}

	void recruitCommandoUnits(int num) {
		int cost = num * (int) (Empire.COMMANDO_UNIT_COST * ((100 - millitaryIndustryLvl) / 100.0));
		if (cash < cost) {
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		commandoUnits += num;
		Game.rcNews("מערכת: " + name + " גייסה " + num + " יחידות קומנדו!");
	}

	// army upgrading cost
	int soldiersTechCost() {
		return Empire.SOLDIER_TECH_COST * (1 + soldiersTech);
	}

	int tanksTechCost() {
		return Empire.TANK_TECH_COST * (1 + tanksTech);
	}

	int artilleryTechCost() {
		return Empire.ARTILLERY_TECH_COST * (1 + artilleryTech);
	}

	int aaSystemsTechCost() {
		return Empire.AASYSTEM_TECH_COST * (1 + aaSystemsTech);
	}

	int planesTechCost() {
		return Empire.PLANE_TECH_COST * (1 + planesTech);
	}

	int helicoptersTechCost() {
		return Empire.HELICOPTER_TECH_COST * (1 + helicoptersTech);
	}

	int shipsTechCost() {
		return Empire.SHIP_TECH_COST * (1 + shipsTech);
	}

	int submarinesTechCost() {
		return Empire.SUBMARINE_TECH_COST * (1 + submarinesTech);
	}

	int rocketsTechCost() {
		return Empire.ROCKET_TECH_COST * (1 + rocketsTech);
	}

	int kipatBarzelTechCost() {
		return Empire.KIPAT_BARZEL_TECH_COST * (1 + kipatBarzelTech);
	}

	int flyersTechCost() {
		return Empire.FLYERS_TECH_COST * (1 + flyersTech);
	}

	int kelaDavidTechCost() {
		return Empire.KELA_DAVID_TECH_COST * (1 + kelaDavidTech);
	}

	int commandoUnitsTechCost() {
		return Empire.COMMANDO_UNIT_TECH_COST * (1 + commandoTech);
	}

	// economy upgrading cost
	int growingCost() {
		return Empire.GROWING_LVL_COST * (1 + growingLvl);
	}

	int educationCost() {
		return Empire.EDUCATION_LVL_COST * (1 + educationLvl);
	}

	int industryCost() {
		return Empire.INDUSTRY_LVL_COST * (1 + industryLvl);
	}

	int millitaryIndustryCost() {
		return Empire.MILLITARY_INDUSTRY_LVL_COST * (1 + millitaryIndustryLvl);
	}

	int scienceCost() {
		return Empire.SCIENCE_LVL_COST * (1 + scienceLvl);
	}

	int cyberTechCost() {
		return Empire.CYBER_TECH_COST * (1 + cyberTech);
	}

	int missilesProductionCost() {
		return Empire.MISSILES_PRODUCTION_LVL_COST * (1 + missilesProductionLvl);
	}

	int mamProductionCost() {
		return Empire.MAM_PRODUCTION_LVL_COST * (1 + mamProductionLvl);
	}

	int mofetCost() {
		return Empire.MOFET_LVL_COST * (1 + mofetLvl);
	}

	// special projects upgrading cost
	int atomicResearchCost() {
		return Empire.ATOMIC_RESEARCH_LVL_COST * (1 + atomicResearchLvl);
	}

	int nuclearWarheadCost() {
		return Empire.NUCLEAR_WARHEAD_LVL_COST * (1 + nuclearWarheadLvl);
	}

	int bioWarheadCost() {
		return Empire.BIO_WARHEAD_LVL_COST * (1 + bioWarheadLvl);
	}

	int chimicWarheadCost() {
		return Empire.CHIMIC_WARHEAD_LVL_COST * (1 + chimicWarheadLvl);
	}

	int atomicEnergyCost() {
		return Empire.ATOMIC_ENERGY_LVL_COST * (1 + atomicEnergyLvl);
	}

	int accurateMissilesCost() {
		return Empire.ACCURATE_MISSILES_LVL_COST * (1 + accurateMissilesLvl);
	}

	// upgrading army tech
	void upgradeSoldiers() {
		if (cash < soldiersTechCost() || soldiersTech >= 100) {
			return;
		}
		soldiersTech++;
		cash = cash - soldiersTechCost();
		Game.rsNews("מערכת: " + name + " שדרגה את החיילים שלה.");
	}

	void upgradeTanks() {
		if (cash < tanksTechCost() || tanksTech >= 100) {
			return;
		}
		tanksTech++;
		cash = cash - tanksTechCost();
		Game.rsNews("מערכת: " + name + " שדרגה את הטנקים שלה.");
	}

	void upgradeArtillery() {
		if (cash < artilleryTechCost() || artilleryTech >= 100) {
			return;
		}
		artilleryTech++;
		cash = cash - artilleryTechCost();
		Game.rsNews("מערכת: " + name + " שדרגה את הארטילריה שלה.");
	}

	void upgradeAASystems() {
		if (cash < aaSystemsTechCost()) {
			return;
		}
		cash = cash - aaSystemsTechCost();
		Game.rsNews("מערכת: " + name + " שדרגה את מערכות ההגנה האוירית שלה.");
	}

	void upgradePlanes() {
		if (cash < planesTechCost()) {
			return;
		}
		cash = cash - planesTechCost();
		Game.rsNews("מערכת: " + name + " שדרגה את המטוסים שלה.");
	}

	void upgradeHelicopters() {
		if (cash < helicoptersTechCost()) {
			return;
		}
		cash = cash - helicoptersTechCost();
		Game.rsNews("מערכת: " + name + " שדרגה את המסוקים שלה.");
	}

	void upgradeShips() {
		if (cash < shipsTechCost()) {
			return;
		}
		cash = cash - shipsTechCost();
		Game.rsNews("מערכת: " + name + " שדרגה את הספינות שלה.");
	}

	void upgradeSubmarines() {
		if (cash < submarinesTechCost()) {
			return;
		}
		cash = cash - submarinesTechCost();
		Game.rsNews("מערכת: " + name + " שדרגה את הצוללות שלה.");
	}

	void upgradeRockers() {
		if (cash < rocketsTechCost()) {
			return;
		}
		cash = cash - rocketsTechCost();
		Game.rsNews("מערכת: " + name + " שדרגה את הרקטות שלה.");
	}

	void upgradeKipatBarzel() {
		if (cash < kipatBarzelTechCost()) {
			return;
		}
		cash = cash - kipatBarzelTechCost();
		Game.rsNews("מערכת: " + name + " שדרגה את מערכות הכיפת ברזל שלה.");
	}

	void upgradeFlyers() {
		if (cash < flyersTechCost()) {
			return;
		}
		cash = cash - flyersTechCost();
		Game.rsNews("מערכת: " + name + " שדרגה את הרחפנים שלה.");
	}

	void upgradeKelaDavid() {
		if (cash < kelaDavidTechCost()) {
			return;
		}
		cash = cash - kelaDavidTechCost();
		Game.rsNews("מערכת: " + name + " שדרגה את מערכות הקלע דוד שלה.");
	}

	void upgradeCommando() {
		if (cash < commandoUnitsTechCost()) {
			return;
		}
		cash = cash - commandoUnitsTechCost();
		Game.rsNews("מערכת: " + name + " שדרגה את יחידות העילית שלה.");
	}

	// upgrading economy upgrades
	void upgradeGrowing() {
		if (cash < growingCost() || growingLvl >= 100) {
			return;
		}
		growingLvl++;
		cash = cash - growingCost();
		Game.eNews("מערכת: " + name + " פיתחה את צמיחת האוכלוסיה שלה.");
	}

	void upgradeEducation() {
		if (cash < educationCost() || educationLvl >= 100) {
			return;
		}
		educationLvl++;
		cash = cash - educationCost();
		Game.eNews("מערכת: " + name + " פיתחה את מערכת החינוך שלה.");
	}

	void upgradeIndustry() {
		if (cash < industryCost() || industryLvl >= 100) {
			return;
		}
		industryLvl++;
		cash = cash - industryCost();
		Game.eNews("מערכת: " + name + " פיתחה את התעשיה שלה.");
	}

	void upgradeMillitaryIndustry() {
		if (cash < millitaryIndustryCost() || millitaryIndustryLvl >= 100) {
			return;
		}
		millitaryIndustryLvl++;
		cash = cash - millitaryIndustryCost();
		Game.eNews("מערכת: " + name + " פיתחה את התעשיה הצבאית שלה.");
	}

	void upgradeScience() {
		if (cash < scienceCost() || scienceLvl >= 100) {
			return;
		}
		scienceLvl++;
		cash = cash - scienceCost();
		Game.eNews("מערכת: " + name + " פיתחה את המדע והמחקר.");
	}

	void upgradeCyber() {
		if (cash < cyberTechCost() || cyberTech >= 100) {
			return;
		}
		cyberTech++;
		cash = cash - cyberTechCost();
		Game.eNews("מערכת: " + name + " פיתחה את טכנולוגית הסייבר שלה.");
	}

	void upgradeMissilesProduction() {
		if (cash < missilesProductionCost() || missilesProductionLvl >= 100) {
			return;
		}
		missilesProductionLvl++;
		cash = cash - missilesProductionCost();
		Game.eNews("מערכת: " + name + " פיתחה את מפעלי הטילים שלה.");
	}

	void upgradeMamProduction() {
		if (cash < mamProductionCost() || mamProductionLvl >= 100) {
			return;
		}
		mamProductionLvl++;
		cash = cash - mamProductionCost();
		Game.eNews("מערכת: " + name + " פיתחה את מפעלי הטילים נגד טילים שלה.");
	}

	void upgradeMofet() {
		if (cash < mofetCost() || mofetLvl >= 100) {
			return;
		}
		mofetLvl++;
		cash = cash - mofetCost();
		Game.eNews("מערכת: " + name + " השקיעה במחקר ופיתוח כלי נשק.");
	}

	// upgrading special projects
	void researchAtomicResearch() {
		if (cash < atomicResearchCost()) {
			return;
		}
		cash = cash - atomicResearchCost();
		Game.spNews("מערכת: " + name + " השקיעה במחקר אטומי.");
	}

	void researchNuclearWarhead() {
		if (cash < nuclearWarheadCost()) {
			return;
		}
		cash = cash - nuclearWarheadCost();
		Game.spNews("מערכת: " + name + " מפתחת ראשי קרב גרעיניים!");
	}

	void researchBioWarhead() {
		if (cash < bioWarheadCost()) {
			return;
		}
		cash = cash - bioWarheadCost();
		Game.spNews("מערכת: " + name + " מפתחת ראשי קרב ביולוגיים!");
	}

	void researchChimicWarhead() {
		if (cash < chimicWarheadCost()) {
			return;
		}
		cash = cash - chimicWarheadCost();
		Game.spNews("מערכת: " + name + " מפתחת ראשי קרב כימיים!");
	}

	void researchAtomicEnergy() {
		if (cash < atomicEnergyCost()) {
			return;
		}
		cash = cash - atomicEnergyCost();
		Game.spNews("מערכת: " + name + " השקיעה במחקר אנרגיה אטומית.");
	}

	void researchAccurateMissiles() {
		if (cash < accurateMissilesCost()) {
			return;
		}
		cash = cash - accurateMissilesCost();
		Game.spNews("מערכת: " + name + " פיתחה את פרויקט הטילים המדויקים שלה!");
	}

	void economyUpgrading(int amount) {
		int choice = (int) (Math.random() * 9);
		switch (choice) {
		case 0:
			if (amount >= growingCost() && growingLvl < 100)
				upgradeGrowing();
			break;
		case 1:
			if (amount >= educationCost() && educationLvl < 100)
				upgradeEducation();
			break;
		case 2:
			if (amount >= industryCost() && industryLvl < 100)
				upgradeIndustry();
			break;
		case 3:
			if (amount >= millitaryIndustryCost() && millitaryIndustryLvl < 100)
				upgradeMillitaryIndustry();
			break;
		case 4:
			if (amount >= scienceCost() && scienceLvl < 100)
				upgradeScience();
			break;
		case 5:
			if (amount >= cyberTechCost() && cyberTech < 100)
				upgradeCyber();
			break;
		case 6:
			if (amount >= missilesProductionCost() && missilesProductionLvl < 100)
				upgradeMissilesProduction();
			break;
		case 7:
			if (amount >= mamProductionCost() && mamProductionLvl < 100)
				upgradeMamProduction();
			break;
		case 8:
			if (amount >= mofetCost() && mofetLvl < 12)
				upgradeMofet();
			break;
		}
	}

	void specialProjectsInvesting(int amount) {
		int choice = 0;
		if (atomicResearchLvl < 50) {
			choice = (int) (Math.random() * 4);
			switch (choice) {
			case 0:
				if (amount >= atomicResearchCost())
					researchAtomicResearch();
				break;
			case 1:
				if (amount >= bioWarheadCost() && bioWarheadLvl < 35)
					researchBioWarhead();
				break;
			case 2:
				if (amount >= chimicWarheadCost() && chimicWarheadLvl < 20)
					researchChimicWarhead();
				break;
			case 3:
				if (amount >= accurateMissilesCost() && accurateMissilesLvl < 50)
					researchAccurateMissiles();
				break;
			}
		} else {
			choice = (int) (Math.random() * 5);
			switch (choice) {
			case 0:
				if (amount >= nuclearWarheadCost() && nuclearWarheadLvl < 50)
					researchNuclearWarhead();
				break;
			case 1:
				if (amount >= atomicEnergyCost() && atomicEnergyLvl < 50)
					researchAtomicEnergy();
				break;
			case 2:
				if (amount >= bioWarheadCost() && bioWarheadLvl < 35)
					researchBioWarhead();
				break;
			case 3:
				if (amount >= chimicWarheadCost() && chimicWarheadLvl < 20)
					researchChimicWarhead();
				break;
			case 4:
				if (amount >= accurateMissilesCost() && accurateMissilesLvl < 50)
					researchAccurateMissiles();
				break;
			}
		}
	}

	void produceWeaponry(int amount) {
		if (mofetLvl <= 0)
			return;
		int choice = (int) (Math.random() * mofetLvl);
		switch (choice) {
		case 0:
			recruitTanks(Math.min(getIncome() / Empire.TANK_UPKEEP, (amount / (int)(Empire.TANK_COST* ((100 - millitaryIndustryLvl) / 100.0)))));
			break;
		case 1:
			recruitArtillery(Math.min(getIncome() / Empire.ARTILLERY_UPKEEP, (amount / (int)(Empire.ARTILLERY_COST* ((100 - millitaryIndustryLvl) / 100.0)))));
			break;
		case 2:
			recruitRockets(amount / (int)(Empire.ROCKET_COST* ((100 - millitaryIndustryLvl) / 100.0)));
			break;
		case 3:
			recruitFlyers(Math.min(getIncome() / Empire.FLYERS_UPKEEP, (amount / (int)(Empire.FLYERS_COST* ((100 - millitaryIndustryLvl) / 100.0)))));
			break;
		case 4:
			recruitCommandoUnits(
					Math.min(getIncome() / Empire.COMMANDO_UNIT_UPKEEP, (amount / (int)(Empire.COMMANDO_UNIT_COST* ((100 - millitaryIndustryLvl) / 100.0)))));
			break;
		case 5:
			recruitAASystems(Math.min(getIncome() / Empire.AASYSTEM_UPKEEP, (amount / (int)(Empire.AASYSTEM_COST* ((100 - millitaryIndustryLvl) / 100.0)))));
			break;
		case 6:
			recruitHelicopters(Math.min(getIncome() / Empire.HELICOPTER_UPKEEP, (amount / (int)(Empire.HELICOPTER_COST* ((100 - millitaryIndustryLvl) / 100.0)))));
			break;
		case 7:
			recruitPlanes(Math.min(getIncome() / Empire.PLANE_UPKEEP, (amount / (int)(Empire.PLANE_COST* ((100 - millitaryIndustryLvl) / 100.0)))));
			break;
		case 8:
			recruitShips(Math.min(getIncome() / Empire.SHIP_UPKEEP, (amount / (int)(Empire.SHIP_COST* ((100 - millitaryIndustryLvl) / 100.0)))));
			break;
		case 9:
			recruitSubmarines(Math.min(getIncome() / Empire.SUBMARINE_UPKEEP, (amount / (int)(Empire.SUBMARINE_COST* ((100 - millitaryIndustryLvl) / 100.0)))));
			break;
		case 10:
			recruitKipatBarzel(Math.min(getIncome() / Empire.KIPAT_BARZEL_UPKEEP, (amount / (int)(Empire.KIPAT_BARZEL_COST* ((100 - millitaryIndustryLvl) / 100.0)))));
			break;
		case 11:
			recruitKelaDavid(Math.min(getIncome() / Empire.KELA_DAVID_UPKEEP, (amount / (int)(Empire.KELA_DAVID_COST* ((100 - millitaryIndustryLvl) / 100.0)))));
			break;
		}
	}

	void produceWeaponryMax() {
		if (mofetLvl <= 0)
			return;
		int choice = (int) (Math.random() * mofetLvl);
		switch (choice) {
		case 0:
			recruitTanks(cash / Empire.TANK_COST);
			break;
		case 1:
			recruitArtillery(cash / Empire.ARTILLERY_COST);
			break;
		case 2:
			recruitRockets(cash / Empire.ROCKET_COST);
			break;
		case 3:
			recruitFlyers(cash / Empire.FLYERS_COST);
			break;
		case 4:
			recruitCommandoUnits(cash / Empire.COMMANDO_UNIT_COST);
			break;
		case 5:
			recruitAASystems(cash / Empire.AASYSTEM_COST);
			break;
		case 6:
			recruitHelicopters(cash / Empire.HELICOPTER_COST);
			break;
		case 7:
			recruitPlanes(cash / Empire.PLANE_COST);
			break;
		case 8:
			recruitShips(cash / Empire.SHIP_COST);
			break;
		case 9:
			recruitSubmarines(cash / Empire.SUBMARINE_COST);
			break;
		case 10:
			recruitKipatBarzel(cash / Empire.KIPAT_BARZEL_COST);
			break;
		case 11:
			recruitKelaDavid(cash / Empire.KELA_DAVID_COST);
			break;
		}
	}

	void upgradeArmy(int amount) {
		int choice = (int) (Math.random() * (mofetLvl + 1));
		switch (choice) {
		case 0:
			upgradeSoldiers();
			break;
		case 1:
			upgradeTanks();
			break;
		case 2:
			upgradeArtillery();
			break;
		case 3:
			upgradeFlyers();
			break;
		case 4:
			upgradeCommando();
			break;
		case 5:
			upgradeAASystems();
			break;
		case 6:
			upgradeHelicopters();
			break;
		case 7:
			upgradePlanes();
			break;
		case 8:
			upgradeShips();
			break;
		case 9:
			upgradeSubmarines();
			break;
		case 10:
			upgradeKipatBarzel();
			break;
		case 11:
			upgradeKelaDavid();
			break;
		}
	}

	/*
	 * void research(int amount) { if (amount > (int) (cash *
	 * (par.rulingAgenda.budget / 100.0)) && par.rulingAgenda.rulerAuthority <
	 * Agenda.INSIDE_RULER) { Game.eNews("מנהיג מדינת " + name +
	 * "ניסה לפתח את המדינה בסכום שחורג מהתקציב שנקבע בפרלמנט, מאחר שאין לו מספיק סמכויות, הסכום קוזז כדי לעמוד בתקציב."
	 * ); amount = (int) (cash * (par.rulingAgenda.budget / 100.0)); } int
	 * choice = (int) (Math.random() * (5)) + 1; switch (choice) { case 1: if
	 * (getAdGCost() <= amount) { advanceGrow(); return; } else if (getAdTCost()
	 * <= amount) { advanceTax(); return; } else if (getAdACost() <= amount) {
	 * advanceArmy(); return; } else { if (getProMilCost() <= amount) {
	 * produceMillitary(); } return; } case 2: if (getAdTCost() <= amount) {
	 * advanceTax(); return; } else if (getAdACost() <= amount) { advanceArmy();
	 * return;
	 * 
	 * } else if (getAdGCost() <= amount) { advanceGrow(); return; } else { if
	 * (getProMilCost() <= amount) { produceMillitary(); } return; } case 3: if
	 * (getAdACost() <= amount) { advanceArmy(); return; } else if (getAdGCost()
	 * <= amount) { advanceGrow(); return;
	 * 
	 * } else if (getAdTCost() <= amount) { advanceTax(); return; } else { if
	 * (getProMilCost() <= amount) { produceMillitary(); } return; } case 4: if
	 * (getProMilCost() <= amount) { produceMillitary(); return; } else if
	 * (getAdGCost() <= amount) { advanceGrow(); return;
	 * 
	 * } else if (getAdTCost() <= amount) { advanceTax(); return; } else { if
	 * (getAdACost() <= amount) { advanceArmy(); } return; } case 5: if (techA
	 * >= 3 && getAcmLvlCost() <= amount) researchAccurateMissiles(); return; }
	 * }
	 */
	/*
	 * 
	 * void buildMissiles(int num) { if (cash < (int) (num * 2.5)) { return; }
	 * if (num <= 0) return; cash = (int) (cash - (num * 2.5)); missiles += num;
	 * Game.rNews("מערכת: " + name + " ייצרה " + num + " טילים!"); }
	 * 
	 * void buildKipatBarzel(int num) { if (cash < num * 10) { return; } if (pop
	 * < num * 10) { return; } if (num <= 0) return; cash = cash - (num * 10);
	 * pop = pop - (num * 10); kipatBarzel += num; Game.rNews("מערכת: " + name +
	 * " ייצרה " + num + " מערכות כיפת ברזל!"); }
	 * 
	 * void recruitFlyers(int num) { if (cash < num * 5) { return; } if (num <=
	 * 0) return; cash = cash - (num * 5); flyers += num; Game.rNews("מערכת: " +
	 * name + " בנתה " + num + " רחפני תקיפה!"); }
	 * 
	 * void recruitKelaDavid(int num) { if (cash < num * 2) { return; } if (pop
	 * < num * 3) { return; } if (num <= 0) return; cash = cash - (num * 2); pop
	 * = pop - (num * 3); kelaDavid += num; Game.rNews("מערכת: " + name +
	 * " ייצרה " + num + " מערכות קלע דוד!"); }
	 */

	int warsAmount() {
		return Matrix.getDiploLevelsOf(name, 0);
	}

	boolean inWarWith(Empire empire) {
		return Matrix.getRelations(name, empire.name) == 0;
	}

	void doTurn() {
		if (warsAmount() > 0) {
			if (confidentInWar()) {
				upgradeArmy(cash / 4);
				economyUpgrading(cash / 3);
				if (Math.random() > 0.5)
					specialProjectsInvesting(cash / 2);
			} else {
				offerCeaseFireToAll();
				upgradeArmy(cash / 5);
			}
			produceWeaponryMax();
		} else {
			// int ecoBudget = cash / 3;
			// int upgradeBudget = cash / 4;
			// int weaponBudget = (int) (cash * 0.42);
			// int ecoBudget = cash / 3;
			economyUpgrading(cash / 3);
			if (Math.random() > 0.5)
				specialProjectsInvesting(cash / 2);
			upgradeArmy(cash / 4);
			produceWeaponry(cash);

			Empire bem = randomBorderEmpire();
			if (Matrix.getRelations(name, bem.name) != 6) {
				if (bem.militaryPower() < militaryPower() * 0.9) {
					coldRelationsWith(bem);
					if (Math.random() * 100 + 1 > 80) {
						declareWar(bem);
					}
				} else
					warmRelationsWith(bem);
			}
		}
		passTurn();
	}

	/*
	 * void doTurn() { par.servingTime++; if (par.servingTime >=
	 * par.rulingAgenda.serviceLength) { if (par.parties.size() < 3)
	 * par.addParties(3); Game.eNews("הפרלמנט במדינת " + name +
	 * " סיים את תקופת כהונתו ויצא לבחירות."); par.elections(); Game.eNews(
	 * "האג'נדה החדשה של המדינה " + name + " דרגת התקפיות: " +
	 * par.rulingAgenda.aggresion + " אחוזי תקציב לכלכלה: " +
	 * par.rulingAgenda.budget + " שיטת בחירה: " +
	 * par.rulingAgenda.choosingMethod + " דרגת מוחצנות: " +
	 * par.rulingAgenda.extern + " סמכות המנהיג: " +
	 * par.rulingAgenda.rulerAuthority + " אורך הקדנציה: " +
	 * par.rulingAgenda.serviceLength);
	 * 
	 * cash = cash - (par.members * 1000); Game.eNews("בפרלמנט במדינת " + name +
	 * " יש " + par.members + " חברים, ולכן הבחירות עלו למדינה " +
	 * Game.nameNumber(par.members * 1000)); } if (warsAmount() > 0) { if
	 * (confidentInWar()) { research((int) ((cash * (par.rulingAgenda.budget /
	 * 100.0)) / 2.0)); } else { offerCeaseFireToAll(); } produceWeaponry(cash);
	 * } else { research((int) (cash * (par.rulingAgenda.budget / 100.0)));
	 * produceWeaponry(cash);
	 * 
	 * Empire bem; if (par.rulingAgenda.extern == Agenda.AVERAGE_WOLF) { bem =
	 * randomBorderEmpire(); if (Matrix.getRelations(name, bem.name) != 6) {
	 * switch (par.rulingAgenda.aggresion) { case Agenda.AGGRESIVE:
	 * declareWar(bem); break; case Agenda.OFFENSIVE: if (bem.militaryPower() >
	 * militaryPower() * 0.9) { coldRelationsWith(bem); } else if (Math.random()
	 * * 100 + 1 > 20) { declareWar(bem); } break; case Agenda.AVERAGE: if
	 * (bem.militaryPower() < militaryPower() * 0.9) { coldRelationsWith(bem);
	 * if (Math.random() * 100 + 1 > 80) { declareWar(bem); } } else
	 * warmRelationsWith(bem); break; case Agenda.PROTECTIVE: if
	 * (bem.militaryPower() < militaryPower() * 0.5) { coldRelationsWith(bem);
	 * if (Math.random() * 100 + 1 > 90) { declareWar(bem); } } else
	 * warmRelationsWith(bem); break; case Agenda.DEFENSIVE:
	 * warmRelationsWith(bem); break; } } if (par.rulingAgenda.extern ==
	 * Agenda.PACK_WOLF) { bem = randomEmpire(); if (Matrix.getRelations(name,
	 * bem.name) != 6) { switch (par.rulingAgenda.aggresion) { case
	 * Agenda.AGGRESIVE: switch ((int) (Math.random() * 2)) { case 0: if
	 * (getRank() + bravery > 5 && flyers > 0) flyersAttack(bem); break; case 1:
	 * if (Math.random() * 100 > 50 && getRank() + bravery > 7 && missiles > 0)
	 * missilesAttack(bem); break; } break; case Agenda.OFFENSIVE: if
	 * (bem.militaryPower() > militaryPower() * 0.9) { coldRelationsWith(bem); }
	 * else if (Math.random() * 100 + 1 > 20) { switch ((int) (Math.random() *
	 * 2)) { case 0: if (getRank() + bravery > 5 && flyers > 0)
	 * flyersAttack(bem); break; case 1: if (Math.random() * 100 > 50 &&
	 * getRank() + bravery > 7 && missiles > 0) missilesAttack(bem); break; } }
	 * break; case Agenda.AVERAGE: if (bem.militaryPower() < militaryPower() *
	 * 0.9) { coldRelationsWith(bem); if (Math.random() * 100 + 1 > 80) { switch
	 * ((int) (Math.random() * 2)) { case 0: if (getRank() + bravery > 5 &&
	 * flyers > 0) flyersAttack(bem); break; case 1: if (Math.random() * 100 >
	 * 50 && getRank() + bravery > 7 && missiles > 0) missilesAttack(bem);
	 * break; } } } else warmRelationsWith(bem); break; case Agenda.PROTECTIVE:
	 * if (bem.militaryPower() < militaryPower() * 0.5) {
	 * coldRelationsWith(bem); if (Math.random() * 100 + 1 > 90) { switch ((int)
	 * (Math.random() * 2)) { case 0: if (getRank() + bravery > 5 && flyers > 0)
	 * flyersAttack(bem); break; case 1: if (Math.random() * 100 > 50 &&
	 * getRank() + bravery > 7 && missiles > 0) missilesAttack(bem); break; } }
	 * } else warmRelationsWith(bem); break; case Agenda.DEFENSIVE:
	 * warmRelationsWith(bem); break; } } } } } passTurn(); }
	 */
	private void offerCeaseFireToAll() {
		for (int i = 0; i < Game.empires.size(); i++) {
			if (inWarWith(Game.empires.get(i))) {
				if (warmRelationsWith(Game.empires.get(i)))
					Game.warRemove(this, Game.empires.get(i));
			}
		}
	}

	void passTurn() {

		soldiers = soldiers + (millitaryIndustryLvl * 1000);
		pop = pop - (millitaryIndustryLvl * 1000);
		missiles = missiles + (missilesProductionLvl * 10);
		mam = mam + (mamProductionLvl * 10);

		cash = cash + getIncome();
		pop = (int) ((pop) * (1.0001 + (growingLvl / 100.0)));
	}

	int getRank() {
		int rank = 0;
		for (int i = 0; i < Game.empires.size(); i++) {
			if (!Game.empires.get(i).equals(this)) {
				if (Game.empires.get(i).militaryPower() > militaryPower())
					rank--;
				else
					rank++;
			}
		}
		return rank;
	}

	int getNearRank() {
		int rank = 0;
		for (int i = 0; i < borders.size(); i++) {
			if (!borders.get(i).equals(this.name)) {
				Empire emp = getEmpire(borders.get(i));
				if (emp != null) {
					if (emp.militaryPower() > militaryPower())
						rank--;
					else
						rank++;
				}
			}
		}
		return rank;
	}

	/*
	 * int power() { return ((pop / 10) + (soldiers * 10) + (flyers * 500) +
	 * (kelaDavid * 200) + (missiles * 250) + (kipatBarzel * 1000) + cash +
	 * (techT * 400) + (techG * 400) + (techA * 400) + (millitaryIndustry * 650)
	 * + (acmLvl * 320)) / 1000; }
	 */
	int militaryPower() {
		int mPower = soldiers * 10 * soldiersTech + tanks * 50 * tanksTech + artillery * 60 * artilleryTech
				+ aaSystems * 65 * aaSystemsTech + planes * 100 * planesTech + helicopters * 70 * helicoptersTech
				+ ships * 400 * shipsTech + submarines * 500 * submarinesTech + rockets * 3 * rocketsTech
				+ kipatBarzel * 200 * kipatBarzelTech + flyers * 7 * flyersTech + kelaDavid * 250 * kelaDavidTech
				+ missiles + mam + commandoUnits;
		return mPower;
		/*
		 * return ((((soldiers * 10) + (flyers * 500) + (kelaDavid * 200) +
		 * (missiles * 250) + (kipatBarzel * 1000)) techA) + (millitaryIndustry
		 * * 650) + ((acmLvl * 10) * (missiles * 20))) / 1000;
		 */
	}

	Empire getEmpire(String name) {
		for (int i = 0; i < Game.empires.size(); i++) {
			if (Game.empires.get(i).name.equals(name))
				return Game.empires.get(i);
		}
		// System.err.println("debug NOT FOUND - name: " + name + " my name: " +
		// this.name);
		return null;
	}

	private Empire randomEmpire() {
		int num;
		do {
			num = (int) (Math.random() * Game.empires.size());
		} while (num == Game.empires.indexOf(this));
		return Game.empires.get(num);
	}

	private Empire randomBorderEmpire() {
		int num = (int) (Math.random() * borders.size());
		return getEmpire(borders.get(num));
	}

	private boolean confidentInWar() {
		int enemiesPower = 0;
		/*
		 * int num = 0; for(int i=0;i<relations.size();i++){
		 * if(relations.get(i).level == 0) num++; } return num;
		 */

		for (int i = 0; i < Game.empires.size(); i++) {
			if (inWarWith(Game.empires.get(i)))
				enemiesPower += Game.empires.get(i).militaryPower();
			// if(relations.get(i).level == 0) enemiesPower +=
			// relations.get(i).empire.power();
		}
		/*
		 * for (int i = 0; i < inWar.size(); i++) { enemiesPower +=
		 * inWar.get(i).power(); }
		 */
		return militaryPower() > enemiesPower;
	}

	void displayInfo() {
		String b = "";
		for (int i = 0; i < borders.size(); i++) {
			b += borders.get(i) + ", ";
		}
		b = b.substring(0, Math.max(b.length() - 2, 0));
		Game.g.ldata.setText("שם: " + name + " אוכלוסיה: " + pop / 1000000 + " מיליון. כסף: " + Game.nameNumber100(cash)
				+ "\n" + " הכנסה בסיסית: " + Game.nameNumber(basicIncome()) + " אחזקת הצבא: "
				+ Game.nameNumber(upkeep()) + " הכנסה: " + Game.nameNumber100(getIncome()) + "  גבולות: " + b + " תור: "
				+ Game.turn);
	}

	int tradeProfits() {
		int num = 0;
		num = num + (Matrix.getDiploLevelsOf(name, 4) * 2);
		num = num + (Matrix.getDiploLevelsOf(name, 5) * 5);
		num = num + (Matrix.getDiploLevelsOf(name, 6) * 10);
		return num;
	}

	int upkeep() {
		return (soldiers * Empire.SOLDIER_UPKEEP) + (tanks * Empire.TANK_UPKEEP) + (artillery * Empire.ARTILLERY_UPKEEP)
				+ (aaSystems * Empire.AASYSTEM_UPKEEP) + (planes * Empire.PLANE_UPKEEP)
				+ (helicopters * Empire.HELICOPTER_UPKEEP) + (ships * Empire.SHIP_UPKEEP)
				+ (submarines * Empire.SUBMARINE_UPKEEP) + (kipatBarzel * Empire.KIPAT_BARZEL_UPKEEP)
				+ (flyers * Empire.FLYERS_UPKEEP) + (kelaDavid * Empire.KELA_DAVID_UPKEEP)
				+ (commandoUnits * Empire.COMMANDO_UNIT_UPKEEP);
	}

	int basicIncome() {
		return (int) (((pop/* / 50.0 */) * (1 + (educationLvl / 100.0))));
	}

	int industryProfits() {
		return industryLvl * 100000;
	}

	private int getIncome() {
		// int basicIncome = (int) (((pop / 50.0) * (1 + (educationLvl /
		// 100.0))));
		// int industryProfits = industryLvl * 100000;
		int income = (int) ((basicIncome() + industryProfits()) * (1 + (tradeProfits() / 100.0)));
		income = income - upkeep();
		// int income = (int) (basicIncome - soldiers - (flyers * 10) -
		// (kelaDavid * 5) - (kipatBarzel * 25));
		// income = income - (par.members * 100);
		income = (int) (income / 100.0);
		return income;
	}

	/*
	 * int getAdTCost() { return (int) (((Math.pow(pop / 12000.0, techT * 0.3) *
	 * 5) + 20000) / 100.0); }
	 * 
	 * int getAdGCost() { return (int) (((Math.pow(pop / 12000.0, techG * 0.3) *
	 * 5) + 20000) / 100.0); }
	 * 
	 * public int getAdACost() { return (int) (((Math.pow(pop / 12000.0, techA *
	 * 0.3) * 5) + 20000) / 100.0); }
	 * 
	 * public int getProMilCost() { return (int) (((Math.pow(pop / 9000.0,
	 * millitaryIndustry * 0.55) * 7.5) + 75000) / 100.0); }
	 * 
	 * public int getAcmLvlCost() { return (int) (((Math.pow(10, 3 + ((10 -
	 * techA))) * acmLvl) + 100000) / 100.0); }
	 * 
	 * void advanceTax() { int cost = getAdTCost(); if (cash < cost) { if
	 * (this.equals(Game.player)) err("אין לך מספיק כסף!"); return; } cash -=
	 * cost; techT = (techT + 1); Game.eNews("מערכת: " + name +
	 * " פיתחה את טכנולוגית הכלכלה במדינה"); }
	 * 
	 * void advanceGrow() { int cost = getAdGCost(); if (cash < cost) { if
	 * (this.equals(Game.player)) err("אין לך מספיק כסף!"); return; } cash -=
	 * cost; techG = (techG + 1); Game.eNews("מערכת: " + name +
	 * " פיתחה את טכנולוגית הצמיחה במדינה"); }
	 * 
	 * void advanceArmy() { int cost = getAdACost(); if (cash < cost) { if
	 * (this.equals(Game.player)) err("אין לך מספיק כסף!"); return; } cash -=
	 * cost; techA = (techA + 1); Game.eNews("מערכת: " + name +
	 * " פיתחה את טכנולוגית הצבא במדינה"); }
	 * 
	 * void produceMillitary() { int cost = getProMilCost(); if (cash < cost) {
	 * if (this.equals(Game.player)) err("אין לך מספיק כסף!"); return; } cash -=
	 * cost; millitaryIndustry = (millitaryIndustry + 1); Game.eNews("מערכת: " +
	 * name + " פיתחה את התעשיה הצבאית במדינה"); }
	 * 
	 * public void researchAccurateMissiles() { if (acmLvl >= 50) return; int
	 * cost = getAcmLvlCost(); if (cash < cost) { if (this.equals(Game.player))
	 * err("אין לך מספיק כסף!"); return; } cash -= cost; acmLvl = (acmLvl + 1);
	 * Game.eNews("מערכת: " + name +
	 * " פיתחה את פרויקט הטילים המדויקים שלה לשלב: " + acmLvl); }
	 */
	/*
	 * void missilesAttack(Empire def) { if (Matrix.getRelations(name, def.name)
	 * == 6) { return; // peace agreement! } if (missiles <= 0) return; int
	 * defPower = Math.min((int) ((def.kipatBarzel * 10) * (1 + (def.getTechA()
	 * / 10.0))), missiles); missiles -= defPower; int atkPower = Math.max((int)
	 * ((missiles) * (1 + (techA / 10.0))), 0); Game.aNews("מערכת: " + name +
	 * " תקפה באמצעות טילים את " + def.name); Game.aNews("מערכת: ל" + name +
	 * " הופלו " + defPower + " טילים ע\"י מערכות כיפת ברזל של " + def.name); if
	 * (atkPower > 0) { int acc = Math.max(acmLvl * 2, 20); atkPower = (int)
	 * (atkPower * acc / 100.0); int killed = Math.min(def.pop, (int) (atkPower
	 * * 500 * Math.random())); def.pop -= killed; if (def.pop <= 0)
	 * absorb2(def); Game.aNews("מערכת: " + name +
	 * " שיגרה טילים על אזרחי מדינת " + def.name + " שהרגו " + killed +
	 * " אנשים."); if (Math.random() < 0.80 && !def.inWarWith(this) &&
	 * !inWarWith(def)) { def.declareWar(this, name + " שיגרה טילים על אזרחיה!"
	 * ); } missiles = 0; } }
	 * 
	 * void flyersAttack(Empire def) { if (Matrix.getRelations(name, def.name)
	 * == 6) { return; // peace agreement! } if (flyers <= 0) return; int
	 * atkPower = Math.min((int) ((flyers) * (1 + (techA / 10.0))),
	 * def.kelaDavid); int defPower = Math.min((int) ((def.kelaDavid) * (1 +
	 * (def.getTechA() / 10.0))), flyers); flyers -= defPower; def.kelaDavid -=
	 * atkPower; Game.aNews("מערכת: " + name + " תקפה באמצעות רחפנים את " +
	 * def.name); Game.aNews("מערכת: ל" + name + " הופלו " + defPower +
	 * " רחפנים ול" + def.name + " נהרסו " + atkPower + " מערכות קלע דוד."); if
	 * (flyers > 0) { int lvls = Math.max(1, flyers / 4); int actualLvls = 0;
	 * switch ((int) (Math.random() * 5)) { case 0: actualLvls = Math.min(lvls,
	 * def.techG); def.techG -= actualLvls; Game.aNews("מערכת: המדינה " + name +
	 * " תקפה באמצעות רחפנים את טכנולוגית הגדילה במדינת " + def.name +
	 * " והורידה אותה ב" + actualLvls + " שלבים."); break; case 1: actualLvls =
	 * Math.min(lvls, def.techT); def.techT -= actualLvls; Game.aNews(
	 * "מערכת: המדינה " + name +
	 * " תקפה באמצעות רחפנים את טכנולוגית הכלכלה במדינת " + def.name +
	 * " והורידה אותה ב" + actualLvls + " שלבים."); break; case 2: actualLvls =
	 * Math.min(lvls, def.techT); def.techT -= actualLvls; Game.aNews(
	 * "מערכת: המדינה " + name +
	 * " תקפה באמצעות רחפנים את טכנולוגית הצבא במדינת " + def.name +
	 * " והורידה אותה ב" + actualLvls + " שלבים."); break; case 3: actualLvls =
	 * Math.min(lvls, def.millitaryIndustry); def.millitaryIndustry -=
	 * actualLvls; Game.aNews("מערכת: המדינה " + name +
	 * " תקפה באמצעות רחפנים את התעשיה הצבאית במדינת " + def.name +
	 * " והורידה אותה ב" + actualLvls + " שלבים."); break; case 4: actualLvls =
	 * Math.min(lvls, def.kipatBarzel); def.kipatBarzel -= actualLvls;
	 * Game.aNews("מערכת: המדינה " + name +
	 * " תקפה באמצעות רחפנים את מערכות כיפת ברזל במדינת " + def.name + " והרסה "
	 * + actualLvls + " מערכות."); break; } } if (Math.random() < 0.30 &&
	 * !def.inWarWith(this)) { def.declareWar(this, name +
	 * " תקפה אותה באמצעות רחפנים!"); } /* if (Math.random() < 0.30 &&
	 * !def.inWar.contains(this)) { def.declareWar(this, name +
	 * " תקפה אותה באמצעות רחפנים!"); }
	 */
	// }
	// */
	boolean warmRelationsWith(Empire empire) {
		if (Matrix.getRelations(name, empire.name) == 6) {
			return false; // peace agreement!
		}
		if (empire.equals(Game.player)) {
			Object[] options = { "אנו מסכימים. נשמח לשפר את היחסים!",
					" אין סיכוי, המדינה " + this.name + " חלשה מאיתנו!" };
			int n = JOptionPane.showOptionDialog(Game.g,
					" המדינה " + this.name + " מציעה להעלות את רמת היחסים ביניכם. מה דעתך?", "יחסי חוץ",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			// JOptionPane.showOptionDialog(arg0, arg1, arg2, arg3, arg4, arg5,
			// arg6, arg7)
			if (n == JOptionPane.YES_OPTION) {
				Matrix.setRelations(name, empire.name, Matrix.getRelations(name, empire.name) + 1);
				Game.dNews("מערכת: " + name + " שיפרה את יחסיה עם " + empire.name);
				return true;
			} else {
				Game.dNews("מערכת: " + name + " ניסתה לשפר את יחסיה עם " + empire.name
						+ " אך נענתה בסירוב בגלל שהיא חלשה ממנה באופן ניכר.");
				return false;
			}
		}
		if (power() >= empire.power() * 0.9) {
			Matrix.setRelations(name, empire.name, Matrix.getRelations(name, empire.name) + 1);
			Game.dNews("מערכת: " + name + " שיפרה את יחסיה עם " + empire.name);
			return true;
		} else {
			Game.dNews("מערכת: " + name + " ניסתה לשפר את יחסיה עם " + empire.name
					+ " אך נענתה בסירוב בגלל שהיא חלשה ממנה באופן ניכר.");
			return false;
		}
	}

	int power() {
		return militaryPower();
	}

	void coldRelationsWith(Empire empire) {
		if (Matrix.getRelations(name, empire.name) <= 0) {
			return;
		}
		Matrix.setRelations(name, empire.name, Matrix.getRelations(name, empire.name) - 1);
		Game.dNews("מערכת: " + name + " הרעה את יחסיה עם " + empire.name);
		if (Matrix.getRelations(name, empire.name) == 0) {
			declareWar(empire);
		}
	}

	boolean declareWar(Empire def) {
		if (Matrix.getRelations(name, def.name) == 6) {
			return false; // peace agreement!
		}
		if (!borders.contains(def.name))
			return false;
		War nWar = new War(this, def);
		Matrix.setRelations(name, def.name, 0);
		// inWar.add(def);
		// def.inWar.add(this);
		Game.wars.add(nWar);
		Game.wNews("מערכת: " + name + " הכריזה מלחמה על " + def.name);
		// Game.dNews("מערכת: " + name + " הכריזה מלחמה על " + def.name);
		return true;
	}

	void declareWar(Empire def, String reason) {
		if (Matrix.getRelations(name, def.name) == 6) {
			return; // peace agreement!
		}
		/*
		 * flyersAttack(def); missilesAttack(def);
		 */
		if (!borders.contains(def.name))
			return;
		War nWar = new War(this, def);
		Matrix.setRelations(name, def.name, 0);
		// inWar.add(def);
		// def.inWar.add(this);
		Game.wars.add(nWar);
		Game.wNews("מערכת: " + name + " הכריזה מלחמה על " + def.name + " בגלל ש" + reason);
		// Game.dNews("מערכת: " + name + " הכריזה מלחמה על " + def.name + " בגלל
		// ש" + reason);
	}

	void absorb2(Empire los) {
		// if (Matrix.getRelations(name, los.name) == -1)
		// return;
		if (los.annexed)
			return;

		// Matrix.setDiploLevelsOf(los.name, -1);
		los.annexed = true;
		Game.empires.remove(los);

		// wars remove:
		Vector<War> toRemove = new Vector<War>();
		for (int i = 0; i < Game.wars.size(); i++) {
			War cr = Game.wars.get(i);
			if (cr.emp1.equals(los) || cr.emp2.equals(los))
				toRemove.add(cr);
		}

		for (int i = 0; i < toRemove.size(); i++) {
			War cr = toRemove.get(i);
			Game.wars.remove(cr);
			/*
			 * if (cr.emp1.equals(los)) { for (int j = 0; j <
			 * cr.emp2.warsAmount(); j++) { if
			 * (cr.emp2.inWar.get(j).equals(los)) cr.emp2.inWar.remove(j); } }
			 * if (cr.emp2.equals(los)) { for (int j = 0; j <
			 * cr.emp1.warsAmount(); j++) { if
			 * (cr.emp1.inWar.get(j).equals(los)) cr.emp1.inWar.remove(j); } }
			 */
		}
		toRemove.clear();
		Matrix.setDiploLevelsOf(los.name, -1);
		// los.inWar.clear();

		// borders remove:
		for (int i = 0; i < los.borders.size(); i++) {
			Empire emp = getEmpire(los.borders.get(i));
			emp.borders.remove(los.name);
			if (!emp.borders.contains(name))
				emp.borders.add(name);
		}
		for (int i = 0; i < los.borders.size(); i++) {
			if (!borders.contains(los.borders.get(i)) && !stringEquals(los.borders.get(i), name))
				borders.add(los.borders.get(i));
		}
		los.borders.clear();

		for (int i = 0; i < borders.size(); i++) {
			if (borders.get(i).equals(name)) {
				borders.remove(i);
				i--;
			}
		}

		// Absorption
		if (los.pop >= 0) {
			pop += los.pop;
			los.pop = 0;
		}
		if (los.cash >= 0) {
			cash += los.cash;
			los.cash = 0;
		}
		/*
		 * if (los.flyers >= 0) { flyers += los.flyers; los.flyers = 0; } if
		 * (los.kelaDavid >= 0) { kelaDavid += los.kelaDavid; los.kelaDavid = 0;
		 * } if (los.missiles >= 0) { missiles += los.missiles; los.missiles =
		 * 0; } if (los.kipatBarzel >= 0) { kipatBarzel += los.kipatBarzel;
		 * los.kipatBarzel = 0; } if (los.techT > techT) { techT = los.techT;
		 * los.techT = 0; } if (los.techA > techA) { techA = los.techA;
		 * los.techA = 0; } if (los.techG > techG) { techG = los.techG;
		 * los.techG = 0; }
		 */
		// news
		Game.wNews("מערכת: " + name + " כבשה את " + los.name + "!");
		// Game.eNews("מערכת: " + name + " סיפחה את " + los.name + "!");
		Game.dNews("מערכת: " + name + " סיפחה את " + los.name + "!");
		// Finalize
		los = null;
	}

	private boolean stringEquals(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i))
				return false;
		}
		return true;
	}

}