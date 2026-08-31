// practice with rainboy
import java.io.*;
import java.util.*;

public class CF634C extends PrintWriter {
	CF634C() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF634C o = new CF634C(); o.main(); o.flush();
	}

	void update(int[] aa, int i, int n, int x) {
		while (i < n) {
			aa[i] += x;
			i |= i + 1;
		}
	}
	int query(int[] aa, int i) {
		int x = 0;
		while (i >= 0) {
			x += aa[i];
			i &= i + 1;
			i--;
		}
		return x;
	}
	void main() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int q = sc.nextInt();
		int[] aa = new int[n];
		int[] bb = new int[n];
		int[] cc = new int[n];
		while (q-- > 0) {
			int t = sc.nextInt();
			int i = sc.nextInt() - 1;
			if (t == 1) {
				int c = sc.nextInt();
				if (cc[i] < a)
					update(aa, i, n, Math.min(c, a - cc[i]));
				if (cc[i] < b)
					update(bb, i, n, Math.min(c, b - cc[i]));
				cc[i] += c;
			} else
				println(query(aa, n - 1) - query(aa, i + k - 1) + query(bb, i - 1));
		}
	}
}
