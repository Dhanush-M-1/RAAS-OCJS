import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class MainA {

	public static int mod = 20000;
	public static long[] val;
	public static long[] arr;
	static int max = (int) 1e9 + 7;

	public static void main(String[] args) {

		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n=in.nextInt();
		int k=in.nextInt();
		int max=0;
		for(int i=0;i<n;i++)
		{
			int x=in.nextInt();
			if(k%x==0 && max<x)max=x;
		}
		out.println(k/max);
		out.close();
	}

	static void swap(Pairs arr[], int i, int j) {
		Pairs t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	static int partition(Pairs arr[], int l, int h) {
		long x = arr[h].x;
		int i = (l - 1);

		for (int j = l; j <= h - 1; j++) {
			if (arr[j].x <= x) {
				i++;
				// swap arr[i] and arr[j]
				swap(arr, i, j);
			}
		}
		// swap arr[i+1] and arr[h]
		swap(arr, i + 1, h);
		return (i + 1);
	}

	// Sorts arr[l..h] using iterative QuickSort
	static void sort(Pairs arr[], int l, int h) {
		// create auxiliary stack
		int stack[] = new int[h - l + 1];

		// initialize top of stack
		int top = -1;

		// push initial values in the stack
		stack[++top] = l;
		stack[++top] = h;

		// keep popping elements until stack is not empty
		while (top >= 0) {
			// pop h and l
			h = stack[top--];
			l = stack[top--];

			// set pivot element at it's proper position
			int p = partition(arr, l, h);

			// If there are elements on left side of pivot,
			// then push left side to stack
			if (p - 1 > l) {
				stack[++top] = l;
				stack[++top] = p - 1;
			}

			// If there are elements on right side of pivot,
			// then push right side to stack
			if (p + 1 < h) {
				stack[++top] = p + 1;
				stack[++top] = h;
			}
		}
	}

	static class Pairs implements Comparable<Pairs> {
		long x;
		int y;

		Pairs(long a, int b) {
			x = a;
			y = b;
		}

		@Override
		public int compareTo(Pairs o) {
			// TODO Auto-generated method stub
			if (x == o.x)
				return Integer.compare(y, o.y);
			else
				return Long.compare(x, o.x);
		}

	}

	public static void debug(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}

	public static boolean isPal(String s) {
		for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
			if (s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}

	public static String rev(String s) {
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		return sb.toString();
	}

	public static long gcd(long x, long y) {
		if (y == 0)
			return x;
		if (x % y == 0)
			return y;
		else
			return gcd(y, x % y);
	}

	public static int gcd(int x, int y) {
		if (x % y == 0)
			return y;
		else
			return gcd(y, x % y);
	}

	public static long gcdExtended(long a, long b, long[] x) {

		if (a == 0) {
			x[0] = 0;
			x[1] = 1;
			return b;
		}
		long[] y = new long[2];
		long gcd = gcdExtended(b % a, a, y);

		x[0] = y[1] - (b / a) * y[0];
		x[1] = y[0];

		return gcd;
	}

	public static int abs(int a, int b) {
		return (int) Math.abs(a - b);
	}

	public static long abs(long a, long b) {
		return (long) Math.abs(a - b);
	}

	public static int max(int a, int b) {
		if (a > b)
			return a;
		else
			return b;
	}

	public static int min(int a, int b) {
		if (a > b)
			return b;
		else
			return a;
	}

	public static long max(long a, long b) {
		if (a > b)
			return a;
		else
			return b;
	}

	public static long min(long a, long b) {
		if (a > b)
			return b;
		else
			return a;
	}

	public static long[][] mul(long a[][], long b[][]) {
		long c[][] = new long[2][2];
		c[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0];
		c[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1];
		c[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0];
		c[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1];

		return c;
	}

	public static long[][] pow(long n[][], long p, long m) {
		long result[][] = new long[2][2];
		result[0][0] = 1;
		result[0][1] = 0;
		result[1][0] = 0;
		result[1][1] = 1;

		if (p == 0)
			return result;
		if (p == 1)
			return n;
		while (p != 0) {
			if (p % 2 == 1)
				result = mul(result, n);
			//System.out.println(result[0][0]);
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					if (result[i][j] >= m)
						result[i][j] %= m;
				}
			}

			p >>= 1;
			n = mul(n, n);
			// System.out.println(1+" "+n[0][0]+" "+n[0][1]+" "+n[1][0]+" "+n[1][1]);
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					if (n[i][j] >= m)
						n[i][j] %= m;
				}
			}
		}
		return result;
	}

	public static long pow(long n, long p) {
		long result = 1;
		if (p == 0)
			return 1;
		if (p == 1)
			return n;
		while (p != 0) {
			if (p % 2 == 1)
				result *= n;
			p >>= 1;
			n *= n;
		}
		return result;
	}

	static class InputReader {

		private final InputStream stream;
		private final byte[] buf = new byte[8192];
		private int curChar, snumChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int snext() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int nextInt() {
			int c = snext();
			while (isSpaceChar(c)) {
				c = snext();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public long nextLong() {
			int c = snext();
			while (isSpaceChar(c)) {
				c = snext();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int[] nextIntArray(int n) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}

		public long[] nextLongArray(int n) {
			long a[] = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}

		public String readString() {
			int c = snext();
			while (isSpaceChar(c)) {
				c = snext();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = snext();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public String nextLine() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = snext();
			} while (!isEndOfLine(c));
			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
}