import java.util.Scanner;

public class CF433A {

	static int N, total;
	static Boolean[][] dp;
	static int[] a;

	static boolean solve(int cur, int rem) {
		if (cur == N && rem == total / 2)
			return true;
		if (cur == N)
			return false;
		if (dp[cur][rem] != null)
			return dp[cur][rem];
		boolean ret = solve(cur + 1, rem - a[cur]) || (solve(cur + 1, rem));
		return dp[cur][rem] = ret;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		a = new int[N];
		total = 0;
		for (int i = 0; i < N; i++)
			total += (a[i] = sc.nextInt());

		dp = new Boolean[N + 1][total + 1];
		if (solve(0, total))
			System.out.println("YES");
		else
			System.out.println("NO");

	}
}
