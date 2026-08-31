import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int result = solve(a, b);
		System.out.println(result);
	}

	private static int solve(int a, int b) {
		int sum = 0;
		int burnedCandles = 0;
		while (a >= b) {
			burnedCandles = a - (a % b);
			sum += burnedCandles;
			a = a / b + a % b;
		}
		sum += a;
		return sum;
	}
}