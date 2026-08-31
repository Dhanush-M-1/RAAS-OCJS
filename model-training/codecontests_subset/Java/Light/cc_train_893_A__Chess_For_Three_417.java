
import java.io.*;
import java.util.*;

public class App {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int spectator = 3;
		int n = in.nextInt();
		int winner = 0;
		for(int i = 0; i < n; i++) {
			winner = in.nextInt();
			if (winner == spectator) {
				System.out.print("NO");
				return;
			}
			spectator = 6 - winner - spectator;
		}
		System.out.print("YES");
	}
}