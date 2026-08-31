
import java.util.Scanner;

public class HelpVasilisaTheWise2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r1 = sc.nextInt(), r2 = sc.nextInt();
		int c1 = sc.nextInt(), c2 = sc.nextInt();
		int d1 = sc.nextInt(), d2 = sc.nextInt();
		for (int a = 1; a <= 9; a++)
			for (int b = 1; b <= 9; b++)
				if (a != b)
					for (int c = 1; c <= 9; c++)
						if (c != b && c != a)
							for (int d = 1; d <= 9; d++)
								if (d != a && d != b && d != c)
									if (a + b == r1 && c + d == r2 && a + c == c1 && b + d == c2 && a + d == d1
											&& b + c == d2) {
										System.out.printf("%d %d\n%d %d\n", a, b, c, d);
										return;
									}
		System.out.println(-1);
	}

}
