import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();
		
		Map<Character, boolean[]> cardsMap = new HashMap<>();
		cardsMap.put('S', new boolean[13]);
		cardsMap.put('H', new boolean[13]);
		cardsMap.put('C', new boolean[13]);
		cardsMap.put('D', new boolean[13]);

		for (int i = 0; i < n; i++) {
			String input[] = sc.nextLine().split(" ");
			char mark = input[0].charAt(0);
			int num = Integer.parseInt(input[1]);

			cardsMap.get(mark)[num - 1] = true;
		}
		sc.close();

		char[] marks = { 'S', 'H', 'C', 'D' };
		for (char mark : marks) {
			boolean[] cards = cardsMap.get(mark);
			for (int i = 0; i < 13; i++) {

				if (!cards[i])
					System.out.println(mark + " " + (i + 1));

			}
		}
	}
}