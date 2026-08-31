import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		int n = sc.nextInt();

		List<Integer>[] tree = new List[n + 1];

		boolean[] leafs = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList();
		}

		for (int i = 0; i < n - 1; i++) {
			int v = sc.nextInt();
			int u = sc.nextInt();

			tree[v].add(u);
			tree[u].add(v);
		}

		for (int i = 1; i <= n; i++) {
			if (tree[i].size() == 1) {
				leafs[i] = true;
			}
		}

		for (int i = 1; i <= n; i++) {
			if (!leafs[i]) {
				if (tree[i].size() == 2) {
					System.out.println("NO");
					return;
				}
			}
		}

		System.out.println("YES");

	}

	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
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

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
