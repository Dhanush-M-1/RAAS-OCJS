//package cf663;

import java.util.Scanner;

public class C {


    public static long f[];
    public static final long MOD = 1000000000 + 7;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        f = new long[n + 1];
        for(int i = 1; i <= n; i++){
            if(i == 1){
                f[i] = 1;
                continue;
            }
            f[i] = f[i - 1] * i % MOD;
        }
        long dp[] = new long[n + 1];
        for(int i = 3; i <= n; i++){
            if(i == 3){
                dp[i] = 2;
                continue;
            }
            dp[i] = f[i - 1] * (i - 2) % MOD;
            dp[i] = (dp[i] + 2 * dp[i - 1] % MOD ) % MOD;
        }

        System.out.println(dp[n]);

    }


}
