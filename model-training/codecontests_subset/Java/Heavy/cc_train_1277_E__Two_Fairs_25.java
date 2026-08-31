import java.io.*;
import java.util.*;
 
public class  gym{
	static LinkedList<Integer>adjList[];
	static int cnt;
	static boolean[]v;
	static void dfs(int i,int avoid) {
		v[i]=true;
		cnt++;
		for(int j:adjList[i]) {
			if(!v[j] && j!=avoid) {
				dfs(j,avoid);
			}
		}
	}
	public static void main(String[] args) throws Exception{
		MScanner sc=new MScanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt(),m=sc.nextInt(),a=sc.nextInt()-1,b=sc.nextInt()-1;
			adjList=new LinkedList[n];for(int i=0;i<n;i++)adjList[i]=new LinkedList<Integer>();
			for(int i=0;i<m;i++) {
				int u=sc.nextInt()-1,v=sc.nextInt()-1;
				adjList[u].add(v);adjList[v].add(u);
			}
			cnt=0;
			v=new boolean[n];
			dfs(a,b);
			int cntb=n-cnt-1;
			
			cnt=0;
			v=new boolean[n];
			dfs(b,a);
			int cnta=n-cnt-1;
			pw.println(cnta*1l*cntb);
		}
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