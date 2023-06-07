/* IPA 17 */

/*

Create a class Student with below attributes:

rollNo - int
name - String
subject - String
grade - char
date - String [DD/MM/YYYY]



The above attributes should be private.Write Getter and Setter and parametrized constructor as required.


Create class Solution with main method.
****************************************************************************
Implement one static method: findStudentByGradeAndMonth Solution Class.


findStudentByGradeAndMonth Method:

This method will take an array of Student objects, char value as grade and int value as month for input parameters.The method will find out all Students from the given grade and month. 
This method will return array of Student object ascending based on their rollNo if found. 
If there is no Student that matches then the method should return null.

for this method- main method should print Student name, subject and total student found [The length of the list], if the returned value is not null. If the returned value is null then main method should print "No student found".


NOTE:
	1. For Taking char as input use sc.nextLine().charAt(0)
	2. To match/check the month You havee to convert int month in the parameter to String.
	3. No need to count the Student array if return not null just print the array length.


****************************************************************************



Consider the below input and output:


input1:

111
Arijit
Math
B
22/09/2023
101
Priyanka
English
A
30/03/2022
107
Shreosi
History
C
13/05/2022
105
Tatan
Physics
A
27/03/2022
A
3


output1:

Priyanka
A
Tatan
A
2




input2:

111
Sohel
Math
B
22/09/2022
101
Priyanka
English
A
30/03/2022
107
Gopa
History
C
12/05/2022
105
Kamal
Physics
A
27/03/2022
A
7



output 2:

No student found
 
*/

import java.util.Scanner;
import java.util.*;

public class StudentSolution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Student[] students = new Student[4];

		for (int i = 0; i < students.length; i++) {
			int rollNo = sc.nextInt();
			sc.nextLine();
			String name = sc.nextLine();
			String subject = sc.nextLine();
			char grade = sc.nextLine().charAt(0);
			String date = sc.nextLine();

			students[i] = new Student(rollNo, name, subject, grade, date);
		}
		char targetGrade = sc.nextLine().charAt(0);
		int targetMonth = sc.nextInt();

		sc.close();

		Student[] newStudent = findStudentByGradeAndMonth(students, targetGrade, targetMonth);

		if (newStudent != null) {
			for (int i = 0; i < newStudent.length; i++) {
				System.out.println(newStudent[i].getName());
				System.out.println(newStudent[i].getGrade());
			}
			System.out.println(newStudent.length);
		} else {
			System.out.println("No student found");
		}

	}

	public static Student[] findStudentByGradeAndMonth(Student[] s, char grade, int month) {
		String targetMonth = String.format("%02d", month);

		Student[] foundStudents = new Student[s.length];
		int count = 0;

		// Date - DD/MM/YYYY
		for (Student student : s) {
			String studentMonth = student.getDate().substring(3, 5);

			if (student.getGrade() == grade && studentMonth.equals(targetMonth)) {
				foundStudents[count] = student;
				count++;
			}
		}
		if (count == 0) {
			return null;
		}
		return Arrays.copyOf(foundStudents, count);
	}

}

class Student {
	private int rollNo;
	private String name;
	private String subject;
	private char grade;
	private String date;

	public Student(int rollNo, String name, String subject, char grade, String date) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.subject = subject;
		this.grade = grade;
		this.date = date;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}