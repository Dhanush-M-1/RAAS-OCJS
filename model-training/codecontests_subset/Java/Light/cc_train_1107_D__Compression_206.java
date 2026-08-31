import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class D {
	public static void main(String args[]) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintStream out = new PrintStream(new BufferedOutputStream(System.out));

		int N = in.nextInt();
		boolean[][] map = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String s = in.next();
			for (int j = 0; j < s.length(); j++) {
				int n = Integer.parseInt("" + s.charAt(j), 16);
				for (int k = 0; k < 4; k++) {
					map[i][4 * j + (4 - 1 - k)] = (n & (1 << k)) != 0;
				}
			}
		}

		int[][] lp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				lp[i][j] = lp[i - 1][j] + lp[i][j - 1] - lp[i - 1][j - 1];
				lp[i][j] += map[i - 1][j - 1] ? 1 : 0;
			}
		}

		int ans = 1;
		for (int i = 1; i <= N; i++) {
			if (isAns(i, lp)) ans = i;
		}

		out.println(ans);

		in.close();
		out.close();
	}

	public static boolean isAns(int x, int[][] lp) {
		int n = lp.length - 1;

		if (n % x != 0) return false;
		for (int i = 0; i < n / x; i++) {
			for (int j = 0; j < n / x; j++) {
				if ((lp[x * (i + 1)][x * (j + 1)] - lp[i * x][j * x]) % (x * x) != 0) {
					return false;
				}
			}
		}
		return true;
	}
}
