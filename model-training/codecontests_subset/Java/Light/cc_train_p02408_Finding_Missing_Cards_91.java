import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		ArrayList<String> deck = new ArrayList<String>();
		String suit;
		int p = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 14; j++) {
				if (i == 0) {
					suit = "S";
				} else if (i == 1) {
					suit = "H";
				} else if (i == 2) {
					suit = "C";
				} else {
					suit = "D";
				}
				deck.add(suit + " " + Integer.toString(j));
			}
		}
		for (int i = 0; i <= num; i++) {
			String test = scan.nextLine();
			for (int q = 0; q < deck.size(); q++) {
				if (deck.get(q).equals(test)) {
					deck.remove(q);
				}
			}
		}
		for (int q = 0; q < deck.size(); q++) {
			System.out.println(deck.get(q));
		}
	}
}
