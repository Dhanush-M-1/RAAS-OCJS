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
		int k = in.nextInt()-1;
		int[] vs = new int[n]; for(int i = 0; i < n; i++) vs[i] = in.nextInt();
		k = (int)(k%((long)n*(n+1)/2));
		for(int i = 0; i < n; i++)
		{
			if(k <= i)
			{
				out.println(vs[k]);
				break;
			}
			else
			{
				k -= i+1;
			}
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
