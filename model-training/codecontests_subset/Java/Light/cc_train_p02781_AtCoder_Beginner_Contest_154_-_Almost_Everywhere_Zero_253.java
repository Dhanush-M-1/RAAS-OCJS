import java.io.*;
import java.util.*;


public class  Main{
	static char[]in;
	static int k;
	static int[][][]memo;
	static int dp(int i,int nonzero,int isSmall) {
		if(nonzero>k)return 0;
		if(i>=in.length)return nonzero==k?1:0;
		if(memo[i][nonzero][isSmall]!=-1)return memo[i][nonzero][isSmall];
		int ans=0;
		if(isSmall==1) {
			ans=dp(i+1,nonzero,isSmall)+dp(i+1,nonzero+1,isSmall)*9;
		}
		else {
			for(int d=0;d<=(in[i]-'0');d++) {
				ans+=dp(i+1,nonzero + ((d!=0)?1:0) ,d<(in[i]-'0')?1:0);
			}
		}
		return memo[i][nonzero][isSmall]=ans;
	}
	public static void main(String[] args) throws Exception{
		MScanner sc=new MScanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		in=sc.nextLine().toCharArray();
		k=sc.nextInt();
		memo=new int[in.length][k+1][2];
		for(int i[][]:memo) {
			for(int j[]:i) {
				j[0]=-1;j[1]=-1;
			}
		}
		pw.println(dp(0,0,0));
		pw.flush();
	}
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
		public int[] takearr(int n) throws IOException {
	        int[]in=new int[n];for(int i=0;i<n;i++)in[i]=nextInt();
	        return in;
		}
		public long[] takearrl(int n) throws IOException {
	        long[]in=new long[n];for(int i=0;i<n;i++)in[i]=nextLong();
	        return in;
		}
		public Integer[] takearrobj(int n) throws IOException {
	        Integer[]in=new Integer[n];for(int i=0;i<n;i++)in[i]=nextInt();
	        return in;
		}
		public Long[] takearrlobj(int n) throws IOException {
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
 
		public Long nextLong() throws IOException {
			return Long.parseLong(next());
		}
 
		public boolean ready() throws IOException {
			return br.ready();
		}
 
		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}
}