// package com.company;

import java.util.Scanner;

public class b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            char[][] m = new char[n][];
            for (int i = 0; i < n; i++) {
                m[i] = scanner.next().toCharArray();
            }

            if (m[0][1] == m[1][0] && m[n - 1][n - 2] == m[n - 2][n - 1] && m[0][1] == m[n - 1][n - 2]) {
                System.out.println(2);
                System.out.println("1 2");
                System.out.println("2 1");
            } else if (m[0][1] == m[1][0] && m[n - 1][n - 2] == m[n - 2][n - 1] && m[0][1] != m[n - 1][n - 2])
                System.out.println(0);
            else if (notE(m[0][1], m[1][0], m[n - 1][n - 2], m[n - 2][n - 1])) {
                System.out.println(1);
                System.out.println("2 1");
            } else if (notE(m[1][0], m[0][1], m[n - 1][n - 2], m[n - 2][n - 1])) {
                System.out.println(1);
                System.out.println("1 2");
            } else if (notE(m[n - 1][n - 2], m[1][0], m[0][1], m[n - 2][n - 1])) {
                System.out.println(1);
                System.out.printf("%d %d\n", n- 1, n );
            } else if (notE(m[n - 2][n - 1], m[n - 1][n - 2], m[1][0], m[0][1])) {
                System.out.println(1);
                System.out.printf("%d %d\n", n , n-1);
            } else {
                System.out.println(2);
                System.out.printf("%s\n", m[0][1] == '1' ? "1 2" : "2 1");
                System.out.printf("%s\n", m[n - 1][n - 2] == '0' ? String.format("%d %d\n", n, n - 1) : String.format("%d %d\n", n - 1, n));
            }
        }

    }

    private static boolean notE(char c, char c1, char c2, char c3) {
        return c != c1 && c != c2 && c != c3;
    }


}
