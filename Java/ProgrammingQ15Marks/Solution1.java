package Java.ProgrammingQ15Marks;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        int chars = 0, spaces = 0;

        sc.close();

        for(int i = 0; i < inputStr.length(); i++) {
            if(inputStr.charAt(i) != ' ') {
                chars++;
            }
            if(Character.isWhitespace(inputStr.charAt(i))) {
                spaces++;
            }
        }

        System.out.println("No of characters: " + chars + " and spaces : " + spaces);
    }
}
