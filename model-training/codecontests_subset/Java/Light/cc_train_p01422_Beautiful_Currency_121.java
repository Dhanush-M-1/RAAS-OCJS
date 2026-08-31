import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int AMAX = 200000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		double[][] dp = new double[n+1][AMAX+1];
		for(int i=0;i<=n;i++) {
			Arrays.fill(dp[i], Double.POSITIVE_INFINITY);
		}
		dp[0][1] = 0;
		for(int i=0;i<n;i++) {
			for(int j=1;j<=AMAX;j++) {
				if (dp[i][j] >= Double.POSITIVE_INFINITY) {
					continue;
				}
				for(int k=j;k<=AMAX;k+=j) {
					dp[i+1][k] = Math.min(dp[i+1][k], Math.max(dp[i][j],(double) Math.abs(a[i] - k) / a[i]));
				}
			}
		}
//		for(int i=0;i<=n;i++) {
//			for(int j=0;j<=100;j++) {
//				System.out.print(String.format("%10f,",dp[i][j]));
//			}
//			System.out.println();
//		}
		double ans = Double.POSITIVE_INFINITY;
		for(int i=1;i<=AMAX;i++) {
			ans = Math.min(ans, dp[n][i]);
		}
		System.out.println(String.format("%.9f", ans));
	}

}