import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[] dp = new long[n+1];
        for(int i = 0; i < m; i++){
            int a = scanner.nextInt();
            dp[a] = -1;
        }
        dp[0] = 1;
        if(dp[1] == 0){
            dp[1] = 1;
        }else{
            dp[1] = 0;
        }
        for(int i = 2; i <= n; i++){
            if(dp[i] >= 0){
                dp[i] = (dp[i-1] + dp[i-2])%1000000007;
            }else{
                dp[i] = 0;
            }
        }
        System.out.println(dp[n]);
    }
}

