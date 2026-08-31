import java.util.*;

public class Main {
    
    static int MOD = (int) 1e9 + 7;
    
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        long[] dp = new long[N+1];
        int[] a = new int[M];
        for(int i = 0; i < M; i++){
            a[i] = sc.nextInt();
            dp[a[i]] = -1;
            if( (i > 0) && (a[i-1] + 1 == a[i]) ){
                System.out.println(0);
                return;
            }
        }
        
        dp[0] = 1;
        if( dp[1] != -1 ) dp[1] = 1;
        
        for(int i = 2; i <= N; i++){
            if(dp[i] == -1) continue;
            if(dp[i-2] != -1 ) dp[i] = (dp[i] + dp[i-2]) % MOD;
            if(dp[i-1] != -1 ) dp[i] = (dp[i] + dp[i-1]) % MOD;
        }
        
        System.out.println(dp[N]);
        
    }
}
