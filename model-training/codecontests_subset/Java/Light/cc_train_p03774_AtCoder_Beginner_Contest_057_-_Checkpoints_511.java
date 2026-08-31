import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];
        long[] c = new long[m];
        long[] d = new long[m];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                if (min > Math.abs(c[j] - a[i]) + Math.abs(d[j] - b[i])) {
                    min = Math.abs(c[j] - a[i]) + Math.abs(d[j] - b[i]);
                    ans[i] = j + 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]);
        }
    }
}
