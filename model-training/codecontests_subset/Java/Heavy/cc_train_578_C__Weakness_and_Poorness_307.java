import java.io.*;
import java.util.*;
 
public class CF578C extends PrintWriter {
	CF578C() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF578C o = new CF578C(); o.main(); o.flush();
	}
 
	int[] aa;
	long cross(long x1, long y1, long x2, long y2) {
		return x1 * y2 - y1 * x2;
	}
	long cross3(int i, int j, int k) {
		return cross(j - i, aa[j] - aa[i], k - i, aa[k] - aa[i]);
	}
	double weakness(int i, int j, double x) {
		return Math.abs((aa[i] - x * i) - (aa[j] - x * j));
	}
	void main() {
		int n = sc.nextInt();
		aa = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			aa[i] = sc.nextInt();
			aa[i] += aa[i - 1];
		}
		Integer[] ii = new Integer[n + 1];
		for (int h = 0; h <= n; h++)
			ii[h] = h;
		Arrays.sort(ii, 1, n + 1, (i, j) -> {
			long c = cross3(0, i, j);
			return c == 0 ? i - j : c < 0 ? -1 : 1;
		});
		int[] stack = new int[n + 2];
		int cnt = 0;
		stack[cnt++] = ii[0];
		stack[cnt++] = ii[1];
		for (int h = 2; h <= n; h++) {
			int i = ii[h];
			while (cnt >= 2 && cross3(stack[cnt - 2], stack[cnt - 1], i) >= 0)
				cnt--;
			stack[cnt++] = i;
		}
		stack[cnt] = 0;
		double ans = 3e9;
		for (int p = 0, q = 1; p < cnt; p++) {
			int ux = stack[p + 1] - stack[p];
			int uy = aa[stack[p + 1]] - aa[stack[p]];
			while (true) {
				int vx = stack[q + 1] - stack[q];
				int vy = aa[stack[q + 1]] - aa[stack[q]];
				if (cross(ux, uy, vx, vy) >= 0)
					break;
				q = (q + 1) % cnt;
			}
			ans = Math.min(ans, weakness(stack[p], stack[q], (double) uy / ux));
		}
		println(ans);
	}
}
