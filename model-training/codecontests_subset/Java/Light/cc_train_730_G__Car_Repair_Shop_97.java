// practice with kaiboy
import java.io.*;
import java.util.*;

public class CF730G extends PrintWriter {
	CF730G() { super(System.out); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF730G o = new CF730G(); o.main(); o.flush();
	}

	static class C {
		int s, d, i;
		C(int s, int d, int i) {
			this.s = s; this.d = d; this.i = i;
		}
	}
	C[] aa, bb;
	boolean check(int n) {
		Arrays.sort(bb, 0, n, (a, b) -> a.s - b.s);
		for (int i = 0; i < n - 1; i++)
			if (bb[i].s + bb[i].d > bb[i + 1].s)
				return false;
		return true;
	}
	void main() {
		int n = sc.nextInt();
		aa = new C[1 + n];
		bb = new C[1 + n];
		aa[0] = bb[0] = new C(0, 1, 0);
		for (int j = 1; j <= n; j++) {
			int s = sc.nextInt();
			int d = sc.nextInt();
			aa[j] = bb[j] = new C(s, d, j);
			if (!check(1 + j))
				for (int i = 0; i < j; i++) {
					aa[j].s = aa[i].s + aa[i].d;
					if (check(1 + j))
						break;
				}
			C[] tmp = aa; aa = bb; bb = tmp;
		}
		Arrays.sort(aa, 0, 1 + n, (a, b) -> a.i - b.i);
		for (int i = 1; i <= n; i++) {
			C c = aa[i];
			println(c.s + " " + (c.s + c.d - 1));
		}
	}
}
