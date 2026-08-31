import java.io.*;
import java.util.*;
public class B {
	static PrintWriter out=new PrintWriter(System.out);
	public static int max(int a,int b) {return Math.max(a, b);}
	public static int min(int a,int b) {return Math.min(a, b);}
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		String a=sc.next();
		String b=sc.next();
		int n=sc.nextInt();
		out.println(a+" "+b);
		while(n-->0) {
			String r=sc.next();
			String New=sc.next();
			if(a.equals(r))a=New;
			else b=New;
			out.println(a+" "+b);
		}
		out.close();
	}
	
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;
		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}
		public Scanner(String file) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(file));
		}
		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
		public String nextLine() throws IOException {
			return br.readLine();
		}
		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
		public boolean ready() throws IOException {
			return br.ready();
		}
		public int[] nextIntArr(int n) throws IOException{
			int arr[]=new int[n];
			for(int i=0;i<n;i++)arr[i]=nextInt();
			return arr;
		}
		
	}
}
