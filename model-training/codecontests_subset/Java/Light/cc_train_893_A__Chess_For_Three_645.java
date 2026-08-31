import java.util.Scanner;

public class ChessForThree {
	public static void main(String[] args) {
		Scanner jin = new Scanner(System.in);

		int N = Integer.parseInt(jin.nextLine());
		int spectator = 3;

		for (int i = 0; i < N; ++i) {
			int curr = Integer.parseInt(jin.nextLine());
			if (curr == spectator) {
				System.out.println("NO");
				return;
			}
			if ((curr == 1 && spectator == 2) || (curr == 2 && spectator == 1)) {
				spectator = 3;
				continue;
			}
			if ((curr == 1 && spectator == 3) || (curr == 3 && spectator == 1)) {
				spectator = 2;
				continue;
			}
			if ((curr == 2 && spectator == 3) || (curr == 3 && spectator == 2)) {
				spectator = 1;
				continue;
			}
		}
		jin.close();
		System.out.println("YES");
	}
}