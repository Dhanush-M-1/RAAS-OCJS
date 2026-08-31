import java.util.Scanner;

public class fadiAndLCM {
	static long gcd(long i, long j) {
		if (i == 0)
			return j;
		if (j == 0)
			return i;
		if (i > j)
			return gcd(i % j, j);
		else
			return gcd(i, j % i);
	}

	static long lcm(long i, long j) {
		return (i / gcd(i, j)) * j;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
//		for (int x = 2; x <= 100; x++) {
		long minAns = Long.MAX_VALUE;
		long maxAns = 0;
		for (long i = 1; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				long j = x / i;
				if (x % j == 0) {
					long temp = Long.max(i, j);
					if (lcm(i, j) == x && minAns > temp) {
						minAns = temp;
						maxAns = Long.min(i, j);
					}
				}
			}
		}
//			if (minAns * maxAns != x)
		System.out.println(maxAns + " " + minAns);
		sc.close();
	}
}
