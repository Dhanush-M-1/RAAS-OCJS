import java.util.*;
import java.awt.Point;
import javafx.util.Pair;
import java.math.*;
public class Euler {
	
	static int[][] directions = {{1, -1}, {0, 1}, {1, 1}, {-1, 0}, {1, 0}, {-1, -1}, {0, -1}, {-1, 1}};
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		int x2 = in.nextInt();
		int y2 = in.nextInt();
		
		Map<Point, Integer> map = new HashMap<>();
		int n = in.nextInt();
		for (int i = 0;i < n; i++) {
			
			int r = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			for (int j = a; j <= b; j++) {
				
				Point p = new Point(r, j);
				map.put(p, 0);
				
			}
			
			
		}
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x1, y1));
		
		while (!q.isEmpty()) {
			
			Point poi = q.poll();
			
			for (int[] direction: directions) {
				
				int x = (int) poi.getX();
				x += direction[0];
				int y = (int) poi.getY();
				y += direction[1];
				Point pl = new Point(x, y);
				
				if (!map.containsKey(pl) || map.get(pl) != 0) continue;
				q.add(pl);
				int level = map.get(poi);
				map.put(pl, level + 1);
				if (x == x2 && y == y2) {
					System.out.println(level + 1);
					return;
				}
				
			}
			
		}
		System.out.println("-1");
		
		
    }
}
