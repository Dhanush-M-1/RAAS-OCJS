import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO ?????????????????????????????????????????????
		
		Scanner sc = new Scanner(System.in);
		String line1 = sc.nextLine();
		int n = Integer.parseInt(line1);
		
		String[] cards = new String[n];
		for (int i = 0; i < cards.length; i++) {
			String c = sc.nextLine();
			cards[i] = c;
		}
		
		String[] suit = {"S","H","C","D"};
		
		for (int i = 0; i < 4; i++) {
			for (int j = 1 ; j <= 13; j++) {
				StringBuilder card = new StringBuilder();
				card.append(suit[i]);
				card.append(" ");
				String js = String.valueOf(j);
				card.append(js);
				String str = card.toString();
				if (Arrays.asList(cards).contains(str)) {
					continue;
				}
				System.out.println(card);
			}
		}
	}

}