import java.awt.geom.Line2D;
import java.util.Scanner;


public class CF_614C {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), px = scan.nextInt(), py = scan.nextInt();
		
		double minRadius = Double.MAX_VALUE;
		double maxRadius = -1;
		Point[] pts = new Point[n];
		for(int i=0;i<n;i++) {
			int x = scan.nextInt(), y = scan.nextInt();
			pts[i] = new Point(x-px,y-py);
		}
		Point last = pts[pts.length-1];
		for(int i=0;i<pts.length;i++) {
			double r = Line2D.ptSegDist(last.x, last.y, pts[i].x, pts[i].y, 0, 0);
			
			// System.err.println("Line between " + last + " and " + pts[i]);
			// System.err.println("=" + r);
			minRadius = Math.min(minRadius,r);
			maxRadius = Math.max(maxRadius,r);
			
			long dx = pts[i].x;
			long dy = pts[i].y;
			r = Math.sqrt(dx*dx+dy*dy);
			maxRadius = Math.max(maxRadius,r);
			minRadius = Math.min(minRadius,r);
			
			last = pts[i];
		}
		// System.err.println("min: " + minRadius);
		// System.err.println("max: " + maxRadius);
		System.out.println(Math.PI * (maxRadius * maxRadius -minRadius*minRadius));
	}
	static class Point {
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}