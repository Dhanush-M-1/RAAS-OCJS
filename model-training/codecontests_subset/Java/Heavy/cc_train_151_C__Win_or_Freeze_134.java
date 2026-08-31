import java.util.*;

public class C {
	static boolean[] v = new boolean[10000010];

	public static void sieve() {
		int r = v.length, i, j;
		v[1] = true;
		v[0] = true;
		for (j = 2; 2 * j < r; j++)
			v[2 * j] = true;
		for (i = 3; (j = i * i) < r; i += 2)
			if (!v[i])
				for (; j < r; j += i + i)
					v[j] = true;
	}

	public static boolean isPrime(long r) {
		if (r == 1)
			return false;
		if (r % 2 == 0 && r != 2)
			return false;
		if (r < v.length)
			return !v[(int) r];
		for (int i = 3; i < v.length && i * i <= r; i += 2)
			if (!v[i] && r % i == 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long q = in.nextLong();
		sieve();
		if (q == 0) {
			System.out.println(1);
			System.out.println(0);
		} else if (q == 1) {
			System.out.println(1);
			System.out.println(0);
		} else if (isPrime(q)) {
			System.out.println(1);
			System.out.println(0);
		} else {
			long qq = q;
			int cnt = 0;
			long win = 1;

			for (int i = 2; i * i <= q; i++) {
				if (q % i == 0 && !v[i]) {
					win *= i;
					cnt++;
					q /= i;
					while (q % i == 0) {
						if (cnt == 2) {
							if (win == qq) {
								System.out.println(2);
							} else {
								System.out.println(1);
								System.out.println(win);
							}
							System.exit(0);
						}
						q /= i;
						cnt++;
						win *= i;
					}
					if (cnt == 2) {
						if (win == qq) {
							System.out.println(2);
						} else {
							System.out.println(1);
							System.out.println(win);
						}
						System.exit(0);
					}
					if (isPrime(q)) {
						win *= q;
						cnt++;
						q = 1;
					}
					if (cnt == 2) {
						if (win == qq) {
							System.out.println(2);
						} else {
							System.out.println(1);
							System.out.println(win);
						}
						System.exit(0);
					}
				}

			}
		}
	}
}