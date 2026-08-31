import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int r = 0; r < t; r++) {
            int n = in.nextInt();
            int m = in.nextInt();
            char[] p = in.next().toCharArray();
            int[] a = new int[n];
            int[] ans = new int[26];
            int sum = 0;
            a[n - 1] = 1;
            for (int i = 0; i < m; i++) {
                a[in.nextInt() - 1]++;
            }
            for (int i = n - 1; i >= 0; i--) {
                sum += a[i];
                ans[p[i] - 'a'] += sum;
            }
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}