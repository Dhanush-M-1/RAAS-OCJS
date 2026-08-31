import java.io.*;
import java.util.*;
public class Main{
	static void main() throws Exception{
		int n=sc.nextInt(),k=sc.nextInt();
		ArrayList<int[]>[][]like=new ArrayList[2][2];
		TreeSet<int[]>all=new TreeSet<>((x,y)->x[0]-y[0]==0?x[1]-y[1]:x[0]-y[0]);
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				like[i][j]=new ArrayList<>();
			}
		}
		for(int i=0;i<n;i++) {
			int t=sc.nextInt();
			like[sc.nextInt()][sc.nextInt()].add(new int[] {t,i+1});
			all.add(new int[] {t,i+1});
		}
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				Collections.sort(like[i][j],(x,y)->x[0]-y[0]);
			}
		}
		int[][][]pref=new int[2][2][];
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				pref[i][j]=new int[like[i][j].size()+1];
				for(int idx=1;idx<pref[i][j].length;idx++) {
					pref[i][j][idx]=like[i][j].get(idx-1)[0]+pref[i][j][idx-1];
				}
			}
		}
		int ans=-1;
		int ansCnt11=0;
		for(int cnt11=0;cnt11<pref[1][1].length && cnt11<=k;cnt11++) {
			int wanted=k-cnt11;
			if(wanted>=pref[1][0].length || wanted>=pref[0][1].length)continue;
			int curTime=pref[1][1][cnt11]+pref[0][1][wanted]+pref[1][0][wanted];
			if(ans==-1 || curTime<ans) {
				ans=curTime;
				ansCnt11=cnt11;
			}
		}
//		if(ans==-1) {
//			pw.println(-1);
//			return;
//		}
//		StringBuilder print=new StringBuilder();
//		for(int i=0;i<ansCnt11;i++) {
//			print.append(like[1][1].get(i)[1]+" ");
//			all.remove(like[1][1].get(i));
//		}
//		int wanted=(k-ansCnt11);
//		for(int i=0;i<wanted;i++) {
//			print.append(like[1][0].get(i)[1]+" ");
//			all.remove(like[1][0].get(i));
//		}
//		for(int i=0;i<wanted;i++) {
//			print.append(like[0][1].get(i)[1]+" ");
//			all.remove(like[0][1].get(i));
//		}
//		int rem=m-(ansCnt11+(wanted<<1));
//		while(rem-->0) {
//			int[]cur=all.pollFirst();
//			ans+=cur[0];
//			print.append(cur[1]+" ");
//		}
		pw.println(ans);
//		pw.println(print);
	}
	public static void main(String[] args) throws Exception{
		sc=new MScanner(System.in);
		pw = new PrintWriter(System.out);
		int tc=1;
//		tc=sc.nextInt();
		while(tc-->0)
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