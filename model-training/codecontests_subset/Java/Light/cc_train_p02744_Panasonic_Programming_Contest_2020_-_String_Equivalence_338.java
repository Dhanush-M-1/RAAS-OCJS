import java.io.*;
import java.util.*;
 
 
public class  Main{
	static TreeSet<String>all,ans;
	static void solve(char[]in) {
		StringBuilder sb=new StringBuilder();
		for(char x:in) {
			sb.append(x);
		}
		
		if(all.contains(sb.toString()))return;
		all.add(sb.toString());
		
		
		for(int j=0;j<in.length-1;j++) {
			char c=(char)(in[j]+1);
			if(in[j+1]!=c) {
				char[]tmp=in.clone();
				tmp[j+1]=c;
				solve(tmp);
			}
		}
	}
	static void gen(StringBuilder sb,int n) {
		if(all.contains(sb.toString()))return;
		all.add(sb.toString());
		if(sb.length()==n) {
			ans.add(sb.toString());
			return;
		}
		
		
		for(int j=0;j<sb.length();j++) {
			StringBuilder tmp=new StringBuilder(sb);
			tmp.append((char)(sb.charAt(j)+1));
			gen(tmp,n);
		}
		
		for(int j=0;j<sb.length();j++) {
			StringBuilder tmp=new StringBuilder(sb);
			tmp.append(sb.charAt(j));
			gen(tmp,n);
		}
	}
	public static void main(String[] args) throws Exception{
		MScanner sc=new MScanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		char[]in=new char[sc.nextInt()];
		for(int i=0;i<in.length;i++) {
			in[i]='a';
		}
		all=new TreeSet<String>();
		ans=new TreeSet<String>();
		StringBuilder sb=new StringBuilder();
		sb.append('a');
		gen(sb, in.length);
		
//		System.out.println(ans.size());
		while(!ans.isEmpty()) {
			pw.println(ans.pollFirst());
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
