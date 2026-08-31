import java.io.*;
import java.util.*;

public class cons {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n=sc.nextInt();
		String h=sc.nextLine();
		int c=0;
		for(int i=0;i<n;i++) {
			if(h.charAt(i)=='8')
				c++;
		}
		int ans=0;
		int l=n;
		for(int i=0;i<c && l>=11;i++) {
			ans++; l=l-11;
		}
		out.print(ans);
		out.flush();
	}
	static class pair{
		int l;
		int r;
		pair(int l,int r){
			this.l=l;
			this.r=r;
		}
		public String toString() {
			return l+" "+r;
		}
	}
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}

		public Scanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
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