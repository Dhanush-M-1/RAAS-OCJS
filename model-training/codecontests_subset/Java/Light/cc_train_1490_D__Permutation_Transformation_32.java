// package practice9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Permutation_Transformation {

	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		int T = in.nextInt();
		for (int tt = 0; tt < T; tt++) {
			int n = in.nextInt();
			int a[] = in.readArray(n);
			int d[] = new int[n];
			makedvc(a, 0, n - 1, d, 0);
			for (int x : d) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

	public static void makedvc(int a[], int l, int r, int d[], int cnt) {
		if (l > r)
			return;
		int pos = 0;
		int ans = 0;
		for (int i = l; i <= r; i++) {
			if (a[i] > ans) {
				ans = a[i];
				pos = i;
			}
		}
		d[pos] = cnt;
		makedvc(a, l, pos - 1, d, cnt + 1);
		makedvc(a, pos + 1, r, d, cnt + 1);
	}

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

}