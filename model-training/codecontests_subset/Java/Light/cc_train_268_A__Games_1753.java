import java.util.Scanner;

public class Games {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] teams = new int[2][n];
		int total = 0;

		for (int i = 0; i < n; ++i) {
			teams[0][i] = scan.nextInt();
			teams[1][i] = scan.nextInt();
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (teams[0][i] == teams[1][j]) {
					total++;
				}
			}
		}

		System.out.println(total);

		scan.close();
	}
}
