import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner((System.in));
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] a = new int[N + 1];
		int[] b = new int[N + 1];
		int[] c = new int[M + 1];
		int[] d = new int[M + 1];
		int[] ans = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		for (int i = 1; i <= M; i++) {
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		
		for (int i = 1; i <= N; i++) {
			int dif = Math.abs(a[i] - c[1]) + Math.abs(b[i] - d[1]);
			ans[i] = 1;
			for (int j = 2; j <= M; j++) {
				if (dif > (Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]))) {
					ans[i] = j;
					dif = Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(ans[i]);
		}


		sc.close();
	}
}