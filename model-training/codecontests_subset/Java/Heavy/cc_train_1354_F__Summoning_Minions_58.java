import java.io.*;
import java.util.*;

public class gym{
	static int n,k;
	static int[][]in;
	static long[][]memo;
	static long inf=(long)1e12;


	static long dp(int i,int takenInFirstK){
		if(takenInFirstK>k)return -inf;
		if(i>=n)return (takenInFirstK==k)?0:-inf;
		if(memo[i][takenInFirstK]!=-1)return memo[i][takenInFirstK];

		long take=dp(i+1, takenInFirstK+1)+in[i][0]+(in[i][1]*takenInFirstK);
		long takeAndDelete=dp(i+1, takenInFirstK)+(in[i][1]*(k-1));
		return memo[i][takenInFirstK]=Math.max(take, takeAndDelete);
	}
	static int chooseLast;
	static LinkedList<Integer> print,takeAndDel;

	static void trace(int i,int takenInFirstK){
		if(takenInFirstK>k)return;
		if(i>=n)return;

		long ans=dp(i, takenInFirstK);

		long take=dp(i+1, takenInFirstK+1)+in[i][0]+(in[i][1]*takenInFirstK);
		if(ans==take){
			if(takenInFirstK+1==k){
				chooseLast=in[i][2];
			}
			else{
				print.add(in[i][2]);
			}
			trace(i+1, takenInFirstK+1);
		}
		else{
			takeAndDel.add(in[i][2]);
			trace(i+1, takenInFirstK);
		}
	}
	static void main() throws Exception{
		n=sc.nextInt();k=sc.nextInt();
		in=new int[n][];
		for(int i=0;i<n;i++){
			in[i]=new int[] {sc.nextInt(),sc.nextInt(),i+1};
		}
		Arrays.sort(in,(x,y)->x[1]==y[1]?x[0]-y[0]:x[1]-y[1]);
		memo=new long[n][k+1];
		for(int i=0;i<n;i++){
			for(int j=0;j<=k;j++){
				memo[i][j]=-1;
			}
		}
		chooseLast=-1;
		takeAndDel=new LinkedList<>();
		print=new LinkedList<>();
		trace(0, 0);
		while(takeAndDel.size()>0){
			int x=takeAndDel.pollFirst();
			print.add(x);
			print.add(-x);
		}

		if(chooseLast!=-1){
			print.add(chooseLast);
		}
		pw.println(print.size());
		while(print.size()>0){
			int x=print.pollFirst();
			pw.print(x+" ");
		}
		pw.println();
		
	
	}
	public static void main(String[] args) throws Exception{
		pw=new PrintWriter(System.out);
		sc = new MScanner(System.in);
		int tc=sc.nextInt();
		while(tc-->0)main();
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
