import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);
	static String str;
	static int[][] ansM;
	static int n;

	public static void main(String[] args) {

		n = Integer.valueOf(in.nextLine());
		str = in.nextLine();
		ansM = new int[30][1510];
		for (int i = 0; i < 26; i++) {
			char ch = (char) ('a' + i);
			for (int j = 1; j <= n; j++) {
				solve(ch, j);
			}

		}

		int plan = in.nextInt();

		while (plan-- != 0) {
			int cnt = in.nextInt();
			char c = in.next().charAt(0);
			int output = ansM[c - 'a'][cnt];
			System.out.println(output);
		}

	}

	static void solve(char ch, int m) {
		int ans = 0, lo = 0, hi = 0;
		int cnt = 0;
		while (hi < n) {
			if (cnt <= m) {
				if (str.charAt(hi) != ch)
					cnt++;
				hi++;
			}
			if (cnt > m) {
				if (str.charAt(lo) != ch) {
					cnt--;
				}
				lo++;
			}
			ans = Math.max(hi - lo, ans);
		}
		ansM[ch - 'a'][m] = ans;

	}

	static void print() {
		// for (int i = 1; i <= n; i++) {
		// for (int j = 1; j <= n; j++) {
		// System.out.print(dp[i][j] + " ");
		// }
		// System.out.println();
		// }
	}
}
