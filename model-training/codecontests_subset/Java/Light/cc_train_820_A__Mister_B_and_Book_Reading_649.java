import java.io.*;
import java.util.*;
import java.math.*;
import java.util.concurrent.*;

public final class round_421_a
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static FastScanner sc=new FastScanner(br);
    static PrintWriter out=new PrintWriter(System.out);
	static Random rnd=new Random();
	
    public static void main(String args[]) throws Exception
    {
		int c=sc.nextInt(),a=sc.nextInt(),b=sc.nextInt(),x=sc.nextInt(),y=sc.nextInt();
		
		int res=0,curr=a,p=0;
		
		while(p<c)
		{
			if(res>0)
			{
				p-=y;
			}
			
			p+=curr;
			
			curr+=x;curr=Math.min(curr,b);
			
			res++;
			
			//out.println(p);
		}
		
		out.println(res);out.close();
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