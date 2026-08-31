import java.io.*;
import java.util.*;
public class A830 
{
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int p=sc.nextInt();
        int arr[]=new int[n+1];
        int key[]=new int[k+1];
        for(int i=0;i<n;i++)
        {
            arr[i+1]=sc.nextInt();
        }
        for(int i=0;i<k;i++)
        {
            key[i+1]=sc.nextInt();
        }
        Arrays.sort(arr);
        Arrays.sort(key);
        int dp[][]=new int[n+1][k+1];
        for(int i=1;i<=n;i++)
        {
            dp[i][i-1]=Integer.MAX_VALUE;
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=i;j<=k;j++)
            {
                int num=Math.abs(key[j]-arr[i])+Math.abs(key[j]-p);
                dp[i][j]=Math.min(dp[i][j-1],Math.max(dp[i-1][j-1],num));
                //System.out.print(dp[i][j]+" ");
            }
            //System.out.println();
        }
        System.out.println(dp[n][k]);
    }
}