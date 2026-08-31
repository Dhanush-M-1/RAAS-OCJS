import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean num[][] = new boolean[4][13];

		for (int i = 0; i < n; i++) {
			String tempSuit = sc.next();
			int tempNum = sc.nextInt();
			if (tempSuit.equals("S")) {
				num[0][tempNum - 1] = true;
			} else if (tempSuit.equals("H")) {
				num[1][tempNum - 1] = true;
			} else if (tempSuit.equals("C")) {
				num[2][tempNum - 1] = true;
			} else if (tempSuit.equals("D")) {
				num[3][tempNum - 1] = true;
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				if (i == 0 && !num[i][j]) {
					System.out.println("S " + (j + 1));
				} else if (i == 1 && !num[i][j]) {
					System.out.println("H " + (j + 1));
				} else if (i == 2 && !num[i][j]) {
					System.out.println("C " + (j + 1));
				} else if (i == 3 && !num[i][j]) {
					System.out.println("D " + (j + 1));
				}
			}
		}
	}

}