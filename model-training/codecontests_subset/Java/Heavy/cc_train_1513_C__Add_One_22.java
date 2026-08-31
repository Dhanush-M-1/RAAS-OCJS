import java.util.Scanner;

public class C {
    static long mod = (long) (1e9 + 7);

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long[] dp = new long[(int) 2e5 + 20];
        for (int i = 0; i < 2e5 + 10; i++) {
            if (i < 10) {
                dp[i] = 1;
                dp[i] = dp[i] % mod;
                continue;
            }
            dp[i] = dp[i - 10] + dp[i - 9];
            dp[i] = dp[i] % mod;

        }
        StringBuilder ans = new StringBuilder();
        int cases = scn.nextInt();
        while (cases-- > 0) {
            int n = scn.nextInt();
            int m = scn.nextInt();
            long count = 0;
            while (n > 0) {
                int digit = n % 10;
                count += dp[digit + m];
                count %= mod;
                n /= 10;
            }
            ans.append(count + "\n");
        }

        System.out.println(ans);


    }


}
