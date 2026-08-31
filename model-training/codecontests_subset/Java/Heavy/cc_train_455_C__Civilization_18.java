import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Queue;

public class C455{

	void solve()
	{
		int n = ni(), m = ni(), Q = ni();
		int[] v1 = new int[m];
		int[] v2 = new int[m];
		DJSet2 ds = new DJSet2(n);
		for(int i = 0;i < m;i++)
		{
			v1[i] = ni()-1;
			v2[i] = ni()-1;
			ds.union(v1[i], v2[i]);
		}
		int[][] g = buildUG(n, v1, v2);
		int[] diam = new int[n];
		Arrays.fill(diam, -1>>>1);
		int[] d = new int[n];
		Arrays.fill(d, -1>>>1);
		int[] f = new int[n];
		Arrays.fill(f, -1>>>1);
		for(int i = 0;i < n;i++)
		{
			if(ds.root[i] < 0)
			{
				Queue<Integer> q = new ArrayDeque<Integer>();
				q.add(i);
				d[i] = 0;
				int far = i;
				while(!q.isEmpty())
				{
					int cur = q.poll();
					far = cur;
					for(int e : g[cur])
					{
						if(d[e] > d[cur] + 1)
						{
							d[e] = d[cur] + 1;
							q.add(e);
						}
					}
				}
				f[far] = 0;
				q.add(far);
				while(!q.isEmpty())
				{
					int cur = q.poll();
					far = cur;
					for(int e : g[cur])
					{
						if(f[e] > f[cur] + 1){
							f[e] = f[cur] + 1;
							q.add(e);
						}
					}
				}
				diam[i] = f[far];
			}
		}
		
		while(Q-->0)
		{
			int t = ni();
			if(t == 1)
			{
				int x = ni()-1;
				out.println(diam[ds.root(x)]);
			}
			else
			{
				int x = ds.root(ni()-1), y = ds.root(ni()-1);
				if(x == y)
					continue;
				int dx = diam[x], dy = diam[y];
				int ndx = Math.max(Math.max(dx, dy), (dx+1)/2+(dy+1)/2+1);
				ds.union(x, y);
				int r = ds.root(x);
				diam[r] = ndx;
			}
		}
	}
	
	public int[][] buildUG(int n,int[] v1,int[] v2)
	{
		int[][] graph = new int[n][];
		int[] cn = new int[graph.length];
		for(int i=0;i<v1.length;i++)
		{
			cn[v1[i]]++;
			cn[v2[i]]++;
		}
		for(int i=0;i<graph.length;i++)
			graph[i] = new int[cn[i]];
		for(int i=0;i<v1.length;i++)
		{
			graph[v1[i]][--cn[v1[i]]] = v2[i];
			graph[v2[i]][--cn[v2[i]]] = v1[i];
		}
		return graph;
	}
	
	public class DJSet2 {
		
		public int[] root;

		public DJSet2(int n) 
		{
			root = new int[n];
			Arrays.fill(root, -1);
		}

		public int root(int x)
		{ return root[x] < 0 ? x : (root[x] = root(root[x])); }

		public boolean find(int x, int y) 
		{ return root(x) == root(y); }

		public void union(int x, int y)
		{
			x = root(x);
			y = root(y);
			if (x != y) 
			{
				if (root[y] < root[x])
				{
					int d = x;
					x = y;
					y = d;
				}
				root[x] += root[y];
				root[y] = x;
			}
		}

	}
	
	public static void main(String[] args){new C455().run();}
	
	private byte[] bufferArray = new byte[1024];
	private int bufLength = 0;
	private int bufCurrent = 0;
	InputStream inputStream;
	PrintWriter out;
	
	public void run()
	{
		inputStream = System.in;
		out = new PrintWriter(System.out);
		solve();
		out.flush();
	}
	
	int nextByte()
	{
		if(bufLength==-1)
			throw new InputMismatchException();
		if(bufCurrent>=bufLength)
		{
			bufCurrent = 0;
			try
			{bufLength = inputStream.read(bufferArray);}
			catch(IOException e)
			{ throw new InputMismatchException();}
			if(bufLength<=0)
				return -1;
		}
		return bufferArray[bufCurrent++];
	}
	
	boolean isSpaceChar(int x)
	{return (x<33 || x>126);}
	
	boolean isDigit(int x)
	{return (x>='0' && x<='9');}
	
	int nextNonSpace()
	{
		int x;
		while((x=nextByte())!=-1 && isSpaceChar(x));
		return x;
	}
	
	int ni()
	{
		long ans = nl();
		if ( Integer.MIN_VALUE <= ans && ans <= Integer.MAX_VALUE )
			return (int)ans;
		throw new InputMismatchException();
	}
	
	long nl()
	{
		long ans = 0;
		boolean neg = false;
		int x = nextNonSpace();
		if(x=='-') 
		{
			neg = true;
			x = nextByte();
		}
		while(!isSpaceChar(x))
		{
			if(isDigit(x))
			{
				ans = ans*10 + x -'0';
				x = nextByte();
			}
			else
				throw new InputMismatchException();
		}
		return neg ? -ans:ans;
	}
	
	String ns()
	{
		StringBuilder sb = new StringBuilder();
		int x = nextNonSpace();
		while(!isSpaceChar(x))
		{
			sb.append((char)x);
			x = nextByte();
		}
		return sb.toString();
	}
	
	char nc()
	{ return (char)nextNonSpace();}
	
	double nd()
	{ return (double)Double.parseDouble(ns()); }
	
	char[] ca()
	{ return ns().toCharArray();}
	
	char[] ca(int n)
	{
		char[] ans = new char[n];
		int p =0;
		int x = nextNonSpace();
		while(p<n)
		{
			ans[p++] = (char)x;
			x = nextByte();
		}
		return ans;
	}
	
	int[] ia(int n)
	{
		int[] ans = new int[n];
		for(int i=0;i<n;i++)
			ans[i]=ni();
		return ans;
	}
	
}
