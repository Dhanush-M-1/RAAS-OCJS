import java.util.Scanner;


public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		boolean[][] deck = new boolean[4][];
		String sootS[] = {"S", "H", "C", "D"};
		for (int i = 0; i < 4; i++) {
			deck[i] = new boolean[13];
		}
		for (int i = 0; i < n; i++) {
			String soot = scan.next();
			int rank = scan.nextInt();
			deck[sootNumber(soot)][rank - 1] = true;
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				if (deck[i][j] == false) {
					System.out.println(sootS[i] + " " + (j + 1));
				}
			}
		}
	}
	int sootNumber(String soot) {
		if (soot.equals("S")) {
			return 0;
		} else if (soot.equals("H")) {
			return 1;
		} else if (soot.equals("C")) {
			return 2;
		} else if (soot.equals("D")) {
			return 3;
		} else {
			return -1;
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}