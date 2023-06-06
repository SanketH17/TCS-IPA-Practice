package Java.ProgrammingQ15Marks;

import java.util.Scanner;

public class p5_ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();

        sc.close();

        int sum = 0;

        for (int i = 0; i < n.length(); i++) {
            sum += Math.pow(n.charAt(i) - '0', 3);
        }

        if (sum == Integer.parseInt(n)) {
            System.out.println("Yes, the number is an Armstrong number");
        } else {
            System.out.println("No, the number is not an Armstrong number.");
        }

    }
}
