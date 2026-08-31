import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class MainC {
	MyScanner sc = new MyScanner();
	Scanner sc2 = new Scanner(System.in);
	final int MOD = 1000000007;
	int[] dx = { 1, 0, 0, -1 };
	int[] dy = { 0, 1, -1, 0 };

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Book> list = new ArrayList<Book>();
		ArrayList<Book> order = new ArrayList<Book>();
		HashSet<Book> use = new HashSet<Book>();
		for (int i = 0; i < n; i++) {
			int w = sc.nextInt();
			list.add(new Book(i + 1, w));
		}
		int[] o = new int[m];
		for (int i = 0; i < m; i++) {
			o[i] = sc.nextInt();
			if (!use.contains(list.get(o[i] - 1))) {
				order.add(list.get(o[i] - 1));
				use.add(list.get(o[i] - 1));
			}
		}
		int cost = 0;
		for (int i = 0; i < m; i++) {
			int get = o[i];
			ArrayList<Book> move = new ArrayList<Book>();
			while (order.get(0).num != get) {
				move.add(order.remove(0));
				cost += move.get(move.size() - 1).wight;
			}
			Book pull = order.remove(0);
			for (int j = 0; j < move.size(); j++) {
				order.add(0, move.get(move.size() - 1 - j));
			}
			order.add(0, pull);
		}
		System.out.println(cost);
	}

	class Book {
		int num;
		int wight;

		/**
		 * @param num
		 * @param wight
		 */
		public Book(int num, int wight) {
			super();
			this.num = num;
			this.wight = wight;
		}
	}

	public static void main(String[] args) {
		new MainC().run();
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
	}
}
