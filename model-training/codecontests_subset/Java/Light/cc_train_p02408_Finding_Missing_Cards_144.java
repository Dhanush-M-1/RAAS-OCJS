import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[][] cards = new int[4][13];

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			String k = sc.next();

			int rank = sc.nextInt();

			if (k.equals("S")) {

				cards[0][rank - 1] = 1;

			} else if (k.equals("H")) {

				cards[1][rank - 1] = 1;

			} else if (k.equals("C")) {

				cards[2][rank - 1] = 1;

			} else if (k.equals("D")) {

				cards[3][rank - 1] = 1;

			}

		}

		for (int a = 0; a < 4; ++a) {

			for (int j = 0; j < 13; j++) {

				if (cards[a][j] == 0 && a == 0) {

					System.out.println("S " + (j + 1));

				} else if (cards[a][j] == 0 && a == 1) {

					System.out.println("H " + (j + 1));

				} else if (cards[a][j] == 0 && a == 2) {

					System.out.println("C " + (j + 1));

				} else if (cards[a][j] == 0 && a == 3) {

					System.out.println("D " + (j + 1));

				}

			}

		}
	}

}