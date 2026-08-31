

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Task {
	void run() {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int x0 = in.nextInt();
		int y0 = in.nextInt();
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		int n = in.nextInt();
		int[] r = new int[n];
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			r[i] = in.nextInt();
			a[i] = in.nextInt();
			b[i] = in.nextInt();
		}
		int moves = findShortestPath(n, r, a, b, x0, y0, x1, y1);
		out.println(moves);
		out.close();
		in.close();
	}
	
	class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			return x * 15013 + y;
		}

		@Override
		public boolean equals(Object o) {
			if (o == null) {
				return false;
			}
			Point p = (Point) o;
			if (p == null) {
				return false;
			}
			return p.x == x && p.y == y;
		}
	}

	static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

	class PathPoint {

		Point point;
		int distance;

		PathPoint(Point point, int distance) {
			this.point = point;
			this.distance = distance;
		}
	}

	int findShortestPath(int n, int[] r, int[] a, int[] b, int x0, int y0, int x1, int y1) {
		Map<Point, Boolean> points = new HashMap<>();
		Point p0 = new Point(x0, y0);
		Point p1 = new Point(x1, y1);
		points.put(p0, false);
		points.put(p1, false);
		for (int i = 0; i < n; i++) {
			for (int y = a[i]; y <= b[i]; y++) {
				Point p = new Point(r[i], y);
				points.put(p, false);
			}
		}
		Queue<PathPoint> q = new LinkedList<>();
		q.add(new PathPoint(p0, 0));
		points.put(p0, true);
		boolean found = false;
		int distance = -1;
		while (!q.isEmpty()) {
			PathPoint p = q.poll();
			for (int[] d : directions) {
				Point p2 = new Point(p.point.x + d[0], p.point.y + d[1]);
				Boolean visited = points.get(p2);
				if (visited != null && visited.equals(false)) {
					if (p2.equals(p1)) {
						found = true;
						distance = p.distance + 1;
						break;
					}
					q.add(new PathPoint(p2, p.distance + 1));
					points.put(p2, true);
				}
			}
			if (found) {
				break;
			}
		}
		return distance;
	}

	
	public static void main(String[] args) {
		new Task().run();
	}
}
