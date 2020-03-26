package agt;

public class Relation {
	Empire emp1, emp2;
	int level;

	public Relation(Empire emp1, Empire emp2, int level) {
		this.emp1 = emp1;
		this.emp2 = emp2;
		this.level = level;
	}
}

class Relation2 {
	Empire empire;
	int level;

	public Relation2(Empire empire, int level) {
		this.empire = empire;
		this.level = level;
	}
}