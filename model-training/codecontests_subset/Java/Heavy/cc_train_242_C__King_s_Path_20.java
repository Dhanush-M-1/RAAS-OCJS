// practice with kaiboy
import java.io.*;
import java.util.*;

public class CF242C extends PrintWriter {
	CF242C() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF242C o = new CF242C(); o.main(); o.flush();
	}

	static final int N = 100000;
	static class P {
		int x, y;
		P(int x, int y) {
			this.x = x; this.y = y;
		}
	}
	P[] pp = new P[N];
	int[] eo; int[][] ej;
	void init(int n) {
		eo = new int[n]; ej = new int[n][2];
	}
	void append(int i, int j) {
		int o = eo[i]++;
		if (o >= 2 && (o & o - 1) == 0)
			ej[i] = Arrays.copyOf(ej[i], o << 1);
		ej[i][o] = j;
	}
	void sweep1(int l, int r) {
		for (int i = l + 1; i < r; i++)
			if (pp[i - 1].y == pp[i].y - 1) {
				append(i - 1, i); append(i, i - 1);
			}
	}
	void sweep2(int l, int m, int r) {
		for (int i = l, j = m; i < m && j < r; i++) {
			int y = pp[i].y;
			while (j < r && pp[j].y < y - 1)
				j++;
			for (int k = j; k < r && pp[k].y <= y + 1; k++) {
				append(i, k); append(k, i);
			}
		}
	}
	int bfs(int n, int s, int t) {
		int[] dd = new int[n]; Arrays.fill(dd, n);
		int[] qu = new int[n]; int head = 0, cnt = 0, cnt_ = 0;
		dd[s] = 0; qu[head + cnt++] = s;
		while (cnt > 0) {
			int i = qu[head++]; cnt--;
			int d = dd[i] + 1;
			for (int o = eo[i]; o-- > 0; ) {
				int j = ej[i][o];
				if (dd[j] == n) {
					dd[j] = d;
					if (j == t)
						return d;
					qu[head + cnt++] = j;
				}
			}
		}
		return -1;
	}
	void main() {
		int x0 = sc.nextInt();
		int y0 = sc.nextInt();
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int m = sc.nextInt();
		int n = 0;
		while (m-- > 0) {
			int x = sc.nextInt();
			int l = sc.nextInt();
			int r = sc.nextInt();
			for (int y = l; y <= r; y++)
				pp[n++] = new P(x, y);
		}
		Arrays.sort(pp, 0, n, (p, q) -> p.x != q.x ? p.x - q.x : p.y - q.y);
		m = 1;
		for (int i = 1; i < n; i++) {
			P p = pp[i - 1], q = pp[i];
			if (p.x != q.x || p.y != q.y)
				pp[m++] = q;
		}
		init(n = m);
		for (int i = 0, j = 0, k; i < n; i = j, j = k) {
			int xi = pp[i].x;
			if (i == 0) {
				j = i + 1;
				while (j < n && pp[j].x == xi)
					j++;
			}
			sweep1(i, j);
			if (j == n)
				break;
			int xj = pp[j].x;
			k = j + 1;
			while (k < n && pp[k].x == xj)
				k++;
			if (xj == xi + 1)
				sweep2(i, j, k);
		}
		int i0 = 0, i1 = 0;
		while (!(pp[i0].x == x0 && pp[i0].y == y0))
			i0++;
		while (!(pp[i1].x == x1 && pp[i1].y == y1))
			i1++;
		println(bfs(n, i0, i1));
	}
}
