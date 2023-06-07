/* IPA 13 */

import java.util.Scanner;

public class AutonomousCarSolution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		AutonomousCar[] autonomousCars = new AutonomousCar[4];

		for (int i = 0; i < autonomousCars.length; i++) {
			int carId = sc.nextInt();
			String brand = sc.next();
			int noOfTestsConducted = sc.nextInt();
			int noOfTestsPassed = sc.nextInt();
			String environment = sc.next();

			autonomousCars[i] = new AutonomousCar(carId, brand, noOfTestsConducted, noOfTestsPassed, environment);

		}

		String targetEnv = sc.next();
		String targetBrand = sc.next();

		sc.close();

		int noOfTestsPassed = findTestPassedByEnv(autonomousCars, targetEnv);

		if (noOfTestsPassed > 0) {
			System.out.println(noOfTestsPassed);
		} else {
			System.out.println("There are no tests passed in this particular environment");
		}

		AutonomousCar autonomousCar = updateCarGrade(autonomousCars, targetBrand);

		if (autonomousCar != null) {
			System.out.println(autonomousCar.getBrand() + "::" + autonomousCar.getGrade());
		} else {
			System.out.println("No Car is available with the specified brand");
		}
	}

	// findTestPassedByEnv
	public static int findTestPassedByEnv(AutonomousCar[] autonomousCars, String targetEnv) {
		int sumOfTestsPassed = 0;
		for (AutonomousCar aCar : autonomousCars) {
			if (aCar.getEnvironment().equalsIgnoreCase(targetEnv)) {
				sumOfTestsPassed = sumOfTestsPassed + aCar.getNoOfTestsPassed();
			}
		}
		return sumOfTestsPassed;
	}

	/*
	 * updateCarGrade method:
	 * 
	 * This method will take a String parameter brand, along with the array of
	 * AutonomousCar objects. The method will return the autonomousCar object, if
	 * the input String parameter matches with the brand attribute of the
	 * autonomousCar object. Before returning the object, the grade should be
	 * derived based on the rating calculation mentioned below. This grade value
	 * should be assigned to the object. If any of the above conditions are not met,
	 * then the method should return null. The grade attribute should be calculated
	 * as follows: rating = (noOfTestsPassed * 100)/noOfTestsConducted If the rating
	 * > = 80 then grade should be ‘A1’, otherwise the grade should be ‘B2’.
	 */

	public static AutonomousCar updateCarGrade(AutonomousCar[] autonomousCars, String targetBrand) {

		AutonomousCar carwithUpdatedGrade = null;

		for (AutonomousCar autonomousCar : autonomousCars) {
			if (autonomousCar.getBrand().equalsIgnoreCase(targetBrand)) {
				double rating = (double) autonomousCar.getNoOfTestsPassed() * 100
						/ autonomousCar.getNoOfTestsConducted();
				if (rating >= 80) {
					autonomousCar.setGrade("A1");
				} else {
					autonomousCar.setGrade("B2");
				}

				carwithUpdatedGrade = autonomousCar;
				break;
			}
		}
		return carwithUpdatedGrade;
	}

}

class AutonomousCar {
	private int carId;
	private String brand;
	private int noOfTestsConducted;
	private int noOfTestsPassed;
	private String environment;
	private String grade;

	public AutonomousCar(int carId, String brand, int noOfTestsConducted, int noOfTestsPassed, String environment) {
		super();
		this.carId = carId;
		this.brand = brand;
		this.noOfTestsConducted = noOfTestsConducted;
		this.noOfTestsPassed = noOfTestsPassed;
		this.environment = environment;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getNoOfTestsConducted() {
		return noOfTestsConducted;
	}

	public void setNoOfTestsConducted(int noOfTestsConducted) {
		this.noOfTestsConducted = noOfTestsConducted;
	}

	public int getNoOfTestsPassed() {
		return noOfTestsPassed;
	}

	public void setNoOfTestsPassed(int noOfTestsPassed) {
		this.noOfTestsPassed = noOfTestsPassed;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
