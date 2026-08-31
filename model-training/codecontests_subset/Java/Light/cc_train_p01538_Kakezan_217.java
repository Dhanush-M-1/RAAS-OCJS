import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] arg) {
		int Q = sc.nextInt();
		for (int i = 0; i < Q; ++i) {
			System.out.println(solve(sc.nextInt()));
		}
	}

	static int solve(int n) {
		if (n < 10) return 0;
		int base = 10;
		int max = 0;
		while (base <= n) {
			int hi = n / base;
			int lw = n % base;
			base *= 10;
			max = Math.max(max, hi * lw);
		}
		return solve(max) + 1;
	}
}