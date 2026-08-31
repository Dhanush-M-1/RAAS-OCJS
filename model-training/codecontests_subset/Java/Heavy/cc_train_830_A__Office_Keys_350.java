import java.util.*;
import java.io.*;

public class CF_424_D {
	FastScanner in;
	PrintWriter out;

	public void solve() {
		int n = in.nextInt();
		int k = in.nextInt();
		long p = in.nextLong();
		
		long a[] = new long[n];
		long b[] = new long[k];
		
		for (int i = 0; i < n; i++){
			a[i] = in.nextLong();
		}
		for (int i = 0; i < k; i++){
			b[i] = in.nextLong();
		}
		
		long res = Long.MAX_VALUE;
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		for (int i = 0; i <= k-n; i++) {
			long tmp = 0;
			for (int j = 0; j < n; j++){
				tmp = Math.max(tmp, Math.abs(a[j]-b[j+i])+Math.abs(b[j+i]-p));
			}
			res = Math.min(tmp, res);
		}
		
		out.println(res);
	}

	public void run() {
		in = new FastScanner();
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		solve();
		out.close();
	}

	class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}
	}

	public static void main(String[] args) {
		new CF_424_D().run();
	}
}
