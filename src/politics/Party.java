package politics;

public class Party {
	Leader leader;
	int members, modifiers;
	public Party() {
		members = 0;
		modifiers = 0;
		leader = new Leader();
	}
	public Party(int members) {
		this.members = members;
		modifiers = 0;
		leader = new Leader();
	}
}