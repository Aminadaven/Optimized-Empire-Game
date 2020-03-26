package politics;

public class Leader {
	String name;
	int charisma;
	public int wisdom;
	int age;
	Agenda personalAgenda;

	public Leader() {
		name = Double.toHexString(Math.random());
		charisma = (int) (Math.random() * 10);
		wisdom = (int) (Math.random() * 10);
		age = 16 + (int) (Math.random() * 30);
		personalAgenda = Agenda.getRandom();
	}
}