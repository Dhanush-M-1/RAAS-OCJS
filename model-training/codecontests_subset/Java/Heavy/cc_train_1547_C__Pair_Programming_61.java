import java.util.*;
import java.io.*;

public class A
{

	static FastIO f;
	static double e = 0.000001;
	static double a;

	public static void main(String args[]) throws IOException
	{
		f = new FastIO();

		int t, k, n, m, a[], b[], c[], i, j, x;

		t = f.ni();

		while(t-->0)
		{
			k = f.ni();
			n = f.ni();
			m = f.ni();
			a = f.nia(n);
			b = f.nia(m);
			c = new int[n+m];

			for(i = j = x = 0; i < n || j < m;)
			{
				while(i < n && a[i] == 0)
				{
					i++;
					k++;
					c[x++] = 0;
				}

				while(j < m && b[j] == 0)
				{
					j++;
					k++;
					c[x++] = 0;
				}

				if(i < n && (j == m || b[j] > a[i]))
				{
					if(a[i] > k)
						break;
					else
					{
						c[x++] = a[i];
						i++;
					}
				}

				else if(j < m)
				{
					if(b[j] > k)
						break;
					else
					{
						c[x++] = b[j];
						j++;
					}
				}
			}

			if(i < n || j < m)
			{
				f.out("-1\n");
				continue;
			}

			for(i = 0; i < c.length; i++)
				f.out(c[i] + " ");
			f.out("\n");
		}

		f.flush();
	}

	public static class FastIO
	{
		BufferedReader br;
		BufferedWriter bw, be;
		StringTokenizer st;

		public FastIO()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			be = new BufferedWriter(new OutputStreamWriter(System.err));
			st = new StringTokenizer("");
		}

		private void read() throws IOException
		{
			st = new StringTokenizer(br.readLine());
		}

		public String ns() throws IOException
		{
			while(!st.hasMoreTokens())
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

		public int[] nia(int n) throws IOException
		{
			int[] a = new int[n];
			for(int i = 0; i < n; i++)
				a[i] = ni();

			return a;
		}

		public long[] nla(int n) throws IOException
		{
			long[] a = new long[n];
			for(int i = 0; i < n; i++)
				a[i] = nl();

			return a;
		}

		public char[] nca() throws IOException
		{
			return ns().toCharArray();
		}

		public void out(String s) throws IOException
		{
			bw.write(s);
		}

		public void flush() throws IOException
		{
			bw.flush();
			be.flush();
		}

		public void err(String s) throws IOException
		{
			be.write(s);
		}
	}
}