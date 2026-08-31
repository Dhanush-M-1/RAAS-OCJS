import java.util.*;
import java.io.*;

public class Main {
	static class Reader {
		BufferedReader br; StringTokenizer st;

		public Reader() { br = new BufferedReader(new InputStreamReader(System.in)); }

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try { st = new StringTokenizer(br.readLine());
				} catch (IOException e) { e.printStackTrace(); }
			}
			return st.nextToken();
		}

		int nextInt() { return Integer.parseInt(next()); }
		long nextLong() { return Long.parseLong(next()); }
		double nextDouble() { return Double.parseDouble(next()); }
	}
	static int n, k;
	static long[] t;
	static int[] a;
	static int[] b;
	static long[] dp;
	static long mint = 1000000000;

	static long recur(int i, int al, int bl, long curt) {
		if (al >= k && bl >= k) {
			return curt;
			//return curt;
		} else if (i < 0) {
			return 1000000000;
		}
		
		else if (dp[i] != 0) {
			return dp[i];
		}

		long m1 = 1000000000;
		m1 = recur(i - 1, al + a[i], bl + b[i], curt + t[i]);
		m1 = Long.min(m1, recur(i - 1, al, bl, curt));
		dp[i] = Long.min(dp[i], curt);


		return m1;
	}

	public static void main(String[] args) {
		Reader r = new Reader();

		n = r.nextInt();
		k = r.nextInt();
		int[] t = new int[n];
		a = new int[n];
		b = new int[n];
		ArrayList<Integer> aa = new ArrayList<Integer>();
		ArrayList<Integer> bb = new ArrayList<Integer>();
		ArrayList<Integer> cc = new ArrayList<Integer>();
				
		for (int i = 0; i < n; i++) {
			t[i] = r.nextInt();
			a[i] = r.nextInt();
			b[i] = r.nextInt();

			if (a[i] > 0 && b[i] > 0) {
				cc.add(t[i]);
			} else if (a[i] > 0) {
				aa.add(t[i]);
			} else if (b[i] > 0) {
				bb.add(t[i]);
			}
		}

		aa.sort(null);
		bb.sort(null);
		cc.sort(null);

		int ak = k;
		int bk = k;
		int c1 = 0;
		int c2 = 0;
		int c3 = 0;
		long o = 0;

		while (ak > 0 || bk > 0) {
			int t1 = 100000;
			int t2 = 100000;
			int t3 = 100000;
			if (c1 < aa.size()) t1 = aa.get(c1);
			if (c2 < bb.size()) t2 = bb.get(c2);
			if (c3 < cc.size()) t3 = cc.get(c3);

			if (ak > 0 && bk > 0) {
				if (t3 != 100000 && t3 < t1 + t2) {
					o += t3;
					c3++;
					ak--;
					bk--;
				} else if (t1 != 100000 && t2 != 100000) {
					o += t1 + t2;
					c1++;
					c2++;
					ak--;
					bk--;
				} else {
					break;
				}
			} else if (ak > 0) {
				if (t3 < t1) {
					o += t3;
					c3++;
					ak--;
					bk--;
				} else if (t1 != 100000) {
					o += t1;
					c1++;
					ak--;
				} else {
					break;
				}
			} else {
				if (t3 < t2) {
					o += t3;
					c3++;
					ak--;
					bk--;
				} else if (t2 != 100000) {
					o += t2;
					c2++;
					ak--;
				} else {
					break;
				}
			}
		}

		if (ak < 1 && bk < 1) {
			System.out.println(o);
		} else {
			System.out.println(-1);
		}
	}
}
