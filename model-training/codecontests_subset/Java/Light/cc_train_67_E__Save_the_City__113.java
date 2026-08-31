// practice with rainboy
import java.io.*;
import java.util.*;

public class CF67E extends PrintWriter {
	CF67E() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF67E o = new CF67E(); o.main(); o.flush();
	}

	int[] xx, yy;
	long cross2(long x1, long y1, long x2, long y2) {
		return x1 * y2 - x2 * y1;
	}
	long cross(int i, int j, int k) {
		return cross2(xx[j] - xx[i], yy[j] - yy[i], xx[k] - xx[i], yy[k] - yy[i]);
	}
	void main() {
		int n = sc.nextInt();
		xx = new int[n];
		yy = new int[n];
		for (int i = 0; i < n; i++) {
			xx[i] = sc.nextInt();
			yy[i] = sc.nextInt();
		}
		boolean flip = xx[0] < xx[1];
		int x = xx[1], y = yy[1];
		for (int i = 0; i < n; i++) {
			xx[i] -= x;
			yy[i] -= y;
			if (flip) {
				xx[i] = -xx[i];
				yy[i] = -yy[i];
			}
		}
		int l = 0, r = xx[0];
		for (int i = 2; i + 1 < n; i++) {
			long cr = cross(i, i + 1, 0);
			long cl = cross(i, i + 1, 1);
			if (cr > 0 && cl > 0) {
				println(0);
				return;
			}
			int x0 = xx[i], y0 = yy[i], x1 = xx[i + 1], y1 = yy[i + 1];
			if (cr > 0 || cl > 0) {
				long p = (long) x0 * (y1 - y0) - (long) y0 * (x1 - x0);
				long q = y1 - y0;
				if (q < 0) {
					p = -p; q = -q;
				}
				if (cr > 0)
					r = Math.min(r, (int) (p / q));
				else
					l = Math.max(l, (int) ((p + q - 1) / q));
			}
		}
		println(l <= r ? r - l + 1 : 0);
	}
}
