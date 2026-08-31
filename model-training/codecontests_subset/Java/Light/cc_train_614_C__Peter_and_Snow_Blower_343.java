import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.util.*;

public class SnowBlower {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Line2D> seg = new ArrayList<Line2D>();
		int n = scan.nextInt();
		Point[] arr = new Point[n];
		Point P = new Point(scan.nextDouble(), scan.nextDouble());
		double R = -1;
		for(int i = 0; i < n; i++){
			Point Z = new Point(scan.nextDouble(), scan.nextDouble());
			arr[i] = Z;
			R = Math.max(R, P.dist(Z));
		}
		for(int i = 1; i < n; i++){
			seg.add(new Line2D.Double(arr[i-1].x, arr[i-1].y, arr[i].x, arr[i].y));
		}
		seg.add(new Line2D.Double(arr[n-1].x, arr[n-1].y, arr[0].x, arr[0].y));
		double r = Integer.MAX_VALUE;
		for(int i = 0; i < seg.size(); i++){
			Line2D.Double l = (Double) seg.get(i);
			r = Math.min(r, Line2D.ptSegDist(l.x1, l.y1, l.x2, l.y2, P.x, P.y));
		}
		System.out.println(Math.PI*(R*R-r*r));
	}
	
	
	static class Point{
		
		double x;
		double y;
		
		public Point(double p, double q){
			this.x = p;
			this.y = q;
		}
		
		double dist(Point a){
			return Math.sqrt((this.x-a.x)*(this.x-a.x)+(this.y-a.y)*(this.y-a.y));
		}
	}
}
