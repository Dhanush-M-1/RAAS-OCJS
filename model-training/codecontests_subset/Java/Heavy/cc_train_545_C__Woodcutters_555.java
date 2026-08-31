import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WoodCutters {
	static Point[] a;
	static int n;
	static int[][] dp = new int[100000 + 5][2];

	static int f(int i, int prev) {

		if (i == n)
			return 0;
		if (dp[i][prev] != -1)
			return dp[i][prev];
		int ret = f(i + 1, 0);
		if (i == 0 || (prev == 0 && a[i - 1].x < a[i].x - a[i].y)
				|| (prev == 1 && a[i - 1].x + a[i - 1].y < a[i].x - a[i].y))
			ret = Math.max(ret, 1 + f(i + 1, 0));
		if (i == n - 1 || a[i + 1].x - a[i].x > a[i].y) {
			ret = Math.max(ret, 1 + f(i + 1, 1));
		}
		return dp[i][prev] = ret;

	}

	public static void main(String[] args) throws IOException {
		skp();
		n = nextInt();
		a = new Point[n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}

		for (int i = 0; i < n; i++) {
			skp();
			a[i] = new Point(nextInt(), nextInt());
		}
		System.out.println(f(0, 0));

	}

	static boolean skp() throws IOException {
		String line = r.readLine();
		if (line == null)
			return false;
		tkn = new StringTokenizer(line);
		return true;
	}

	static int nextInt() {
		return Integer.parseInt(tkn.nextToken());
	}

	static int readInt() throws NumberFormatException, IOException {
		return Integer.parseInt(r.readLine());
	}

	static long nextLong() {
		return Long.parseLong(tkn.nextToken());
	}

	static long readLong() throws NumberFormatException, IOException {
		return Long.parseLong(r.readLine());
	}

	static double nextDouble() {

		return Double.parseDouble(tkn.nextToken());
	}

	static BufferedReader r = new BufferedReader(new InputStreamReader(
			System.in));
	static StringTokenizer tkn;

}
