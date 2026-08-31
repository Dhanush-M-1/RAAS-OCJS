
// package contest615;

import java.util.Scanner;

public class Bulbs {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		boolean[] onBulbs = new boolean[m];
		for (int i = 0; i < m; i++) {
			onBulbs[i] = false;
		}
		for (int i = 0; i < n; i++) {
			int x = in.nextInt();
			for (int j = 0; j < x; j++) {
				onBulbs[in.nextInt() - 1] = true;
			}
		}
		in.close();
		for (boolean b : onBulbs) {
			if (!b) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

}
