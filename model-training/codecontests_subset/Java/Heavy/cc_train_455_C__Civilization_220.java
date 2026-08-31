
import java.io.*;
import java.math.*;
import java.util.*;

import static java.util.Arrays.fill;
import static java.lang.Math.*;
import static java.util.Arrays.sort;
import static java.util.Collections.sort;


public class C455 
{

	public static int mod = 1000000007;
	public static long INF = (1L << 60);
	static FastScanner2 in = new FastScanner2();
	static OutputWriter out = new OutputWriter(System.out);
 
	static int n;
	static int m;
	static ArrayList<Integer>[] adjlist;
	static int[] parent;
	static int[] size;
	static int[] diameter;
	static int[] depth;
	static int[] used;
	static int comp=1;
	static int maxd=0;
	static int ver=0;
	
	public static int getroot(int i)
	{
		if(parent[i]==i)
			return i;
		return getroot(parent[i]);
	}
	
	public static void union(int u,int v)
	{
		int x=getroot(u);
		int y=getroot(v);
		if(x==y)
			return;
		if(size[x]>size[y])
		{
			union(v, u);
			return;
		}
		size[y]+=size[x];
		diameter[y]=max(diameter[x], max(diameter[y], (diameter[x]+1)/2+(diameter[y]+1)/2+1));
		parent[x]=y;
	}
	
	public static void dfs(int v,int p,int dep)
	{
		used[v]=comp;
		depth[v]=dep;
		if(depth[v]>=maxd)
		{
			maxd=depth[v];
			ver=v;
		}
		for(int u : adjlist[v])
		{
			if(u==p)
				continue;
			dfs(u, v, dep+1);
		}
	}
	
	public static int finddiameter(int v)
	{
		maxd=0;
		ver=0;
		dfs(v, -1, 0);
		maxd=0;
		dfs(ver, -1, 0);
		return maxd;
	}
	
	public static void main(String[] args) 
	{

		n=in.nextInt();
		m=in.nextInt();
		int q=in.nextInt();
		adjlist=new ArrayList[n+1];
		parent=new int[n+1];
		diameter=new int[n+1];
		size=new int[n+1];
		used=new int[n+1];
		depth=new int[n+1];
		for(int i=1;i<=n;i++)
		{
			parent[i]=i;
			size[i]=1;
			adjlist[i]=new ArrayList<>();
		}
		for(int i=1;i<=m;i++)
		{
			int u=in.nextInt();
			int v=in.nextInt();
			adjlist[u].add(v);
			adjlist[v].add(u);
			union(u, v);
		}
		
		for(int i=1;i<=n;i++)
		{
			if(used[i]==0)
			{
				comp++;
				diameter[getroot(i)]=finddiameter(i);
			}
		}
		while(q-->0)
		{
			int type=in.nextInt();
			if(type==1)
			{
				out.println(diameter[getroot(in.nextInt())]);
			}
			else
			{
				int u=in.nextInt();
				int v=in.nextInt();
				if(getroot(u)==getroot(v))
					continue;
				else
					union(u, v);
			}
		}
		out.close();
		

	}
	

	static class FastScanner2 
	{
		private byte[] buf = new byte[1024];
		private int curChar;
		private int snumChars;

		public int read() 
		{
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) 
			{
				curChar = 0;
				try 
				{
					snumChars = System.in.read(buf);
				} catch (IOException e) 
				{
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public String nextLine() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do 
			{
				res.appendCodePoint(c);
				c = read();
			} 
			while (!isEndOfLine(c));
			return res.toString();
		}

		public String nextString() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do 
			{
				res.appendCodePoint(c);
				c = read();
			} 
			while (!isSpaceChar(c));
			return res.toString();
		}

		public long nextLong()
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do 
			{
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} 
			while (!isSpaceChar(c));
			return res * sgn;
		}

		public int nextInt() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do 
			{
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} 
			while (!isSpaceChar(c));
			return res * sgn;
		}

		public int[] nextIntArray(int n)
		{
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) 
			{
				arr[i] = nextInt();
			}
			return arr;
		}

		public long[] nextLongArray(int n)
		{
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) 
			{
				arr[i] = nextLong();
			}
			return arr;
		}

		private boolean isSpaceChar(int c)
		{
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c) 
		{
			return c == '\n' || c == '\r' || c == -1;
		}
	}


	static class OutputWriter 
	{
		private final PrintWriter writer;

		public OutputWriter(OutputStream outputStream) 
		{
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}

		public OutputWriter(Writer writer)
		{
			this.writer = new PrintWriter(writer);
		}

		public void print(Object... objects)
		{
			for (int i = 0; i < objects.length; i++) 
			{
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}

		public void println(Object... objects)
		{
			print(objects);
			writer.println();
		}

		public void close() 
		{
			writer.close();
		}

		public void flush() 
		{
			writer.flush();
		}
	}
private static boolean oj = System.getProperty("ONLINE_JUDGE") != null;
	
	private static void debug(Object... o) 
	{
		if (!oj)
			System.out.println(Arrays.deepToString(o));
	}
	private static void tr(Object... o) 
	{
		if (!oj)
			System.out.println(Arrays.deepToString(o));
	}
}