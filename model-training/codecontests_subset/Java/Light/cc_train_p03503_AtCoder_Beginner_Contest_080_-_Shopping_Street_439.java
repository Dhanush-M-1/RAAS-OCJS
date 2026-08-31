
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][][] F = new int[n][5][2];
		for (int i = 0; i < F.length; ++i) {
			for (int j = 0; j < F[i].length; ++j) {
				for (int k = 0; k < F[i][j].length; ++k) {
					F[i][j][k] = sc.nextInt();
				}
			}
		}
		long[][] p = new long[n][11];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < 11; ++j) {
				p[i][j] = sc.nextInt();
			}
		}

		long ret = -Long.MAX_VALUE / 3;
		for (int s = 1; s < 1 << 10; ++s) {
			int[] c = new int[n];
			for (int i = 0; i < 5; ++i) {
				for (int j = 0; j < 2; ++j) {
					if ((s >> (i + j * 5)) % 2 == 0) {
						continue;
					}
					for (int k = 0; k < n; ++k) {
						c[k] += F[k][i][j];
					}
				}
			}
			long tmp = 0;
			for (int i = 0; i < n; ++i) {
				tmp += p[i][c[i]];
			}
			ret = Math.max(ret, tmp);
		}
		System.out.println(ret);
	}

	static void tr(Object... objects) {
		System.out.println(Arrays.deepToString(objects));
	}

}
