import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] cards = new boolean[4][13];
		char[] suit = {'S', 'H', 'C', 'D'};
		int n = sc.nextInt();
		for (int i=0; i < n; i++) {
			char c = sc.next().charAt(0);
			int num = Integer.parseInt(sc.next());
			switch (c) {
			case 'S': cards[0][num-1] = true; break;
			case 'H': cards[1][num-1] = true; break;
			case 'C': cards[2][num-1] = true; break;
			case 'D': cards[3][num-1] = true; break;
			}
		}
		sc.close();
		for (int i=0; i < 4; i++) {
			for (int j=0; j < 13; j++) {
				if (!cards[i][j]) System.out.println(suit[i] + " " + (j + 1));
			}
		}
	}
}