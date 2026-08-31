/*package com.company.tests.number658;*/

import com.sun.security.jgss.GSSUtil;

import java.util.*;

public class Main {
    public static Scanner key = new Scanner(System.in);

    public static void solveA(int t) {
        while (t > 0) {
            t--;
            int n = key.nextInt();
            int m = key.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < n; i++) {
                a[i] = key.nextInt();
                set.add(a[i]);
            }
            String ans = "NO";
            int common = -1;
            for (int i = 0; i < m; i++) {
                b[i] = key.nextInt();
                if(set.contains(b[i]) && common == -1) {
                    ans = "YES";
                    common = b[i];
                }
            }
            if(ans.equals("YES")) {
                System.out.println("YES");
                System.out.println("1 " + common);
            }
            else
                System.out.println("NO");
        }
    }


    public static void main(String[] args) {
        int t = key.nextInt();
        solveA(t);
    }
}
