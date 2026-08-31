import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		boolean[][] card = new boolean[4][13];
		for (int i = 0; i < n; ++i) {
			String s = scanner.next();
			int num = scanner.nextInt();
			card[s.equals("S") ? 0 : s.equals("H") ? 1 : s.equals("C") ? 2 : 3][num - 1] = true;
		}
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 13; ++j) {
				if (!card[i][j])
					System.out.printf("%s %d\n", i == 0 ? "S" : i == 1 ? "H" : i == 2 ? "C" : "D", j + 1);
			}
		}
	}
}

