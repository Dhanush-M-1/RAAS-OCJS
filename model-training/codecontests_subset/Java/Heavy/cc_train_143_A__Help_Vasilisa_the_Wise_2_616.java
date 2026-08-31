import java.util.Scanner;
public class HelpVasilisaTheWise2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r1 = sc.nextInt();
		int r2 = sc.nextInt();
		int c1 = sc.nextInt();
		int c2 = sc.nextInt();
		int d1 = sc.nextInt();
		int d2 = sc.nextInt();
		sc.close();
		int a, b, c, d;
		for (int i = 1; i < Math.min(10, Math.min(r1, Math.min(c1, d1))); i++) {
			a = i;
			b = r1 - a;
			c = c1 - a;
			d = d1 - a;
			if (c + d == r2 && b + d == c2 && b + c == d2 && a != b && a != c && a != d
					&& b != c && b != d && c != d && b < 10 && c < 10 && d < 10) {
				System.out.printf("%d %d%n%d %d", a, b, c, d);
				System.exit(0);
			}
		}
		System.out.println(-1);
	}
}