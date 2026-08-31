
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	private static class Block {
		int row, c1, c2;

		Block(int row, int c1, int c2) {
			this.row = row;
			this.c1 = c1;
			this.c2 = c2;
		}

		/*
		 * boolean contains(Point p) { return p.x == row && p.y >= c1 && p.y <= c2; }
		 * 
		 * boolean overlaps(Block b) { return Math.abs(row - b.row) <= 1 && ((c1 >= b.c1
		 * - 1 && c1 <= b.c2 + 1) || (c2 >= b.c1 - 1 && c2 <= b.c2 + 1) || (b.c1 >= c1 -
		 * 1 && b.c1 <= c2 + 1) || (b.c2 >= c1 - 1 && b.c2 <= c2 + 1)); }
		 */
	}

	private static class Point {
		int x, y;
		int deep;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			return x + y * 100000;
		}

		@Override
		public boolean equals(Object obj) {
			return ((Point) obj).x == x && ((Point) obj).y == y;
		}
	}

	private static Point start, end;
	private static int blocksCount;
	private static HashMap<Point, Boolean> allowed = new HashMap<>();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		start = new Point(s.nextInt() - 1, s.nextInt() - 1);
		end = new Point(s.nextInt() - 1, s.nextInt() - 1);
		blocksCount = s.nextInt();
		for (int i = 0; i < blocksCount; i++) {
			Block b = new Block(s.nextInt() - 1, s.nextInt() - 1, s.nextInt() - 1);
//			if (blocks[i].contains(start)) {
//				kingsLocation = i;
//			}
			for (int j = b.c1; j <= b.c2; j++) {
				allowed.put(new Point(b.row, j), true);
			}
		}
		/*
		 * vis[kingsLocation] = true; int result = dfs(kingsLocation, start.y);
		 * System.out.println(result < Integer.MAX_VALUE / 3 ? result : -1);
		 * vis[kingsLocation] = false;
		 */
		if (Math.max(Math.abs(start.x - end.x), Math.abs(start.y - end.y)) > 100001) {
			System.out.println(-1);
		} else {
			System.out.println(bfs());
		}
	}

	private static boolean allowed(Point p) {
		if (p.x < 0 || p.y < 0)
			return false;
		return allowed.containsKey(p) && allowed.get(p);
	}

	private static int bfs() {

		int[] moveX = new int[] { 0, 0, 1, 1, 1, -1, -1, -1 };
		int[] moveY = new int[] { 1, -1, 1, -1, 0, -1, 1, 0 };
		Queue<Point> q = new LinkedList<>();
		q.add(start);

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.equals(end))
				return p.deep;

			for (int i = 0; i < moveY.length; i++) {
				Point newP = new Point(p.x + moveX[i], p.y + moveY[i]);
				newP.deep = p.deep + 1;
				if (allowed(newP)) {
					allowed.put(newP, false);
					q.add(newP);
				}
			}
		}

		return -1;
	}

	/*
	 * private static int dfs(int currentBlock, int col) { if
	 * (!blocks[currentBlock].contains(new Point(blocks[currentBlock].row, col))) {
	 * return Integer.MAX_VALUE / 2; } if (blocks[currentBlock].contains(end)) {
	 * return Math.abs(col - end.y); } int dist = Integer.MAX_VALUE / 2; for (int i
	 * = 0; i < blocksCount; i++) { if (!vis[i]) { if
	 * (blocks[currentBlock].overlaps(blocks[i])) { vis[i] = true; int rowMove =
	 * (blocks[currentBlock].row == blocks[i].row ? 0 : 1); dist = min(dist,
	 * Math.max(rowMove, Math.abs(blocks[i].c1 - col)) + dfs(i, blocks[i].c1),
	 * Math.max(rowMove, Math.abs(blocks[i].c2 - col)) + dfs(i, blocks[i].c2),
	 * rowMove + dfs(i, col)); vis[i] = false; } } } return dist; }
	 */
	/*
	 * private static int min(int... ints) { int min = Integer.MAX_VALUE; for (int i
	 * : ints) { min = Math.min(min, i); } return min; }
	 */

}
