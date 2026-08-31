import java.util.*;
import java.io.*;
import java.math.BigInteger;
/*
2 1
2 1

1 10
1
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
		int[] freq = new int[2];
		int total = 0;
		for(int i = 0; i < n; i++)
		{
			int v = in.nextInt();
			if(v == 100) freq[0]++;
			else freq[1]++;
			total += v;
		}
		int target = total/2;
		while(target >= 200 && freq[1] > 0)
		{
			target -= 200;
			freq[1]--;
		}
		while(target > 0 && freq[0] > 0)
		{
			target -= 100;
			freq[0]--;
		}
		out.println(target == 0 ? "YES":"NO");
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