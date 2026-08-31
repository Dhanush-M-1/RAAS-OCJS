import java.io.*;
import java.util.*;

public class Main{
	static Boolean[][]memo;
	static int[]a,b;
	static boolean dp(int i,int j,int lines) {
		if(i>a.length || j>b.length)return false;
		if(i==a.length && j==b.length)return true;
		if(memo[i][j]!=null)return memo[i][j];
		boolean ans=false;
		if(i<a.length) {
			if(a[i]==0) {
				ans=dp(i+1, j, lines+1);
			}
			else {
				if(a[i]<=lines) {
					ans=dp(i+1, j, lines);
				}
			}
		}
		if(j<b.length) {
			if(b[j]==0) {
				ans|=dp(i, j+1, lines+1);
			}
			else {
				if(b[j]<=lines) {
					ans|=dp(i, j+1, lines);
				}
			}
		}
		return memo[i][j]=ans;
	}
	static void trace(int i,int j,int lines) {
		if(i==a.length && j==b.length)return;
		if(i<a.length) {
			if(a[i]==0) {
				if(dp(i+1, j, lines+1)) {
					pw.print(a[i]+" ");
					trace(i+1, j, lines+1);
					return;
				}
			}
			else {
				if(a[i]<=lines) {
					if(dp(i+1, j, lines)) {
						pw.print(a[i]+" ");
						trace(i+1, j, lines);
						return;
					}
				}
			}
		}
		if(j<b.length) {
			if(b[j]==0) {
				if(dp(i, j+1, lines+1)) {
					pw.print(b[j]+" ");
					trace(i, j+1, lines+1);
					return;
				}
			}
			else {
				if(b[j]<=lines) {
					if(dp(i, j+1, lines)) {
						pw.print(b[j]+" ");
						trace(i, j+1, lines);
						return;
					}
				}
			}
		}
	}
	static void main() throws Exception{
		int k=sc.nextInt(),n=sc.nextInt(),m=sc.nextInt();
		a=sc.intArr(n);
		b=sc.intArr(m);
		memo=new Boolean[n+1][m+1];
		if(!dp(0, 0, k)) {
			pw.println(-1);
			return;
		}
		trace(0, 0, k);
		pw.println();
	}
	public static void main(String[] args) throws Exception{
		sc=new MScanner(System.in);
		pw = new PrintWriter(System.out);
		int tc=1;
        tc=sc.nextInt();
		for(int i=1;i<=tc;i++) {
//			pw.printf("Case #%d: ", i);
			main();
		}
		
		pw.flush();
	}
	static PrintWriter pw;
	static MScanner sc;
	static class MScanner {
		StringTokenizer st;
		BufferedReader br;
		public MScanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}
	 
		public MScanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}
	 
		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public int[] intArr(int n) throws IOException {
	        int[]in=new int[n];for(int i=0;i<n;i++)in[i]=nextInt();
	        return in;
		}
		public long[] longArr(int n) throws IOException {
	        long[]in=new long[n];for(int i=0;i<n;i++)in[i]=nextLong();
	        return in;
		}
		public int[] intSortedArr(int n) throws IOException {
	        int[]in=new int[n];for(int i=0;i<n;i++)in[i]=nextInt();
	        shuffle(in);
	        Arrays.sort(in);
	        return in;
		}
		public long[] longSortedArr(int n) throws IOException {
	        long[]in=new long[n];for(int i=0;i<n;i++)in[i]=nextLong();
	        shuffle(in);
	        Arrays.sort(in);
	        return in;
		}
		public Integer[] IntegerArr(int n) throws IOException {
	        Integer[]in=new Integer[n];for(int i=0;i<n;i++)in[i]=nextInt();
	        return in;
		}
		public Long[] LongArr(int n) throws IOException {
	        Long[]in=new Long[n];for(int i=0;i<n;i++)in[i]=nextLong();
	        return in;
		}
		public String nextLine() throws IOException {
			return br.readLine();
		}
	 
		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	 
		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
	 
		public char nextChar() throws IOException {
			return next().charAt(0);
		}
	 
		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
	 
		public boolean ready() throws IOException {
			return br.ready();
		}
	 
		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
		
	}
	static void dbg(int[]in) {
		System.out.println(Arrays.toString(in));
	}
	static void dbg(long[]in) {
		System.out.println(Arrays.toString(in));
	}
	static void sort(int[]in) {
		shuffle(in);
		Arrays.sort(in);
	}
	static void sort(long[]in) {
		shuffle(in);
		Arrays.sort(in);
	}
	static void shuffle(int[]in) {
		for(int i=0;i<in.length;i++) {
			int idx=(int)(Math.random()*in.length);
			int tmp=in[i];
			in[i]=in[idx];
			in[idx]=tmp;
		}
	}
	static void shuffle(long[]in) {
		for(int i=0;i<in.length;i++) {
			int idx=(int)(Math.random()*in.length);
			long tmp=in[i];
			in[i]=in[idx];
			in[idx]=tmp;
		}
	}
}