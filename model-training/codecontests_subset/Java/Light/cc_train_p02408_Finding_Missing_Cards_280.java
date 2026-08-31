import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String[] suits = new String[] {"S", "H", "C", "D"};
		boolean[][] cards = new boolean[4][13];
		Scanner sc = new Scanner(System.in);
		String str;
		String[] strs = new String[2];
		int s = 0;

		int n = Integer.parseInt( sc.nextLine() );

		for (int i = 0; i < n; i++) {

			str = sc.nextLine();
			strs = str.split(" ");

			String suit = strs[0];
			int num = Integer.parseInt(strs[1]);

			switch(suit) {
				case "S":
					s = 0;
					break;
				case "H":
					s = 1;
					break;
				case "C":
					s = 2;
					break;
				case "D":
					s = 3;
					break;
				default:
					break;
			}

			cards[s][num - 1] = true;
		}



		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				if( cards[i][j] == false) {
					System.out.println(suits[i] + " " + (j+1));
				}
			}
		}

		sc.close();
	}


}
