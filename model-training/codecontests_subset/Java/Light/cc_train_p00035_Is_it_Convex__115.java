import java.awt.geom.Point2D;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter(",|\\s+");
		while (sc.hasNext()) {
			double[] xs = new double[4];
			double[] ys = new double[4];
			Point2D.Double[] ps = new Point2D.Double[4];
			for (int i = 0; i < 4; i++) {
				xs[i] = sc.nextDouble();
				ys[i] = sc.nextDouble();
				ps[i] = new Point2D.Double(xs[i], ys[i]);
			}
			Line[][] ls = new Line[4][2];
			for (int i = 0; i < 4; i++) {
				ls[i][0] = new Line(ps[i], ps[(i + 1) % 4]);
				ls[i][1] = new Line(ps[(i + 1) % 4], ps[i]);
			}
			boolean convex = false;
			double pro = 1;
			for (int i = 0; i < 4; i++) {
				pro *= ls[(i + 1) % 4][0].ep(ls[i][1]);
			}
			if (pro < 0) {
				convex = true;
			}
			System.out.println(convex ? "NO" : "YES");
		}
	}
}

class Line {
	public Point2D.Double p1;
	public Point2D.Double p2;

	Line(Point2D.Double p1, Point2D.Double p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public double length() {
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y)
				* (p1.y - p2.y));
	}

	public double ip(Line l) {
		Point2D.Double q1 = l.p1;
		Point2D.Double q2 = l.p2;
		return (p2.x - p1.x) * (q2.x - q1.x) + (p2.y - p1.y) * (q2.y - q1.y);
	}

	public double ep(Line l) {
		Point2D.Double q1 = l.p1;
		Point2D.Double q2 = l.p2;
		return (p2.x - p1.x) * (q2.y - q1.y) - (p2.y - p1.y) * (q2.x - q1.x);
	}

	public double disToPoint(Point2D.Double q1) {
		Line p1q1 = new Line(p1, q1);
		double ip1 = p1q1.ip(this);
		double ip2 = this.ip(this);
		if (ip1 <= 0)
			return p1q1.length();
		else if (0 < ip1 && ip1 < ip2) {
			double d2 = ip1 / this.length();
			double size = p1q1.length();
			return Math.sqrt(size * size - d2 * d2);
		} else {
			Line p2q1 = new Line(p2, q1);
			return p2q1.length();
		}
	}

	public boolean isCross(Line q1q2) {
		Point2D.Double q1 = q1q2.p1;
		Point2D.Double q2 = q1q2.p2;
		Line p1q1 = new Line(p1, q1);
		Line p1q2 = new Line(p1, q2);
		Line q1p1 = new Line(q1, p1);
		Line q1p2 = new Line(q1, p2);
		if (this.ep(p1q1) * this.ep(p1q2) < 0
				&& q1q2.ep(q1p1) * q1q2.ep(q1p2) < 0)
			return true;
		else
			return false;
	}

	public double minDistance(Line q1q2) {
		if (this.isCross(q1q2))
			return 0;
		double ans = Double.MAX_VALUE;
		Point2D.Double q1 = q1q2.p1;
		Point2D.Double q2 = q1q2.p2;
		ans = Math.min(ans, this.disToPoint(q1));
		ans = Math.min(ans, this.disToPoint(q2));
		ans = Math.min(ans, q1q2.disToPoint(p1));
		ans = Math.min(ans, q1q2.disToPoint(p2));
		return ans;
	}

	public String toString() {
		return p1 + "=>" + p2;
	}
}