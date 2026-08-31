import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int h_min = Integer.MAX_VALUE;

		for (int i = 1; i <= n; i++) {
			int ai = sc.nextInt();

			if (k % ai == 0) {
				int hi = k / ai;
				if (hi < h_min) {
					h_min = hi;
				}
			}
		}
		System.out.println(h_min);

		sc.close();

	}

}