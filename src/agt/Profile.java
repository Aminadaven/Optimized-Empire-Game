package agt;

import java.util.Vector;

public class Profile {
	public int pop, army, flyers, missiles, kelaDavid, kipatBarzel, cash, techT, techG, techA, millitaryIndustry;
	public String name;
	public Vector<String> borders = new Vector<String>();

	// public String name;
	// public int pop;
	// private Vector<String> borders = new Vector<String>();
	public Profile(String name, int pop, int army, int flyers, int missiles, int kelaDavid, int kipatBarzel, int cash,
			int techT, int techG, int techA, int millitaryIndustry) {
		this.name = name;
		this.pop = pop;
		this.army = army;
		this.cash = cash;
		this.flyers = flyers;
		this.kelaDavid = kelaDavid;
		this.missiles = missiles ;
		this.kipatBarzel = kipatBarzel;
		this.techT = techT;
		this.techG = techG;
		this.techA = techA;
		this.millitaryIndustry = millitaryIndustry;
	}

	public void addBorder(String emp) {
		borders.add(emp);
	}

	public Vector<String> getBorders() {
		return borders;
	}
}