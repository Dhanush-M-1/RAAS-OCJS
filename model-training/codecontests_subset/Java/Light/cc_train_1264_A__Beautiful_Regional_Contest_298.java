import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();

		for (int testCase = 0; testCase < T; testCase++) {
			int n = scanner.nextInt();
			int[] p = new int[n];

			int maxAmountMedals = n / 2;
			int gold = 0;
			int silver = 0;
			int bronze = 0;

			for (int i = 0; i < n; i++) {
				int pi = scanner.nextInt();
				p[i] = pi;

				if (i != 0 && gold == 0 && p[i] != p[i-1]) {
					gold = i;
				} else if (i != 0 && silver == 0 && p[i] != p[i-1] && i - gold > gold) {
					silver = i - gold;
				}
			}

			int bestNonMedal = p[maxAmountMedals];
			for (int i = maxAmountMedals - 1; i >= 0; i--) {
				if (p[i] != bestNonMedal) {
					bronze = i - silver - gold + 1;
					break;
				}
			}

			if (gold == 0 || silver == 0 || bronze == 0 || gold >= silver || gold >= bronze || p[0] <= p[gold] || p[gold] < p[gold+silver]) {
				System.out.println("0 0 0");
			} else {
				System.out.println(gold + " " + silver + " " + bronze);
			}
		}

	}
}