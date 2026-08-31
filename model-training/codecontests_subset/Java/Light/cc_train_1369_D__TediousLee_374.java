import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Codeforces2
{
    static long dp[]=new long[2000001];
    static int mod=1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(dp,-1);
        dp[1]=0;
        dp[2]=0;
        dp[3]=4;
        dp[4]=4;
        int n=2000001;
        for(int i=3;i<n;i++)
        {
            if(i%3!=0)
        {
        dp[i]=(dp[i-1]%mod+(2*dp[i-2])%mod)%mod;
        }
        else
        dp[i]=((dp[i-1]%mod+(2*dp[i-2])%mod)+4)%mod;
        }
        int t=Integer.parseInt(br.readLine());
        while(t-->0)
        {
             n=Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}