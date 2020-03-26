package agt;

import java.util.Vector;

public class MarketPlace {
	static Vector<Proposal> proposals;

	/*
	 * public MarketPlace() { }
	 */
	static void initMarketPlace() {
		proposals = new Vector<Proposal>();
	}

	static void sellWeapon(Empire seller, String type, int quantity, int price) {
		proposals.add(new Proposal(seller, type, quantity, price));
	}
	
	static Vector<Proposal> getMissilesPrices() {
		Vector<Proposal> missilePrices = new Vector<Proposal>();
		for(int i = 0; i < proposals.size(); i++) {
			if(proposals.get(i).type.equals("θιμιν")) missilePrices.add(proposals.get(i));
		}
		return missilePrices;
	}
	/*
	static Vector<Proposal> getMissilesPricesExceptWar(Empire me) {
		Vector<Proposal> missilePrices = new Vector<Proposal>();
		for(int i = 0; i < proposals.size(); i++) {
			if(!me.inWar.contains(proposals.get(i).seller))
			if(proposals.get(i).type.equals("θιμιν")) missilePrices.add(proposals.get(i));
		}
		return missilePrices;
	}
	*/
}