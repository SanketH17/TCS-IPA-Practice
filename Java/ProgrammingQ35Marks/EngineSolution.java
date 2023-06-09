/* IPA 20 */

import java.util.Scanner;

public class EngineSolution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Engine[] engines = new Engine[4];

		for (int i = 0; i < engines.length; i++) {
			int engineId = sc.nextInt();
			sc.nextLine();
			String engineName = sc.next();
			String engineType = sc.next();
			double enginePrice = sc.nextDouble();

			engines[i] = new Engine(engineId, engineName, engineType, enginePrice);

		}

		String targetEngType = sc.next();
		String targetEngName = sc.next();

		sc.close();

		int avgPrice = findAvgEnginePriceByType(engines, targetEngType);

		if (avgPrice > 0) {
			System.out.println(avgPrice);
		} else {
			System.out.println("There are no engine with given type");
		}

		Engine[] sortedEngine = searchEngineByName(engines, targetEngName);

		if (sortedEngine != null) {
			for (int i = 0; i < sortedEngine.length; i++) {
				System.out.println(sortedEngine[i].getEngineId());
			}
		} else {
			System.out.println("There are no engine with the given name");
		}

	}

	public static int findAvgEnginePriceByType(Engine[] engines, String etype) {
		int sum = 0;
		int n = 0;
		for (Engine engine : engines) {
			if (engine.getEngineType().equalsIgnoreCase(etype)) {
				sum = sum + (int) engine.getEnginePrice();
				n++;
			}
		}
		if (sum > 0) {
			return sum / n;
		} else {
			return 0;
		}
	}

	public static Engine[] searchEngineByName(Engine[] engines, String eName) {
		int count = 0;
		for (Engine engine : engines) {
			if (engine.getEngineName().equalsIgnoreCase(eName)) {
				count++;
			}
		}
		Engine[] sortedEngines = new Engine[count];
		int index = 0;

		for (int i = 0; i < engines.length; i++) {
			if (engines[i].getEngineName().equalsIgnoreCase(eName)) {
				sortedEngines[index] = engines[i];
				index++;
			}
		}

		// sorting
		for (int i = 0; i < sortedEngines.length - 1; i++) {
			for (int j = 0; j < sortedEngines.length - i - 1; j++) {
				if (sortedEngines[j].getEngineId() > sortedEngines[j + 1].getEngineId()) {
					Engine temp = sortedEngines[j];
					sortedEngines[j] = sortedEngines[j + 1];
					sortedEngines[j + 1] = temp;
				}
			}
		}
		return sortedEngines;

	}

}

class Engine {
	private int engineId;
	private String engineName;
	private String engineType;
	private double enginePrice;

	public Engine(int engineId, String engineName, String engineType, double enginePrice) {
		super();
		this.engineId = engineId;
		this.engineName = engineName;
		this.engineType = engineType;
		this.enginePrice = enginePrice;
	}

	public int getEngineId() {
		return engineId;
	}

	public void setEngineId(int engineId) {
		this.engineId = engineId;
	}

	public String getEngineName() {
		return engineName;
	}

	public void setEngineName(String engineName) {
		this.engineName = engineName;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public double getEnginePrice() {
		return enginePrice;
	}

	public void setEnginePrice(double enginePrice) {
		this.enginePrice = enginePrice;
	}

}