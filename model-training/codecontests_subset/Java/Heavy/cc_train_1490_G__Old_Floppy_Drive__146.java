// package CodeForces;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Round702G {

	public static void solve() {
		int t = s.nextInt();
		while(t-- > 0) {
			int n = s.nextInt();
			int m = s.nextInt();
			long[] arr = s.nextLongArray(n);
			long[] que = s.nextLongArray(m);
			long sum = 0;
			ArrayList<Long> mono = new ArrayList<Long>();
			ArrayList<Integer> index = new ArrayList<Integer>();
			mono.add(0L);
			index.add(-1);
			for(int i = 0; i < n; i++) {
				sum += arr[i];
				if(sum > mono.get(mono.size() - 1)) {
					mono.add(sum);
					index.add(i);
				}
			}
			for(int i = 0; i < m; i++) {
				long x = que[i];
				if(mono.get(mono.size() - 1) >= x) {
					int ans = bs(mono, index, x);
					if(ans <= -1) throw null;
					out.print(ans + " ");
				}else if(sum > 0) {
//					long times = (x/sum) * (long)n;
//					x -= (x/sum) * sum;
//					if(x > 0) {
//						times += bs(mono, index, x);
//					}else {
//						times--;
//					}
					long max = mono.get(mono.size() - 1);
					x -= max;
					long times = (x%sum == 0 ? x/sum : x/sum + 1) * (long)n;
					long rem = que[i] - (x%sum == 0 ? x/sum : x/sum + 1) * sum;
					if(rem > 0) {
						times += bs(mono, index, rem);
					}else {
						times--;
					}
					if(times <= -1) throw null;
					out.print(times + " ");
				}else {
					out.print(-1 + " ");
				}
			}
			out.println();
		}
	}
	
	public static int bs(ArrayList<Long> mono, ArrayList<Integer> index, long reqd) {
		int start = 0;
		int end = mono.size() - 1;
		int ans = -1;
		while(start <= end) {
			int mid = (start + end)>>1;
			if(mono.get(mid) >= reqd) {
				ans = index.get(mid);
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		if(ans == -1) throw null;
		return ans;
	}

	public static void main(String[] args) {
		new Thread(null, null, "Thread", 1 << 27) {
			public void run() {
				try {
					out = new PrintWriter(new BufferedOutputStream(System.out));
					s = new FastReader(System.in);
					solve();
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(1);
				}
			}
		}.start();
	}

	public static PrintWriter out;
	public static FastReader s;

	public static class FastReader {

		private InputStream stream;
		private byte[] buf = new byte[4096];
		private int curChar, snumChars;

		public FastReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (snumChars == -1) {
				throw new InputMismatchException();
			}
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException E) {
					throw new InputMismatchException();
				}
			}
			if (snumChars <= 0) {
				return -1;
			}
			return buf[curChar++];
		}

		public int nextInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int number = 0;
			do {
				number *= 10;
				number += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return number * sgn;
		}

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			long sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long number = 0;
			do {
				number *= 10L;
				number += (long) (c - '0');
				c = read();
			} while (!isSpaceChar(c));
			return number * sgn;
		}

		public int[] nextIntArray(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = this.nextInt();
			}
			return arr;
		}

		public long[] nextLongArray(int n) {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = this.nextLong();
			}
			return arr;
		}

		public String next() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public String nextLine() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndofLine(c));
			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public boolean isEndofLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

	}

	
}
