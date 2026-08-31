import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[m];
		int[] d = new int[m];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}

		for (int i = 0; i < m; i++) {
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}


		for (int i = 0; i < n; i++) {
			int minDist = Integer.MAX_VALUE;
			int num = 0;
			for (int j = 0; j < m; j++) {

				int tmpDist = Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]);
				if (minDist > tmpDist || tmpDist == 0) {
					minDist = tmpDist;
					num = j;
				}
			}
			System.out.println(num + 1);
			}

	}
}