import java.util.Scanner;

public class ChessThree {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), i, x = 1, y = 2, z = 3, t = -1;
		for (i = 0; i < n; i++) {

			int a = in.nextInt();
			if (a == x) {
				t = y;
				y = z;
				z = t;
			} else if (a == y) {
				t = x;
				x = z;
				z = t;
			} else {
				System.out.println("NO");
				return;
			}
		}
		in.close();
		System.out.println("YES");
	}
}
