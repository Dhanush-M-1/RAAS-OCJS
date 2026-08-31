import java.io.*;
import java.util.*;
public final class football
{
    static FastScanner sc=new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out=new PrintWriter(System.out);
	
    static int check(long mid,long a,long b,long c)
	{
		long base=mid*b;
		for(long i=mid;i<=mid+c;i++)
		{
			if(base<((i-mid)*a))
			{
				return -1;
			}
			base+=b;
		}
		return 1;
	}
	
    public static void main(String args[]) throws Exception
    {
		long a=sc.nextLong(),b=sc.nextLong(),c=sc.nextLong();
		long low=0,high=(long)Math.pow(10,12);
		while(low!=high)
		{
			long mid=(low+high)>>1;
			int elem=check(mid,a,b,c);
			if(elem<0)
			{
				low=mid+1;
			}
			else
			{
				high=mid;
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