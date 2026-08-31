import java.util.Scanner;

public class C_236C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long p = 1, cnt = 0;
		for (long i = Math.max(p, n-6); i <= n; i++) {
			for (long j = Math.max(p, n-6); j <= n; j++) {
				long sum = i*j/gcd(i,j);
				for (long k = Math.max(p, n-6); k <= n; k++) {
					long sum1 = sum * k / gcd(sum,k);
					cnt = Math.max(cnt, sum1);
				}
			}
		}
		System.out.println(cnt);
	}

	private static long gcd(long i, long j) {
		return j == 0 ? i : gcd(j,i%j);
	}
}
