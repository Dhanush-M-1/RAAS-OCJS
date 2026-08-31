import java.awt.Point;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Point a = new Point(0, 0);
		a.x = s.nextInt();
		a.y = s.nextInt();
		Point b = new Point(0, 0);
		b.x = s.nextInt();
		b.y = s.nextInt();
		Point c = new Point(0, 0);
		c.x = s.nextInt();
		c.y = s.nextInt();
		s.close();
		if (isTreeangel(a, b, c)) {
			if (distance(a,b,c)) {
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		} else {
			System.out.println("No");
		}
	}

	private static boolean distance(Point a, Point b, Point c) {
		long ax,ay,bx,by,cx,cy;
		ax = a.x;
		ay = a.y;
		bx = b.x;
		by = b.y;
		cx = c.x;
		cy = c.y;
		long dis1 = (ax - bx)*(ax - bx) + (ay - by)*(ay - by);
		long dis2 = (cx - bx)*(cx - bx) + (cy - by)*(cy - by);
		if(dis1 == dis2)
			return true;
		return false;
	}

	private static boolean isTreeangel(Point a, Point b, Point c) {
		double m = 0;
		try {
			double x = (b.y - a.y); 
			m = (x)/(b.x - a.x);
		} catch (ArithmeticException e) {
			if((b.x - c.x) == 0){
				return false;
			}else{
				return true;
			}
		}
		Double d = new Double(m);
		if(d.isInfinite()){
			return false;
		}
		if((c.y - a.y) == (m*(c.x - a.x))){
			return false;
		}else{
			return true;
		}
	}
}
