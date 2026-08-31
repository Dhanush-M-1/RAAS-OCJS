import java.util.*;
import java.io.*;

public class G
{
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
			return f.ns().toCharArray();
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

	static FastIO f;

	public static void main(String args[]) throws IOException
	{
		f = new FastIO();

		int t, n, m, i, j;
		long a[], x[], ans, max;
		TreeMap<Long, Long> h;
		Map.Entry<Long, Long> e;
		
		t = f.ni();
		
		while(t-->0)
		{
			n = f.ni();
			m = f.ni();
			a = f.nla(n);
			x = f.nla(m);
			h = new TreeMap<>();
			h.put(0L, 0L);

			for(i = 1, max = a[0], h.put(a[0], 1L); i < n; i++)
			{
				a[i] += a[i-1];
				max = Math.max(max, a[i]);
				if(a[i] > h.lastKey())
					h.putIfAbsent(a[i], (long)(i+1));
			}

			for(i = 0; i < m; i++)
			{
				if(x[i] > max && a[n-1] <= 0)
					f.out("-1 ");
				else
				{
					ans = (a[n-1] <= 0) ? 0 : (x[i] - max + a[n-1] - 1)/a[n-1];
					ans = Math.max(ans, 0);
					e = h.ceilingEntry(x[i] - ans*a[n-1]);
					// f.err(h + " " + ans + " " + e + " ");
					ans = ans*n + e.getValue() - 1;
					f.out(ans + " ");
					// f.flush();
				}
			}
			f.out("\n");
		}

		f.flush();
	}
}