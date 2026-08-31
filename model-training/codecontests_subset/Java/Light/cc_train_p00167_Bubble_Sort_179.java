import java.util.Arrays;
import java.util.Scanner;

public class Main {
	MyScanner sc = new MyScanner();
	Scanner sc2 = new Scanner(System.in);
	long start = System.currentTimeMillis();
	long fin = System.currentTimeMillis();
	final int MOD = 1000000007;
	int[] dx = { 1, 0, 0, -1 };
	int[] dy = { 0, 1, -1, 0 };

	int N, M, K, cnt;

	void run() {
		for(;;) {
			int n = sc.nextInt();
			if(n==0) return;
			int[] a =sc.nextIntArray(n);
			cnt = 0;
			mergeSort(a,0,n);
			System.out.println(cnt);
		}
	//	int T = sc.nextInt();
	//	for (int t = 1; t <= T; t++) {
	//		cnt = 0;
	//		N = sc.nextInt();
	//		M = sc.nextInt();
	//		K = sc.nextInt();
	//		Pair[] p = new Pair[K];
	//		for (int i = 0; i < K; i++) {
	//			p[i] = new Pair(sc.nextInt(), sc.nextInt());
	//		}
	//		Arrays.sort(p);
	//		int[] a = new int[K];
	//		for (int i = 0; i < K; i++) {
	//			a[i] = p[i].b;
	//		}
	//		mergeSort(a, 0, a.length);
	//		System.out.println("Test case " + t + ": " + cnt);
	//	}
	}

	
	void mergeSort(int a[], int left, int right) {
		if (right - left <= 1) return;
		int mid = (left + right) / 2;
		mergeSort(a, left, mid);
		mergeSort(a, mid, right);
		merge(a, left, mid, right);
	}

	void merge(int[] a, int left, int mid, int right) {
		int[] L = new int[mid - left];
		int[] R = new int[right - mid];
		int li = 0;
		int ri = 0;
		for (int i = 0; i < L.length; i++) L[i] = a[left + i];
		for (int i = 0; i < R.length; i++) R[i] = a[mid + i];
		for (int i = left; i < right; i++) {
			if (li < L.length && (ri == R.length || L[li] <= R[ri])) {
				a[i] = L[li++];
			} else {
				cnt += (mid - li - left);
				a[i] = R[ri++];
			}
		}
	}

	class Pair implements Comparable<Pair> {

		int a;
		int b;

		public Pair() {
			super();
			this.a = 0;
			this.b = 0;
		}

		public Pair(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Pair arg0) {
			if (this.a == arg0.a) {
				return this.b - arg0.b;
			}
			return this.a - arg0.a;
		}

		void show() {
			System.out.println("first = " + this.a + " second = " + this.b);
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}

	void debug(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}

	void debug2(char[][] array) {
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

	// find minimum i (k <= a[i])
	int lower_bound(int a[], int k) {
		int l = -1;
		int r = a.length;
		while (r - l > 1) {
			int mid = (l + r) / 2;
			if (k <= a[mid])
				r = mid;
			else
				l = mid;
		}
		// r = l + 1
		return r;
	}

	// find minimum i (k < a[i])
	int upper_bound(int a[], int k) {
		int l = -1;
		int r = a.length;
		while (r - l > 1) {
			int mid = (l + r) / 2;
			if (k < a[mid])
				r = mid;
			else
				l = mid;
		}
		// r = l + 1
		return r;
	}

	long gcd(long a, long b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}

	long lcm(long a, long b) {
		return a * b / gcd(a, b);
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