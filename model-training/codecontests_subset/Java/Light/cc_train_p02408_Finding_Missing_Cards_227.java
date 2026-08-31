import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();
		boolean[][] list = new boolean[4][13];

		for (int i = 0; i < length; i++) {
			String pattern = scanner.next();
			int number = scanner.nextInt();

			if (pattern.equals("S"))
				list[0][number - 1] = true;
			else if (pattern.equals("H"))
				list[1][number - 1] = true;
			else if (pattern.equals("C"))
				list[2][number - 1] = true;
			else if (pattern.equals("D"))
				list[3][number - 1] = true;
		}

		for (int i = 0; i < 4; i++) {
			for (int i2 = 0; i2 < 13; i2++) {
				if (list[i][i2] != true) {
					if (i == 0)
						System.out.print("S");
					else if (i == 1)
						System.out.print("H");
					else if (i == 2)
						System.out.print("C");
					else if (i == 3)
						System.out.print("D");

					System.out.println(" " + (i2 + 1));
				}

			}
		}
	}
}