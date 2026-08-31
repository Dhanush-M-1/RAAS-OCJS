import java.util.*;
import java.lang.*;
import java.io.*;

public class C {
	public static void main (String[] args) throws java.lang.Exception {
		new Solution();
	}
}
class Solution {
	Scanner scanner;
	public Solution() {
		scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			// int T = Integer.parseInt(scanner.nextLine());

			// for (int i=0; i<T; i++) {
				run_case();
			// }
		}
	}

	private void run_case() {
		long n = Long.parseLong(scanner.nextLine());

		long cur_min = n;

		// System.out.println();
		for (long cur = 1; cur * cur <= n; cur ++) {
			if (n % cur == 0) {
				long a = cur;
				long b = n / cur;
				if (gcd(a, b) == 1) {
					cur_min = Math.min(cur_min, b);
				}
				// System.out.println(a + " " + b);
			}
		}
		System.out.println(cur_min + " " + n / cur_min);
	}

	private long gcd(long a, long b) {
	    if (b == 0) return a;
	    else return gcd(b, a%b);
	}

}
