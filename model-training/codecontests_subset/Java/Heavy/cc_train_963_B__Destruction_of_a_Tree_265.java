// package CodeForces;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.LinkedList;

public class CwD_Graph_I {

	public static LinkedList<Integer>[] adj;
	public static int[] type; // 1 -> I broke connection, 2 -> parent and child broke the connection
	
	public static void dfs(int current, int parent) {
		int dependent = 0;
		for(Integer x : adj[current]) {
			if(x != parent) {
				dfs(x, current);
				if(type[x] == -1) {
					type[current] = -1;
					return;
				}else if(type[x] == 1) {
					// not dependent
				}else {
					dependent++;
				}
			}
		}
		if(dependent%2 == 1) {
			if(current == parent) {
				// root node
				type[current] = -1;
				return;
			}else {
				// i neeed my parent therefore I will broke connection first
				type[current] = 1;
			}
		}else {
			if(current == parent) {
				// root node
				type[current] = 1;
			}else {
				// i dont need my parnt therefore I will not break connection first, my parent should/must
				type[current] = 2;
			}
		}
	}
	
	public static LinkedList<Integer> ans;
	
	public static void dfs2(int current, int parent) {
		for(Integer x : adj[current]) {
			if(x != parent) {
				if(type[x] == 1) {
					dfs2(x, current);
				}
			}
		}
		ans.add(current + 1);
		for(Integer x : adj[current]) {
			if(x != parent) {
				if(type[x] == 2) {
					dfs2(x, current);
				}
			}
		}
	}
	
	public static void solve() {
		int n = s.nextInt();
		int[] arr = s.nextIntArray(n);
		adj = new LinkedList[n];
		for(int i = 0; i < n; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		type = new int[n];
		ans = new LinkedList<Integer>();
		for(int i = 0; i < n; i++) {
			if(arr[i] != 0) {
				int u = i;
				int v = arr[i] - 1;
				adj[u].add(v);
				adj[v].add(u);
			}
		}
		dfs(0, 0);
		if(type[0] == -1) {
			out.println("NO");
			return;
		}
		dfs2(0, 0);
		out.println("YES");
		for(Integer x : ans) {
			out.println(x);
		}
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
