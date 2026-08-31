import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		boolean[][] card = new boolean[4][13];
		int m = 0;
		int r = 0;
		String mark;

		for (int i = 0; i < n; i++) {
			mark = sc.next();
			if (mark.equals("S")) {
				m = 0;
			} else if (mark.equals("H")) {
				m = 1;
			} else if (mark.equals("C")) {
				m = 2;
			} else if (mark.equals("D")) {
				m = 3;
			}

			r = sc.nextInt() - 1;

			card[m][r] = true;
		}

		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 13; i++) {
				if (!card[j][i]) {
					switch (j) {
					case 0:
						System.out.print("S ");
						break;
					case 1:
						System.out.print("H ");
						break;
					case 2:
						System.out.print("C ");
						break;
					case 3:
						System.out.print("D ");
						break;
					default:
						break;
					}
					System.out.println(i + 1);
				}

			}
		}

	}
}
