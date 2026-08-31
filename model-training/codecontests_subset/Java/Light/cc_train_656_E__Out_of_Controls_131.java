import java.util.Scanner;

public class OutOfControls {
	static int[][] dp;
	static int n, res;
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		n = scan.nextInt();
		dp = new int[n][n];
		loop1(0);
		Floyd1(0);
		res = 0;
		Loop1(0);
		System.out.println(res);
	}
	static int Loop1(int i) {
		Loop2(i, 0);
		return i+1<n?Loop1(i+1):0;
	}
	static int Loop2(int i, int j) {
		res = Math.max(res, dp[i][j]);
		return j+1<n?Loop2(i, j+1):0;
	}
	static int loop1(int i) {
		loop2(i, 0);
		return i+1<n?loop1(i+1):0;
	}
	static int loop2(int i, int j) {
		dp[i][j] = scan.nextInt();
		return j+1<n?loop2(i, j+1):0;
	}
	static int Floyd1(int k) {
		Floyd2(k, 0);
		return k+1<n?Floyd1(k+1):0;
	}
	static int Floyd2(int k, int i) {
		Floyd3(k, i, 0);
		return i+1<n?Floyd2(k, i+1):0;
	}
	static int Floyd3(int k, int i, int j) {
		dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
		return j+1<n?Floyd3(k, i, j+1):0;
	}
}
