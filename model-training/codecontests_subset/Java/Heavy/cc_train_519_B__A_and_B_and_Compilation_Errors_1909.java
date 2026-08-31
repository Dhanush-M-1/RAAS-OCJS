import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class MainB {
	MyScanner sc = new MyScanner();
	Scanner sc2 = new Scanner(System.in);
	final int MOD = 1000000007;
	int[] dx = { 1, 0, 0, -1 };
	int[] dy = { 0, 1, -1, 0 };

	void run() {
		int n = sc.nextInt();
		HashMap<Integer, Integer> set1 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> set2 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> set3 = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			int s = sc.nextInt();
			if (set1.containsKey(s)) {
				set1.put(s, set1.get(s) + 1);
			} else {
				set1.put(s, 1);
			}
		}
		for (int i = 0; i < n - 1; i++) {
			int s = sc.nextInt();
			if (set2.containsKey(s)) {
				set2.put(s, set2.get(s) + 1);
			} else {
				set2.put(s, 1);
			}
		}
		for (int i = 0; i < n - 2; i++) {
			int s = sc.nextInt();
			if (set3.containsKey(s)) {
				set3.put(s, set3.get(s) + 1);
			} else {
				set3.put(s, 1);
			}
		}
		for (int key : set2.keySet()) {
			int num = set1.get(key);
			set1.put(key, num - set2.get(key));
		}
		for (int key : set3.keySet()) {
			int num = set2.get(key);
			set2.put(key, num - set3.get(key));
		}
		for (int key : set1.keySet()) {
			if (set1.get(key) != 0) {
				System.out.println(key);
				break;
			}
		}
		for (int key : set2.keySet()) {
			if (set2.get(key) != 0) {
				System.out.println(key);
				break;
			}
		}
	}

	public static void main(String[] args) {
		new MainB().run();
	}

	void debug(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}

	void debug2(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}

	boolean inner(int h, int w, int limH, int limW) {
		return 0 <= h && h < limH && 0 <= w && w < limW;
	}

	void swap(int[] x, int a, int b) {
		int tmp = x[a];
		x[a] = x[b];
		x[b] = tmp;
	}

	// find minimum i (a[i] >= border)
	int lower_bound(int a[], int border) {
		int l = -1;
		int r = a.length;

		while (r - l > 1) {
			int mid = (l + r) / 2;
			if (border <= a[mid]) {
				r = mid;
			} else {
				l = mid;
			}
		}
		// r = l + 1
		return r;
	}

	boolean palindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	class MyScanner {
		int nextInt() {
			try {
				int c = System.in.read();
				while (c != '-' && (c < '0' || '9' < c))
					c = System.in.read();
				if (c == '-')
					return -nextInt();
				int res = 0;
				do {
					res *= 10;
					res += c - '0';
					c = System.in.read();
				} while ('0' <= c && c <= '9');
				return res;
			} catch (Exception e) {
				return -1;
			}
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		String next() {
			try {
				StringBuilder res = new StringBuilder("");
				int c = System.in.read();
				while (Character.isWhitespace(c))
					c = System.in.read();
				do {
					res.append((char) c);
				} while (!Character.isWhitespace(c = System.in.read()));
				return res.toString();
			} catch (Exception e) {
				return null;
			}
		}

		int[] nextIntArray(int n) {
			int[] in = new int[n];
			for (int i = 0; i < n; i++) {
				in[i] = nextInt();
			}
			return in;
		}

		int[][] nextInt2dArray(int n, int m) {
			int[][] in = new int[n][m];
			for (int i = 0; i < n; i++) {
				in[i] = nextIntArray(m);
			}
			return in;
		}

		double[] nextDoubleArray(int n) {
			double[] in = new double[n];
			for (int i = 0; i < n; i++) {
				in[i] = nextDouble();
			}
			return in;
		}

		long[] nextLongArray(int n) {
			long[] in = new long[n];
			for (int i = 0; i < n; i++) {
				in[i] = nextLong();
			}
			return in;
		}

		char[][] nextCharField(int n, int m) {
			char[][] in = new char[n][m];
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				for (int j = 0; j < m; j++) {
					in[i][j] = s.charAt(j);
				}
			}
			return in;
		}
	}
}
