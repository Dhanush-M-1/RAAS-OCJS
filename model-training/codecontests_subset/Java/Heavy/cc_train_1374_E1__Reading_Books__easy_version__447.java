import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class _653 {

	static Reader r = new Reader();
	static PrintWriter out = new PrintWriter(System.out);

	private static void solve1() throws IOException {

		int t = r.nextInt();
		StringBuilder res = new StringBuilder();

		while (t-- > 0) {

			int x = r.nextInt();
			int y = r.nextInt();
			int n = r.nextInt();

			int ans = (x * (n / x));

			if (n - ans >= y) {
				ans += y;
			} else {
				ans -= (x - y);
			}

			res.append(ans).append("\n");

		}

		out.print(res);
		out.close();
	}

	private static void solve2() throws IOException {

		int t = r.nextInt();
		StringBuilder res = new StringBuilder();

		while (t-- > 0) {

			long n = r.nextLong();

			int cnt = 0;

			long num = n;

			while (num > 1) {
				if (num % 6 == 0) {
					num /= 6;
					cnt++;
				} else {
					num *= 2;
					cnt++;
				}
				if (num % 3 != 0)
					break;
			}

			res.append(num == 1 ? cnt : -1).append("\n");

		}

		out.print(res);
		out.close();

	}

	private static void solve3() throws IOException {

		int t = r.nextInt();
		StringBuilder res = new StringBuilder();

		while (t-- > 0) {

			int n = r.nextInt();
			char str[] = r.next().toCharArray();

			Stack<Character> st = new Stack<Character>();
			for (int i = 0; i < n; i++) {
				if (str[i] == '(') {
					st.push(str[i]);
				} else {
					if (!st.isEmpty() && st.peek() == '(') {
						st.pop();
					} else {
						st.push(str[i]);
					}
				}
			}

			res.append(st.size() / 2).append("\n");

		}

		out.print(res);
		out.close();

	}

	private static void solve4() throws IOException {

		int t = r.nextInt();
		StringBuilder res = new StringBuilder();

		while (t-- > 0) {

			int n = r.nextInt();
			long k = r.nextLong();

			long arr[] = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = r.nextLong();
				long ele = k * (arr[i] / k) + k;
				arr[i] = ele - arr[i];
			}

//			System.out.println(Arrays.toString(arr));

			HashMap<Long, Long> map = new HashMap<>();

			for (int i = 0; i < n; i++) {
				if (arr[i] != 0) {
					long freq = 0;
					if (map.containsKey(arr[i])) {
						freq = map.get(arr[i]);
					}
					freq++;
					map.put(arr[i], freq);
				}
			}

			long cnt = map.size();

			for (long ele : map.keySet()) {
				cnt = Math.max(cnt, (ele + (map.get(ele) - 1) * k));
			}

			if (cnt > 0)
				cnt++;

			res.append(cnt).append("\n");

		}

		out.print(res);
		out.close();

	}

	private static void solve5() throws IOException {

		int n = r.nextInt();
		int k = r.nextInt();

		ArrayList<Integer> alice = new ArrayList<Integer>();
		ArrayList<Integer> bob = new ArrayList<Integer>();
		ArrayList<Integer> both = new ArrayList<Integer>();

		int al = 0, bo = 0;

		while (n-- > 0) {
			int t = r.nextInt();
			int a = r.nextInt();
			int b = r.nextInt();
			if (a == 1 && b == 1) {
				both.add(t);
				al++;
				bo++;
			} else if (a == 1) {
				alice.add(t);
				al++;
			} else if (b == 1) {
				bob.add(t);
				bo++;
			}
		}

		Collections.sort(alice);
		Collections.sort(bob);
		Collections.sort(both);

//		System.out.println(alice);
//		System.out.println(bob);

		long ans = 0;

		if (al < k || bo < k) {
			ans = -1;
		} else {

			al = k;
			bo = k;

			int id1 = 0, id2 = 0, id3 = 0;

			while (al > 0 || bo > 0) {
				if (al > 0 && bo > 0) {
					// Case 1: al > 0 && bo > 0
					if (id1 < alice.size() && id2 < bob.size()) {
						if (id3 < both.size()) {
							if (both.get(id3) > alice.get(id1) + bob.get(id2)) {
								ans += (alice.get(id1++) + bob.get(id2++));
								al--;
								bo--;
							} else {
								ans += both.get(id3++);
								al--;
								bo--;
							}
						} else {
							ans += (alice.get(id1++) + bob.get(id2++));
							al--;
							bo--;
						}
					} else {
						ans += both.get(id3++);
						al--;
						bo--;
					}
				} else if (al > 0) {
					// Case 2: al > 0 && bo == 0
					if (id1 >= alice.size()) {
						ans += both.get(id3++);
						al--;
					} else if (id3 >= both.size()) {
						ans += alice.get(id1++);
						al--;
					} else {
						if (alice.get(id1) < alice.get(id3)) {
							ans += alice.get(id1++);
							al--;
						} else {
							ans += both.get(id3++);
							al--;
						}
					}
				} else if (bo > 0) {
					// Case 3: al == 0 && bo > 0
					if (id2 >= bob.size()) {
						ans += both.get(id3++);
						bo--;
					} else if (id3 >= both.size()) {
						ans += bob.get(id2++);
						bo--;
					} else {
						if (alice.get(id1) < alice.get(id3)) {
							ans += bob.get(id2++);
							bo--;
						} else {
							ans += both.get(id3++);
							bo--;
						}
					}
				}
			}

		}

		out.print(ans);
		out.close();

	}

	private static void solve6() throws IOException {

		int t = r.nextInt();
		StringBuilder res = new StringBuilder();

		while (t-- > 0) {

			int n = r.nextInt();

			res.append(false).append("\n");
		}

		out.print(res);
		out.close();

	}

	public static void main(String[] args) throws IOException {

//		solve1();

//		solve2();

//		solve3();

//		solve4();

		solve5();

		// solve6();

	}

	static class Reader {

		final private int BUFFER_SIZE = 1 << 12;
		boolean consume = false;
		private byte[] buffer;
		private int bufferPointer, bytesRead;
		private boolean reachedEnd = false;

		public Reader() {
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = 0;
			bytesRead = 0;
		}

		public boolean hasNext() {
			return !reachedEnd;
		}

		private void fillBuffer() throws IOException {
			bytesRead = System.in.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1) {
				buffer[0] = -1;
				reachedEnd = true;
			}
		}

		private void consumeSpaces() throws IOException {
			while (read() <= ' ' && reachedEnd == false)
				;
			bufferPointer--;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead) {
				fillBuffer();
			}
			return buffer[bufferPointer++];
		}

		public String next() throws IOException {
			StringBuilder sb = new StringBuilder();
			consumeSpaces();
			byte c = read();
			do {
				sb.append((char) c);
			} while ((c = read()) > ' ');
			if (consume) {
				consumeSpaces();
			}
			;
			if (sb.length() == 0) {
				return null;
			}
			return sb.toString();
		}

		public String nextLine() throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			return str;
		}

		public int nextInt() throws IOException {
			consumeSpaces();
			int ret = 0;
			byte c = read();
			boolean neg = (c == '-');
			if (neg) {
				c = read();
			}
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (consume) {
				consumeSpaces();
			}
			if (neg) {
				return -ret;
			}
			return ret;
		}

		public long nextLong() throws IOException {
			consumeSpaces();
			long ret = 0;
			byte c = read();
			boolean neg = (c == '-');
			if (neg) {
				c = read();
			}
			do {
				ret = ret * 10L + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (consume) {
				consumeSpaces();
			}
			if (neg) {
				return -ret;
			}
			return ret;
		}

		public double nextDouble() throws IOException {
			consumeSpaces();
			double ret = 0;
			double div = 1;
			byte c = read();
			boolean neg = (c == '-');
			if (neg) {
				c = read();
			}
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}
			if (consume) {
				consumeSpaces();
			}
			if (neg) {
				return -ret;
			}
			return ret;
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}

		public long[] nextLongArray(int n) throws IOException {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}

		public int[][] nextIntMatrix(int n, int m) throws IOException {
			int[][] grid = new int[n][m];
			for (int i = 0; i < n; i++) {
				grid[i] = nextIntArray(m);
			}
			return grid;
		}

		public char[][] nextCharacterMatrix(int n) throws IOException {
			char[][] a = new char[n][];
			for (int i = 0; i < n; i++) {
				a[i] = next().toCharArray();
			}
			return a;
		}

		public void close() throws IOException {
			if (System.in == null) {
				return;
			} else {
				System.in.close();
			}
		}
	}

}