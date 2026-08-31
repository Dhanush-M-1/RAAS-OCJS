//package CodeForcesRound_10_4_2020;

import java.util.Scanner;

public class Ex1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		while (T-- > 0) {
			int n = scan.nextInt();
			int[][] check = new int[n][2];
			for (int i = 0; i < check.length; i++) {
				check[i][0] = scan.nextInt();
				check[i][1] = scan.nextInt();
			}
			int plays = check[0][0];
			int clears = check[0][1];
			int i = 0;
			if (plays < clears)
				System.out.println("NO");
			else {
				for (i = 1; i < check.length; i++) {

					if (check[i][0] < plays) {
						System.out.println("NO");
						break;
					}
					if (check[i][1] < clears) {
						System.out.println("NO");
						break;
					}
					if (check[i][1] > clears) {
						int difference = check[i][1] - clears;
						if (check[i][0] < (plays + difference)) {
							System.out.println("NO");
							break;
						}
					}

					if (clears > plays) {
						System.out.println("NO");
						break;
					}
					clears = check[i][1];
					plays = check[i][0];
				}
			}
			if (i == check.length)
				System.out.println("YES");
		}
	}
}
