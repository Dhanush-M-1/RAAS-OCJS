import java.util.Scanner;

public class p1374B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			long n = sc.nextLong();
			int c = 0, d = 0;
			while (n % 2 == 0) {
				n /= 2;
				++c;
			}
			while (n % 3 == 0) {
				n /= 3;
				++d;
			}
			if (n == 1 && c <= d) {
				System.out.println(2 * d - c);
			} else
				System.out.println("-1");
		}
	}
}
