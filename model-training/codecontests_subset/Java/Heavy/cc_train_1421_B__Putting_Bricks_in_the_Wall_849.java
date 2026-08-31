import java.util.Scanner;
import java.util.*;
public class Main {
    static Scanner in;
    public static void main(String[] args) {
        in = new Scanner(System.in);
        // int num = in.nextInt();
        int t = in.nextInt();
        for (int j = 0; j < t; j++) {
            int n = in.nextInt();
            String[] m = new String[n];
            for (int i = 0; i < n; i++) m[i] = in.next();
            char l1 = m[0].charAt(1);
            char l2 = m[1].charAt(0);
            char r1 = m[n - 2].charAt(n - 1);
            char r2 = m[n - 1].charAt(n - 2);
            if (l1 == l2 && r1 == r2 && l1 != r2) {
                System.out.println(0);
            } else if (l1 == l2 && r1 == r2 && l1 == r1) {
                System.out.println(2);
                System.out.println("1 2");
                System.out.println("2 1");
            } else if (l1 == l2) {
                System.out.println(1);
                if (r1 == l1) {
                    System.out.println((n-1) + " " + n);
                } else {
                    System.out.println(n + " " + (n - 1));
                }
            } else if (r1 == r2) {
                System.out.println(1);
                if (r1 == l1) {
                    System.out.println(1 + " " + 2);
                } else {
                    System.out.println(2 + " " + 1);
                }
            } else {
                System.out.println(2);
                if (l1 == '0') {
                    System.out.println(1 + " " + 2);
                } else {
                    System.out.println(2 + " " + 1);
                }
                if (r1 == '1') {
                    System.out.println((n-1) + " " + n);
                } else {
                    System.out.println(n + " " + (n - 1));
                }
            }
        }
    }
    
    static int solve(int a, int b) {
        int p = 1;
        int res = 0;
        while (p <= a || p <= b) {
            if ((p & a) != (p & b)) res += p;
            p <<= 1;
        }
        return res;
    }
}