import java.util.*;

public class Main {
    static long mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] lis = new int[n + 1];

        for (int i = 0; i < m; ++i) {
            lis[sc.nextInt()] = 1;
        }

        long[] cnt = new long[n + 1];
        cnt[0] = 1;
        if (lis[1] == 1) {
            cnt[1] = 0;
        } else {
            cnt[1] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            if (lis[i] == 1) {
                cnt[i] = 0;
            } else {
                cnt[i] = (cnt[i - 1] + cnt[i - 2]) % mod;
            }
        }

        System.out.println(cnt[n]);
    }
}
