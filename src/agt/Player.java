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
			err("��� �� ����� ���!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		tanks += num;
		Game.rNews("�����: " + name + " ����� " + num + " �����!");
	}

	void recruitArtillery(int num) {
		int cost = num * Empire.ARTILLERY_COST;
		if (cash < cost) {
			err("��� �� ����� ���!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		artillery += num;
		Game.rNews("�����: " + name + " ����� " + num + " ��������!");
	}

	void recruitAASystems(int num) {
		int cost = num * Empire.AASYSTEM_COST;
		if (cash < cost) {
			err("��� �� ����� ���!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		aaSystems += num;
		Game.rNews("�����: " + name + " ����� " + num + " ������ ���� ������!");
	}

	void recruitPlanes(int num) {
		int cost = num * Empire.PLANE_COST;
		if (cash < cost) {
			err("��� �� ����� ���!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		planes += num;
		Game.rNews("�����: " + name + " ����� " + num + " ������!");
	}

	void recruitHelicopters(int num) {
		int cost = num * Empire.HELICOPTER_COST;
		if (cash < cost) {
			err("��� �� ����� ���!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		helicopters += num;
		Game.rNews("�����: " + name + " ����� " + num + " ������!");
	}

	void recruitShips(int num) {
		int cost = num * Empire.SHIP_COST;
		if (cash < cost) {
			err("��� �� ����� ���!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		ships += num;
		Game.rNews("�����: " + name + " ����� " + num + " ������!");
	}

	void recruitSubmarines(int num) {
		int cost = num * Empire.SUBMARINE_COST;
		if (cash < cost) {
			err("��� �� ����� ���!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		submarines += num;
		Game.rNews("�����: " + name + " ����� " + num + " ������!");
	}

	void recruitRockets(int num) {
		int cost = num * Empire.ROCKET_COST;
		if (cash < cost) {
			err("��� �� ����� ���!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		rockets += num;
		Game.rNews("�����: " + name + " ����� " + num + " �����!");
	}

	void recruitKipatBarzel(int num) {
		int cost = num * Empire.KIPAT_BARZEL_COST;
		if (cash < cost) {
			err("��� �� ����� ���!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		kipatBarzel += num;
		Game.rNews("�����: " + name + " ����� " + num + " ������ ���� ����!");
	}

	void recruitFlyers(int num) {
		int cost = num * Empire.FLYERS_COST;
		if (cash < cost) {
			err("��� �� ����� ���!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		flyers += num;
		Game.rNews("�����: " + name + " ����� " + num + " ������!");
	}

	void recruitKelaDavid(int num) {
		int cost = num * Empire.KELA_DAVID_COST;
		if (cash < cost) {
			err("��� �� ����� ���!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		kelaDavid += num;
		Game.rNews("�����: " + name + " ����� " + num + " ������ ��� ���!");
	}

	void recruitCommandoUnits(int num) {
		int cost = num * Empire.COMMANDO_UNIT_COST;
		if (cash < cost) {
			err("��� �� ����� ���!");
			return;
		}
		if (num <= 0)
			return;
		cash = cash - cost;
		commandoUnits += num;
		Game.rNews("�����: " + name + " ����� " + num + " ������ ������!");
	}

	void err(String txt) {
		JOptionPane.showMessageDialog(Game.g, txt);
	}
}
*/