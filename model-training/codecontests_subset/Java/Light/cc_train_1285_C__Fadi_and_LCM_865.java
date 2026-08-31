import java.util.*;
public class LCM {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		long n = in.nextLong();
		long min = Long.MAX_VALUE;
		long minA = Long.MAX_VALUE;
		long minB = Long.MAX_VALUE;

		for (long i = (int)Math.sqrt(n); i > 0; i--) {
			long a = i;
			long b = 0;
			if (n % a == 0) {
				b = n/a;
				if (min > Math.max(a, b) && isLCM(a, b, n)) {
					min = Math.max(a, b);
					minA = a;
					minB = b;
				}
			}
			else {
				b = 0;
			}
		}
		long x = Math.min(minA, minB);
		long y = Math.max(minA, minB);

		System.out.println(x + " " + y);
	}

	public static long gcd(long a, long b) {
		while (b > 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	public static boolean isLCM(long a, long b, long lcm) {
		return (a*b / gcd(a, b) == lcm);
		
	}
}