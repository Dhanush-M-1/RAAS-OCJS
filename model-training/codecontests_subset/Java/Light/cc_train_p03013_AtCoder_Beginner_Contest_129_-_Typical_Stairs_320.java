import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        long mod = (long)Math.pow(10,9)+7;
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] brokes = new boolean[n+1];
        for(int i = 0; i < m; i++){
            brokes[sc.nextInt()] = true;
        }
        long[] dp = new long[n+1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            if(brokes[i]){
                continue;
            }else if(i == 1){
                dp[i] = dp[i-1]%mod;
            }else{
                dp[i] = dp[i-2]%mod + dp[i-1]%mod;
                dp[i] %= mod;
            }
        }
        System.out.println(dp[n]%mod);
    }
}