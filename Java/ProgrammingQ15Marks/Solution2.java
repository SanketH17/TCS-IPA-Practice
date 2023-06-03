package Java.ProgrammingQ15Marks;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inpuString = sc.nextLine();
        printLastCharacter(inpuString);

        sc.close();
    }

    public static void printLastCharacter(String str) {
        str = str + " "; // we need one extra char at the last word
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                System.out.print(str.charAt(i - 1));
            }
        }
    }

}
