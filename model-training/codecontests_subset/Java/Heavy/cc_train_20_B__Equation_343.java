import java.util.Scanner;

public class Main {

	public static final double EPS = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long a = in.nextLong();
		long b = in.nextLong();
		long c = in.nextLong();
		if (a == 0) {
			if (b == 0) {
				if (c != 0) {
					System.out.println(0);
				} else {
					System.out.println(-1);
				}
			} else {
				System.out.println(1);
				System.out.println(-c * 1.0 / b);
			}
			return;
		}
		if (b * b - 4 * a * c < -EPS) {
			System.out.println(0);
		} else if (b * b - 4 * a * c > EPS) {
			System.out.println(2);
			double x1 = (-b - Math.sqrt(b * b - 4 * a * c)) / a / 2.0;
			double x2 = (-b + Math.sqrt(b * b - 4 * a * c)) / a / 2.0;
			if (x1 > x2) {
				double t = x1;
				x1 = x2;
				x2 = t;
			}
			System.out.println(x1 + "\n" + x2);
		} else {
			System.out.println(1);
			System.out.println(-b / a / 2.0);
		}
	}

}
