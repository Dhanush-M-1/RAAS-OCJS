import java.util.Scanner;

public class C {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int r1 = in.nextInt(), r2 = in.nextInt(), c1 = in.nextInt(), c2 = in
				.nextInt(), d1 = in.nextInt(), d2 = in.nextInt();

		for (int i = 1; i <= 9; i++)
			for (int j = 1; j <= 9; j++)
				for (int k = 1; k <= 9; k++)
					for (int t = 1; t <= 9; t++) {
						if (i == j || i == k || i == t || j == k || j == t
								|| k == t)
							continue;
						if (i + j == r1 && k + t == r2 && i + k == c1
								&& j + t == c2 && i + t == d1 && j + k == d2) {
							System.out.println(i + " " + j);
							System.out.println(k + " " + t);
							return;
						}
					}

		System.out.println("-1");

	}
}