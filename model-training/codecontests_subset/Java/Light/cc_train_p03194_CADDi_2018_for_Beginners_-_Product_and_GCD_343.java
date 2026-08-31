import java.util.Scanner;

public class Main {
	static boolean[] isPrime;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long P = sc.nextLong();
		sc.close();
		if(N == 1) {
			System.out.println(P);
			System.exit(0);
		}
		long ans = 1;
		long t = (long)Math.pow(P, (double)1 / N) + 1;
		for(long k = 2; k <= t; k++) {
			long s = (long)Math.pow(k, N);
			if(P % s == 0) {
				ans = k;
			}
		}
		System.out.println(ans);
	}
}
