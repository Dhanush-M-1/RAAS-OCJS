import java.text.DecimalFormat;
import java.util.Scanner;

public class Codeforces {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double a = Double.valueOf(scanner.next());
		double b = Double.valueOf(scanner.next());
		double c = Double.valueOf(scanner.next());

		p20b(a, b, c);

		scanner.close();
	}

	private static void p20b(double a, double b, double c) {
		if (a != 0) {

			double d = b * b - 4 * a * c;
			if (d < 0) {
				System.out.println(0);
			} else {
				double d2 = Math.sqrt(d);
				double d1m = -b - d2;
				double d1p = -b + d2;
				DecimalFormat df = new DecimalFormat("#.#####");
				if (d1m == d1p) {
					System.out.println("1");
					System.out.println(df.format(d1m / (2 * a)));
				} else {
					System.out.println("2");
					double d1ma = d1m / (2 * a);
					double d1pa = d1p / (2 * a);
					if (d1ma < d1pa) {
						System.out.println(df.format(d1ma));
						System.out.println(df.format(d1pa));
					} else {
						System.out.println(df.format(d1pa));
						System.out.println(df.format(d1ma));
					}
				}
			}
		} else if (b != 0) {
			System.out.println("1");
			System.out.println(-c / b);
		} else if (c != 0) {
			System.out.println(0);
		} else {
			System.out.println(-1);
		}
	}}