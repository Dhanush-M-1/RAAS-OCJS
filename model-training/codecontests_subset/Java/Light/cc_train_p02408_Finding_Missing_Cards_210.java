import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] card = new int[4][13];
		String mark;
		int num;
		int i;

		//入力されたカード
		for (i = 0; i < n; i++) {
			mark = sc.next();
			num = sc.nextInt();
			switch (mark) {
			case "S":
				card[0][num - 1] = 1;
				break;
			case "H":
				card[1][num - 1] = 1;
				break;
			case "C":
				card[2][num - 1] = 1;
				break;
			case "D":
				card[3][num - 1] = 1;
				break;
			}
		}

		//ないカード
		for (num = 0; num <= 3; num++) {
			for (i = 0; i <= 12; i++) {
				if (card[num][i] == 0) {
					switch (num) {
					case 0:
						System.out.println("S " + (i+1));
						break;
					case 1:
						System.out.println("H " + (i+1));
						break;
					case 2:
						System.out.println("C " + (i+1));
						break;
					case 3:
						System.out.println("D " + (i+1));
						break;
					}
				}
			}
		}
	}

}
