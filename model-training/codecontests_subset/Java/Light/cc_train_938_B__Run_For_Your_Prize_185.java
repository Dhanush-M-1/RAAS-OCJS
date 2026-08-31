import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int ans = 0;
		for (int i = 0; i < n; i++) {
			int ai = sc.nextInt();
			ai = ai > 500000 ? 1000000 - ai : ai - 1;
			ans = ai > ans ? ai : ans;
		}
		System.out.println(ans);

		sc.close();

	}

}