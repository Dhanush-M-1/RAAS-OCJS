import java.util.*;
import java.io.*;

public class A2OJ
{
	public static class FastIO
	{
		BufferedReader br;
		BufferedWriter bw;
		StringTokenizer st;

		public FastIO()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			st = new StringTokenizer("");
		}

		public FastIO(int x) throws IOException
		{
			br = new BufferedReader(new FileReader("input.txt"));
			bw = new BufferedWriter(new FileWriter("output.txt"));
			st = new StringTokenizer("");
		}

		private void read() throws IOException
		{
			st = new StringTokenizer(br.readLine());
		}

		public String ns() throws IOException
		{
			if(!st.hasMoreTokens())
				read();
			return st.nextToken();
		}

		public int ni() throws IOException
		{
			return Integer.parseInt(ns());
		}

		public long nl() throws IOException
		{
			return Long.parseLong(ns());
		}

		public float nf() throws IOException
		{
			return Float.parseFloat(ns());
		}

		public double nd() throws IOException
		{
			return Double.parseDouble(ns());
		}

		public char nc() throws IOException
		{
			return ns().charAt(0);
		}

		public void out(String s) throws IOException
		{
			bw.write(s);
		}

		public void flush() throws IOException
		{
			bw.flush();
		}
	}

	public static void main(String args[]) throws IOException
	{
		FastIO f = new FastIO();

		int k = f.ni(), c[] = new int[26], i, j;
		char[] s = f.ns().toCharArray();
		StringBuilder ns = new StringBuilder();

		for(i = 0; i < s.length; i++)
			c[s[i]-'a']++;

		for(i = 0; i < 26; i++)
			if(c[i]%k != 0)
				break;

		if(i < 26)
		{
			f.out("-1\n");
			f.flush();
			return;
		}

		for(i = 0; i < 26; i++)
			for(j = 0; j < c[i]/k; j++)
				ns.append("" + (char)(i + 'a'));
		for(i = 0; i < k; i++)
			f.out(ns.toString());
		f.out("\n");

		f.flush();
	}
}