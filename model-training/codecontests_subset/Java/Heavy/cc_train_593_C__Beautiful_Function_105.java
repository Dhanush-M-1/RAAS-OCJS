//package codeforces.cfr329div2;

import java.util.Scanner;

/**
 * Created by raggzy on 22-Jan-16.
 */
public class C {
    private static String abs(String s) {
        return "abs(" + s + ")";
    }

    private static String plus(String s1, String s2) {
        return "(" + s1 + "+" + s2 + ")";
    }

    private static String minus(String s1, String s2) {
        return "(" + s1 + "-" + s2 + ")";
    }

    private static String mult(String s1, String s2) {
        return "(" + s1 + "*" + s2 + ")";
    }

    private static String point(int x, int y) {
        String T = "t";
        String X = String.valueOf(x);
        String Y = String.valueOf(y / 2);
        return mult(Y, plus(minus("1", abs(minus(T, X))), abs(minus(abs(minus(T, X)), "1"))));
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String resX = point(0, in.nextInt());
        String resY = point(0, in.nextInt());
        in.nextInt();
        for (int i = 1; i < n; i++) {
            resX = plus(resX, point(i, in.nextInt()));
            resY = plus(resY, point(i, in.nextInt()));
            in.nextInt();
        }
        System.out.println(resX);
        System.out.println(resY);
    }
}
