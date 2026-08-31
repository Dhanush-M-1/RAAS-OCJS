import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 

		int n = sc.nextInt();
		boolean[][] cards = new boolean[4][13];
		char[] suit_tb = new char[] {'S', 'H', 'C', 'D'};
		
		for (int i = 0; i < n; i++) {
			char suit = sc.next().toCharArray()[0];
			int rank = sc.nextInt();
			int suit_index;
			switch (suit) {
			case 'S':
				suit_index = 0;
				break;
			case 'H':
				suit_index = 1;
				break;
			case 'C':
				suit_index = 2;
				break;
			case 'D':
				suit_index = 3;
				break;
			default:
				suit_index = -1;
				break;
			}
			cards[suit_index][rank - 1] = true;
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				if (!cards[i][j]) {
					System.out.println(suit_tb[i] + " " + (j + 1));
				}
			}
		}
		
		sc.close();
	}
}