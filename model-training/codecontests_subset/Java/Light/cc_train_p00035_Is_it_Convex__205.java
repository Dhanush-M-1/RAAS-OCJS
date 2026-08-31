
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		StringBuilder builder = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.isEmpty()) {
				break;
			}
			StringTokenizer tokenizer = new StringTokenizer(line, ",");
			double[] x = new double[4];
			double[] y = new double[4];
			for (int i = 0; i < 4; i++) {
				x[i] = java.lang.Double.parseDouble(tokenizer.nextToken());
				y[i] = java.lang.Double.parseDouble(tokenizer.nextToken());
			}
			Point2D.Double a = new Point2D.Double(x[0], y[0]);
			Point2D.Double b = new Point2D.Double(x[1], y[1]);
			Point2D.Double c = new Point2D.Double(x[2], y[2]);
			Point2D.Double d = new Point2D.Double(x[3], y[3]);

			if (isTrue(a, b, c, d) || isTrue(a, b, d, c) || isTrue(a, d, c, b)
					|| isTrue(d, b, c, a)) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}

	public static boolean isTrue(Point2D.Double a, Point2D.Double b,
			Point2D.Double c, Point2D.Double d) {
		Path2D.Double sank = new Path2D.Double();
		sank.moveTo(a.getX(), a.getY());
		sank.lineTo(b.getX(), b.getY());
		sank.lineTo(c.getX(), c.getY());
		if (sank.contains(d))
			return true;
		else
			return false;
	}
}