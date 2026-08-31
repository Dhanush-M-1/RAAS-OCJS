import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			boolean[][] cards = new boolean[128][14];
			int N = sc.nextInt();
			for(int i = 0; i < N; i++) {
				String c = sc.next();
				int n = sc.nextInt();
				cards[c.charAt(0)][n] = true;
			}
			for(char c: new char[]{'S', 'H', 'C', 'D'}) {
				for(int n = 1; n <= 13; n++){
					if(!cards[c][n]) {
						System.out.printf("%s %d\n", c, n);
					}
				}
			}
	 	}
	}
}

