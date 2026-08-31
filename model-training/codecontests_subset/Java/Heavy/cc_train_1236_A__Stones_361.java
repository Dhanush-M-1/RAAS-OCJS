
import java.util.Arrays;

import java.util.Scanner;

public class Exp290421 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			Fun(a, b, c);
		}

	}

	public static void Fun(int a, int b, int c) {
		int ans = 0;
		if (c >= 2) {

			int count = Math.min(b, c / 2);
			c = c - 2 * count;
			b = b - count;
			ans += (2 * count) + count;
		}
		if (b >= 2) {
			int count = Math.min(a, b / 2);
			b = b - 2 * count;
			a = a - count;
			ans += (2 * count) + count;
		}
		System.out.println(ans);
	}

}
