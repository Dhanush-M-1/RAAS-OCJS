import java.io.*;
import java.util.*;

public class Main{
	static HashSet<Integer>[]adj;
	static TreeSet<Integer>unvisited;
	static int n;
	static int dfs(int i) {
		unvisited.remove(i);
		int visited=-1;
		int cnt=1;
		while(visited<n-1) {
			Integer smallestUnvisited=unvisited.ceiling(visited+1);
			if(smallestUnvisited==null)break;
			visited=smallestUnvisited;
			if(!adj[i].contains(smallestUnvisited)) {
				cnt+=dfs(smallestUnvisited);
			}
		}
		return cnt;
	}
   	static void main() throws Exception{
   		n=sc.nextInt();int m=sc.nextInt();
   		adj=new HashSet[n];
   		for(int i=0;i<n;i++)adj[i]=new HashSet<>();
   		for(int i=0;i<m;i++) {
   			int x=sc.nextInt()-1,y=sc.nextInt()-1;
   			adj[x].add(y);
   			adj[y].add(x);
   		}
   		PriorityQueue<Integer>ans=new PriorityQueue<>();
   		unvisited=new TreeSet<>();
   		for(int i=0;i<n;i++)unvisited.add(i);
   		
   		for(int i=0;i<n;i++) {
   			if(unvisited.contains(i)) {
   				ans.add(dfs(i));
   			}
   		}
   		pw.println(ans.size());
   		while(!ans.isEmpty())pw.print(ans.poll()+" ");
   		pw.println();
	}
	public static void main(String[] args) throws Exception{
		pw=new PrintWriter(System.out);
		sc = new MScanner(System.in);
//		int tc=sc.nextInt();
//		while(tc-->0)
			main();
		pw.flush();
	}
	static PrintWriter pw;
	static MScanner  sc;
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