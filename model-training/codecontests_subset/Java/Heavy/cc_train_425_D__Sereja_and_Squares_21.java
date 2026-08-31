import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;

public class CF243_SerejaSquares {

	public static void main(String[] args) {

		CF243_SerejaSquares me = new CF243_SerejaSquares();
		me.run();

	}

	public void run() {

		Scanner in = new Scanner(System.in);

		int nPts = in.nextInt();

		HashSet<Point> ptSet = new HashSet<Point>();
		HashMap<Integer, ArrayList<Point>> xLists = new HashMap<Integer, ArrayList<Point>>();
		HashMap<Integer, ArrayList<Point>> yLists = new HashMap<Integer, ArrayList<Point>>();

		for (int i = 0; i < nPts; i++) {
			int x = in.nextInt();
			int y = in.nextInt();

			Point newP = new Point(x, y);
			ptSet.add(newP);

			if (xLists.containsKey(y)) {
				xLists.get(y).add(newP);
			} else {
				ArrayList<Point> list = new ArrayList<Point>();
				list.add(newP);
				xLists.put(y, list);
			}

			if (yLists.containsKey(x)) {
				yLists.get(x).add(newP);
			} else {
				ArrayList<Point> list = new ArrayList<Point>();
				list.add(newP);
				yLists.put(x, list);
			}
		}

		// Sort all of the lists
		Comparator<Point> cX = new Comparator<Point>() {
			public int compare(Point arg0, Point arg1) {
				return Integer.compare(arg0.x, arg1.x);
			}
		};
		for (Entry<Integer, ArrayList<Point>> e : xLists.entrySet()) {
			Collections.sort(e.getValue(), cX);
		}
		
		Comparator<Point> cY = new Comparator<Point>() {
			public int compare(Point arg0, Point arg1) {
				return Integer.compare(arg0.y, arg1.y);
			}
		};
		for (Entry<Integer, ArrayList<Point>> e : yLists.entrySet()) {
			Collections.sort(e.getValue(), cY);
		}

		// Count the squares
		long squares = 0;
		for (Entry<Integer, ArrayList<Point>> e : xLists.entrySet()) {
			ArrayList<Point> list = e.getValue();

			for (int i = 0; i < list.size(); i++) {

				Point p = list.get(i);

				if (list.size() - i < yLists.get(p.x).size() - 1) {
					// Search along this list
					for (int j = i + 1; j < list.size(); j++) {
						Point o = list.get(j);
						int d = o.x - p.x;
						if (ptSet.contains(new Point(p.x, p.y + d)) && ptSet.contains(new Point(p.x + d, p.y + d))) {
							squares++;
						}
					}
				} else {
					// Search along the y list
					ArrayList<Point> yList = yLists.get(p.x);
					for (int j = yList.indexOf(p) + 1; j < yList.size(); j++) {
						Point o = yList.get(j);
						int d = o.y - p.y;
						if (ptSet.contains(new Point(p.x + d, p.y)) && ptSet.contains(new Point(p.x + d, p.y + d))) {
							squares++;
						}
					}
				}
			}
		}

		System.out.println(squares);

	}

	public class Point {
		int x, y, hash;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
			hash = x ^ y * 10007700;
		}

		@Override
		public int hashCode() {
			return hash;
		}

		@Override
		public boolean equals(Object other) {

			if (!(other instanceof Point)) {
				return false;
			}

			Point o = (Point) other;
			return x == o.x && y == o.y;

		}

	}

}
