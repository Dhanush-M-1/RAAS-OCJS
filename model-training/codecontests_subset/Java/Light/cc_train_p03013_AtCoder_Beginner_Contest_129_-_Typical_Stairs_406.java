import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n + 1];
		
		for (int i = 0; i < m; i++) {
			a[sc.nextInt()]++;
		}
//		for (int i = 0; i <= n; i++) {
//			System.out.printf("a[%d]=%d\n", i, a[i]);
//		}
		
		long[] cmb = new long[n + 1];
		cmb[0] = 1;
		cmb[1] = a[1] ^ 1;
		
		final long mod = 1_000_000_007;
		for (int i = 2; i <= n; i++) {
			cmb[i] = (a[i] ^ 1) * (cmb[i - 2] + cmb[i - 1]) % mod;
		}
//		for (int i = 0; i <= n; i++) {
//			System.out.printf("cmb[%d]=%d\n", i, cmb[i]);
//		}
		System.out.println(cmb[n]);
	}
}
