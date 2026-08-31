import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class chess4three {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		boolean possible = true;
		boolean alex = true;
		boolean bob = true;
		boolean carl = false;
		for (int i = 0; i < n; i++) {
			int winner = Integer.parseInt(reader.readLine());
			if ((winner == 1 && !alex) || (winner == 2 && !bob) || (winner == 3 && !carl)) {
				possible = false;
				break;
			}
			if (winner == 1) {
				if (bob) {
					bob = false;
					carl = true;
				} else {
					carl = false;
					bob = true;
				}

			} else if (winner == 2) {
				if (carl) {
					carl = false;
					alex = true;
				} else {
					alex = false;
					carl = true;
				}
			} else {
				if (alex) {
					alex = false;
					bob = true;
				} else {
					bob = false;
					alex = true;
				}
			}
		}
		System.out.println(possible ? "YES" : "NO");
	}
}
