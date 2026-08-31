// package problemSet1;

import java.util.Scanner;

public class HelpfulMaths {
    public static void main(String[] args) {
        // Date: 27-04-2021
        // Time: 16:23:49 (IST)
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder(sc.nextLine());
        sc.close();


        for(int i = 0; i < str.length(); i++) {
            for(int j = 0; j < str.length() - i - 2; j++) {
                if (str.charAt(j) > str.charAt(j + 2)) {
                    // swap(str.charAt(j), str.charAt(j + 1));
                    char temp = str.charAt(j);
                    str.setCharAt(j, str.charAt(j + 2));
                    str.setCharAt(j + 2, temp);
                }
            }
        }
        System.out.println(str);

        
    }
}
