import java.util.*;

public class codeforces
{
    static int n,m;
    private static int lcs(int arr1[],int arr2[],int dp[][],int start,int end)
    {
        if(start>=n||end>=m)
        return 0;

        if(dp[start][end]!=-1)
        return dp[start][end];

        int val=0;
        if(arr1[start]==arr2[end])
            return arr1[start];

        val=lcs(arr1,arr2,dp,start+1,end);
        if(val!=0)
            return val;

        val=lcs(arr1,arr2,dp,start,end+1);
        if(val!=0)
            return val;

        dp[start][end]=0;
        return 0;
    }

    public static void main(String[] args) 
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0)
        {
            n=s.nextInt();
            m=s.nextInt();

            int arr1[]=new int[n];
            int arr2[]=new int[m];

            for(int i=0;i<n;i++)
                arr1[i]=s.nextInt();
            for(int i=0;i<m;i++)
                arr2[i]=s.nextInt();

            int dp[][]=new int[n][m];
            for(int i[]:dp)
                Arrays.fill(i,-1);

            int val=lcs(arr1,arr2,dp,0,0);
            if(val==0)
                System.out.println("NO");
            else
            {
                System.out.println("YES");
                System.out.println(1+" "+val);
            }
        }    
    }
}