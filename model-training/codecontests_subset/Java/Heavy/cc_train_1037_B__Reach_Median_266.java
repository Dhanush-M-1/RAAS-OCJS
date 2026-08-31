import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;

public class template {
	InputStream is;
	PrintWriter out;
	String INPUT = "";

	void solve()
	{	
		int n = ni();
		int s = ni();
		int a[] = na(n);
		
		Arrays.sort(a);
		
		for(int i = 0 ; i<n ; i++) {
			if(a[i] == s) {
				if(i == n/2) {
					out.println(0);
					return;
				}
				else {
					if(i > n/2) {
						long sum = 0;
						for(int j = i-1 ; j>=n/2 ; j--) sum += (s - a[j]);
						
						out.println(sum);
						return ;
					}
					else {
						
						long sum = 0;
						for(int j = i+1 ; j<=n/2; j++) sum += (a[j] - s);
						out.println(sum);
						return ;						
					}
				}
			}
		}
		
		int i = 0;
		if(s < a[i]) {
			
			long sum = 0;
			for(i = 0 ; i<=n/2 ; i++) sum += (a[i] - s);
			
			out.println(sum);
			return;
		}
		for(i = 0 ; i<n-1 ; i++) {
			if(a[i] < s && a[i+1] > s) {
				if(i == n/2) {
					out.println(s-a[i]);
					return ;
				}
				else {
					long sum = 0;
					if(i > n/2) {
						for(int j = i ; j>=n/2 ; j--) sum += (s - a[j]);
						
						out.println(sum);
						return;
					}
					else {
						for(int j = i+1 ; j<=n/2 ; j++) sum += (a[j] - s);
						
						out.println(sum);
						return;
					}
				}
			}
		}
		long sum = 0;
		for(i = n-1 ; i>=n/2 ; i--) sum += (s-a[i]);
		out.println(sum);
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
	
	public static void main(String[] args) throws Exception { new template().run(); }
	
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
	
	void display2D(int a[][]) {
		for(int i[] : a) {
			for(int j : i) {
				out.print(j+" ");
			}
			out.println();
		}
	}
	
	private static void tr(Object... o) { System.out.println(Arrays.deepToString(o)); }
}