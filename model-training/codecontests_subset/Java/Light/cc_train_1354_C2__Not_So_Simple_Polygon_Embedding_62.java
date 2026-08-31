

import java.util.Scanner;

public class third {
	static double polydiagonal(double n, double a) {

		// Side and side length cannot be negative
		if (a < 0 && n < 0) {
			return -1;
		}

		double rad = Math.toRadians(180 / n);
		return (double) (1 / Math.sin(rad));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = scn.nextInt();
		while (t-- >0) {
			int n = scn.nextInt();
			double x = Math.PI / (4 * n);
			double ans = Math.sin(x)*2;
			ans = 1 / ans;
//			double s = (Math.sqrt(ans * ans - 1.0));
			sb.append(ans + "\n");
		}
		System.out.print(sb);

	}

}
