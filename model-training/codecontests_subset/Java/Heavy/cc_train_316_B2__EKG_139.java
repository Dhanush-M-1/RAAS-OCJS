import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;

import static java.lang.Math.*;

public class Solution implements Runnable {
	
	public void solve() throws Exception {
		int n = sc.nextInt(), x = sc.nextInt() - 1;
		
		int[] prev = new int[n];
		int[] next = new int[n];
		
		Arrays.fill(prev, -1);
		Arrays.fill(next, -1);
		
		for (int i = 0; i < n; i++) {
			prev[i] = sc.nextInt() - 1;
			if (prev[i] != -1) {
				next[prev[i]] = i;
			}
		}
		
		ArrayList<Integer> groups = new ArrayList<Integer>();
		int cbgroup = -1, cbpos = -1;
		
		for (int i = 0; i < n; i++) {
			if (prev[i] == -1) {
				int cur = i;
				int curpos = 0;
				while (cur != -1) {
					if (cur == x) {
						cbgroup = groups.size();
						cbpos = curpos;
					}
					cur = next[cur];
					curpos++;
				}
				groups.add(curpos);
			}
		}
		
		int[] w = new int[groups.size() - 1];
		
		for (int i = 0, pos = 0; i < groups.size(); i++) {
			if (i != cbgroup) {
				w[pos++] = groups.get(i);
			}
		}
		
		boolean[] knapsack = new boolean[n + 1];
		knapsack[0] = true;
		for (int i = 0; i < w.length; i++) {
			for (int j = knapsack.length - 1; j >= 0; j--) {
				if (knapsack[j] && j + w[i] < knapsack.length) {
					knapsack[j + w[i]] = true;
				}
			}
		}
		
		for (int i = 0; i < knapsack.length; i++) {
			if (knapsack[i]) {
				out.println(i + cbpos + 1);
			}
		}
	}

	static Throwable uncaught;

	BufferedReader in;
	FastScanner sc;
	PrintWriter out;

	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			sc = new FastScanner(in);
			solve();
		} catch (Throwable uncaught) {
			Solution.uncaught = uncaught;
		} finally {
			out.close();
		}
	}

	public static void main(String[] args) throws Throwable {
		Thread thread = new Thread(null, new Solution(), "", (1 << 26));
		thread.start();
		thread.join();
		if (Solution.uncaught != null) {
			throw Solution.uncaught;
		}
	}

}

class FastScanner {

	BufferedReader in;
	StringTokenizer st;

	public FastScanner(BufferedReader in) {
		this.in = in;
	}

	public String nextToken() throws Exception {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		return st.nextToken();
	}

	public int nextInt() throws Exception {
		return Integer.parseInt(nextToken());
	}

	public long nextLong() throws Exception {
		return Long.parseLong(nextToken());
	}

	public double nextDouble() throws Exception {
		return Double.parseDouble(nextToken());
	}

}