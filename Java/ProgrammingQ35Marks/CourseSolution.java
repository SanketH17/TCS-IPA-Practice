/*

create the class Course with the below Attributes.

courseId- int
courseName- String
courseAdmin- String
quiz- int
handson -int

The above methods should be private ,write getter and
setter and parametrized constructor as required.

create class courseProgram with main method.

implement two static methods-
findAvgOfQuizByAdmin method:this method will take array
of Courses objects and a String  value as input parameters.
This method will find out Average (as int) of Quiz questions
for given Course Admin (String parameter passed)
This method will return Average if found.if there is no course
that matches then the method should return 0.

sortCourseByHandsOn method:
This method will take an Array of Course Objects and int
value as input parameters.
This methods should return an Array of Course objects in an
ascending order of their  handson which are less than the
given handson(int parameter passed) value. if there is no
such course then the method should return null.

The above mentioned static methods should be called from
main methods.

for findAvgOfQuizByAdmin method: The main method
should print the average if the returned value is not 0.
if the returned value is 0 then it should print "No Course
found."


for sortCourseByHandsOn method:
                        the  main method should print the name
of the Course from the returned Course object Array if the
returned value is not null.if the returned value is null then
it should print "No Course found with mentioned attribute."

input1:
111
kubernetes
Nisha
40
10
321
cassandra
Roshini
30
15
457
Apache Spark
Nisha
30
12
987
site core
Tirth
50
20
Nisha
17

output1:
35
kubernetes
Apache Spark
cassandra

input2:
111
kubernetes
Nisha
40
10
321
cassandra
Roshini
30
15
457
Apache Spark
Nisha
30
12
987
site core
Tirth
50
20
Shubhamk
5

output 2:
No Course found
No Course found with mentioned attributes.

*/













import java.util.Scanner;

public class CourseSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Course[] courses = new Course[4];

        for (int i = 0; i < courses.length; i++) {
            int courseId = sc.nextInt();sc.nextLine();
            String courseName = sc.nextLine();
            String courseAdmin = sc.nextLine();
            int quiz = sc.nextInt();sc.nextLine();
            int handson = sc.nextInt();sc.nextLine();

            courses[i] = new Course(courseId, courseName, courseAdmin, quiz, handson);
        }
        String admin = sc.nextLine();
        int hand = sc.nextInt();

        sc.close();

        int ans1 = findAvgOfQuizByAdmin(courses, admin);
        if (ans1 != 0) {
            System.out.println(ans1);
        } else {
            System.out.println("No course found");
        }

        Course[] ans2 = sortCourseByHandsOn(courses, hand);

        if (ans2 != null) {
            for (int i = 0; i < ans2.length; i++) {
                System.out.println(ans2[i].getcourseName());
            }
        } else {
            System.out.println("No course found with mentioned attribute.");
        }

    }

    public static int findAvgOfQuizByAdmin(Course[] courses, String admin) {
        int sum = 0, count = 0;
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].getcourseAdmin().equalsIgnoreCase(admin)) {
                sum = sum + courses[i].getquiz();
                count++;
            }

        }

        if (count > 0) {
            int avg = sum / count;
            return avg;
        } else {
            return 0;
        }
    }

    public static Course[] sortCourseByHandsOn(Course[] courses, int handson) {
        int count = 0;
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].gethandson() < handson) {
                count++;
            }
        }

        if (count == 0) {
            return null;
        } else {
            Course[] sortedCourses = new Course[count];
            int index = 0;
            for (Course course : courses) {
                if (course.gethandson() < handson) {
                    sortedCourses[index] = course;
                    index++;
                }
            }

            // perform sorting
            for (int i = 0; i < count - 1; i++) {
                for (int j = 0; j < count - i - 1; j++) {
                    if (sortedCourses[j].gethandson() > sortedCourses[j + 1].gethandson()) {
                        Course temp = sortedCourses[j];
                        sortedCourses[j] = sortedCourses[j + 1];
                        sortedCourses[j + 1] = temp;
                    }
                }
            }

            return sortedCourses;

        }
    }

}

class Course {
    private int courseId;
    private String courseName;
    private String courseAdmin;
    private int quiz;
    private int handson;

    public Course(int courseId, String courseName, String courseAdmin, int quiz, int handson) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseAdmin = courseAdmin;
        this.quiz = quiz;
        this.handson = handson;
    }

    // courseId
    public int getcourseId() {
        return this.courseId;
    }

    public void setcourseId(int courseId) {
        this.courseId = courseId;
    }

    // courseName
    public String getcourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    // courseAdmin
    public String getcourseAdmin() {
        return this.courseAdmin;
    }

    public void setcourseAdmin(String courseAdmin) {
        this.courseAdmin = courseAdmin;
    }

    // quiz
    public int getquiz() {
        return this.quiz;
    }

    public void setquiz(int quiz) {
        this.quiz = quiz;
    }

    // handson
    public int gethandson() {
        return this.handson;
    }

    public void sethandson(int handson) {
        this.handson = handson;
    }

}