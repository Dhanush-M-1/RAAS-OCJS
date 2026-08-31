// practice with rainboy
import java.io.*;
import java.util.*;

public class CF613A extends PrintWriter {
	CF613A() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF613A o = new CF613A(); o.main(); o.flush();
	}

	long dot(long x1, long y1, long x2, long y2) {
		return x1 * x2 + y1 * y2;
	}
	long cross(long x1, long y1, long x2, long y2) {
		return x1 * y2 - x2 * y1;
	}
	void main() {
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int[] xx = new int[n];
		int[] yy = new int[n];
		for (int i = 0; i < n; i++) {
			xx[i] = sc.nextInt() - x;
			yy[i] = sc.nextInt() - y;
		}
		double d1 = 9e12, d2 = 0;
		for (int i = 0; i < n; i++) {
			int x_, y_;
			x = xx[i]; x_ = xx[(i + 1) % n];
			y = yy[i]; y_ = yy[(i + 1) % n];
			double d = Math.hypot(x, y);
			d2 = Math.max(d2, d);
			if (dot(x, y, x - x_, y - y_) >= 0 && dot(x_, y_, x_ - x, y_ - y) >= 0) {
				double d_ = Math.abs(cross(x, y, x_, y_)) / Math.hypot(x - x_, y - y_);
				d = Math.min(d, d_);
			}
			d1 = Math.min(d1, d);
		}
		println((d2 * d2 - d1 * d1) * Math.PI);
	}
}
