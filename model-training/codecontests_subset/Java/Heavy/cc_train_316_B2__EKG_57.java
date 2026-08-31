import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;
	
	String nextToken() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}
	
	int nextInt() throws Exception {
		return Integer.parseInt(nextToken());
	}
	
	boolean[][] ans = new boolean[1001][1001];
	
	void solve() throws Exception {
		int n = nextInt();
		int x = nextInt();
		int[] vs = new int[n + 1];
		int[] a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = nextInt();
			vs[a[i]]++;
		}
		ArrayList<Integer> q = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			if (vs[i] == 0) {
				int t = 0;
				int cur = i;
				int self = 0;
				while (cur > 0) {
					t++;
					if (cur == x) self = t;
					cur = a[cur];
				}
				if (self > 0) {
					ans[0][t - self + 1] = true;
				} else {
					q.add(t);
				}
			}
		}
		for (int i = 0; i < q.size(); i++) {
			int t = q.get(i);
			for (int j = 1; j <= n; j++) {
				if (ans[i][j]) {
					ans[i + 1][j] = true;
					ans[i + 1][j + t] = true;
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			if (ans[q.size()][i]) out.println(i);
		}
	}
	
	void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			Locale.setDefault(Locale.US);
			solve();
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			out.close();
		}
	}

	public static void main(String[] args) {
		new Solution().run();
	}
	
}
