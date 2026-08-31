import java.util.*;
import java.lang.*;
import java.io.*;

public class Codechef{
 
	PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
 	
 	class Pair 
	{
	    int f;
	    int s;
 
	    public Pair(int t, int r) {
	       f = t;
	       s = r;
	    }
 	}
 
	String ns() {
        while (st == null || !st.hasMoreElements()) {
 
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
 
    String nextLine() throws Exception {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            throw new Exception(e.toString());
        }
        return str;
    }
 
    int nextInt() {
        return Integer.parseInt(ns());
    }
 
    long nextLong() {
        return Long.parseLong(ns());
    }
 
    double nextDouble() {
        return Double.parseDouble(ns());
    }
	
	
	public static void main(String args[]) throws IOException {
		new Codechef().run();
	}
 
	void run() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
		solve();
		out.flush();
		out.close();
	}
 
	long power(long x,long y)
	{
		long ans=1;
		while(y!=0)
		{
			if(y%2==1)
				ans*=x;
			x=x*x;
			y/=2;
		}
		return ans;
	}

	int gcd(int x, int y)
	{
	    if (y!=0)
	        return gcd(y, x%y);
	    else
	        return x;
	}
    
	void solve(){
		int t=nextInt();
		while(t-->0)
		{
			int a=nextInt();
			int b=nextInt();
			int c=nextInt();
			int cnt=0;
			if(b>0&&c>1)
			{
				if(b>=c/2)
				{
					cnt+=3*(c/2);
					b-=c/2;
				}
				else//(b<c/2)
				{	
					cnt+=3*b;
					b=0;
					
				}
				
			}

			if(a>0&&b>1)
			{
				if(a>=b/2)
				{
					cnt+=3*(b/2);
					a-=b/2;
				}
				else//(a<b/2)
				{	
					cnt+=3*a;
					a=0;
					
				}
			}
			out.println(cnt);

		}	

	}
}
