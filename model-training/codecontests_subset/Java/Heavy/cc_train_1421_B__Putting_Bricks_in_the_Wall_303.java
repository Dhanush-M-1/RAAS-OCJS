import java.util.Scanner;

public class _B_ {

	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);

		m: for (int tt = in.nextInt(); tt > 0; tt--) {
			final int n = in.nextInt();
			final char[][] map = new char[n][];
			for (int y = 0; y < n; y++) {
				map[y] = in.next().toCharArray();
			}

			if (map[0][1] == map[1][0]) {
				final boolean b1 = map[n - 1][n - 2] == map[0][1];
				final boolean b2 = map[n - 2][n - 1] == map[0][1];
				if (b1 && b2) {
					System.out.println("2");
					System.out.println("1 2");
					System.out.println("2 1");
				} else if (b1) {
					System.out.println("1");
					System.out.println(n + " " + (n - 1));
				} else if (b2) {
					System.out.println("1");
					System.out.println((n - 1) + " " + n);
				} else {
					System.out.println("0");
				}
			} else if (map[n - 1][n - 2] == map[n - 2][n - 1]) {
				final boolean b1 = map[n - 1][n - 2] == map[0][1];
				final boolean b2 = map[n - 1][n - 2] == map[1][0];
				if (b1 && b2) {
					System.out.println("2");
					System.out.println("1 2");
					System.out.println("2 1");
				} else if (b1) {
					System.out.println("1");
					System.out.println(1 + " " + 2);
				} else if (b2) {
					System.out.println("1");
					System.out.println(2 + " " + 1);
				} else {
					System.out.println("0");
				}
			} else {
				System.out.println("2");
				if (map[0][1] == '0')
					System.out.println("1 2");
				if (map[1][0] == '0')
					System.out.println("2 1");
				if (map[n - 1][n - 2] == '1')
					System.out.println(n + " " + (n - 1));
				if (map[n - 2][n - 1] == '1')
					System.out.println((n - 1) + " " + n);
			}

		}

	}
}