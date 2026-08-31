//package codeforces;

import java.util.Scanner;

public class A5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int online = 0;
        int traffic = 0;
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.charAt(0) == '+') {
                online++;
            } else if (s.charAt(0) == '-') {
                online--;
            } else {
                int a = s.substring(s.indexOf(":")).length() - 1;
                traffic += (a * online);
            }
        }
        System.out.println(traffic);
    }
}
