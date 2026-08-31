import java.util.Scanner;

public class Equation {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long A = scan.nextInt();
		long B = scan.nextInt();
		long C = scan.nextInt();
		if (A == 0 && B == 0 && C == 0)
			System.out.printf("-1");
		else if (A == 0 && B == 0)
			System.out.println("0");
		else if (A == 0) {
			System.out.printf("1\n%.10f", -(double) C / (double) B);

		} else {
			long delta = (long) Math.pow(B, 2) - 4 * A * C;
			if (delta < 0)
				System.out.println("0");
			else if (delta == 0) {
				System.out.printf("1\n%.10f", (double) -B / (2 * A));
			} else {
				double x1 = -B - Math.sqrt(delta);
				x1 /= 2 * A;
				double x2 = -B + Math.sqrt(delta);
				x2 /= 2 * A;
				System.out.printf("2\n%.10f\n%.10f", Math.min(x1, x2), Math.max(x1, x2));
			}
		}
		scan.close();

	}
}
