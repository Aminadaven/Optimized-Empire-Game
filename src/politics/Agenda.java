package politics;

public class Agenda {
	public final static int DEMOCRACY = 0;
	public final static int DEMONARCHY = 1;
	public final static int MONARCHY = 2;

	public final static int ABSOLUTE_RULER = 5;
	public final static int STRONG_RULER = 4;
	public final static int AVERAGE_RULER = 3;
	public final static int OUTSIDE_RULER = 2;
	public final static int INSIDE_RULER = 1;
	public final static int PUPPET_RULER = 0;

	public final static int AGGRESIVE = 5;
	public final static int OFFENSIVE = 4;
	public final static int AVERAGE = 3;
	public final static int PROTECTIVE = 2;
	public final static int DEFENSIVE = 1;

	public final static int PACK_WOLF = 2;
	public final static int AVERAGE_WOLF = 1;
	public final static int LONE_WOLF = 0;

	public int budget, extern, aggresion, choosingMethod, rulerAuthority, serviceLength;

	public Agenda(int budget, int extern, int aggresion, int choosingMethod, int rulerAuthority, int serviceLength) {
		this.budget = budget;
		this.extern = extern;
		this.aggresion = aggresion;
		this.choosingMethod = choosingMethod;
		this.rulerAuthority = rulerAuthority;
		this.serviceLength = serviceLength;
	}

	public static Agenda getRandom() {
		Agenda random = new Agenda((int) (Math.random() * 100), (int) (Math.random() * 2),
				(int) (Math.random() * 5) + 1, (int) (Math.random() * 3), (int) (Math.random() * 5),
				(int) (Math.random() * 96) + 1);
		return random;
	}

	public static Agenda getDefault() {
		Agenda defaultA = new Agenda(50, Agenda.AVERAGE_WOLF, Agenda.AVERAGE, Agenda.DEMOCRACY, Agenda.AVERAGE_RULER,
				1);
		return defaultA;
	}
}