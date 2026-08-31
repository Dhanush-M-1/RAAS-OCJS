import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.lang.Long;

public class Test {
	static long mod = 1000000007;
	static int[][] dp;
	static ArrayList<Integer>[] pre;
	static int contains;

	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter out = new PrintWriter(System.out);
		Scanner in = new Scanner();
		int n = in.nextInt();
		int m = in.nextInt() - 1;
		int[] pos = new int[n];
		for (int i = 0; i < n; i++) {
			pos[i] = in.nextInt() - 1;
		}
		ArrayList<Integer> com = new ArrayList();
		int q = 0;
		int p = 0;
		for (int i = 0; i < n; i++) {
			if (pos[i] == -1) {
				contains = -1;
				int v = cal(i, m, pos);
				if (contains != -1) {
					q = v;
					p = contains;
				} else {
					com.add(v);
				}
			}
		}
		// System.out.println(com + " " + q + " " + p);
		boolean[][] po = new boolean[n + 1][2];
		int index = 0;
		for (int i : com) {
			po[i][index] = true;
			for (int j = 0; j <= n; j++) {
				if (po[j][1 - index]) {
					po[j + i][index] = true;
					po[j][index] = true;
				}
			}
			index = 1 - index;
		}
		index = 1 - index;
		po[0][index] = true;
		for (int i = 0; i <= n; i++) {
			if (po[i][index]) {
				out.println((i + p));
			}
		}
		out.close();
	}

	static int cal(int index, int m, int[] pos) {
		int result = 1;

		for (int i = 0; i < pos.length; i++) {
			if (pos[i] == index) {
				result += cal(i, m, pos);
			}
		}
		if (index == m) {
			contains = 1;
		} else if (contains != -1) {
			contains++;
		}

		return result;
	}

	static int crossProduct(Point a, Point b) {
		return a.x * b.y + a.y * b.x;
	}

	static long squareDist(Point a) {
		long x = a.x;
		long y = a.y;
		return x * x + y * y;
	}

	static Point minus(Point a, Point b) {
		return new Point(a.x - b.x, a.y - b.y);
	}

	public static boolean nextPer(int[] data) {
		int i = data.length - 1;
		while (i > 0 && data[i] < data[i - 1]) {
			i--;
		}
		if (i == 0) {
			return false;
		}
		int j = data.length - 1;
		while (data[j] < data[i - 1]) {
			j--;
		}
		int temp = data[i - 1];
		data[i - 1] = data[j];
		data[j] = temp;
		Arrays.sort(data, i, data.length);
		return true;
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return "{" + x + " " + y + "}";
		}

	}

	static class Entry implements Comparable<Entry> {
		int x, cost;

		public Entry(int x, int cost) {
			super();
			this.x = x;
			this.cost = cost;
		}

		public int compareTo(Entry o) {
			// TODO Auto-generated method stub
			if (cost > o.cost) {
				return 1;
			} else if (cost == o.cost) {
				return -1;
			}

			return 0;
		}
	}

	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	static class Scanner {

		BufferedReader br;
		StringTokenizer st;

		public Scanner() throws FileNotFoundException {
			// System.setOut(new PrintStream(new
			// BufferedOutputStream(System.out), true));
			br = new BufferedReader(new InputStreamReader(System.in));
			// br = new BufferedReader(new InputStreamReader(new
			// FileInputStream(new File("B-large.in"))));
		}

		public String next() {

			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					throw new RuntimeException();
				}
			}
			return st.nextToken();
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public String nextLine() {
			st = null;
			try {
				return br.readLine();
			} catch (Exception e) {
				throw new RuntimeException();
			}
		}

		public boolean endLine() {
			try {
				String next = br.readLine();
				while (next != null && next.trim().isEmpty()) {
					next = br.readLine();
				}
				if (next == null) {
					return true;
				}
				st = new StringTokenizer(next);
				return st.hasMoreTokens();
			} catch (Exception e) {
				throw new RuntimeException();
			}
		}
	}
}