import java.io.*;
import java.util.*;
import java.awt.geom.*;

public class Solution {

	public static void main(String args[]) {

		Scanner in;
		try {
			in = new Scanner(new File("input.txt"));
		} catch (Exception e) {
			in = new Scanner(System.in);
		}

		int n = in.nextInt();
		double x = in.nextDouble();
		double y = in.nextDouble();

		double[] xs = new double[n];
		double[] ys = new double[n];

		double minR = Double.MAX_VALUE;
		double maxR = Double.MIN_VALUE;

		for (int i = 0; i < n; ++i) {
			xs[i] = in.nextDouble();
			ys[i] = in.nextDouble();
		}

		for (int i = 0; i < n; ++i) {
				minR = Math.min(minR, Line2D.ptSegDistSq(xs[i], ys[i], xs[(i + 1) % n], ys[(i + 1) % n], x, y));
				maxR = Math.max(maxR, findR(x, y, xs[i], ys[i]));
		}

		System.out.println((maxR - minR) * Math.PI);
	}

	public static double findR(double x1, double y1, double x2, double y2) {
		double xx = (x1 - x2) * (x1 - x2);
		double yy = (y1 - y2) * (y1 - y2);
		return xx + yy;
	}
}