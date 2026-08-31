
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alik
 */
public class B {
    static int n, x, a[], p[], q[];
    static boolean w[];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); x = in.nextInt(); a = new int [n + 1]; p = new int [n + 1]; q = new int [n + 1];
        w = new boolean [2000]; int ans = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
            if (a[i] == 0) {
                p[i] = 1;
                q[i] = 1;
                if (i == x) { q[i] = 2; ans = 1; }
            }
        }
        for (int i = 0; i < n; i++)
            for (int j = 1; j <= n; j++) {
                if (a[j] != 0 && p[a[j]] != 0 && p[j] == 0) {
                    p[j] = p[a[j]] + 1;
                    q[j] = q[a[j]]; q[a[j]] = 0;
                    if (j == x) { q[j] = 2; ans = p[j]; }
                }
            }
        w[0] = true;
        for (int i = 1; i <= n; i++)
            if (q[i] == 1) {
                for (int j = n; j >= 0; j--)
                    if (w[j]) w[j + p[i]] = true;
            }
        
        for (int i = 0; i <= n; i++)
            if (w[i]) System.out.println(i + ans);
    }
}
