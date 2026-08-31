import java.io.IOException;
import java.util.*;

class Point {
	double x;
	double y;
	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}

class Vec {
	Point a;
	Point b;
	Vec(Point a, Point b) {
		this.a = a;
		this.b = b;
	}
}

class MathUtil {
	/**
	 * ??????????±??????????
	 *     Q
	 *  ???/
	 *   /
	 *  C -------- P
	 *
	 * @param p
	 * @param c
	 * @param q
	 * @return >0: ???????????? <0:???????????? 0:Q,C,P????????´???????????????
	 */
	public static double outProd(Point c, Point p, Point q) {
		return (p.getX() - c.getX()) * (q.getY() - c.getY()) - (p.getY() - c.getY()) * (q.getX() - c.getX());
	}

	public static boolean isZero(long EPS, double val) {
		return Math.abs(val) <= EPS;
	}
}

/**
 */
class Main {
	final static int N = 10;

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String[] strArr = in.nextLine().split(",");
			double[] intArr = new double[strArr.length];
			for(int i=0;i<intArr.length;i++) {
				intArr[i] = Double.parseDouble(strArr[i]);
			}
			List<Point> points = new ArrayList<>();
			for(int i=0;i<intArr.length;i+=2) {
				double a = intArr[i];
				double b = intArr[i+1];
				points.add(new Point(a, b));
			}
			solve(points);
		}
	}

	public static void solve(List<Point> pts) {
		double prev = 0;
		int n =pts.size();
		for(int i=0;i<pts.size();i++) {
			double ret = MathUtil.outProd(pts.get(i%n), pts.get((i+1)%n), pts.get((i+2)%n));
			if(MathUtil.isZero((long)(1e-9), ret)) {
				continue;
			}
			if(ret * prev < 0) {
				System.out.println("NO");
				return;
			}
			prev = ret;
		}
		System.out.println("YES");
	}
}