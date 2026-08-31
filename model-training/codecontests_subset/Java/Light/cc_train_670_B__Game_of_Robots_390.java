//package set_670;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt(), k = input.nextInt();
		double d = (Math.floor((-1 + Math.sqrt(1 + 8 * (double) k)) / 2));
		if (k > d * (d + 1) / 2) {
			d = k - d * (d + 1) / 2;
		}
		for (int i = 0; i < n; i++) {
			if (i + 1 == d) {
				System.out.println(input.nextInt());
				break;
			} else {
				input.nextInt();
			}
		}
		input.close();
	}

}
