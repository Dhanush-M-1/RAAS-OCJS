
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n, m;
		n = in.nextInt();
		m = in.nextInt();
		int two = 0, three = 0;
		if (n == m && n % 2 != 0) {
			System.out.println(n);
		} else {
			int l, r, ll, rr;
			if (n % 2 == 0) {
				l = n;
			} else {
				l = n + 1;
			}
			if (m % 2 == 0) {
				ll = m;
			} else {
				ll = m - 1;
			}
			two = (ll - l) / 2 + 1;
			if (n % 3 == 0) {
				r = n;
			} else {
				r = (n / 3 + 1) * 3;
			}
			if (m % 3 == 0) {
				rr = m;
			} else {
				rr = m / 3 * 3;
			}
			three = (rr - r) / 3 + 1;
			if (two >= three) {
				System.out.println("2");
			} else {
				System.out.println("3");
			}
		}
	}
}
