import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) {new Main().run();}

	FastReader in = new FastReader();
	PrintWriter out = new PrintWriter(System.out);
	void run(){
		work();
		out.flush();
	}
	long mod=1000000007;
	long gcd(long a,long b) {
		return b==0?a:gcd(b,a%b);
	}
	
	void work() {
		long n=in.nextLong();
		long p=in.nextLong();
		long w=in.nextLong();
		long d=in.nextLong();
		for(int i=0;i<w;i++) {
			long v=p-d*i;
			if(v<0) break;
			if(v%w==0) {
				long j=v/w;
				if(i+j<=n) {
					out.println(j+" "+i+" "+(n-i-j));
					return;
				}else {
					break;
				}
			}
		}
		out.println(-1);
	}
}



class FastReader
{
	BufferedReader br;
	StringTokenizer st;

	public FastReader()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}

	public String next() 
	{
		if(st==null || !st.hasMoreElements())
		{
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	public int nextInt() 
	{
		return Integer.parseInt(next());
	}

	public long nextLong()
	{
		return Long.parseLong(next());
	}
}