import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class C {
	static class N {
		int ind, n;

		N(int i, int in) {
			ind = i;
			n = in;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		LinkedList<Point> prev = new LinkedList<>();
		StringBuffer sb = new StringBuffer();
		int a, b, c;
		String l[];
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			a = Integer.parseInt(l[0]);
			c = Integer.parseInt(l[1]);
			b = a + c - 1;
			boolean good = true;
			for (Point p : prev) {
				if (!(p.x > b || p.y < a))
					good = false;
			}
			if (!good) {
				int pp = 1;
				for (Point p : prev) {
					if (p.x - pp >= c) {
						a = pp;
						b = a + c - 1;
						break;
					}
					pp = p.y + 1;
					a = pp;
					b = a + c - 1;
				}
			}
			sb.append(a + " " + b + "\n");
			prev.add(new Point(a, b));
			Collections.sort(prev, new Comparator<Point>() {
				public int compare(Point p1, Point p2) {
					return Integer.compare(p1.x, p2.x);
				}
			});
		}
		System.out.print(sb);
	}
}