package agt;

public class Proposal {
	Empire seller;
	String type;
	int quantity;
	int price;

	public Proposal(Empire seller, String type, int quantity, int price) {
		this.seller = seller;
		this.type = type;
		this.quantity = quantity;
		this.price = price;
	}
}