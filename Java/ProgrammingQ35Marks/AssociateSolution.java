/* IPA 22 */
/*
 
Create class Associate with below attributes:
id - int
name - String
technology - String
experienceInYears - int

Create class Solution and implement static method "associatesForGivenTechnology" in the Solution class.
This method will take array of Associate objects and a searchTechnology String as parameters.
And will return another array of Associate objects where the searchTechnology String matches with the original array of Associate object's technology attribute (case insensitive search) and experienceInYears attribute should be multiples of 5.

Write necessary getters and setters.

Before calling "associatesForGivenTechnology" method in the main method, read values for five associate objects referring 
the attributes in above sequence along with a String searchTechnology.
Then call the "associatesForGivenTechnology" method and write the logic to print the id's in the main method.


Input
-----------------
101
Alex
Java
15
102
Albert
Unix
20
103
Alferd
Testing
13
104
Alfa
Java
15
105
Almas
Java
29
Java

Output
------------------
101
104
 
 */
import java.util.*;

public class AssociateSolution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Associate[] asso = new Associate[5];
		for (int i = 0; i < asso.length; i++) {
			int id = sc.nextInt();
			sc.nextLine();
			String name = sc.next();
			String technology = sc.next();
			int expInYears = sc.nextInt();

			asso[i] = new Associate(id, name, technology, expInYears);
		}

		String searchTechn = sc.next();
		sc.close();

		Associate[] newAssociates = associatesForGivenTechnology(asso, searchTechn);

		for (int i = 0; i < newAssociates.length; i++) {
			System.out.println(newAssociates[i].getId());
		}

	}

	public static Associate[] associatesForGivenTechnology(Associate[] associates, String tech) {
		int count = 0;
		for (Associate associate : associates) {
			if (associate.getTechology().equalsIgnoreCase(tech) && associate.getExp() % 5 == 0) {
				count++;
			}
		}

		int index = 0;
		Associate[] newAsso = new Associate[count];

		for (Associate associate : associates) {
			if (associate.getTechology().equalsIgnoreCase(tech) && associate.getExp() % 5 == 0) {
				newAsso[index] = associate;
				index++;
			}
		}

		return newAsso;

	}

}

class Associate {
	private int id;
	private String name;
	private String technology;
	private int expInYears;

	// constructor
	public Associate(int id, String name, String technology, int expInYears) {
		this.id = id;
		this.name = name;
		this.technology = technology;
		this.expInYears = expInYears;
	}

	// getters and setters
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTechology() {
		return this.technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public int getExp() {
		return this.expInYears;
	}

	public void setExp(int exp) {
		this.expInYears = exp;
	}

}
