
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] isSafe = new boolean[n+1];

        Arrays.fill(isSafe,true);
        for(int i = 0; i < m; i++) {
            isSafe[sc.nextInt()] = false;
        }

        long[] dp = new long[n+1];
        Arrays.fill(dp,0);

        dp[0] = 1;
        if(isSafe[1]) dp[1] = 1;

        for(int i = 2; i <=n; i++) {
            if(isSafe[i-1]) dp[i] += dp[i-1];
            if(isSafe[i-2]) dp[i] += dp[i-2];
            dp[i] %= 1000000007;
        }

        System.out.println(dp[n]);
    }
}
