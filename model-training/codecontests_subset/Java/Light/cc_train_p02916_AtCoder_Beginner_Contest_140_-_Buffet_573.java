import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[2][n + 1];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int[] a = arr[0];
		int[] b = arr[1];

		int[] c = new int[n];
		for (int i = 1; i < n; i++) {
			c[i] = sc.nextInt();
		}

		int sum = 0;
		int bef = n;
		for (int i = 1; i <= n; i++) {
			int dish = a[i];
			sum += b[dish];
			if (dish - 1 == bef) {
				sum += c[bef];
			}
			bef = a[i];
		}

		System.out.println(sum);

		sc.close();
	}

}
