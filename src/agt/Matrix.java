package agt;

public abstract class Matrix {

	static int[][] relations;
	// String[] rowTitles, lineTitles;
	static String[] empires;

	static int getDiploLevelsOf(String empire, int lvl) {
		int num = 0;
		for(int i = 0;i<empires.length;i++){
			if(Matrix.getRelations(empire, empires[i]) == lvl) num++;
		}
		return num;
	}
	
	static void setDiploLevelsOf(String empire, int lvl) {
		//int num = 0;
		for(int i = 0;i<empires.length;i++){
			Matrix.setRelations(empire, empires[i], lvl);
		}
		//return num;
	}
	
	static void setEmpires(String... empires) {
		Matrix.empires = empires;
		relations = new int[empires.length][empires.length];
		for (int i = 0; i < relations.length; i++) {
			for (int j = 0; j < relations[i].length; j++) {
				relations[i][j] = 3;
			}
		}
	}

	static int getRelations(String emp1, String emp2) {
		return Math.min(relations[getEmpireNumber(emp1)][getEmpireNumber(emp2)],
				relations[getEmpireNumber(emp2)][getEmpireNumber(emp1)]);
	}

	static void setRelations(String emp1, String emp2, int relation) {
		relations[getEmpireNumber(emp1)][getEmpireNumber(emp2)] = relation;
		relations[getEmpireNumber(emp2)][getEmpireNumber(emp1)] = relation;
	}

	private static int getEmpireNumber(String empire) {
		for (int i = 0; i < empires.length; i++) {
			if (empires[i].equals(empire))
				return i;
		}
		return -1;
	}
}