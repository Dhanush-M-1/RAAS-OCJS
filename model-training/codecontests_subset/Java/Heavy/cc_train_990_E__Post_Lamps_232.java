import java.io.*;
import java.util.*;
 
public class  Main{

	public static void main(String[] args) throws Exception{
		MScanner sc=new MScanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();
		int[]in=new int[n];
		for(int i=0;i<m;i++) {
			in[sc.nextInt()]=1;
		}
		if(in[0]==1) {
			pw.println(-1);
			pw.flush();
			return;
		}
		int[]last0=new int[n];
		for(int i=1;i<n;i++) {
			if(in[i]==0) {
				last0[i]=i;
			}
			else {
				last0[i]=last0[i-1];
			}
		}
		int[]p=sc.takearr(k);
		long ans=-1;
		for(int power=1;power<=k;power++) {
			int cur=0;
			boolean yes=true;
			long cost=0;
			while(cur<n) {
				if(cur+power<n && last0[cur+power]==cur) {
					yes=false;break;
				}
				cost+=p[power-1];
				if(cur+power>=n)break;
				cur=last0[cur+power];
			}
			if(yes) {
				if(ans==-1 || cost<ans)ans=cost;
			}
		}
		pw.println(ans);
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