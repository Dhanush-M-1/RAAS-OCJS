import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int a[] = new int [m];
        for (int i = 0; i < m; i++) {
            a[i] = in.nextInt();
        }

        long step[] = new long[n + 3];
        Arrays.fill(step, 0);
        for (int i = 0; i < m; i++) {
            step[a[i]] = -1;
        }

        step[0] = 1;
        for (int i = 0; i <= n; i++) {
            if (step[i] == -1) continue;
            if (step[i + 1] != -1) step[i + 1] = modadd(step[i + 1], step[i], MOD);
            if (step[i + 2] != -1) step[i + 2] = modadd(step[i + 2], step[i], MOD);
        }

        System.out.println(step[n]);
    }

    static final long MOD = 1_000_000_007;    

    static long modadd(long a, long b, long mod) {
        return (a + b) % mod;
    }
}