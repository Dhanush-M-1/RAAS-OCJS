import java.io.*;
import java.util.*;
public final class mafia
{
    static FastScanner sc=new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out=new PrintWriter(System.out);
	
	public static void main(String args[]) throws Exception
	{
		int n=sc.nextInt();
		long a[]=new long[n],sum=0,curr=n-1;
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextLong();
			sum+=a[i];
		}
		long low=1,high=(long)Math.pow(10,13);
		while(low<high)
		{
			long mid=(low+high)>>1,val=0;
			boolean ans=true;
			for(int i=0;i<n;i++)
			{
				if(mid-a[i]<0)
				{
					ans=false;
					break;
				}
				val+=mid-a[i];
			}
			if(ans && val>=mid)
			{
				high=mid;
			}
			else
			{
				low=mid+1;
			}
		}
		out.println(low);
		out.close();
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