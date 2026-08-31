import java.io.*;
import java.util.*;


public class Main {

	private static Scanner sc;
	private static Printer pr;

	private static void solve() {
		int n = sc.nextInt();

		int[][][] f = new int[n][5][2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 2; k++) {
					f[i][j][k] = sc.nextInt();
				}
			}
		}

		int[][] p = new int[n][11];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 11; j++) {
				p[i][j] = sc.nextInt();
			}
		}

		long max = Long.MIN_VALUE;
		for (int i = 1; i < 0x1 << 10; i++) {
			int[] cnt = new int[n];
			for (int j = 0; j < 10; j++) {
				if ((i & 0x1 << j) != 0) {
					int d = j / 2;
					int ampm = j % 2;

					for (int k = 0; k < n; k++) {
						if (f[k][d][ampm] == 1) {
							cnt[k]++;
						}
					}
				}
			}

			long tmp = 0;
			for (int j = 0; j < n; j++) {
				tmp += p[j][cnt[j]];
			}

			max = Math.max(max, tmp);
		}

		pr.println(max);
	}

	// ---------------------------------------------------
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		pr = new Printer(System.out);

		solve();

		pr.close();
		sc.close();
	}

	private static class Printer extends PrintWriter {
		Printer(PrintStream out) {
			super(out);
		}
	}
}
