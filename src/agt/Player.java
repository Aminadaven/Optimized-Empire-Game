/*
package agt;

import javax.swing.JOptionPane;

public class Player extends Empire {

	public Player(Profile prof) {
		super(prof);
	}
	




	void recruitTanks(int num) {
		int cost = num * Empire.TANK_COST;
		if (cash < cost) {
			err("אין לך מספיק כסף!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		tanks += num;
		Game.rNews("מערכת: " + name + " גייסה " + num + " טנקים!");
	}

	void recruitArtillery(int num) {
		int cost = num * Empire.ARTILLERY_COST;
		if (cash < cost) {
			err("אין לך מספיק כסף!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		artillery += num;
		Game.rNews("מערכת: " + name + " גייסה " + num + " ארטילריה!");
	}

	void recruitAASystems(int num) {
		int cost = num * Empire.AASYSTEM_COST;
		if (cash < cost) {
			err("אין לך מספיק כסף!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		aaSystems += num;
		Game.rNews("מערכת: " + name + " גייסה " + num + " מערכות הגנה אוירית!");
	}

	void recruitPlanes(int num) {
		int cost = num * Empire.PLANE_COST;
		if (cash < cost) {
			err("אין לך מספיק כסף!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		planes += num;
		Game.rNews("מערכת: " + name + " גייסה " + num + " מטוסים!");
	}

	void recruitHelicopters(int num) {
		int cost = num * Empire.HELICOPTER_COST;
		if (cash < cost) {
			err("אין לך מספיק כסף!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		helicopters += num;
		Game.rNews("מערכת: " + name + " גייסה " + num + " מסוקים!");
	}

	void recruitShips(int num) {
		int cost = num * Empire.SHIP_COST;
		if (cash < cost) {
			err("אין לך מספיק כסף!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		ships += num;
		Game.rNews("מערכת: " + name + " גייסה " + num + " ספינות!");
	}

	void recruitSubmarines(int num) {
		int cost = num * Empire.SUBMARINE_COST;
		if (cash < cost) {
			err("אין לך מספיק כסף!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		submarines += num;
		Game.rNews("מערכת: " + name + " גייסה " + num + " צוללות!");
	}

	void recruitRockets(int num) {
		int cost = num * Empire.ROCKET_COST;
		if (cash < cost) {
			err("אין לך מספיק כסף!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		rockets += num;
		Game.rNews("מערכת: " + name + " גייסה " + num + " רקטות!");
	}

	void recruitKipatBarzel(int num) {
		int cost = num * Empire.KIPAT_BARZEL_COST;
		if (cash < cost) {
			err("אין לך מספיק כסף!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		kipatBarzel += num;
		Game.rNews("מערכת: " + name + " גייסה " + num + " מערכות כיפת ברזל!");
	}

	void recruitFlyers(int num) {
		int cost = num * Empire.FLYERS_COST;
		if (cash < cost) {
			err("אין לך מספיק כסף!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		flyers += num;
		Game.rNews("מערכת: " + name + " גייסה " + num + " רחפנים!");
	}

	void recruitKelaDavid(int num) {
		int cost = num * Empire.KELA_DAVID_COST;
		if (cash < cost) {
			err("אין לך מספיק כסף!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		kelaDavid += num;
		Game.rNews("מערכת: " + name + " גייסה " + num + " מערכות קלע דוד!");
	}

	void recruitCommandoUnits(int num) {
		int cost = num * Empire.COMMANDO_UNIT_COST;
		if (cash < cost) {
			err("אין לך מספיק כסף!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		commandoUnits += num;
		Game.rNews("מערכת: " + name + " גייסה " + num + " יחידות קומנדו!");
	}

	void err(String txt) {
		JOptionPane.showMessageDialog(Game.g, txt);
	}
}
*/