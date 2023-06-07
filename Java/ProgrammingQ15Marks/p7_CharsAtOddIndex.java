package Java.ProgrammingQ15Marks;

import java.util.Scanner;

public class p7_CharsAtOddIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        sc.close();

        for(int i = 0; i < str.length(); i++) {
            if(i % 2 != 0) {
                System.out.print(str.charAt(i));
            }
        }

    }
}
