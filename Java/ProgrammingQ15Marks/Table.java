package Java.ProgrammingQ15Marks;

import java.util.*;

public class Table {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int k = sc.nextInt();
        int n = sc.nextInt();

        sc.close();

        for(int i = 1; i <= n; i++) {
            System.out.println(k + " x " + i + " = " + k * i);
        }

    }
}