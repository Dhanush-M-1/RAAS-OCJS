import java.util.*;
import java.io.*;
public class a 
{
	public static void main(String[] arg) throws IOException
	{
		new a();
	}
	public a() throws IOException
	{
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int m = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		if(m < n-1 + 2 || n == 4)
		{
			out.println("-1");
		}
		else
		{
			ArrayList<Integer> path1 = new ArrayList<Integer>();
			for(int i = 1; i <= n; i++)
			{
				if(i == a || i == b || i == c || i == d) continue;
				path1.add(i);
			}
			out.print(a + " " + c + " ");
			for(int v : path1) out.print(v + " ");
			out.print(d + " " + b);
			out.println();
			out.print(c + " " + a + " ");
			for(int v : path1) out.print(v + " ");
			out.print(b + " " + d);
			out.println();
		}
		in.close(); out.close();
	}

	class FastScanner
	{
		BufferedReader br;
		StringTokenizer st;
		public FastScanner(InputStream in)
		{
			br = new BufferedReader(new InputStreamReader(in));
			st = new StringTokenizer("");
		}
		public String next() throws IOException
		{
			while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public int nextInt() throws IOException
		{
			return Integer.parseInt(next());
		}
		void close() throws IOException
		{
			br.close();
		}
	}
}
