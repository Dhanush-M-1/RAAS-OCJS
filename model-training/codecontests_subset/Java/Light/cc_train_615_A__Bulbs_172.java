//https://codeforces.com/problemset/problem/615/A

import java.util.Scanner;

public class P615A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            while (c-- > 0) {
                int k = sc.nextInt();
                a[k - 1]++;
            }
        }
        String ans = "YES";
        for (int s: a) {
            if (s == 0) ans = "NO";
        }
        System.out.println(ans);
    }
}
