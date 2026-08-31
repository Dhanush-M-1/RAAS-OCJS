import java.util.*;

public class Main {

	public static long digitdp(int digit, String n, int k) {
		long ans = 0;
		long dp[][][] = new long[digit + 1][2][k + 1];
		dp[0][0][0] = 1;
		for (int i = 0; i < digit; ++i) {
			final int num = (int) (n.charAt(i) - '0');
			for (int smaller = 0; smaller < 2; ++smaller) {
				for (int j = 0; j < k + 1; ++j) {
					for (int x = 0; x <= (smaller == 1 ? 9 : num); ++x) {
						if (x != 0 && j == k)
							continue;
						int small = (smaller == 1 ? 1 : (x < num ? 1 : 0));
						int l = j + (x == 0 ? 0 : 1);
						dp[i + 1][small][l] += dp[i][smaller][j];
					}
				}
			}
		}
		ans = dp[digit][0][k] + dp[digit][1][k];
		return ans;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int k = sc.nextInt();
		int digit = n.length();
		sc.close();
		long ans = digitdp(digit, n, k);
		System.out.println(ans);
	}
}
