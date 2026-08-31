import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
public class A {
	InputStream is;
	PrintWriter out;
	String INPUT = "";
	
	void solve()
	{	
		int n = ni(), m = ni(), k = ni();
		ArrayList<Integer> adj[] = (ArrayList<Integer>[]) new ArrayList[n];
		for(int i=0;i<n;i++) adj[i] = new ArrayList<>();
		int u[] = new int[m]; int v[] = new int[m];
		int degree[] = new int[n];
		for(int i=0;i<m;i++){
			int a = ni() - 1, b = ni() - 1;
			u[i] = a; v[i] = b;
			adj[a].add(i); adj[b].add(i);
			degree[a]++; degree[b]++;
		}
		ArrayList<Integer> q = new ArrayList<>();
		int head = 0;
		boolean alive[] = new boolean[m];
		Arrays.fill(alive, true);
		for(int i=0;i<n;i++){
			if(degree[i] < k) q.add(i);
		}
		int ans[] = new int[m];
		for(int day=m-1;day>=0;day--){
			while(head < q.size()){
				int id = q.get(head);
				for(int edgeId: adj[id]){
					if(!alive[edgeId]) continue;
					int other = u[edgeId] == id ? v[edgeId] : u[edgeId];
					if(degree[other]==k){
						q.add(other);
					}
					degree[other]--;
					degree[id]--;
					alive[edgeId] = false;
				}
				head++;
			}
			ans[day] = n - q.size();
			if (alive[day]) {
				if (degree[u[day]] == k)	q.add(u[day]);
				if (degree[v[day]] == k)	q.add(v[day]);
				degree[u[day]]--;
				degree[v[day]]--;
				alive[day] = false;
			}
		}
		for(int ai: ans) out.println(ai);
	}
	
	void run() throws Exception
	{
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
	}
	
	public static void main(String[] args) throws Exception { new A().run(); }
	
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
	
	private static void tr(Object... o) { System.out.println(Arrays.deepToString(o)); }
}