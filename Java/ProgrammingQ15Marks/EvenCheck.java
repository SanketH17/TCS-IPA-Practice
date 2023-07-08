package Java.ProgrammingQ15Marks;

import java.util.*;

public class EvenCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        /*
         * int n = sc.nextInt();
         * 
         * 
         * sc.close();
         * 
         * while(n > 0) {
         * int rem = n % 10;
         * if(rem % 2 == 0) {
         * count++;
         * }
         * n = n / 10;
         * }
         * System.out.println(count);
         */

        // if String is given

        String num = sc.nextLine();

        sc.close();

        for (int i = 0; i < num.length(); i++) {
            if (Integer.parseInt(String.valueOf(num.charAt(i))) % 2 == 0) {
                count++;
            }
        }
        if(count >= 3) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

}
