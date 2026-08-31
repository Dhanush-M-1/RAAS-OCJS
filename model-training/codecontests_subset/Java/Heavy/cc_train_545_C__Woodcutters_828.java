import java.io.*;
import java.math.BigInteger;
import java.util.*;


//Mann Shah [ DAIICT ].
//fast io

public class Main {
	public static int mod = (int) (1e9 + 7);
	public static long inf = (long) 1e15 + 42;
	static InputReader in;
	static PrintWriter out;

	public static long gcd(long a, long b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}
	

	public static void main(String args[]) {

		in = new InputReader(System.in);
		out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		int[] x = new int[n];
		int[] h = new int[n];
		for(int i=0;i<n;i++) {
			x[i]=in.nextInt();
			h[i]=in.nextInt();
		}
		
		if(n==1) {
			out.println("1");
		}
		else {
		int c=2;
		for(int i=1;i<n-1;i++) {
			if(h[i] < x[i] - x[i-1]) {
				// L
				c++;
			}
			else if(h[i] < x[i+1] -x[i]){
				// R
				c++;
				x[i] = x[i]+h[i];
			}
			else {
				continue;
			}
		}
		
//		int cc=2;
//		
//		for(int i=n-2;i>0;i--) {
//			if(h[i] > x[i+1] - x[i]) {
//				// r
//				cc++;
//			}
//			else if(h[i] < x[i] - x[i-1]){
//				// l
//				cc++;
//				x[i] = x[i]+h[i];
//			}
//			else {
//				continue;
//			}
//		}
		
		out.println(c);
		
		}
		
		out.close();
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
				a[i] = nextLong();
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

// For Pair sorting

// Arrays.sort(arr,new Comparator<Pair>() {
// @Override public int compare(Pair p1, Pair p2)
// {
// return p1.x - p2.x;
// }
// });

// Pair arr[] = new Pair[n];
// arr[0] = new Pair(10, 20);
class Pair {
	int x;
	int y;

	// Constructor
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object o) {
		Pair p =(Pair)o;
		return (x==p.x && y==p.y);
	}
}

// // Comparator to sort the pair according to first element.
// Arrays.sort(arr, new Comparator<Pair>() {
// @Override public int compare(Pair p1, Pair p2){
//  return p1.x - p2.x;
// }
// });

class couple implements Comparable<couple> {
	int x, y;

	public couple(int m, int f) {
		x = m;
		y = f;
	}

	public int compareTo(couple o) {

		return x - o.x;
	}
}