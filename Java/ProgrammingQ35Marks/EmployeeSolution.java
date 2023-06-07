import java.util.Scanner;

public class EmployeeSolution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Employee[] employees = new Employee[4];

		for (int i = 0; i < employees.length; i++) {
			int employeeId = scanner.nextInt();
			String name = scanner.next();
			String branch = scanner.next();
			double rating = scanner.nextDouble();
			boolean companyTransport = scanner.nextBoolean();

			employees[i] = new Employee(employeeId, name, branch, rating, companyTransport);
		}

		String targetBranch = scanner.next();

		scanner.close();

		int count = findCountOfEmployeesUsingCompTransport(employees, targetBranch);
		if (count > 0) {
			System.out.println(count);
		} else {
			System.out.println("No such Employees");
		}

		Employee employeeWithSecondHighestRating = findEmployeeWithSecondHighestRating(employees);

		if (employeeWithSecondHighestRating != null) {
			System.out.println(employeeWithSecondHighestRating.getId());
			System.out.println(employeeWithSecondHighestRating.getName());
		} else {
			System.out.println("All employees using company transport");
		}

	}

	// Method to find the count of Employees using company transport in a given
	// branch
	public static int findCountOfEmployeesUsingCompTransport(Employee[] employees, String branch) {
		int count = 0;
		for (Employee employee : employees) {
			if (employee.getBranch().equals(branch) && employee.isTransport() == true) {
				count++;
			}
		}
		return count;
	}

	// // Method to find the Employee with the second highest rating who is not
	// using company transport
	public static Employee findEmployeeWithSecondHighestRating(Employee[] employees) {
		double maxRating = Double.MIN_VALUE;
		double secondMaxRating = Double.MIN_VALUE;
		Employee highestRatedEmployee = null;
		Employee secondHighestRatedEmployee = null;

		for (Employee employee : employees) {
			if (!employee.isTransport() && employee.getRating() > maxRating) {
				secondMaxRating = maxRating;
				maxRating = employee.getRating();
				secondHighestRatedEmployee = highestRatedEmployee;
				highestRatedEmployee = employee;
			} else if (!employee.isTransport() && employee.getRating() > secondMaxRating) {
				secondMaxRating = employee.getRating();
				secondHighestRatedEmployee = employee;
			}
		}
		return secondHighestRatedEmployee;

	}

}

class Employee {
	private int Id;
	private String name;
	private String branch;
	private double rating;
	private boolean transport;

	public Employee(int id, String name, String branch, double rating, boolean transport) {
		super();
		Id = id;
		this.name = name;
		this.branch = branch;
		this.rating = rating;
		this.transport = transport;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public boolean isTransport() {
		return transport;
	}

	public void setTransport(boolean transport) {
		this.transport = transport;
	}
}