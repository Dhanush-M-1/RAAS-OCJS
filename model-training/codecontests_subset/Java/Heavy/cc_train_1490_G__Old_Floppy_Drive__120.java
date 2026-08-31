//created by Whiplash99
import java.io.*;
import java.util.*;
public class G
{
    private static int bSearch(long[] pref, int N, long X)
    {
        int l=0,r=N-1,mid,ans=N;
        while (l<=r)
        {
            mid=(l+r)/2;
            if(pref[mid]>=X)
            {
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }

        return ans;
    }
    public static void main(String[] args) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int i,N;

        int T=Integer.parseInt(br.readLine().trim());
        StringBuilder sb=new StringBuilder();

        while (T-->0)
        {
            String[] s=br.readLine().trim().split(" ");
            N=Integer.parseInt(s[0]);
            int M=Integer.parseInt(s[1]);

            long[] a=new long[N];
            long[] x=new long[M];

            s=br.readLine().trim().split(" ");
            for(i=0;i<N;i++) a[i]=Integer.parseInt(s[i]);
            s=br.readLine().trim().split(" ");
            for(i=0;i<M;i++) x[i]=Integer.parseInt(s[i]);

            long sum=0,max=Long.MIN_VALUE;
            long[] pref=new long[N];
            for(i=0;i<N;i++)
            {
                sum+=a[i];
                max=Math.max(max,sum);
                pref[i]=max;
            }

            long[] ans=new long[M];
            for(i=0;i<M;i++)
            {
                if(max>=x[i]) ans[i]=bSearch(pref,N,x[i]);
                else if(sum<=0) ans[i]=-1;
                else
                {
                    long tmp=x[i]-max;
                    ans[i]=(tmp+sum-1)/sum;
                    x[i]-=sum*ans[i];
                    ans[i]*=N;

                    ans[i]+=bSearch(pref,N,x[i]);
                }
            }

            for(long z:ans) sb.append(z).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}