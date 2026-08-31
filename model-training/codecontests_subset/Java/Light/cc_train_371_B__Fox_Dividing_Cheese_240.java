import java.util.*;
import java.io.*;
import java.math.BigInteger;
/*

 */
public class A 
{
	public static void main(String[] arg) throws Exception
	{
		new A();
	}
	public A() throws Exception
	{
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int a = in.nextInt();
		int b = in.nextInt();
		int[] freq = new int[6];
		while(a%2 == 0)
		{
			a /= 2;
			freq[2]++;
		}
		while(b%2 == 0)
		{
			b/= 2;
			freq[2]--;
		}
		while(a%3 == 0)
		{
			a /= 3;
			freq[3]++;
		}
		while(b%3 == 0)
		{
			b/= 3;
			freq[3]--;
		}
		while(a%5 == 0)
		{
			a /= 5;
			freq[5]++;
		}
		while(b%5 == 0)
		{
			b/= 5;
			freq[5]--;
		}
		if(a != b)
		{
			System.out.println(-1);
		}
		else
		{
			System.out.println(Math.abs(freq[2])+Math.abs(freq[3])+Math.abs(freq[5]));
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
		public void close() throws IOException
		{
			br.close();
		}
		public long nextLong() throws IOException
		{
			return Long.parseLong(next());
		}
	}
}
