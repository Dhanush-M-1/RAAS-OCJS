import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a[][] = new int[n][2];
		int c[][] = new int[m][2];
		int ans[] = new int[n];

		for (int i = 0; i < n; i++) {
			a[i][0] = sc.nextInt();
			a[i][1] = sc.nextInt();
		}

		for (int i = 0; i < m; i++) {
			c[i][0] = sc.nextInt();
			c[i][1] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE;
			int no = 0;
			for (int j = 0; j < m; j++) {
				int tmp = min;
				min = Math.min(min, Math.abs(c[j][0] - a[i][0]) + Math.abs(c[j][1] - a[i][1]));
				if (tmp != min) no = j;
			}
			System.out.println(no + 1);
		}

		sc.close();

	}

}