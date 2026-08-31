//package feb18;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;


public class EdRnd37 {
	InputStream is;
	PrintWriter out;
	String INPUT = "";
	
	static boolean[] pchk=new boolean[200050];

	int lc = 1;
	ArrayList<Integer> Vl[]=new ArrayList[200050];

	int[] r=new int[200050];
	int[] sz=new int[200050];

	void solve()
	{
		int n=ni();
		int m=ni();
		int[] from=new int[2*m];
		int[] to=new int[2*m];
		HashSet<Long> set=new HashSet<Long>();
		for(int i=0;i<m;i++)
		{
			int u=ni()-1;
			int v=ni()-1;
			set.add(Math.min(u, v)+(long)1000000009*Math.max(u, v));
			from[2*i]=u;
			to[2*i]=v;
			from[2*i+1]=v;
			to[2*i+1]=u;
		}
		int[][] g=packD(n, from, to);
		int p=0;
		for(int i=1;i<n;i++)
		{
			if(g[i].length<g[p].length)p=i;
		}
		for(int i:g[p])
		{
			pchk[i]=true;
		}
		Vl[1]=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		{
			if(!pchk[i])Vl[1].add(i);
		}
		for(int i=0;i<n;i++)
		{
			if(!pchk[i])continue;
			lc++;
			Vl[lc]=new ArrayList<Integer>();
			Vl[lc].add(i);
		}
		for(int i=1;i<=lc;i++)
		{
			r[i]=i;
		}
		for(int i=1;i<=lc;i++)
		{
			for(int j=i+1;j<=lc;j++)
			{
				boolean check=false;
				for(int c1:Vl[i])
				{
					for(int c2:Vl[j])
					{
						if(set.contains(Math.min(c1, c2)+(long)1000000009*Math.max(c1, c2)))
							continue;
						check=true;
						break;
					}
				}
				if(check)r[root(i)]=root(j);
			}
		}
		for(int i=1;i<=lc;i++)
		{
			sz[root(i)]+=Vl[i].size();
		}
		ArrayList<Integer> ans=new ArrayList<Integer>();
		for(int i=1;i<=lc;i++)
		{
			if(r[i]==i)ans.add(sz[i]);
		}
		ans.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}});
		out.println(ans.size());
		for(int i:ans)
		{
			out.print(i+" ");
		}
		out.println();
	}
	
	private int root(int x)
	{
		if(x==r[x])return x;
		else return r[x]=root(r[x]);
	}

	static int pow(int a, int b, int p)
	{
		long ans = 1, base = a;
		while (b!=0)
		{
			if ((b & 1)!=0)
			{
				ans *= base;
				ans%= p;
			}
			base *= base;
			base%= p;
			b >>= 1;
		}
		return (int)ans;
	}

	static int inv(int x, int p)
	{
		return pow(x, p - 2, p);
	}
	
	static int[][] packD(int n, int[] from, int[] to) {
		int[][] g = new int[n][];
		int[] p = new int[n];
		for (int f : from)
			p[f]++;
		for (int i = 0; i < n; i++)
			g[i] = new int[p[i]];
		for (int i = 0; i < from.length; i++) {
			g[from[i]][--p[from[i]]] = to[i];
		}
		return g;
	}

	
	public static int[] sortTopologically(int[][] g)
	{
		int n = g.length;
		int[] ec = new int[n];
		for(int i = 0;i < n;i++){
			for(int to : g[i])ec[to]++;
		}
		int[] ret = new int[n];
		int q = 0;
		
		// sources
		for(int i = 0;i < n;i++){
			if(ec[i] == 0)ret[q++] = i;
		}
		
		for(int p = 0;p < q;p++){
			for(int to : g[ret[p]]){
				if(--ec[to] == 0)ret[q++] = to;
			}
		}
		// loop
		for(int i = 0;i < n;i++){
			if(ec[i] > 0)return null;
		}
		return ret;
	}

	
	void run() throws Exception
	{
		is = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		tr(System.currentTimeMillis()-s+"ms");
	}
	
	public static void main(String[] args) throws Exception {new EdRnd37().run();}
	
	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;
	
	private int readByte()
	{
		if(lenbuf == -1)throw new InputMismatchException();
		if(ptrbuf >= lenbuf){
			ptrbuf = 0;
			try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
			if(lenbuf <= 0)return -1;
		}
		return inbuf[ptrbuf++];
	}
	
	private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
	private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
	
	private double nd() { return Double.parseDouble(ns()); }
	private char nc() { return (char)skip(); }
	
	private String ns()
	{
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	private char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while(p < n && !(isSpaceChar(b))){
			buf[p++] = (char)b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	private char[][] nm(int n, int m)
	{
		char[][] map = new char[n][];
		for(int i = 0;i < n;i++)map[i] = ns(m);
		return map;
	}
	
	private int[] na(int n)
	{
		int[] a = new int[n];
		for(int i = 0;i < n;i++)a[i] = ni();
		return a;
	}
	
	private int ni()
	{
		int num = 0, b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private long nl()
	{
		long num = 0;
		int b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private boolean oj = System.getProperty("ONLINE_JUDGE") != null;
	private void tr(Object... o) { if(!oj)System.out.println(Arrays.deepToString(o)); }
}
