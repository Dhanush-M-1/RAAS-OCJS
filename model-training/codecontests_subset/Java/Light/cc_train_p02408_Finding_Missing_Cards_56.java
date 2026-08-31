import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Integer n = sc.nextInt();

		List<String> card = new ArrayList<>();

		for (Integer i = 0; i < n; i++) {
			String mark = sc.next();
			Integer number = sc.nextInt();

			card.add(mark + number);
		}

		// S H C D
		String[] markList = { "S", "H", "C", "D" };

		// 1 to 13
		for (Integer i = 0; i < 4; i++) {
			for (Integer j = 1; j < 14; j++) {
				if (!card.contains(markList[i] + j)) {
					System.out.println(markList[i] + " " + j);
				}

			}
		}

	}
}
