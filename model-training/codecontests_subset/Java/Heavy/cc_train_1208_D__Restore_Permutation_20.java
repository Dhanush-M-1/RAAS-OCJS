import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	static final long INF = (long)1e16 + 239;
	static final int MAXN = (int)1e6 + 239;
	static long[] a = new long[MAXN];
	
	public static void main (String[] args) throws java.lang.Exception
	{
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskD solver= new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
	
	static class TaskD
	{
		void solve(int TestCase, InputReader in, PrintWriter out)
		{
			int n = in.nextInt();
			for(int i = 0; i < n; i++)
			{
				a[i] = in.nextLong();
			}
			
			SegmentTree tree = new SegmentTree();
			tree.init(n);
			int[] ans = new int[n];
			for(int i = 0; i < n; i++) ans[i] = -1;
			for(int i = 1; i <= n; i++)
			{
				int pos = tree.last_zero();
				ans[pos] = i;
				tree.add(pos, INF);
				tree.add(pos + 1, n, -i);
			}
			
			for(int t : ans)
			{
				out.print(t + " ");
			}
			
			out.println();
		}
	}
	
	static class SegmentTree
	{
		int n;
		long[] t = new long[4 * MAXN];
		long[] mod = new long[4 * MAXN];
		
		void pull(int v)
		{
			t[v] = Math.min(t[2 * v + 1], t[2 * v + 2]);
		}
		
		void apply(int v, long val)
		{
			t[v] += val;
			mod[v] += val;
		}
		
		void push(int v)
		{
			if(mod[v] != 0)
			{
				apply(2 * v + 1, mod[v]);
				apply(2 * v + 2, mod[v]);
				mod[v] = 0;
			}
		}
		
		void build(int v, int l, int r)
		{
			if(l + 1 == r)
			{
				t[v] = a[l];
			}
			else
			{
				int m = (r + l) >> 1;
				build(2 * v + 1, l, m);
				build(2 * v + 2, m, r);
				pull(v);
			}
		}
		
		void add(int v, int l, int r, int ql, int qr, long val)
		{
			if(r <= ql || qr <= l)
			{
				return;
			}
			else if(ql <= l && r <= qr)
			{
				apply(v, val);
			}
			else
			{
				push(v);
				int m = (r + l) >> 1;
				add(2 * v + 1, l, m, ql, qr, val);
				add(2 * v + 2, m, r, ql, qr, val);
				pull(v);
			}
		}
		
		int go_down(int v, int l, int r)
		{
			if(l + 1 == r)
			{
				return l;
			}
			else
			{
				push(v);
				int m = (r + l) >> 1;
				int res = -1;
				if(t[2 * v + 2] == 0)
				{
					res = go_down(2 * v + 2, m, r);
				}
				else
				{
					res = go_down(2 * v + 1, l, m);
				}
				
				pull(v);
				return res;
			}
		}
		
		void init(int _n)
		{
			n = _n;
			build(0, 0, n);
		}
		
		void add(int l, int r, long val)
		{
			add(0, 0, n, l, r, val);
		}
		
		void add(int pos, long val)
		{
			add(0, 0, n, pos, pos + 1, val);
		}
		
		int last_zero()
		{
			return go_down(0, 0, n);
		}
	}
	
	static class InputReader
	{
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		
		public InputReader(InputStream stream)
		{
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}
		
		public String next()
		{
			while(tokenizer == null || !tokenizer.hasMoreTokens())
			{
				try
				{
					tokenizer = new StringTokenizer(reader.readLine());
				}
				catch(IOException e)
				{
					throw new RuntimeException(e);
				}
			}
			
			return tokenizer.nextToken();
		}
		
		public int nextInt()
		{
			return Integer.parseInt(next());
		}
		
		public long nextLong()
		{
			return Long.parseLong(next());
		}
	}
}