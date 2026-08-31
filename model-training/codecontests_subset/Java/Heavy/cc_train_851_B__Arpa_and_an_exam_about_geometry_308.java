import java.util.Scanner;

public class B851GeometryTest {

	public static class mPoint {
		public long x, y;
		public mPoint(long a, long b) {
			x = a;
			y = b;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		mPoint a = new mPoint(in.nextLong(), in.nextLong());
		mPoint b = new mPoint(in.nextLong(), in.nextLong());
		mPoint c = new mPoint(in.nextLong(), in.nextLong());
		
		if (a.x - b.x == 0 && b.x - c.x == 0) {
			System.out.println("No");
		} else if (a.x - b.x == 0 || b.x - c.x == 0) {
			if (equidis(a, b, c)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		} else if ((b.y - c.y) * (a.x - b.x) == (a.y - b.y) * (b.x - c.x)) {
			System.out.println("No");
		} else if (equidis(a, b, c)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
	}	
	
	public static boolean equidis(mPoint a, mPoint b, mPoint c) {
		return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y) ==
			   (b.x - c.x) * (b.x - c.x) + (b.y - c.y) * (b.y - c.y);
	}
}
