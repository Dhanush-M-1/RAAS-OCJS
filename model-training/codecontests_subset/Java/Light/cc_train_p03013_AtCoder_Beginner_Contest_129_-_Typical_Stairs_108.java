import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] a = new int[N];
        Arrays.fill(a, 0);
        for(int i = 0; i < M; i++){
            int n = sc.nextInt();
            a[n-1] = -1;
        }
        long[] dp = new long[N+1];
        long mod = 1000000007;
        dp[0] = 1;
        if(a[0] == 0)
            dp[1] = 1;
        for(int i = 1; i < N; i++){
            dp[i+1] = (dp[i] + dp[i-1]) % mod;
            if(a[i] == -1)
                dp[i+1] = 0;
        }
        System.out.println(dp[N]);
        sc.close();
    }
}
