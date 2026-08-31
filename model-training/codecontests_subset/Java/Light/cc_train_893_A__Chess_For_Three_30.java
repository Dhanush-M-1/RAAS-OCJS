import java.util.*;
import java.io.*;
import java.lang.*;

public class A {
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(new File("A.txt"));
		Scanner sc = new Scanner(System.in);

		int nTests = sc.nextInt();

		boolean possible = true;
		int spectator = 3;
		for (int i=0; i < nTests; i++) {
			int winner = sc.nextInt();
			
			if (spectator == winner) {
				possible = false;
				break;
			}

			if (winner == 1) {
				if (spectator == 3) {
					spectator = 2;
				} else if (spectator == 2) {
					spectator = 3;
				}
			} else if (winner == 2) {
				if (spectator == 1) {
					spectator = 3;
				} else if (spectator == 3) {
					spectator = 1;
				}
			} else if (winner == 3) {
				if (spectator == 2) {
					spectator = 1;
				} else if (spectator == 1) {
					spectator = 2;
				}
			}
		}

		System.out.println((possible) ? "YES" : "NO");
	}
}