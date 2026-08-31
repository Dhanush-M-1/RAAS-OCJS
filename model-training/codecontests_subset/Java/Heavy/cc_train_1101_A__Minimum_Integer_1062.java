
import java.io.*;
import java.util.*;

public class test4 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int q=sc.nextInt();
		for(int o=0;o<q;o++) {
			int l=sc.nextInt(); int r=sc.nextInt(); int d=sc.nextInt();
			if(d>r || d<l) {
				System.out.println(d); 
			}
			else {
		    int g=r/d;
		    long ans=++g*d;
		    System.out.println(ans);}
		}
	}
	static class pair implements Comparable<pair> {
		int s;
		int e;

		public String toString() {
			return s + " " + e;
		}

		pair(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(pair o) {
			if (o.s != s)
				return s - o.s;
			return o.e - e;
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