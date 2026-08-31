import java.util.Scanner;

public class Main {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String[] suit = {"S", "H", "C", "D"};
		int[][] cards = new int[4][13];
		int n =Integer.parseInt(input());

		for (int i = 0; i < n; i++) {

			String pattern = input();
			int number = Integer.parseInt(input());

			for (int j = 0; j < cards.length; j++) {

				if (pattern.equals(suit[j])) {

					cards[j][number - 1] = number;

				}
			}
		}

		for (int k = 0; k < cards.length; k++) {

			for (int l = 0; l < cards[0].length; l++) {

				if (cards[k][l] == 0) {

					System.out.print(suit[k]);
					System.out.print(" ");
					System.out.println(l + 1);

				}
			}
		}

		close();

	}

	public static String input() {

		return scanner.next();

	}

	public static void close() {

		if (scanner != null) {

			scanner.close();

		}
	}
}