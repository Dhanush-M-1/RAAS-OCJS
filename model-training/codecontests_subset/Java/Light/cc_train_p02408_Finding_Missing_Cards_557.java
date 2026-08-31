import java.util.HashMap;
import java.util.Scanner;

/**
 * Course ITP1 # 6 B
 *
 * Finding Missing Cards
 *
 * @author misago_jp
 */
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.next());
		boolean[][] cards = new boolean[4][13];
		Character[] its = new Character[]{'S', 'H', 'C', 'D'};
		HashMap<String, Integer> sti = new HashMap<String, Integer>();
		sti.put("S", 0);
		sti.put("H", 1);
		sti.put("C", 2);
		sti.put("D", 3);

		for (int i = 0; i < n; ++i) {
			cards[sti.get(s.next())][Integer.parseInt(s.next()) - 1] = true;
		}
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 13; ++j) {
				if (!cards[i][j]) {
					System.out.println(its[i] + " " + (j + 1));
				}
			}
		}
	}
}