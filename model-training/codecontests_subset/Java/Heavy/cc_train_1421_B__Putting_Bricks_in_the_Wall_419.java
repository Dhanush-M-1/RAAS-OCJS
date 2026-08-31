import java.util.*;
import java.io.*;

public class B2
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

		int t, n, i, j, k, l;
		char[][] g;
		
		t = f.ni();
		
		while(t-->0)
		{
			n = f.ni();
			g = new char[n][];
			for(i = 0; i < n; i++)
				g[i] = f.ns().toCharArray();
			i = 0;
			j = 1;
			k = n-2;
			l = n-1;

			if(g[i][j] == g[j][i])
			{
				if(g[k][l] == g[l][k])
				{
					if(g[k][l] == g[i][j])
						f.out("2\n" + (l+1) + " " + (k+1) + "\n" + (k+1) + " " + (l+1) + "\n");
					else
						f.out("0\n");
				}
				else
				{
					if(g[k][l] == g[i][j])
						f.out("1\n" + (k+1) + " " + (l+1) + "\n");
					else
						f.out("1\n" + (l+1) + " " + (k+1) + "\n");
				}
			}
			else
			{
				if(g[k][l] == g[l][k])
				{
					if(g[k][l] == g[i][j])
						f.out("1\n" + (i+1) + " " + (j+1) + "\n");
					else
						f.out("1\n" + (j+1) + " " + (i+1) + "\n");
				}
				else
				{
					if(g[i][j] == g[k][l])
						f.out("2\n" + (i+1) + " " + (j+1) + "\n" + (l+1) + " " + (k+1) + "\n");
					else
						f.out("2\n" + (i+1) + " " + (j+1) + "\n" + (k+1) + " " + (l+1) + "\n");
				}
			}
		}

		f.flush();
	}
}