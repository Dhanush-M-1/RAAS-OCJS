import java.io.*;
import java.util.*;

public class C {

	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
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

	void solve() throws Exception {
		int b = nextInt();
		int n = nextInt();

		int w[] = new int[b];
		for (int i = 0; i < b; i++)
			w[i] = nextInt();

		int ro[] = new int[n];
		for (int i = 0; i < n; i++)
			ro[i] = nextInt() - 1;

		boolean u[] = new boolean[b];

		int o[] = new int[b];
		int c = 0;
		for (int i = 0; i < n; i++)
			if (!u[ro[i]]) {
				o[c] = ro[i];
				c++;
				u[ro[i]] = true;
			}

		//System.err.println(Arrays.toString(o));

		int ans = 0;

		for (int i = 0; i < n; i++) {
			int req = ro[i];
			int j = 0, cw = 0;
			//System.err.println(req);
			while (o[j] != req) {
				cw += w[o[j]];
				j++;
			}

			//System.err.println(j);
			
			ans += cw;

			for (int jj = j; jj >= 1; jj--)
				o[jj] = o[jj - 1];
			o[0] = req;

			//System.err.println(Arrays.toString(o));
		}

		out.println(ans);

	}

	void run() {
		try {
			Locale.setDefault(Locale.US);
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(new OutputStreamWriter(System.out));
			solve();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		new C().run();
	}

}
