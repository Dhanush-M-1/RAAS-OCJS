import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] f = new int[n][10];
		int[][] p = new int[n][11];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 10; j++) {
				f[i][j] = scanner.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 11; j++) {
				p[i][j] = scanner.nextInt();
			}
		}

		long max = -1000000000;
		long tmp = 0;
		for (int i = 1; i < Math.pow(2, 10); i++) {
			for (int k = 0; k < n; k++) {
				int count = 0;
				for (int j = 0; j < 10; j++) {
					if ((i >> j & 1) == 1 && f[k][j] == 1)
						count++;
				}
				tmp += p[k][count];
			}
			max = Math.max(max, tmp);
			tmp = 0;
		}

		System.out.println(max);
	}
}