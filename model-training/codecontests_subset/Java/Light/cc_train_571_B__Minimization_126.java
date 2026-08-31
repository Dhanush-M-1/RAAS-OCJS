import java.util.*;
import java.lang.*;
import java.io.*;
public class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader f = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int a[] = new int[n];
        for(int i = 0;i<n;i++) a[i]=Integer.parseInt(st.nextToken());
        int q = n/k;
        int r = n%k;
        Arrays.sort(a);
        int dp0[] = new int[r+1];
        int dp1[] = new int[r+1];//starting points xi. d[i][j] is best value of thing up to fi assuming j have been used.
        dp1[0]=a[n-1]-a[0];
        for(int i = 1;i<r;i++) dp1[i]=-1;
        for(int i = 1;i<k;i++){
            for(int j = 0;j<=r;j++) dp0[j]=dp1[j];
            for(int j = Math.max(0,r+i-k);j<Math.min(r+1,i+1);j++){
                dp1[j]=2147483646;
                if((j>=Math.max(r+(i-1)-k,0)&&j<Math.min(r+1,i))&&(dp0[j]+a[q*i+j-1]-a[q*i+j]<=dp1[j])) dp1[j]=dp0[j]+a[q*i+j-1]-a[q*i+j];
                if((j-1>=Math.max(r+(i-1)-k,0)&&j-1<Math.min(r+1,i))&&(dp0[j-1]+a[q*i+j-1]-a[q*i+j]<=dp1[j])) dp1[j]=dp0[j-1]+a[q*i+j-1]-a[q*i+j];
            }
        }
        long ans = dp1[r];
        if(r>0) ans=Math.min(ans,dp1[r-1]);
        System.out.println(ans);
    }
}