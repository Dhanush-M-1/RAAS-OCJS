import java.io.*;
import java.util.*;

public class C {
	/*
	 * 5 0 0 3 0 1
	 */
	static long sum(long x) {
		x--;
		return x * (x + 1) / 2;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt();

		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextLong();
		FenwickTree tree = new FenwickTree(n);
		int[] ans = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			int lo = 1, hi = n;
			int found = -2;
			while (lo <= hi) {
				int mid = lo + hi >> 1;
				long x = sum(mid);
				x -= tree.query(mid);
				if (x < a[i]) {
					lo = mid + 1;
				} else if (x > a[i]) {
					hi = mid - 1;

				} else {
					found = mid;
					lo = mid + 1;
				}

			}
			ans[i] = found;
			tree.update(found + 1, found);
		}
		for (int x : ans) {
			out.print(x + " ");
		}
		out.println();
		out.close();

	}

	static class FenwickTree {
		long[] bit;

		FenwickTree(int n) {
			bit = new long[n + 5];
		}

		void update(int idx, int v) {
			while (idx < bit.length) {
				bit[idx] += v;
				idx += idx & -idx;
			}
		}

		long query(int idx) {
			long ans = 0;
			while (idx > 0) {
				ans += bit[idx];
				idx -= (idx & -idx);
			}
			return ans;
		}
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		Scanner(String fileName) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(fileName));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}

	static void sort(int[] a) {
		shuffle(a);
		Arrays.sort(a);
	}

	static void shuffle(int[] a) {
		int n = a.length;
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			int tmpIdx = rand.nextInt(n);
			int tmp = a[i];
			a[i] = a[tmpIdx];
			a[tmpIdx] = tmp;
		}
	}

}