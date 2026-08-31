import java.io.PrintWriter;
import java.util.*;

public class palin {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		PrintWriter cout = new PrintWriter(System.out);
		int r1 = scan.nextInt(), r2 = scan.nextInt(), c1 = scan.nextInt(), c2 = scan
				.nextInt(), d1 = scan.nextInt(), d2 = scan.nextInt(), a, b, c, d;
		for (int i = 1; i < 10; i++) {
			a = i;
			b = r1 - a;
			c = c1 - a;
			d = r2 - c;
			if (b > 0 && c > 0 && d > 0 && b < 10 && c < 10 && d < 10 && a != b
					&& a != c && a != d && b != c && b != d && c != d
					&& c2 == b + d && d1 == a + d && d2 == b + c) {
				System.out.println(a + " " + b);
				System.out.println(c + " " + d);
				return;
			}
		}

		System.out.println("-1");

		cout.flush();
	}
}