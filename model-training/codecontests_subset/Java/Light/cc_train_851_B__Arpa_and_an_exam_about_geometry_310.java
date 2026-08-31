import java.util.*;

public class b {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long ax = in.nextLong();
		long ay = in.nextLong();
		long bx = in.nextLong();
		long by = in.nextLong();
		long cx = in.nextLong();
		long cy = in.nextLong();
		long dx1 = bx - ax, dy1 = by - ay;
		long dx2 = cx - bx, dy2 = cy - by;
		long d1 = dx1 * dx1 + dy1 * dy1;
		long d2 = dx2 * dx2 + dy2 * dy2;
		long cross = dx1 * dy2 - dy1 * dx2;
		System.out.println(d1 == d2 && cross != 0 ? "Yes" : "No");
	}
}