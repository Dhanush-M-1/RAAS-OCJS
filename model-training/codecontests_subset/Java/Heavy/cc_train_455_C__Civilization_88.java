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
		int[] d = new int[n];
		Arrays.fill(d, -1>>>1);
		int[] f = new int[n];
		Arrays.fill(f, -1>>>1);
		for(int i=0;i<n;i++)
		{
			if(ds.head[i])
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
				ds.diam[i] = f[far];
			}
		}
		
		ds.mergeForDiams = true;
		
		while(Q-->0)
		{
			int ch = ni();
			if(ch == 1)
				out.println(ds.diam[ds.root(ni()-1)]);
			else
				ds.union(ni()-1, ni()-1);
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
		public int[] size;
		public int[] diam;
		public boolean[] head;
		public int setCount;
		public boolean mergeForDiams = false;
		
		public DJSet2(int n)
		{
			root = new int[n];
			size = new int[n];
			diam = new int[n];
			head = new boolean[n];
			setCount = n;
			for(int i=0;i<n;i++)
			{
				root[i] = i;
				size[i] = 1;
				diam[i] = -1;
				head[i] = true;
			}
		}
		
		public int root(int x)
		{ return root[root[x]] == root[x] ? root[x] : (root[x] = root(root[x]));}
		
		public boolean union(int x,int y)
		{
			int a = root(x);
			int b = root(y);
			
			if(a==b)
				return false;
			
			setCount--;
			
			if(size[a] < size[b])
			{
				head[a] = false;
				root[a] = b;
				size[b] += size[a];
				if(mergeForDiams)
					diam[b] = Math.max((diam[a]+1)/2 + (diam[b]+1)/2 + 1, Math.max(diam[a], diam[b]));
			}
			else
			{
				head[b] = false;
				root[b] = a;
				size[a] += size[b];
				if(mergeForDiams)
					diam[a] = Math.max((diam[a]+1)/2 + (diam[b]+1)/2 + 1, Math.max(diam[a], diam[b]));
			}
			return true;
		}
		
		public boolean find(int x, int y)
		{ return root(x)==root(y); }
	
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
