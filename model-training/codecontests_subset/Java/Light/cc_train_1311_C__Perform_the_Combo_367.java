import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Set;
import java.util.Vector;

public class test {

    public static Scanner sc = new Scanner(System.in);

    public static final int MAX_N = 200005;

    public static final int MAX_M = 30;

    public static void main(String []args) {
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            int n = sc.nextInt();
            int m = sc.nextInt();
            String str = sc.next();
            char[] s = str.toCharArray();
            int [][]a = new int[n][MAX_M];
            a[0][s[0] - 'a']++;
            for (int i = 1; i < n; ++i) {
                for (int j = 0; j < 26; ++j) {
                    a[i][j] = a[i - 1][j];
                }
                a[i][s[i] - 'a']++;
            }
            int[] ans = new int[MAX_M];
            for (int i = 0; i < m; ++i) {
                int b = sc.nextInt();
                for (int j = 0; j < 26; ++j) {
                    ans[j] += a[b - 1][j];
                }
            }
            for (int i = 0; i < 26; ++i) {
                ans[i] += a[n - 1][i];
            }
            System.out.print(ans[0]);
            for (int i = 1; i < 26; ++i) {
                System.out.print(" " + ans[i]);
            }
            System.out.println();
        }
    }
}