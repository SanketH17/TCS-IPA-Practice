/* IPA  */
/*

Create a class Institution with below attributes:

institutionId - int
institutionName - String
noOfStudentsPlaced - int
noOfStudentsCleared- int
location - String
grade - String

Write getters, setters for the above attributes.
Create constructor which takes parameter in the above sequence except grade.

Create class Solution with main method.
Implement two static methods - FindNumClearancedByLoc and UpdateInstitutionGrade in Solution class.

FindNumClearancedByLoc method:
----------------------------------------------
This method will take two input parameters - array of Institution objects and string parameter location.
The method will return the sum of the noOfStudentsCleared attribute from institution objects for the location passed as 
parameter. If no institution with the given location is present in the array of institution objects, then the method 
should return 0.

UpdateInstitutionGrade method:
-----------------------------------------------
This method will take a String parameter institutionName, along with the array of Institution objects.
The method will return the institution object, if the input String parameter matches with the institutionName attribute of the institution object. Before returning the object, the grade should be arrived based on the rating calculation mentioned below. 
This grade value should be assigned to the object.If any of the above conditions are not met, then the method should return 
null.

* The grade attribute should be calculated as follows:

Rating=(noOfStudentsPlaced * 100)/noOfStudentsCleared
If the rating >= 80 , then grade should be 'A'.
Else, then grade should be 'B'

**Note:**
--------------------------------------------
No institution object would have the same value for institutionName attribute.
All institution object would have the noOfStudentsPlaced value lesser than noOfStudentsCleared value.
All the searches should be case insensitive.

The above mentioned static methods should be called from the main method.

For FindNumClearancedByLoc method - The main method should print the noOfClearance as it is, if the returned value is 
greater than 0, or it should print "There are no cleared students in this particular location".

For UpdateInstitutionGrade method - The main method should print the institutionName and grade of the returned Institution 
object. The instituationName and grade should be concatinated with :: while printing. eg:- TCS::A, where TCS is the 
institution name and A is the grade.
If the returned value is nullthen it should print "No Institute is available with the specified name".

Before calling these static methods in main, use Scanner object to read the values of four Phone objects referring attributes 
in the above mentioned attribute sequence (except grade attribute). Next, read the value for location and institutionName.

Input
-------------------------------------------
111
Amrita
5000
10000
Chennai
222
Karunya
16000
20000
Coimbatore
333
AppleTech
10000
12000
Chennai
444
Aruna
6000
10000
Vellore
Chennai
Karunya

Output
----------------------------------------
22000
Karunya::A


*/


import java.util.*;

public class InstitutionSolution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Institution[] insti = new Institution[4];
		for (int i = 0; i < insti.length; i++) {
			int institutionId = sc.nextInt();
			sc.nextLine();
			String instName = sc.next();
			int noOfStudPlaced = sc.nextInt();
			int noOfStudCleared = sc.nextInt();
			String location = sc.next();

			insti[i] = new Institution(institutionId, instName, noOfStudPlaced, noOfStudCleared, location);
		}

		String loc = sc.next();
		String nameInst = sc.next();

		sc.close();

		int sum = FindNumClearancedByLoc(insti, loc);
		if (sum > 0) {
			System.out.println(sum);
		} else {
			System.out.println("There are no cleared students in this particular location");
		}

		Institution instObject = UpdateInstitutionGrade(insti, nameInst);

		if (instObject != null) {
			System.out.println(instObject.getInstName() + "::" + instObject.getgrade());
		} else {
			System.out.println("No Institute is available with the specified name");
		}
	}

	public static int FindNumClearancedByLoc(Institution[] inst, String loc) {

		int sum = 0;
		for (Institution i : inst) {
			if (i.getlocation().equalsIgnoreCase(loc)) {
				sum = sum + i.getnoOfStudCleared();
			}
		}
		if (sum > 0) {
			return sum;
		} else {
			return 0;
		}

	}

	public static Institution UpdateInstitutionGrade(Institution[] inst, String instName) {
		Institution ansInst = null;

		for (Institution i : inst) {
			if (i.getInstName().equalsIgnoreCase(instName)) {
				int rating = (i.getnoOfStudPlaced() * 100) / i.getnoOfStudCleared();
				if (rating >= 80) {
					i.setgrade("A");

				} else {
					i.setgrade("B");
				}
				ansInst = i;
				break;
			}
		}
		return ansInst;

	}

}

class Institution {
	private int institutionId;
	private String instName;
	private int noOfStudPlaced;
	private int noOfStudCleared;
	private String location;
	private String grade;

	// constructor
	public Institution(int institutionId, String instName, int noOfStudPlaced, int noOfStudCleared, String location) {
		super();
		this.institutionId = institutionId;
		this.instName = instName;
		this.noOfStudPlaced = noOfStudPlaced;
		this.noOfStudCleared = noOfStudCleared;
		this.location = location;

	}

	// getters and setters
	public int getInstId() {
		return this.institutionId;
	}

	public void set(int instId) {
		this.institutionId = instId;
	}

	public String getInstName() {
		return this.instName;
	}

	public void setInstName(String name) {
		this.instName = name;
	}

	// noOfStudPlaced
	public int getnoOfStudPlaced() {
		return this.noOfStudPlaced;
	}

	public void setnoOfStudPlaced(int noOfStudPlaced) {
		this.noOfStudPlaced = noOfStudPlaced;
	}

	// noOfStudCleared
	public int getnoOfStudCleared() {
		return this.noOfStudCleared;
	}

	public void setnoOfStudCleared(int noOfStudCleared) {
		this.noOfStudCleared = noOfStudCleared;
	}

	// location
	public String getlocation() {
		return this.location;
	}

	public void setlocation(String location) {
		this.location = location;
	}

	// grade
	public String getgrade() {
		return this.grade;
	}

	public void setgrade(String grade) {
		this.grade = grade;
	}

}