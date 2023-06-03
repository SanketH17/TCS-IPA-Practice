package Java.ProgrammingQ15Marks;

import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        sc.close();

        char minVowel = 'u';

        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                if (minVowel > x) {
                    minVowel = x;
                }
            }
        }

        System.out.println(minVowel);
    }
}
