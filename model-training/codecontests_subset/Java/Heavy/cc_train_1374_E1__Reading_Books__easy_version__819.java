// upsolve with kaiboy
import java.io.*;
import java.util.*;

public class CF1374E2 extends PrintWriter {
	CF1374E2() { super(System.out); }
	static class Scanner {
		Scanner(InputStream in) { this.in = in; } InputStream in;
		byte[] bb = new byte[1 << 15]; int i, n;
		byte getc() {
			if (i >= n) {
				try { n = in.read(bb); } catch (IOException e) { n = 0; }
				if (n <= 0) return -1;
				i = 0;
			}
			return bb[i++];
		}
		int nextInt() {
			byte c = 0; while (c <= ' ') c = getc();
			boolean minus = c == '-'; if (minus) c = getc();
			int a = 0; while (c > ' ') { a = a * 10 + c - '0'; c = getc(); }
			return minus ? -a : a;
		}
	}
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1374E2 o = new CF1374E2(); o.main(); o.flush();
	}

	static final int INF = 0x7fffffff;
	int[] tt; Integer[] ta, tb, tc, td;
	int na, nb, nc, nd;
	int ka, kb, kd;
	boolean wiggle(int k, int m) {
		int d = Math.max(k - ka, 0) + Math.max(k - kb, 0);
		ka = Math.max(ka, k); kb = Math.max(kb, k);
		kd = Math.max(kd - d, 0);
		while (ka + kb + kd < m) {
			int t_ = INF, t, choice = 0;
			if (ka < na && t_ > (t = tt[ta[ka]])) {
				t_ = t;
				choice = 1;
			}
			if (kb < nb && t_ > (t = tt[tb[kb]])) {
				t_ = t;
				choice = 2;
			}
			if (kd < nd && t_ > (t = tt[td[kd]])) {
				t_ = t;
				choice = 4;
			}
			if (choice == 0)
				return false;
			if (choice == 1)
				ka++;
			else if (choice == 2)
				kb++;
			else
				kd++;
		}
		return true;
	}
	void main() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		tt = new int[n];
		ta = new Integer[n];
		tb = new Integer[n];
		tc = new Integer[n];
		td = new Integer[n];
		for (int i = 0; i < n; i++) {
			int t = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			tt[i] = t;
			if (a == 1 && b == 0)
				ta[na++] = i;
			else if (a == 0 && b == 1)
				tb[nb++] = i;
			else if (a == 1 && b == 1)
				tc[nc++] = i;
			else
				td[nd++] = i;
		}
		if (nc + Math.min(na, nb) < k || k * 2 - nc > m) {
			println(-1);
			return;
		}
		Arrays.sort(ta, 0, na, (i, j) -> tt[i] - tt[j]);
		Arrays.sort(tb, 0, nb, (i, j) -> tt[i] - tt[j]);
		Arrays.sort(tc, 0, nc, (i, j) -> tt[i] - tt[j]);
		Arrays.sort(td, 0, nd, (i, j) -> tt[i] - tt[j]);
		int[] sa = new int[1 + na];
		int[] sb = new int[1 + nb];
		int[] sc = new int[1 + nc];
		int[] sd = new int[1 + nd];
		for (int i = 0; i < na; i++)
			sa[i + 1] = sa[i] + tt[ta[i]];
		for (int i = 0; i < nb; i++)
			sb[i + 1] = sb[i] + tt[tb[i]];
		for (int i = 0; i < nc; i++)
			sc[i + 1] = sc[i] + tt[tc[i]];
		for (int i = 0; i < nd; i++)
			sd[i + 1] = sd[i] + tt[td[i]];
		int l = Math.max(Math.max(k - Math.min(na, nb), k * 2 - m), 0);
		int r = Math.min(nc, m);
		int ans = INF, ka_ = 0, kb_ = 0, kc_ = 0, kd_ = 0;
		for (int x = r; x >= l && wiggle(Math.max(k - x, 0), m - x); x--) {
			int sum = sa[ka] + sb[kb] + sc[x] + sd[kd];
			if (ans > sum) {
				ans = sum;
				ka_ = ka; kb_ = kb; kc_ = x; kd_ = kd;
			}
		}
		println(ans);
		for (int i = 0; i < ka_; i++)
			print(ta[i] + 1 + " ");
		for (int i = 0; i < kb_; i++)
			print(tb[i] + 1 + " ");
		for (int i = 0; i < kc_; i++)
			print(tc[i] + 1 + " ");
		for (int i = 0; i < kd_; i++)
			print(td[i] + 1 + " ");
		println();
	}
}
