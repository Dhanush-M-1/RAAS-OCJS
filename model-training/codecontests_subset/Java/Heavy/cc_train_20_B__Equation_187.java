import java.util.Scanner;

public class _20B {

	static Scanner scanner = new Scanner(System.in);
	static long A, B, C;

	public static void main(String[] args) {
		A = scanner.nextLong();
		B = scanner.nextLong();
		C = scanner.nextLong();
		if (A == 0) {
			if (B == 0) {
				if (C == 0) {
					System.out.println(-1);
				}
				else {
					System.out.println(0);
				}
			}
			else {
				System.out.println(1);
				System.out.println(String.format("%.10f", (-(double)C / (double)B)));
			}
		}
		else {
			long delta = B*B - 4*A*C;
			if (delta < 0) {
				System.out.println(0);
			}
			else if (delta == 0) {
				System.out.println(1);
				System.out.println(String.format("%.10f", (-(double)B / (double)(2*A))));
			}
			else {
				System.out.println(2);
				double sd = Math.sqrt(delta);
				double x1 = (-B - Math.sqrt(delta)) / (double)(2*A);
				double x2 = (-B + Math.sqrt(delta)) / (double)(2*A);
				if (x1 > x2) {
					double t = x1;
					x1 = x2;
					x2 = t;
				}
				System.out.println(String.format("%.10f\n%.10f", x1, x2));
			}
		}

	}

}
