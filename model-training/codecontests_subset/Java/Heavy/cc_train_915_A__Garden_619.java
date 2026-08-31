import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	final static int mod = 1_000_000_007;

	public static void main(String[] args) throws Exception {

		STDIN scan = new STDIN();
		StringBuilder sb = new StringBuilder();
		
		int n = scan.nextInt(), k = scan.nextInt(), ans = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			int curr = scan.nextInt();
			if(k % curr == 0) ans = Math.min(ans, k / curr);
		}
		sb.append(ans);
		
		System.out.println(sb);
	
	}
	
	static class STDIN {
		BufferedReader br;
		StringTokenizer st;

		public STDIN() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = null;
		}

		boolean hasNext() throws Exception {
			if (!st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.hasMoreTokens();
		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		long nextLong() throws Exception {
			return Long.parseLong(next());
		}

		double nextDouble() throws Exception {
			return Double.parseDouble(next());
		}

		String next() throws Exception {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		String nextLine() throws Exception {
			return br.readLine();
		}
	}
}