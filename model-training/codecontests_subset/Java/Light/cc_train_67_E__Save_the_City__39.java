import java.util.Scanner;

public class CF67E {
	static int[] x, y;
	
	static long cross(int i, int j, int k) {
		long x1=x[j] - x[i];
		long x2=x[k] - x[i];
		long y1=y[j] - y[i];
		long y2=y[k] - y[i];
		return x1 * y2 - x2 * y1;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		x = new int[n];
		y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		
		boolean flip = x[0] < x[1];
		int X = x[1], Y = y[1];
		for (int i = 0; i < n; i++) {
			x[i] -= X;
			y[i] -= Y;
			if (flip) {
				x[i] = -x[i];
				y[i] = -y[i];
			}
		}
		
		int l = 0, r = x[0];
		for (int i = 2; i + 1 < n; i++) {
			long cr = cross(i, i + 1, 0);
			long cl = cross(i, i + 1, 1);
			if (cr > 0 && cl > 0) {
				System.out.println(0);
				return;
			}
			int x0 = x[i], y0 = y[i], x1 = x[i + 1], y1 = y[i + 1];
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
		System.out.println(l <= r ? r - l + 1 : 0);
		
	}	
}

