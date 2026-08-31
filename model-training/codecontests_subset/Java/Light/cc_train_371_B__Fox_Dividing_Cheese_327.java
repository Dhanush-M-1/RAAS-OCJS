import java.io.*;
import java.util.*;
public class Main
{
	
	private void solve()throws Exception
	{
		int a=nextInt();
		int b=nextInt();
		int f1[]=new int[6];
		int f2[]=new int[6];
		int f[]={2,3,5};
		for(int i=0;i<3;i++)
		{
			while(a%f[i]==0)
			{
				f1[f[i]]++;
				a=a/f[i];
			}
			while(b%f[i]==0)
			{
				f2[f[i]]++;
				b=b/f[i];
			}
		}
		if(a!=b)
		{
			out.println(-1);
			return;
		}
		int ans=0;
		for(int i=0;i<3;i++)
			ans+=Math.abs(f1[f[i]]-f2[f[i]]);
		out.println(ans);
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