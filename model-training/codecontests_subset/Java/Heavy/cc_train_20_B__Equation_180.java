import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long b = sc.nextInt();
		long c = sc.nextInt();
		long d = b * b - 4 * a * c;
		if (a == 0 && b == 0 && c == 0)
			System.out.printf("-1\n");
		else if (a == 0 && b == 0) {
			System.out.printf("0\n");
		} else if (a == 0) {
			System.out.printf("1\n%.6f\n", -c * 1.0 / b);
		} else {
			if (d > 0) {
				double t = Math.sqrt(b * b * 1.0 - 4 * a * c);
				double x1 = (-b - t) / 2 / a, x2 = (-b + t) / 2 / a;
				if (x1 < x2)
					System.out.printf("2\n%.6f\n%.6f\n", x1, x2);
				else
					System.out.printf("2\n%.6f\n%.6f\n", x2, x1);
			} else if (d == 0) {
				System.out.printf("1\n%.6f\n", -b / 2.0 / a);
			} else
				System.out.printf("0\n");
		}
	}
}
  			 	  		 	 		 	       			