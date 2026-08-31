import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] a = new int[N + 1];
		int[] b = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		int[] c = new int[M + 1];
		int[] d = new int[M + 1];

		for (int i = 1; i <= M; i++) {
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			long dis = Long.MAX_VALUE;
			int minPos = 0;
			for (int j = 1; j <= M; j++) {
				if (dis > Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j])) {
					dis = Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]);
					minPos = j;
				}
				;
			}
			System.out.println(minPos);
		}

	}
}
