import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        if(m==0) {
            long[] dp = new long[n+1];
            dp[0] = 1;
            dp[1] = 1;

            for(int i = 2; i<n+1; i++) {
                dp[i] = (dp[i-1]+dp[i-2])%1000000007;
            }
            System.out.println(dp[n]);
            return;
        }


        long[] a = new long[m];
        long[] dp = new long[n+1];



        for(int i = 0; i<m; i++) {
            a[i] = sc.nextInt();
            dp[(int)a[i]] = -1;
        }
        dp[0] = 1;
        dp[1] = (a[0]==1)?0:1;

        for(int i = 2; i<n+1; i++) {
            if(dp[i]==-1) dp[i] = 0;
            else dp[i] = (dp[i-1]+dp[i-2])%1000000007;
        }
        System.out.println(dp[n]);

    }
}