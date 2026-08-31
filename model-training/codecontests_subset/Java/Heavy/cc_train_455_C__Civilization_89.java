import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;

public class Round260C {

	
	public static LinkedList<Integer>[] adj;
	public static int[] dia;
	public static int[] st_max;
	public static boolean[] visited;
	
	public static int dfs(int curr, int pr) {
		visited[curr] = true;
		ArrayList<Integer> set = new ArrayList<Integer>();
		int max = 0;
		for(Integer x : adj[curr]) {
			if(x != pr) {
				max = Integer.max(dfs(x, curr), max);
				set.add(st_max[x]);
			}
		}
		Collections.sort(set);
		if(set.size() == 0) {
			dia[curr] = 0;
		}else if(set.size() == 1) {
			dia[curr] = 1 + set.get(0);
			st_max[curr] = 1 + set.get(0);
		}else {
			st_max[curr] = 1 + set.get(set.size() - 1);
			dia[curr] = 2 + set.get(set.size() - 1) + set.get(set.size() - 2);
		}
		max = Integer.max(max, Integer.max(st_max[curr], dia[curr]));
		return max;
	}
	
	public static int[] parent;
	public static int[] size;
	public static int[] diameter;
	
	public static void make_set(int u) {
		parent[u] = u;
		size[u] = 1;
	}
	
	public static int find_set(int u) {
		if(u == parent[u]) {
			return u;
		}
		return parent[u] = find_set(parent[u]);
	}
	
	public static void Union_set(int u, int v, int type) {
		u = find_set(u);
		v = find_set(v);
		if(u == v) {
			return;
		}
		if(size[u] > size[v]) {
			size[u] += size[v];
			parent[v] = u;
			if(type == 1) {
				int first_max = diameter[u] % 2 == 1 ? (diameter[u] + 1)/2 : diameter[u]/2;
				int second_max = diameter[v] % 2 == 1 ? (diameter[v] + 1)/2 : diameter[v]/2;
				diameter[u] = Integer.max(diameter[u], 1 + first_max + second_max);
				diameter[u] = Integer.max(diameter[u], diameter[v]);
			}
		}else {
			size[v] += size[u];
			parent[u] = v;
			if(type == 1) {
				int first_max = diameter[u] % 2 == 1 ? (diameter[u] + 1)/2 : diameter[u]/2;
				int second_max = diameter[v] % 2 == 1 ? (diameter[v] + 1)/2 : diameter[v]/2;
				diameter[v] = Integer.max(diameter[v], 1 + first_max + second_max);
				diameter[v] = Integer.max(diameter[v], diameter[u]);
			}
		}
	}
	
	public static void solve() {
		int n = s.nextInt();
		int m = s.nextInt();
		int q = s.nextInt();
		adj = new LinkedList[n];
		parent = new int[n];
		size = new int[n];
		dia = new int[n];
		st_max = new int[n];
		diameter = new int[n];
		for(int i = 0; i < n; i++) {
			make_set(i);
			adj[i] = new LinkedList<Integer>();
		}
		while(m-- > 0) {
			int u = s.nextInt() - 1;
			int v = s.nextInt() - 1;
			adj[u].add(v);
			adj[v].add(u);
			Union_set(u, v, 0);
		}
		visited = new boolean[n];
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				int now_dia = dfs(i, i);
				int par = find_set(i);
				diameter[par] = now_dia;
			}
		}
		while(q-- > 0) {
			int type = s.nextInt();
			if(type == 1) {
				int x = s.nextInt() - 1;
				x = find_set(x);
				out.println(diameter[x]);
			}else {
				int u = s.nextInt() - 1;
				int v = s.nextInt() - 1;
				Union_set(u, v, 1);
			}
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
