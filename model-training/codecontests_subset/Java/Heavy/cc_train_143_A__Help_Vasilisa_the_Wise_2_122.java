import java.util.Scanner;

public class P143A_HelpVasilisaTheWise2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int r1 = scanner.nextInt();
		int r2 = scanner.nextInt();
		int c1 = scanner.nextInt();
		int c2 = scanner.nextInt();
		int d1 = scanner.nextInt();
		int d2 = scanner.nextInt();
		scanner.close();

		int a, b, c, d;

		for (a = 1; a < 10; a++) {
			b = r1 - a;
			c = c1 - a;
			d = r2 - c;

			if (b > 0 && b < 10 && c > 0 && c < 10 && d > 0 && d < 10) {
				if (a != b && a != c && a != d && b != c && b != d && c != d) {
					if (b + d == c2 && a + d == d1 && b + c == d2) {
						System.out.println(a + " " + b);
						System.out.println(c + " " + d);
						return;
					}
				}
			}

		}

		System.out.println(-1);
	}
}
