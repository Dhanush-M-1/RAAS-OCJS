import java.io.*;
import java.util.*;

public class CF1490G extends PrintWriter {
	CF1490G() { super(System.out); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1490G o = new CF1490G(); o.main(); o.flush();
	}

	static final int INF = 1000000000;
	void main() {
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			long[] aa = new long[n];
			for (int i = 0; i < n; i++)
				aa[i] = sc.nextInt();
			long a = 0;
			for (int i = 0; i < n; i++) {
				aa[i] = a += aa[i];
				if (a >= INF) {
					aa[i] = a = INF;
					n = i + 1;
					break;
				}
			}
			for (int i = 1; i < n; i++)
				aa[i] = Math.max(aa[i], aa[i - 1]);
			long b = aa[n - 1];
			while (m-- > 0) {
				long x = sc.nextInt();
				long k = 0;
				if (x > b) {
					if (a <= 0) {
						print(-1 + " ");
						continue;
					}
					k = (x - b + a - 1) / a;
				}
				x -= k * a;
				int lower = -1, upper = n - 1;
				while (upper - lower > 1) {
					int i = (lower + upper) / 2;
					if (aa[i] >= x)
						upper = i;
					else
						lower = i;
				}
				print(k * n + upper + " ");
			}
			println();
		}
	}
}
