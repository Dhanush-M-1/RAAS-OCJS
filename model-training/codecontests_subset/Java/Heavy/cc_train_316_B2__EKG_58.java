import java.io.*;
import java.util.*;
import java.math.*;
import java.awt.geom.*;

import static java.lang.Math.*;

public class Solution implements Runnable {
	
	class DSU {
		
		
		int n;
		int p [];
		int size [];
		
		public DSU(int n) {
			this.n = n;
			p = new int [n];
			size = new int [n];
			for (int i = 0; i < n; i++) {
				p[i] = i;
				size[i] = 1;
			}
		}
		
		public int get (int x) {
			if (x == p[x]) return x;
			return p[x] = get (p[x]);
		}
		
		public void unite (int x, int y) {
			x = get (x);
			y = get (y);
			if (size[x] < size[y]) {
				p[x] = y;
				size[y] += size[x];
			} else {
				p[y] = x;
				size[x] += size[y];
			}
		}
		
	}
	
	int n, x;
	int [] next;
	boolean [] used;
	
	public void solve() throws Exception {
		n = sc.nextInt();
		x = sc.nextInt() - 1;
		next = new int [n];
		for (int i = 0; i < n; i++) {
			next[i] = sc.nextInt() - 1;
		}
		DSU dsu = new DSU(n);
		used = new boolean [n];
		
		for (int i = 0; i < n; i++) {
			if (next[i] != -1) {
				dsu.unite(i, next[i]);
			}
		}
		
		int componentX = dsu.get(x);
		used[componentX] = true;
		
		int posX = 1;
		int tx = next[x];
		while (tx != -1) {
			tx = next[tx];
			posX++;
		}
		
		ArrayList<Integer> sizes = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			int j = dsu.get(i);
			if (!used[j]) {
				sizes.add(dsu.size[j]);
				used[j] = true;
			}
		}
		
		int m = sizes.size();
		
		boolean dp[][] = new boolean [m + 1][n + 1];
		dp[0][0] = true;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j <= n; j++) {
				if (dp[i][j]) {
					dp[i + 1][j + sizes.get(i)] = true;
					dp[i + 1][j] = true;
				}
			}
		}
		
		for (int i = 0; i <= n; i++) {
			if (dp[m][i]) {
				out.println((i+posX));
			}
		}
		
	}

	BufferedReader in;
	PrintWriter out;
	FastScanner sc;

	static Throwable uncaught;

	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			sc = new FastScanner(in);
			solve();
		} catch (Throwable t) {
			Solution.uncaught = t;
		} finally {
			out.close();
		}
	}

	public static void main(String[] args) throws Throwable {
		Thread t = new Thread(null, new Solution(), "", (1 << 26));
		t.start();
		t.join();
		if (uncaught != null) {
			throw uncaught;
		}
	}

}

class FastScanner {

	BufferedReader reader;
	StringTokenizer strTok;

	public FastScanner(BufferedReader reader) {
		this.reader = reader;
	}

	public String nextToken() throws IOException {
		while (strTok == null || !strTok.hasMoreTokens()) {
			strTok = new StringTokenizer(reader.readLine());
		}
		return strTok.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

}
