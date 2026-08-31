//package codeforces;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Nibir Joydhar
 */
public class ABCompilationError {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        int[] a, b, c;
        a = new int[n+1];
        b = new int[n];
        c = new int[n-1];
        for (int j = 0; j < n; j++) {
            a[j] = in.nextInt();
        }
        for (int j = 0; j < n - 1; j++) {
            b[j] = in.nextInt();
        }
        for (int j = 0; j < n - 2; j++) {
            c[j] = in.nextInt();
        }
        Arrays.sort(a,0,n);
        Arrays.sort(b,0,n-1);
        Arrays.sort(c,0,n-2);
       
        for (int j = 0; j < n; j++) {
            if (a[j] != b[j]) {
                System.out.println(a[j]);
                break;
            }
        }
        for (int j = 0; j < n - 1; j++) {
            if (b[j] != c[j]) {
                System.out.println(b[j]);
                break;
            }
        }
    }
}
