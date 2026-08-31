// codeforces.com/contest/195/problem/A

import java.util.Scanner;

public class StreamingInternet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, c;
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        double ans = c * (a - b) / b;
        if (ans > (int) ans) {
            System.out.println((int) ans + 1);
        } else {
            System.out.println((int) ans);

        }
    }
}