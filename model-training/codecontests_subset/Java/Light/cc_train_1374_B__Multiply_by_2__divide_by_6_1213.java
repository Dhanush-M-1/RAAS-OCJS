import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		while (t-- > 0) {

			int n = scn.nextInt();

			int moves = 0;
			while (n != 1) {
				if (n % 6 == 0) {
					n /= 6;
					moves++;
				} else if (n % 3 == 0) {
					n *= 2;
					moves++;
				} else {
					moves = -1;
					break;
				}
			}

			System.out.println(moves);

		}
	}
}