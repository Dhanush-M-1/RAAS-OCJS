import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args)
	{
		FastReader reader = new FastReader();
		PrintWriter writer = new PrintWriter(System.out);
			
		int n=reader.nextInt();
		
		String a=reader.next();
		int cnt=0,flag=0;
		
			int t=n/11;
			//writer.println(t);
			for(int i=0;i<n;i++)
			{
				if(a.charAt(i)=='8')
				{
					cnt++;
				}
				//writer.println(cnt);
				if(cnt>=t)
				{	flag=1;
				break;}
			}
			if(flag==1)
				writer.println(t);
			
			else
				writer.println(cnt);
		
		writer.close();
	}



	static class FastReader
	{
		BufferedReader br;
		StringTokenizer st;

		public FastReader()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next()
		{
			while (st == null || !st.hasMoreElements())
			{
				try
				{
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt()
		{
			return Integer.parseInt(next());
		}

		long nextLong()
		{
			return Long.parseLong(next());
		}

		double nextDouble()
		{
			return Double.parseDouble(next());
		}

		String nextLine()
		{
			String str = "";
			try
			{
				str = br.readLine();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			return str;
		}
	}
}

class MyList
{
	ArrayList<Integer> list = new ArrayList<>();
}