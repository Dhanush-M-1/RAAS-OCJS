import java.util.*;
import java.io.*;
/*

 */
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
		int x = in.nextInt();
		int y = in.nextInt();
		int target = (n*y+99)/100;
		target -= x;
		if(target < 0) target = 0;
		out.println(target);
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
		String next() throws IOException
		{
			while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		int nextInt() throws IOException
		{
			return Integer.parseInt(next());
		}
		void close() throws IOException
		{
			br.close();
		}
	}
}
