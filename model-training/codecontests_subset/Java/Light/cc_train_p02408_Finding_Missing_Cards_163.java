import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] cards = new int[4][13];
		for (int i = 0; i < n; i++) {
			String suit = sc.next();
			int rank = sc.nextInt();
			int sn = -1;
			switch (suit) {
				case "S": sn = 0; break;
				case "H": sn = 1; break;
				case "C": sn = 2; break;
				case "D": sn = 3; break;
			}
			cards[sn][rank - 1] = 1;
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				if (cards[i][j] == 0) {
					String suit = null;
					switch (i) {
						case 0: suit = "S"; break;
						case 1: suit = "H"; break;
						case 2: suit = "C"; break;
						case 3: suit = "D"; break;
					}
					System.out.printf("%s %d\n", suit, j + 1);
				}
			}
		}
	}
}
