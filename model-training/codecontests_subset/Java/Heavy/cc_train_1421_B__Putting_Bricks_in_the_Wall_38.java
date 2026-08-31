
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

import java.awt.*;

public class Main {

	static long sx = 0, sy = 0, mod = (long) (1e9 + 7);
	static int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
	static ArrayList<Integer>[] a;
	static Long[][][] dp;
	static long[] fa;
	static int[] farr;
	public static PrintWriter out = new PrintWriter(System.out);
	static ArrayList<pair> pa = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static boolean cycle = false;
	static long m = 998244353;
	static long[] no, col;
	static String s;
	// static long k = 0, n = 0, ans = 0;
	static long cnt;
	// static long[] dp;
	// static long[] p;
	// static long[] ans;
	// static Double[][] a = new Double[2][2];
	static Double[][] b = new Double[2][2];
	static Double[] x;
	static Double[] y;
	static long[] d;
	// static boolean b = true;
	static int[] par;
	static int[] depth;
	static HashMap<Integer, Integer> map;
	// static ArrayList<Integer> p;
	static int time = 0;
	static int[] size;
	static int[] arr;
	static pair[] p;
	static HashSet<Integer> ans = new HashSet<>();

	public static void main(String[] args) throws IOException {

		Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		// Reader scn = new Reader();

		int t = scn.nextInt();

		z: while (t-- != 0) {

			int n = scn.nextInt();

			char[][] ch = new char[n][n];

			for (int i = 0; i < n; i++)
				ch[i] = scn.next().toCharArray();

			HashSet<Character> hm1 = new HashSet<>();
			HashSet<Character> hm2 = new HashSet<>();

			hm1.add(ch[0][1]);
			hm1.add(ch[1][0]);

			hm2.add(ch[n - 1][n - 2]);
			hm2.add(ch[n - 2][n - 1]);

			char val1 = 'a', val2 = 'a';

			for (char i : hm1)
				val1 = i;
			for (char i : hm2)
				val2 = i;

			if (hm1.size() == 1 && hm2.size() == 1) {

				if (val1 == val2) {

					System.out.println(2);
					System.out.println("1 2");
					System.out.println("2 1");
					continue z;
				}

				else {
					System.out.println(0);
					continue z;
				}
			}

			else if (hm1.size() == 1) {

				System.out.println(1);

				if (ch[n - 1][n - 2] == val1)
					System.out.println(n + " " + (n - 1));
				else
					System.out.println((n - 1) + " " + n);

				continue z;
			}

			else if (hm2.size() == 1) {

				System.out.println(1);

				if (ch[0][1] == val2)
					System.out.println(1 + " " + (2));
				else
					System.out.println(2 + " " + 1);

				continue z;
			}

			else {

				System.out.println(2);

				if (ch[0][1] == '1')
					System.out.println(1 + " " + (2));
				else
					System.out.println(2 + " " + 1);

				if (ch[n - 1][n - 2] == '0')
					System.out.println(n + " " + (n - 1));
				else
					System.out.println((n - 1) + " " + n);

			}
		}
	}

	// _________________________TEMPLATE_____________________________________________________________

	// public static long lcm(long x, long y) {
	//
	// return (x * y) / gcd(x, y);
	// }
	//
	// private static long gcd(long x, long y) {
	// if (x == 0)
	// return y;
	//
	// return gcd(y % x, x);
	// }
	//
	// static class comp implements Comparator<Integer> {
	//
	// @Override
	// public int compare(Integer p1, Integer p2) {
	//
	// return p2 - p1;
	//
	// }
	// }
	//
	// }
	//
	// public static long pow(long a, long b) {
	//
	// if (b < 0)
	// return 0;
	// if (b == 0 || b == 1)
	// return (long) Math.pow(a, b);
	//
	// if (b % 2 == 0) {
	//
	// long ret = pow(a, b / 2);
	// ret = (ret % mod * ret % mod) % mod;
	// return ret;
	// }
	//
	// else {
	// return ((pow(a, b - 1) % mod) * a % mod) % mod;
	// }
	// }

	private static class pair implements Comparable<pair> {

		int i, j;

		pair(int a, int b) {
			i = a;
			j = b;
		}

		@Override
		public int compareTo(pair o) {

			return 1;
		}

		@Override

		public int hashCode() {
			return (int) (i * 17 + j * 31);
		}

		@Override

		public boolean equals(Object o) {

			pair p = (pair) o;
			return this.i == p.i && this.j == p.j;
		}

	}

	private static String reverse(String s) {

		return new StringBuilder(s).reverse().toString();
	}

	public static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[1000000 + 1]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextInt();
			}
			return arr;
		}

		public long[] nextLongArray(int n) throws IOException {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextLong();
			}
			return arr;
		}

		public int[][] nextInt2DArray(int m, int n) throws IOException {
			int[][] arr = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++)
					arr[i][j] = nextInt();
			}
			return arr;
		}

		public long[][] nextInt2DArrayL(int m, int n) throws IOException {
			long[][] arr = new long[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++)
					arr[i][j] = nextInt();
			}
			return arr;
		}
		// kickstart - Solution
		// atcoder - Main
	}

}