import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Boolean[][] cards = new Boolean[4][14];
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards[0].length; j++) {
				cards[i][j]=false;
			}
		}
		String[] suits = {"S","H","C","D"};
		int n = scanner.nextInt();
		for(int i=0;i<n;i++) {
			int tem = 0;
			String rank = scanner.next();
			int num = scanner.nextInt();
			switch (rank) {
			case "S":
				tem = 0;
				break;
			case "H":
				tem = 1;
				break;
			case "C":
				tem = 2;
				break;
			case "D":
				tem = 3;
				break;
			default:
				break;
			}
			cards[tem][num]=true;
		}
		for(int i=0;i<4;i++) {
			for(int j=1;j<=13;j++) {
				if (cards[i][j]!=true) {
					System.out.println(suits[i] + " " + j);
				}
			}
		}
		scanner.close();
	}
}
