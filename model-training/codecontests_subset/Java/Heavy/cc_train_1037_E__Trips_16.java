import java.io.*;
import java.util.*;
import javafx.util.Pair;

public class HR27 {
	InputStream is;
	PrintWriter out;
	String INPUT = "";
	//boolean codechef=true;
	boolean codechef=true;
	
	void solve()
	{
	        int n=ni(),m=ni(),k=ni();
	        int[] from=new int[2*m];
	        Pair[] to=new Pair[2*m];
	        int[] deg=new int[n];
	        int[][] backup=new int[m][2];
	        boolean[] unvis=new boolean[n];
	        Arrays.fill(unvis,true);
	        for(int i=0;i<m;i++)
	        {
	                int x=ni()-1,y=ni()-1;
	                from[2*i]=x;
	                to[2*i]=new Pair(y,i);
	                from[2*i+1]=y;
	                to[2*i+1]=new Pair(x,i);
	                deg[x]++;
	                deg[y]++;
	                backup[i][0]=x;
	                backup[i][1]=y;
	        }
	        
	        Pair[][] g=packD(n,from,to);
	        TreeSet<Pair> set=new TreeSet<>(new Comparator<Pair>(){
	                public int compare(Pair p1,Pair p2)
	                {
	                        if(p1.a==p2.a)return p1.b-p2.b;
	                        return p1.a-p2.a;
	                }
	        });
	        
	        for(int i=0;i<n;i++)
	        {
	                set.add(new Pair(deg[i],i));
	        }
	        while(!set.isEmpty() && set.first().a<k)
	        {
	                Pair u=set.pollFirst();
	                unvis[u.b]=false;
	                for(Pair next:g[u.b])
	                {
	                        int v=next.a;
	                        if(unvis[v])
	                        {
	                                set.remove(new Pair(deg[v],v));
	                                deg[v]--;
	                                set.add(new Pair(deg[v],v));
	                        }
	                }
	        }
	        int[] ans=new int[m];
	        for(int i=m-1;i>=0;i--)
	        {
	                ans[i]=set.size();
	                
	                int x=backup[i][0];
	                int y=backup[i][1];
	                
	                if(unvis[x] && unvis[y])
	                {
	                        set.remove(new Pair(deg[x],x));
	                        deg[x]--;
	                        set.add(new Pair(deg[x],x));
	                        
	                        set.remove(new Pair(deg[y],y));
	                        deg[y]--;
	                        set.add(new Pair(deg[y],y));
	                        
                       	        while(!set.isEmpty() && set.first().a<k)
                	        {
                	                Pair u=set.pollFirst();
                	                unvis[u.b]=false;
                	                for(Pair next:g[u.b])
                	                {
                	                        int v=next.a;
                	                        if(next.b>=i)continue;
                	                        if(unvis[v])
                	                        {
                	                                set.remove(new Pair(deg[v],v));
                	                                deg[v]--;
                	                                set.add(new Pair(deg[v],v));
                	                        }
                	                }
                	        }
	                        
	                }
	                
	        }
	        
	        for(int i=0;i<m;i++)
	        {
	                out.println(ans[i]);
	        }
	        //out.println();
	}
	
	static Pair[][] packD(int n, int[] from, Pair[] to) {
		Pair[][] g = new Pair[n][];
		int[] p = new int[n];
		for (int f : from)
			p[f]++;
		for (int i = 0; i < n; i++)
			g[i] = new Pair[p[i]];
		for (int i = 0; i < from.length; i++) {
			g[from[i]][--p[from[i]]] = to[i];
		}
		return g;
	}
	
	public static long[] radixSort(long[] f){ return radixSort(f, f.length); }
	public static long[] radixSort(long[] f, int n)
	{
		long[] to = new long[n];
		{
			int[] b = new int[65537];
			for(int i = 0;i < n;i++)b[1+(int)(f[i]&0xffff)]++;
			for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
			for(int i = 0;i < n;i++)to[b[(int)(f[i]&0xffff)]++] = f[i];
			long[] d = f; f = to;to = d;
		}
		{
			int[] b = new int[65537];
			for(int i = 0;i < n;i++)b[1+(int)(f[i]>>>16&0xffff)]++;
			for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
			for(int i = 0;i < n;i++)to[b[(int)(f[i]>>>16&0xffff)]++] = f[i];
			long[] d = f; f = to;to = d;
		}
		{
			int[] b = new int[65537];
			for(int i = 0;i < n;i++)b[1+(int)(f[i]>>>32&0xffff)]++;
			for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
			for(int i = 0;i < n;i++)to[b[(int)(f[i]>>>32&0xffff)]++] = f[i];
			long[] d = f; f = to;to = d;
		}
		{
			int[] b = new int[65537];
			for(int i = 0;i < n;i++)b[1+(int)(f[i]>>>48&0xffff)]++;
			for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
			for(int i = 0;i < n;i++)to[b[(int)(f[i]>>>48&0xffff)]++] = f[i];
			long[] d = f; f = to;to = d;
		}
		return f;
	}
	
	static class Pair
	{
	    int a,b;
	    public Pair(int a,int b)
	    {
	        this.a=a;
	        this.b=b;
	    }
	}
	
	static int bit[];
	
    static void add(int x,int d,int n)
    {
        for(int i=x;i<=n;i+=i&-i)bit[i]+=d;
    }

    static int query(int x)
    {
        int ret=0;
        for(int i=x;i>0;i-=i&-i)
        ret+=bit[i];
        return ret;
    }
	
	static long lcm(int a,int b)
	{
		long val=a;
		val*=b;
		return (val/gcd(a,b));
	}
	
	static int gcd(int a,int b)
	{
		if(a==0)return b;
		return gcd(b%a,a);
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

	
	void run() throws Exception
	{
		if(codechef)oj=true;
		is = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		tr(System.currentTimeMillis()-s+"ms");
	}
	
	public static void main(String[] args) throws Exception {new HR27().run();}
	
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