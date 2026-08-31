// practice with rainboy
import java.io.*;
import java.util.*;

public class CF425D extends PrintWriter {
	CF425D() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF425D o = new CF425D(); o.main(); o.flush();
	}

	static final int K = 200, Y = 100000;
	static class P {
		int x, y;
		P(int x, int y) {
			this.x = x; this.y = y;
		}
	}
	static Random rand = new Random();
	static class V {
		V l, r;
		long key;
		int x;
		V(long key) {
			this.key = key;
			x = rand.nextInt();
		}
	}
	V v_, l_, r_;
	void split(V v, long key) {
		if (v == null) {
			v_ = l_ = r_ = null;
		} else if (v.key < key) {
			split(v.r, key);
			v.r = l_; l_ = v;
		} else if (v.key > key) {
			split(v.l, key);
			v.l = r_; r_ = v;
		} else {
			v_ = v; l_ = v.l; r_ = v.r;
			v.l = v.r = null;
		}
	}
	V merge(V u, V v) {
		if (u == null)
			return v;
		if (v == null)
			return u;
		if (u.x < v.x) {
			u.r = merge(u.r, v);
			return u;
		} else {
			v.l = merge(u, v.l);
			return v;
		}
	}
	boolean has(long key) {
		split(v_, key);
		boolean ans = v_ != null;
		v_ = merge(l_, merge(v_, r_));
		return ans;
	}
	void add(long key) {
		split(v_, key);
		if (v_ == null)
			v_ = new V(key);
		v_ = merge(l_, merge(v_, r_));
	}
	long compose(int x, int y) {
		return (long) x * (Y + 1) + y;
	}
	void main() {
		int n = sc.nextInt();
		P[] pp = new P[n];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			pp[i] = new P(x, y);
			add(compose(x, y));
		}
		int[] ll = new int[Y + 1];
		int[] rr = new int[Y + 1]; Arrays.fill(rr, -1);
		Arrays.sort(pp, (p, q) -> p.y != q.y ? p.y - q.y : p.x - q.x);
		int[] yy = new int[n]; int cnt = 0;
		for (int i = 0, j; i < n; i = j) {
			int y = pp[i].y;
			j = i + 1;
			while (j < n && pp[j].y == y)
				j++;
			ll[y] = i; rr[y] = j;
			if (j - i > K)
				yy[cnt++] = y;
		}
		int ans = 0;
		for (int h = 0; h < cnt; h++) {
			int y = yy[h], l = ll[y], r = rr[y];
			for (int h_ = h + 1; h_ < cnt; h_++) {
				int y_ = yy[h_], l_ = ll[y_], r_ = rr[y_];
				for (int i = l, j = l, i_ = l_, j_ = l_; i < r && j < r && i_ < r_ && j_ < r_; i++) {
					int x = pp[i].x, x_ = x + y_ - y;
					while (j < r && pp[j].x < x_)
						j++;
					if (j < r && pp[j].x == x_) {
						while (i_ < r_ && pp[i_].x < x)
							i_++;
						if (i_ < r_ && pp[i_].x == x) {
							while (j_ < r_ && pp[j_].x < x_)
								j_++;
							if (j_ < r_ && pp[j_].x == x_)
								ans++;
						}
					}
				}
			}
		}
		for (int y = 0; y <= Y; y++) {
			int l = ll[y], r = rr[y];
			if (r - l > K)
				continue;
			for (int i = l; i < r; i++)
				for (int j = i + 1; j < r; j++) {
					int x = pp[i].x, x_ = pp[j].x, y_, l_, r_;
					y_ = y - (x_ - x);
					if (y_ >= 0 && rr[y_] - ll[y_] > K && has(compose(x, y_)) && has(compose(x_, y_)))
						ans++;
					y_ = y + (x_ - x);
					if (y_ <= Y && rr[y_] - ll[y_] > 0 && has(compose(x, y_)) && has(compose(x_, y_)))
						ans++;
				}
		}
		println(ans);
	}
}
