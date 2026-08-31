import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GB2014C {
	private FastScanner in;
	private PrintWriter out;

	public void solve() throws IOException {
		int n = in.nextInt();
		int m = in.nextInt();
		int[] weight = new int[505];
		int[] days = new int[1005];
		boolean[] seen = new boolean[505];
		long res = 0;
		for (int i = 0; i < n; i++){
			weight[i] = in.nextInt();
		}
		for (int i = 0; i < m; i++){
			days[i] = in.nextInt() - 1;
		}
		for (int i = 0; i < m; i++){	
			for (int a = 0; a < 505; a++){ seen[a] = false; }
			outerloop:
			for (int j = i-1; j >= 0; j--){
				if (days[i] == days[j]){ break outerloop; }
				if (seen[days[j]]){ continue; }
				res += weight[days[j]];
				seen[days[j]] = true;
			}
		}
		out.println(res);
	}
	
	public static void main(String[] args) {
		new GB2014C().run();
	}

	public void run() {
		try {
			in = new FastScanner();
			out = new PrintWriter(System.out);
			solve();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class FastScanner {
		private BufferedReader br;
		private StringTokenizer st;

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
