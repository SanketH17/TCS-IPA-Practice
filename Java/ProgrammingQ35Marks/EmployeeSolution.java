/*

IPA 10

Create a class called Employee with the below attributes:

employeeld - int
name - String
branch - String
rating - double
company Transport - boolean
The above attributes should be private. write getters, setters and parameterized constructor as required.

Create class MyClass with main method.
Implement two static methods findCountOfEmployeesUsingCompTransport and findEmployeeWithSecondHighestRating
in MyClass class.

findCountOfEmployeesUsingCompTransport method: 
----------------------------------------------
This method will take an array of Employee object and a String parameter as input parameters. 
This method will calculate and return the count of Employees who are all using company transport 
in the given branch (String parameter passed).
If no Employee in the given branch using company transport in the array of Employee objects, then 
the method should return 0.

findEmployeeWithSecondHighestRating method: 
--------------------------------------------
This method will take an array of Employee objects as an input parameter. This method will return 
the object of the second highest rating employee from the array of Employee objects who are not using 
company transport.
If all Employees using company transport in the array of Employee objects, then the method should return null.

Note: All the searches should be case sensitive, companyTransport and rating combination of each Employee 
is unique.
For findCountOfEmployeesUsingCompTransport method, The main method should print the returned count as it 
is if the returned value is greater than 0, else it should print "No such Employees".
Ex: 2 , where 2 is the count
For findEmployeeWithSecondHighestRating method: The main method should print the employeeld and name from 
the returned object if the returned value is not null. If the returned value is null, then it should 
print "All Employees using company transport".
Ex: 1003
    Uma
where 1003 is the employeeld and Uma is the name.
Before calling these static methods in main, use Scanner object to read the values of four Employee 
objects referring attributes in the above mentioned attributes sequence. Next, read the value of String
parameter for capturing branch.

Input : 

1001
Ashwa
IT
5
true
1002
Preeti
IT
4
true
1003
Uma
Admin
3
false
1004
Akash
Hardware
4.5
false
IT



Output : 

2
1003
Uma
*/

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