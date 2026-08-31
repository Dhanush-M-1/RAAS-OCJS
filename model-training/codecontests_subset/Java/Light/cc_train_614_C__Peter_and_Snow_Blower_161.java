import java.io.PrintStream;
import java.util.Scanner;


public class C {

	private static final Scanner in = new Scanner(System.in);
	private static final PrintStream out = System.out;
	
	private static double sqr(double x) {
		return x*x;
	}
	
	public static void main(String[] args) {
		int n = in.nextInt();
		double x = in.nextDouble();
		double y = in.nextDouble();
		double min = Double.MAX_VALUE;
		double max = -1;
		double[] xs = new double[n + 1];
		double[] ys = new double[n + 1];
		for (int i = 0; i < n; ++i) {
			xs[i] = in.nextDouble();
			ys[i] = in.nextDouble();
		}
		xs[n] = xs[0];
		ys[n] = ys[0];
		for (int i = 0; i < n; ++i) {
			// handle max
			double d = sqr(xs[i] - x) + sqr(ys[i] - y);
			max = Math.max(max, d);
			// handle min
			double l = 0;
			double r = 1;
			while (true) {
				double a = l + (r - l)/3 + Math.random()*(r - l)/100;
				double xa = xs[i] + a*(xs[i + 1] - xs[i]);
				double ya = ys[i] + a*(ys[i + 1] - ys[i]);
				double aDist = sqr(xa - x) + sqr(ya - y);
				double b = r - (r - l)/3 + Math.random()*(r - l)/100;
				double xb = xs[i] + b*(xs[i + 1] - xs[i]);
				double yb = ys[i] + b*(ys[i + 1] - ys[i]);
				double bDist = sqr(xb - x) + sqr(yb - y);
				if (aDist < bDist)
					r = b;
				else
					l = a;
				if (Math.abs(aDist - bDist) < 1e-10) {
					min = Math.min(min, (aDist + bDist)/2);
					break;
				}
			}
		}
		double ans = Math.PI*(max - min);
		out.println(ans);
	}

}
