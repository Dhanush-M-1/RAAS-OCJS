import java.awt.geom.Point2D;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str[];
		Point2D.Double p[];
		boolean flag;

		p = new Point2D.Double[4];
		while (sc.hasNext()) {
			str = sc.next().split(",");
			flag = true;
			for (int i = 0; i < 4; i++) {
				p[i] = new Point2D.Double(Double.valueOf(str[2 * i]), Double.valueOf(str[2 * i + 1]));
			}

			for (int i = 0; i < 4; i++) {
				double k = 0.0;
				double a, b;
				if (p[i].x == p[(i + 1) % 4].x) {
					a = Double.POSITIVE_INFINITY;
					b = Double.NaN;
				} else {
					a = (p[(i + 1) % 4].y - p[i].y) / (p[(i + 1) % 4].x - p[i].x);
					b = p[i].y - a * p[i].x;
				}
				for (int j = 0; j < 4; j++) {
					if (j == i || j == (i + 1) % 4) {
						continue;
					}
					if (k == 0.0) {
						if (Double.isNaN(b)) {
							k = p[j].x - p[i].x;
						} else {
							k = p[j].y - (a * p[j].x + b);
						}
					} else {
						if (Double.isNaN(b)) {
							if ((p[j].x - p[i].x) * k < 0) {
								flag = false;
							}
						} else {
							if ((p[j].y - (a * p[j].x + b)) * k < 0) {
								flag = false;
							}
						}
					}
				}
			}
			if (flag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}