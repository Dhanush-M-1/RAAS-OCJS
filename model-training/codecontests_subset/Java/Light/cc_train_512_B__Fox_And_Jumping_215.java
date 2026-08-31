// practice with rainboy
import java.io.*;
import java.util.*;

public class CF512B extends PrintWriter {
	CF512B() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF512B o = new CF512B(); o.main(); o.flush();
	}

	static class V {
		int l, c;
		V(int l, int c) {
			this.l = l; this.c = c;
		}
	}
	int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	void main() {
		int n = sc.nextInt();
		int[] ll = new int[n];
		int[] cc = new int[n];
		for (int i = 0; i < n; i++) {
			int l = sc.nextInt(), l_ = 1;
			for (int a = 2; a <= l / a; a++)
				if (l % a == 0) {
					l_ *= a;
					while (l % a == 0)
						l /= a;
				}
			l_ *= l;
			ll[i] = l_;
		}
		for (int i = 0; i < n; i++)
			cc[i] = sc.nextInt();
		int m = (n << 9) + 1;
		V[] uu = new V[m];
		V[] vv = new V[m * 2];
		m = 0;
		uu[m++] = new V(0, 0);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				V u = uu[j];
				vv[j] = u;
				vv[m + j] = new V(gcd(u.l, ll[i]), u.c + cc[i]);
			}
			int m_ = m * 2;
			Arrays.sort(vv, 0, m_, (u, v) -> u.l != v.l ? u.l - v.l : u.c - v.c);
			m = 0;
			for (int j = 0; j < m_; j++)
				if (j == 0 || vv[j].l != vv[j - 1].l)
					uu[m++] = vv[j];
		}
		println(m >= 2 && uu[1].l == 1 ? uu[1].c : -1);
	}
}
