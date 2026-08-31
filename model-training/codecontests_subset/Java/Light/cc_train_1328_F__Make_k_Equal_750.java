import java.io.*;
import java.util.*;

public class CF1213D2 extends PrintWriter {
	CF1213D2() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1213D2 o = new CF1213D2(); o.main(); o.flush();
	}

	static class V {
		int a, c;
		V(int a, int c) {
			this.a = a; this.c = c;
		}
	}
	void main() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		V[] vv = new V[n * 20];
		int m = 0;
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			for (int c = 0; ; c++) {
				vv[m++] = new V(a, c);
				if (a == 0)
					break;
				a /= 2;
			}
		}
		Arrays.sort(vv, 0, m, (u, v) -> u.a != v.a ? u.a - v.a : u.c - v.c);
		int ans = n * 20;
		for (int i = 0, j; i < m; i = j) {
			j = i + 1;
			while (j < m && vv[j].a == vv[i].a)
				j++;
			if (j - i >= k) {
				int c = 0;
				for (int h = 0; h < k; h++)
					c += vv[i + h].c;
				ans = Math.min(ans, c);
			}
		}
		println(ans);
	}
}
