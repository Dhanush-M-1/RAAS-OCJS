// practice with kaiboy
import java.io.*;
import java.util.*;

public class CF361C extends PrintWriter {
	CF361C() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF361C o = new CF361C(); o.main(); o.flush();
	}

	static final int A = 1000000000;
	void main() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] aa = new int[n]; Arrays.fill(aa, A);
		int[] bb = new int[n];
		int[] tt = new int[m], ll = new int[m], rr = new int[m], xx = new int[m];
		for (int h = 0; h < m; h++) {
			int t = sc.nextInt();
			int l = sc.nextInt() - 1;
			int r = sc.nextInt();
			int x = sc.nextInt();
			tt[h] = t; ll[h] = l; rr[h] = r; xx[h] = x;
			if (t == 1)
				for (int i = l; i < r; i++)
					bb[i] += x;
			else
				for (int i = l; i < r; i++)
					aa[i] = Math.min(aa[i], x - bb[i]);
		}
		for (int i = 0; i < n; i++)
			if (aa[i] < -A) {
				println("NO");
				return;
			}
		Arrays.fill(bb, 0);
		for (int h = 0; h < m; h++) {
			int t = tt[h], l = ll[h], r = rr[h], x = xx[h];
			if (t == 1)
				for (int i = l; i < r; i++)
					bb[i] += x;
			else {
				int y = -A;
				for (int i = l; i < r; i++)
					y = Math.max(y, aa[i] + bb[i]);
				if (y != x) {
					println("NO");
					return;
				}
			}
		}
		println("YES");
		for (int i = 0; i < n; i++)
			print(aa[i] + " ");
		println();
	}
}
