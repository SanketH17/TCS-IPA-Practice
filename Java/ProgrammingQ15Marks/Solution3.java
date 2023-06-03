package Java.ProgrammingQ15Marks;

import java.util.Scanner;

/* 
Given a string print number of vowels and consonants present in the given string
*/

public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int vowels = 0, consonants = 0;

        sc.close();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                    || (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')) {
                vowels++;
            } else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                consonants++;
            }
        }

        System.out.println("Number of vowels:" + vowels);
        System.out.println("Number of consonants: " + consonants);
    }
}
