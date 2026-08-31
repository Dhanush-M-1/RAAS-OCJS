


import java.util.*;
import java.util.Map.Entry;
import javafx.util.Pair;
public class Fds
{
    
    
    
    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        long dp[]=new long[2000001];
        dp[0]=0;
        dp[1]=0;
        dp[2]=0;
        dp[3]=1;
        dp[4]=1;
        long p=1000000007;
        for(int i=5;i<=2000000;i++)
        {
            if(i%3==0)
            {
                dp[i]=(2*dp[i-2]+dp[i-1]+1)%p;
            }
            else
            {
                dp[i]=(2*dp[i-2]+dp[i-1])%p;
            }
        }
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            System.out.println((dp[n]*4)%p);
        }

    }
}