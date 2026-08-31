import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		if (a != 0) {
			double data = b * b - 4 * a * c;
			if (data > 0) {
				System.out.println(2);
				double x1 = (-b + Math.sqrt(data)) / (2 * a);
				double x2 = (-b - Math.sqrt(data)) / (2 * a);
				if (x1 < x2) {
					System.out.printf("%.5f\n", x1);
					System.out.printf("%.5f", x2);
				} else {
					System.out.printf("%.5f\n", x2);
					System.out.printf("%.5f", x1);
				}
			} else if (data == 0) {
				System.out.println(1);
				System.out.printf("%.5f", -b / (2 * a));
			} else {
				System.out.println(0);
			}
		} else if (b != 0) {
			System.out.println(1);
			double x = -c / b;
			System.out.printf("%.5f", x);
		} else {
			if (c == 0)
				System.out.println(-1);
			else
				System.out.println(0);
		}
	}
}
