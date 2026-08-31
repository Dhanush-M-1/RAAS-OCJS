import java.io.*;
import java.util.*;
public class Main
{
	
	private void solve()throws Exception
	{
		long n=nextLong();
		long p=nextLong();
		int w=nextInt();
		int d=nextInt();
		for(int i=0;i<=w-1;i++)
		{
			long rem=p-1l*i*d;
			if(rem>=0 && rem%w==0 && rem/w+i<=n)
			{
				out.println(rem/w+" "+i+" "+(n-rem/w-i));
				return;
			}
		}
		out.println(-1);
	}

	 
	///////////////////////////////////////////////////////////

	public void run()throws Exception
	{
		br=new BufferedReader(new InputStreamReader(System.in));
		st=null;
		out=new PrintWriter(System.out);

		solve();
		
		br.close();
		out.close();
	}
	public static void main(String args[])throws Exception{
		new Main().run();
	}
	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	String nextToken()throws Exception{
		while(st==null || !st.hasMoreTokens())
		st=new StringTokenizer(br.readLine());
		return st.nextToken();
	}
	String nextLine()throws Exception{
		return br.readLine();
	}
	int nextInt()throws Exception{
		return Integer.parseInt(nextToken());
	}
	long nextLong()throws Exception{
		return Long.parseLong(nextToken());
	}
	double nextDouble()throws Exception{
		return Double.parseDouble(nextToken());
	}
}