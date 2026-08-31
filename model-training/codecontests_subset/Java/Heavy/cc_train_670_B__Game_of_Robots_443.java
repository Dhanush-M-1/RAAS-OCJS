import java.io.*;
import java.util.*;
public final class round_350_b
{
    static FastScanner sc=new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out=new PrintWriter(System.out);
	
	public static void main(String args[]) throws Exception
	{
		int n=sc.nextInt();
		long k=sc.nextInt();
		long[] a=new long[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		long low=0,high=(long)Math.pow(10,8);
		while(low<high)
		{
			long mid=(low+high+1)>>1;
			long val=(mid*(mid+1L))>>1;
			if(val<k)
			{
				low=mid;
			}
			else
			{
				high=mid-1;
			}
		}
		k=k-((low*(low+1L)>>1));
		int k1=(int)k;
		out.println(a[k1-1]);
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