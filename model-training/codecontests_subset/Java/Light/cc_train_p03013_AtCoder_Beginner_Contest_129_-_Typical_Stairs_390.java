import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int M = 1000000007;
		long[] a = new long[n + 1];
		for (int i = 0; i < m; i++) {
			a[sc.nextInt()] = -1;
		}

		a[0] = 1;
		a[1] = a[1] == -1 ? -1 : 1;
		for (int i = 2; i <= n; i++) {
			if (a[i] == -1) continue;
			long steps = 0;
			if (a[i - 1] != -1) steps = (steps + a[i - 1]) % M;
			if (a[i - 2] != -1) steps = (steps + a[i - 2]) % M;
			a[i] = steps;
		}

		System.out.println(a[n]);
	}
}
