import java.io.*;
import java.util.*;
public class office
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s[]=br.readLine().split(" ");
        int n=Integer.parseInt(s[0]);
        int k=Integer.parseInt(s[1]);
        int p=Integer.parseInt(s[2]);
        int dp[][]=new int[n+1][k+1];
        int per[]=new int[n+1];
        int key[]=new int[k+1];
        s=br.readLine().split(" ");
        for(int i=0;i<n;i++)
        {
            per[i+1]=Integer.parseInt(s[i]);
        }
        s=br.readLine().split(" ");
        for(int i=1;i<=k;i++)
        {
            key[i]=Integer.parseInt(s[i-1]);
        }
        Arrays.sort(per);
        Arrays.sort(key);
        for(int i=1;i<=n;i++)
        {
            for(int j=k;j>=i;j--)
            {
                dp[i][j]=(int)(Math.max(dp[i-1][j-1],Math.abs(key[j]-per[i])+Math.abs(p-key[j])));
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=k;i>=n;i--)
        {
            min=(int)(Math.min(min,dp[n][i]));
        }
        System.out.println(min);
    }
}