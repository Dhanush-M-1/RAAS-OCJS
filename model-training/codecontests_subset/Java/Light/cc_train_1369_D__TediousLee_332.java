import java.util.Scanner;

public class Main {
    static final int MOD = 1_000_000_007;
    static long[] f = new long[2_000_001];
    
    static {
        f[1] = 0;
        f[2] = 0;
        f[3] = 1;
        f[4] = 1;
        for (int i = 5; i <= 2e6; i++) {
            f[i] = (f[i - 1] + 2 * f[i - 2]) % MOD;
            if (i % 3 == 0) {
                f[i] = (f[i] + 1) % MOD;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(f[n] * 4 % MOD);
        }
    }
    
}
