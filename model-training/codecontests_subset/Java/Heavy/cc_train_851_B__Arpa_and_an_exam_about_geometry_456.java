import java.util.Scanner;

public final class Main {

	public static long distSq(int x1, int y1, int x2, int y2) {
		long a = (x2 - x1);
		long b = (y2 - y1);
		// System.out.println(a * a + " " + b * b);
		return a * a + b * b;
	}

	public static boolean isLine(long x1, long y1, long x2, long y2, long x3, long y3) {
		return (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) == 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ax = sc.nextInt();
		int ay = sc.nextInt();
		int bx = sc.nextInt();
		int by = sc.nextInt();
		int cx = sc.nextInt();
		int cy = sc.nextInt();
		sc.close();

		// System.out.println(distSq(ax, ay, bx, by));
		// System.out.println(distSq(bx, by, cx, cy));

		if (distSq(ax, ay, bx, by) != distSq(bx, by, cx, cy) || isLine(ax, ay, bx, by, cx, cy)) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
	}
}