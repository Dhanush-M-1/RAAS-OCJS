import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] f = new int[n];

		for (int i = 0; i < f.length; i++) {
			int tmp = 0;
			for (int j = 0; j < 10; j++) {
				tmp = tmp << 1;
				tmp += sc.nextInt();
			}
			f[i] = tmp;
		}

		int[][] p = new int[n][11];
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[i].length; j++) {
				p[i][j] = sc.nextInt();
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < 1 << 10; i++) {
			int profit = 0;
			for (int j = 0; j < p.length; j++) {
				profit += p[j][Integer.bitCount(i & f[j])];
			}
			if (profit > max) {
				max = profit;
			}
		}

		System.out.println(max);

		sc.close();
	}

}
