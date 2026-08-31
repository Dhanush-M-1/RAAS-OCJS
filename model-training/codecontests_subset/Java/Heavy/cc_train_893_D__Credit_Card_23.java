import java.io.*;
import java.util.*;
import java.math.*;
import java.util.concurrent.*;

public final class e
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static FastScanner sc=new FastScanner(br);
    static PrintWriter out=new PrintWriter(System.out);
	static Random rnd=new Random();
	
    public static void main(String args[]) throws Exception
    {
		int n=sc.nextInt();long d=sc.nextLong();
		
		long[] a=new long[n+1],pre=new long[n+1];
		
		boolean ans=true;
		
		for(int i=1;i<=n;i++)
		{
			a[i]=sc.nextLong();
			
			pre[i]=pre[i-1]+a[i];
		}
		
		long[] min=new long[n+1];min[n]=d-pre[n];
		
		for(int i=n-1;i>=1;i--)
		{
			min[i]=Math.min(min[i+1],d-pre[i]);
		}
		
		int res=0;long add=0;
		
		for(int i=1;i<=n;i++)
		{
			pre[i]+=add;
			
			if(pre[i]>d)
			{
				ans=false;break;
			}
			
			if(a[i]==0 && pre[i]<0)
			{
				long curr=min[i]-add;
				
				pre[i]+=curr;add+=curr;
				
				if(pre[i]<0)
				{
					ans=false;break;
				}
				
				else
				{
					res++;
				}
			}
		}
		
		out.println(ans?res:-1);out.close();
    }
	
	private static class Pair implements Comparable<Pair>
	{
		int idx;long val;
		
		public Pair(int idx,long val)
		{
			this.idx=idx;this.val=val;
		}
		
		public int compareTo(Pair x)
		{
			if(this.val==x.val)
			{
				return Integer.compare(this.idx,x.idx);
			}
			
			return -(Long.compare(this.val,x.val));
		}
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