import java.io.*;
import java.util.*;

public class CF1253F extends PrintWriter {
	CF1253F() { super(System.out); }
	static class Scanner {
		Scanner(InputStream in) { this.in = in; } InputStream in;
		int k, l; byte[] bb = new byte[1 << 15];
		byte getc() {
			if (k >= l) {
				k = 0;
				try { l = in.read(bb); } catch (IOException e) { l = 0; }
				if (l <= 0) return -1;
			}
			return bb[k++];
		}
		int nextInt() {
			byte c = 0; while (c <= 32) c = getc();
			int a = 0;
			while (c > 32) { a = a * 10 + c - '0'; c = getc(); }
			return a;
		}
	}
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1253F o = new CF1253F(); o.main(); o.flush();
	}

	static final long INF = 0x3f3f3f3f3f3f3f3fL;
	int[] oo, oh; int __ = 1;
	int link(int o, int h) {
		oo[__] = o; oh[__] = h;
		return __++;
	}
	int[] ii, jj; long[] ww;
	int[] ae, pp, dsu; long[] dd;
	int[] pq, iq; int cnt;
	int[][] pp_; long[][] ww_; int ln;
	void init(int n, int m, int k) {
		oo = new int[1 + m * 2]; oh = new int[1 + m * 2];
		ii = new int[m]; jj = new int[m]; ww = new long[m];
		ae = new int[n]; pp = new int[n];
		dsu = new int[n]; Arrays.fill(dsu, -1);
		dd = new long[n]; Arrays.fill(dd, INF);
		pq = new int[1 + n]; iq = new int[n];
		ln = 0;
		while (1 << ln + 1 < n)
			ln++;
		pp_ = new int[ln + 1][k];
		ww_ = new long[ln + 1][k];
	}
	boolean less(int u, int v) {
		return dd[u] < dd[v];
	}
	int i2(int i) {
		return (i *= 2) > cnt ? 0 : i < cnt && less(pq[i + 1], pq[i]) ? i + 1 : i;
	}
	void pq_up(int u) {
		int i, j, v;
		for (i = iq[u]; (j = i / 2) > 0 && less(u, v = pq[j]); i = j)
			pq[iq[v] = i] = v;
		pq[iq[u] = i] = u;
	}
	void pq_dn(int u) {
		int i, j, v;
		for (i = iq[u]; (j = i2(i)) > 0 && less(v = pq[j], u); i = j)
			pq[iq[v] = i] = v;
		pq[iq[u] = i] = u;
	}
	void pq_add_last(int u) {
		pq[iq[u] = ++cnt] = u;
	}
	int pq_remove_first() {
		int u = pq[1], v = pq[cnt--];
		if (v != u) {
			iq[v] = 1; pq_dn(v);
		}
		return u;
	}
	void dijkstra(int n, int k) {
		for (int i = 0; i < k; i++) {
			pp[i] = i;
			dd[i] = 0;
			pq_add_last(i);
		}
		while (cnt > 0) {
			int i = pq_remove_first();
			long d = dd[i];
			for (int o = ae[i]; o != 0; o = oo[o]) {
				int h = oh[o], j = i ^ ii[h] ^ jj[h]; long w = ww[h];
				if (dd[j] > d + w) {
					if (dd[j] == INF)
						pq_add_last(j);
					pp[j] = pp[i];
					dd[j] = d + w;
					pq_up(j);
				}
			}
		}
	}
	int find(int i) {
		return dsu[i] < 0 ? i : (dsu[i] = find(dsu[i]));
	}
	boolean join(int i, int j) {
		i = find(i);
		j = find(j);
		if (i == j)
			return false;
		if (dsu[i] > dsu[j])
			dsu[i] = j;
		else {
			if (dsu[i] == dsu[j])
				dsu[i]--;
			dsu[j] = i;
		}
		return true;
	}
	void dfs_(int p, int i, int d, long w) {
		dd[i] = d;
		pp_[0][i] = p;
		ww_[0][i] = w;
		for (int h = 1; 1 << h <= d; h++) {
			int q = pp_[h - 1][i];
			pp_[h][i] = pp_[h - 1][q];
			ww_[h][i] = Math.max(ww_[h - 1][i], ww_[h - 1][q]);
		}
		for (int o = ae[i]; o != 0; o = oo[o]) {
			int h = oh[o], j = i ^ ii[h] ^ jj[h];
			if (j != p)
				dfs_(i, j, d + 1, ww[h]);
		}
	}
	long query(int i, int j) {
		if (dd[i] < dd[j]) {
			int tmp = i; i = j; j = tmp;
		}
		long w = 0;
		for (int h = ln; h >= 0; h--)
			if (1 << h <= dd[i] - dd[j]) {
				w = Math.max(w, ww_[h][i]);
				i = pp_[h][i];
			}
		if (i == j)
			return w;
		for (int h = ln; h >= 0; h--)
			if (1 << h <= dd[i] && pp_[h][i] != pp_[h][j]) {
				w = Math.max(w, ww_[h][i]);
				w = Math.max(w, ww_[h][j]);
				i = pp_[h][i];
				j = pp_[h][j];
			}
		w = Math.max(w, ww_[0][i]);
		w = Math.max(w, ww_[0][j]);
		return w;
	}
	void main() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int q = sc.nextInt();
		init(n, m, k);
		for (int h = 0; h < m; h++) {
			int i = sc.nextInt() - 1;
			int j = sc.nextInt() - 1;
			int w = sc.nextInt();
			ii[h] = i;
			jj[h] = j;
			ww[h] = w;
			ae[i] = link(ae[i], h);
			ae[j] = link(ae[j], h);
		}
		dijkstra(n, k);
		int m_ = 0;
		for (int h = 0; h < m; h++) {
			int i = ii[h], j = jj[h];
			if (pp[i] != pp[j]) {
				ii[m_] = pp[i];
				jj[m_] = pp[j];
				ww[m_] = dd[i] + dd[j] + ww[h];
				m_++;
			}
		}
		Integer[] hh = new Integer[m_];
		for (int h = 0; h < m_; h++)
			hh[h] = h;
		Arrays.sort(hh, (h1, h2) -> Long.signum(ww[h1] - ww[h2]));
		Arrays.fill(ae, 0, k, 0); __ = 1;
		for (int h = 0; h < m_; h++) {
			int h_ = hh[h], i = ii[h_], j = jj[h_];
			if (join(i, j)) {
				ae[i] = link(ae[i], h_);
				ae[j] = link(ae[j], h_);
			}
		}
		dfs_(-1, 0, 0, 0);
		while (q-- > 0) {
			int i = sc.nextInt() - 1;
			int j = sc.nextInt() - 1;
			println(query(i, j));
		}
	}
}
