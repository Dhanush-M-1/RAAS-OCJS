import java.util.*;
public class qd{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        long dp[][]=new long[2000005][2];
        dp[3][0]=1;
        int mod=1000000007;
        for(int i=4;i<dp.length;i++){
            dp[i][0]=(1+dp[i-2][1]+dp[i-2][1]+dp[i-1][1])%mod;
            dp[i][1]=(Math.max(dp[i-2][0],dp[i-2][1])+Math.max(dp[i-2][0],dp[i-2][1])+Math.max(dp[i-1][0],dp[i-1][1]))%mod;
        }
        while(t-->0){
            int n=sc.nextInt();
            System.out.println((Math.max(dp[n][0],dp[n][1])*4)%mod);
        }
    }
}