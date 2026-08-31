import java.util.*;
import java.io.*;
public class d 
{
	public static void main(String[] arg) throws IOException
	{
		new d();
	}
	public d() throws IOException
	{
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int m = in.nextInt();
		int q = in.nextInt();
		int[] u = new int[m];
		int[] v = new int[m];
		long[] w = new long[m];
		for(int i = 0; i < m; i++)
		{
			u[i] = in.nextInt()-1;
			v[i] = in.nextInt()-1;
			w[i] = ((long)in.nextInt())<<32|i;
		}
		w = radixSort(w);
		for(int qq = 0; qq < q; qq++)
		{
			int l = in.nextInt()-1;
			int r = in.nextInt()-1;
			boolean f = true;
			DJ dj = new DJ(2*n);
			for(int i = m-1; i >= 0; i--)
			{
				int id = (int)w[i];
				if(l <= id && id <= r)
				{
					if(!dj.union(2*v[id],  2*u[id]+1)) continue;
					dj.union(2*v[id]+1, 2*u[id]);
					if(dj.find(2*v[id]) == dj.find(2*u[id]))
					{
						f = false;
						out.println((w[i]>>>32));
						break;
					}
				}
			}
			if(f) out.println(-1);
		}
		in.close(); out.close();
	}
	public long[] radixSort(long[] f)
	{
		long[] to = new long[f.length];
		{
			int[] b = new int[65537];
			for(int i = 0;i < f.length;i++)b[1+(int)(f[i]&0xffff)]++;
			for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
			for(int i = 0;i < f.length;i++)to[b[(int)(f[i]&0xffff)]++] = f[i];
			long[] d = f; f = to;to = d;
		}
		{
			int[] b = new int[65537];
			for(int i = 0;i < f.length;i++)b[1+(int)(f[i]>>>16&0xffff)]++;
			for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
			for(int i = 0;i < f.length;i++)to[b[(int)(f[i]>>>16&0xffff)]++] = f[i];
			long[] d = f; f = to;to = d;
		}
		{
			int[] b = new int[65537];
			for(int i = 0;i < f.length;i++)b[1+(int)(f[i]>>>32&0xffff)]++;
			for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
			for(int i = 0;i < f.length;i++)to[b[(int)(f[i]>>>32&0xffff)]++] = f[i];
			long[] d = f; f = to;to = d;
		}
		{
			int[] b = new int[65537];
			for(int i = 0;i < f.length;i++)b[1+(int)(f[i]>>>48&0xffff)]++;
			for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
			for(int i = 0;i < f.length;i++)to[b[(int)(f[i]>>>48&0xffff)]++] = f[i];
			long[] d = f; f = to;to = d;
		}
		return f;
	}
	class DJ
	{
		int[] vs;
		public DJ(int s)
		{
			vs = new int[s];
			Arrays.fill(vs, -1);
		}
		int find(int v)
		{
			if(vs[v] < 0) return v;
			return (vs[v] = find(vs[v]));
		}
		boolean union(int a, int b)
		{
			int pa = find(a);
			int pb = find(b);
			if(pa == pb) return false;
			if(vs[pa] <= vs[pb])
			{
				vs[pa] += vs[pb];
				vs[pb] = pa;
			}
			else
			{
				vs[pb] += vs[pa];
				vs[pa] = pb;
			}
			return true;
		}
	}
	class Edge implements Comparable<Edge>
	{
		int u, v, w, id;
		public Edge(int a, int b, int c, int d)
		{
			u = a;
			v = b;
			w = c;
			id = d;
		}
		public int compareTo(Edge e)
		{
			return -Integer.compare(w, e.w);
		}
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
	}
}
