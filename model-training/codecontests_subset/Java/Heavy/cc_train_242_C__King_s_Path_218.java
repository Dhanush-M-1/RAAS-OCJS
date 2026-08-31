import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class KingsPath {

	public static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
			
		}
		@Override
		public boolean equals(Object obj) {
			Point p = (Point) obj;
			return this.x == p.x && this.y == p.y;
		}
		@Override
		public int hashCode() {
			return this.x * 997 + this.y;
		}
	}
	public static class State {
		int x;
		int y;
		int moves;
		public State(int x, int y, int moves) {
			this.x = x;
			this.y = y;
			this.moves = moves;
		}
	}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int startX = stdIn.nextInt();
		int startY = stdIn.nextInt();
		int endX = stdIn.nextInt();
		int endY = stdIn.nextInt();
		int N = stdIn.nextInt();
		int ans = Integer.MAX_VALUE;
		HashSet<Point> points = new HashSet<Point>();
		for (int i = 0; i < N; i++) {
			int r = stdIn.nextInt();
			int s = stdIn.nextInt();
			int e = stdIn.nextInt();
			for (int j = s; j <= e; j++) {
				points.add(new Point(r, j));
			}
		}
		Queue<State> queue = new LinkedList<State>();
		
		queue.add(new State(startX, startY, 0));
		HashSet<Point> visited = new HashSet<Point>();
		visited.add(new Point(startX, startY));
		
		
		while (!queue.isEmpty()) {
			State currentState = queue.poll();
			int currentX = currentState.x;
			int currentY = currentState.y;
			int currentMoves = currentState.moves;
			
			if (currentX == endX && currentY == endY) {
				ans = Math.min(ans, currentMoves);
				break;
			}
			for (int dx = -1; dx <= 1; dx++) {
				for (int dy = -1; dy <= 1; dy++) {
					if (points.contains(new Point(currentX + dx, currentY + dy))) {
						if (!visited.contains(new Point((currentX + dx) , currentY + dy))) {
							visited.add(new Point((currentX + dx) , currentY + dy));
							queue.add(new State(currentX + dx, currentY + dy, currentMoves + 1));
						}
					}
				}
			}
			
			
			
		}
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
		stdIn.close();
	}
}
