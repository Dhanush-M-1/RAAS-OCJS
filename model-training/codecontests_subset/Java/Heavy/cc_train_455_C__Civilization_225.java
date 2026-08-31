// practice with rainboy
import java.io.*;
import java.util.*;

public class CF455C extends PrintWriter {
	CF455C() { super(System.out); }
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
		CF455C o = new CF455C(); o.main(); o.flush();
	}

	int[] next, jj; int l_ = 1;
	int link(int l, int j) { next[l_] = l; jj[l_] = j; return l_++; }
	int[] ao, cc, dd, dsu;
	void init(int n, int m) {
		next = new int[1 + m * 2];
		jj = new int[1 + m * 2];
		ao = new int[n];
		cc = new int[n]; Arrays.fill(cc, -1);
		dd = new int[n];
		dsu = new int[n];
	}
	int d_, j_;
	void dfs(int p, int i, int c, int d) {
		if (d_ < d) {
			d_ = d; j_ = i;
		}
		cc[i] = c;
		for (int l = ao[i]; l != 0; l = next[l]) {
			int j = jj[l];
			if (j != p)
				dfs(i, j, c, d + 1);
		}
	}
	int find(int i) {
		return dsu[i] < 0 ? i : (dsu[i] = find(dsu[i]));
	}
	void join(int i, int j) {
		i = find(i);
		j = find(j);
		if (i == j)
			return;
		if (dsu[i] > dsu[j]) {
			dsu[i] = j;
			dd[j] = Math.max(Math.max(dd[i], dd[j]), (dd[i] + 1) / 2 + (dd[j] + 1) / 2 + 1);
		} else {
			if (dsu[i] == dsu[j])
				dsu[i]--;
			dsu[j] = i;
			dd[i] = Math.max(Math.max(dd[i], dd[j]), (dd[i] + 1) / 2 + (dd[j] + 1) / 2 + 1);
		}
	}
	void main() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int q = sc.nextInt();
		init(n, m);
		while (m-- > 0) {
			int i = sc.nextInt() - 1;
			int j = sc.nextInt() - 1;
			ao[i] = link(ao[i], j);
			ao[j] = link(ao[j], i);
		}
		for (int i = 0; i < n; i++)
			if (cc[i] == -1) {
				d_ = 0; j_ = i;
				dfs(-1, i, i, 0);
				dfs(-1, j_, i, 0);
				dd[i] = d_;
				dsu[i] = -1;
			}
		for (int i = 0; i < n; i++)
			if (cc[i] != i)
				dsu[i] = cc[i];
		while (q-- > 0) {
			int t = sc.nextInt();
			int i = sc.nextInt() - 1;
			if (t == 1)
				println(dd[find(i)]);
			else {
				int j = sc.nextInt() - 1;
				join(i, j);
			}
		}
	}
}
