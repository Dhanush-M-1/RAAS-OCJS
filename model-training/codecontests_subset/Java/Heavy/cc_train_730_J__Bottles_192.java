import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
	static int n, a[], b[];
	static int dp[][][] = new int[100][20000 + 5][];
	static int offset = 10000;

	static int[] go(int curr, int have) {
		if (curr >= n) {
			return have >= 0 ? new int[] { 0, 0 } : new int[] { -1, -1 };
		}
		if (dp[curr][have + offset] != null)
			return dp[curr][have + offset];
		int[] ans = go(curr + 1, have + b[curr] - a[curr]).clone();
		if (ans[0] != -1) {
			ans[0]++;
		}
		int[] ans2 = go(curr + 1, have - a[curr]).clone();
		if (ans2[0] != -1) {
			ans2[1] += a[curr];
			if (ans2[0] < ans[0] || (ans2[0] == ans[0] && ans2[1] < ans[1])) {
				ans = ans2;
			}
		}
		return dp[curr][have + offset] = ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[];
		n = Integer.parseInt(bf.readLine());
		l = bf.readLine().split(" ");
		a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(l[i]);
		}
		l = bf.readLine().split(" ");
		b = new int[n];
		for (int i = 0; i < a.length; i++) {
			b[i] = Integer.parseInt(l[i]);
		}
		int ans[] = go(0, 0);
		System.out.println(ans[0] + " " + ans[1]);
	}
}