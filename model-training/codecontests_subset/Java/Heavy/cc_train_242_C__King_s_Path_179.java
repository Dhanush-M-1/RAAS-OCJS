import java.util.Scanner;
import java.util.Set;
import java.util.Queue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.awt.Point;

public class C242 {
	static Map<Integer, List<Point>> seg;
	static Set<Point> vi;
	static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };

	private static int bfs(Point start, Point end) {
		Queue<Point> q = new LinkedList<>();
		int res = 0;
		q.add(start);

		while (!q.isEmpty()) {
			Queue<Point> nextPts = new LinkedList<>();
			while (!q.isEmpty()) {

				Point curr = q.poll();
				vi.add(curr);
				if (curr.equals(end))
					return res;

				for (int i = 0; i < dx.length; i++) {
					int x = curr.x + dx[i];
					int y = curr.y + dy[i];
					Point tmp = new Point(x, y);
					if (isValid(tmp)) {
						vi.add(tmp);
						nextPts.add(tmp);
					}
				}
			}
			res++;
			q = nextPts;
		}

		return -1;
	}

	private static boolean isValid(Point tmp) {
		if (!vi.contains(tmp) && seg.containsKey(tmp.x)) {
			for (Point p : seg.get(tmp.x)) {
				if (tmp.y >= p.x && tmp.y <= p.y)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		int tx = sc.nextInt();
		int ty = sc.nextInt();

		seg = new HashMap<>();
		vi = new HashSet<>();
		Point start = new Point(x, y);
		Point end = new Point(tx, ty);
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			int r = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			Point p = new Point(a, b);
			if (seg.containsKey(r)) {
				seg.get(r).add(p);
			} else {
				List<Point> lst = new ArrayList<>();
				lst.add(p);
				seg.put(r, lst);
			}

		}
		sc.close();
		int res = bfs(start, end);
		System.out.println(res);
	}
}