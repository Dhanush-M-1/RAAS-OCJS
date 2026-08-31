
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] map = { { 0, 300, 500, 600, 700, 1350, 1650 },
				{ 6, 0, 350, 450, 600, 1150, 1500 },
				{ 13, 7, 0, 250, 400, 1000, 1350 },
				{ 18, 12, 5, 0, 250, 850, 1300 },
				{ 23, 17, 10, 5, 0, 600, 1150 },
				{ 43, 37, 30, 25, 20, 0, 500 }, { 58, 52, 45, 40, 35, 15, 0 } };
		while (true) {
			int n = scanner.nextInt() - 1;
			if (n == -1)
				break;
			int a = scanner.nextInt() * 100 + scanner.nextInt();
			int m = scanner.nextInt() - 1;
			int b = scanner.nextInt() * 100 + scanner.nextInt();
			int ans = map[n][m];
			if (map[m][n] <= 40) {
				if ((1730 <= a && a <= 1930) || (1730 <= b && b <= 1930)) {
					if (map[n][m] % 20 == 0) {
						ans = map[n][m] / 2;
					} else {
						ans = (map[n][m] - 50) / 2 + 50;
					}

				}
			}
			System.out.println(ans);
		}
	}
}