package Java.ProgrammingQ15Marks;

import java.util.Scanner;

public class p6_CharRepeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        sc.close();

        String compressedString = compressString(input);
        System.out.println(compressedString);
    }

    public static String compressString(String str) {
        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for(int i = 0; i < str.length(); i++) {
            if(i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                compressed.append(str.charAt(i));
                compressed.append(count);
            count = 1;          }
        }
        return compressed.toString();
    }

}




/*  
// aabbbcc = a2b3c2
// abbccc = a1b2c3




*/