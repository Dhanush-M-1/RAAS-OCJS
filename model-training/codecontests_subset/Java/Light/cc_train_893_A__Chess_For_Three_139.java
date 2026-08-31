import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sol {
	private static int N;
	private static int currentA, currentB, spectator;
	private static boolean valid = true;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(f.readLine());
		currentA = 1;
		currentB = 2;
		spectator = 3;
		for (int i = 0; i < N; i++) {
			int winner = Integer.parseInt(f.readLine());
			if (winner == spectator) {
				valid = false;
				break;
			}
			currentA = winner;
			currentB = spectator;
			spectator = left(winner, spectator);
		}
		if (valid)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	public static int left(int winner, int spectator) {
		return 6 - winner - spectator;
	}
}