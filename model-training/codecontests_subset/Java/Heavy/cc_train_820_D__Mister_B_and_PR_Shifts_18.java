import java.io.*;
import java.util.*;
import java.math.*;
import java.util.concurrent.*;

public final class round_421_d
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static FastScanner sc=new FastScanner(br);
    static PrintWriter out=new PrintWriter(System.out);
	static Random rnd=new Random();
	
	static long get(long n)
	{
		return (n*(n+1))/2;
	}
	
    public static void main(String args[]) throws Exception
    {
		int n=sc.nextInt();int[] a=new int[n+1];long[] pre=new long[n+1];
		
		for(int i=1;i<=n;i++)
		{
			a[i]=sc.nextInt();
			
			pre[i]=pre[i-1]+a[i];
		}
		
		long[] suff=new long[n+1];
		
		for(int i=n;i>=1;i--)
		{
			suff[i]=pre[n]-pre[i-1]-get(n-i+1);
		}
		
		long[] val=new long[n+2];int[] cnt=new int[n+2];
		
		for(int i=n;i>=1;i--)
		{
			if(i-a[i]>=1)
			{
				cnt[i-a[i]]++;
			}
			
			cnt[i]+=cnt[i+1];
			
			val[i]=val[i+1]+(cnt[i]*2);
		}
		
		long[] pre1=new long[n+1];
		
		for(int i=1;i<=n;i++)
		{
			pre1[i]=get(n)-get(n-i)-pre[i];
		}
		
		long[] val2=new long[n+1];Arrays.fill(cnt,0);
		
		for(int i=1;i<=n;i++)
		{
			int curr=(n-a[i]+1);
			
			if(i+curr<=n)
			{
				cnt[i+curr]++;
			}
			
			cnt[i]+=cnt[i-1];
			
			val2[i]=val2[i-1]+(cnt[i]*2);
		}
		
		//out.println(Arrays.toString(suff)+" "+Arrays.toString(val)+" "+Arrays.toString(pre1)+" "+Arrays.toString(val2));
		
		long res=Long.MAX_VALUE;int ans=-1;
		
		for(int i=1;i<=n;i++)
		{
			long x1=pre1[i-1],x2=suff[i];
			
			long x3=val2[i-1],x4=val[i];
			
			long curr=x1+x2+x3+x4;
			
		//	out.println(i+" "+x1+" "+x2+" "+x3+" "+x4+" "+curr);
			
			if(curr<res)
			{
				res=curr;
				
				ans=(i==1?0:n-i+1);
			}
		}
		
		out.println(res+" "+ans);out.close();
    }
}
class FastScanner
{
    BufferedReader in;
    StringTokenizer st;

    public FastScanner(BufferedReader in) {
        this.in = in;
    }
	
    public String nextToken() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
	
	public String next() throws Exception {
		return nextToken().toString();
	}
	
    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }
}