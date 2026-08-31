import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.*;


public class D2 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        long ans = 0, mod = 998244353;
        int n = in.nextInt();
        long arr[] = new long[n];
        int len[] = new int[25], f[] = new int[25];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            int l = String.valueOf(arr[i]).length();
            for (int k = 1; k <= l; k++) {
                len[k]++;
            }
            f[l]++;
        }

        for (int i = 0; i < n; i++) {
            long x = arr[i];
            long m = 1, p = 10;
            int l = 1;
            while (x > 0) {
                long d = x % 10;
                ans = (ans + len[l] * (d * m) % mod) % mod;
                ans = (ans + len[l] * (d * p) % mod) % mod;

                x /= 10;
                ans = (ans + f[l] * (x * (m * 100) % mod) % mod) % mod;
                ans = (ans + f[l] * (x * (p * 10) % mod) % mod) % mod;

                m = (m * 100) % mod;
                p = (p * 100) % mod;
                l++;
            }
        }
        pw.println(ans);
        pw.close();
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}