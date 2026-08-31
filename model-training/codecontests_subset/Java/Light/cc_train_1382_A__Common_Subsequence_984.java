// package codeforces.round.n658;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: nayix
 * @Date: 7/22/20 9:10 AM
 */
public class CommonSubsequence {
    private static final boolean[] vis = new boolean[1005];

    private static String solve(int[] a, int[] b) {
        Arrays.fill(vis, false);
        for (int i : a) {
            vis[i] = true;
        }
        for (int i : b) {
            if (vis[i]) {
                return "YES\n1 " + i;
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int t = in.nextInt(); t > 0; t--) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < m; i++) {
                b[i] = in.nextInt();
            }
            System.out.println(solve(a, b));
        }
        in.close();
    }
}
