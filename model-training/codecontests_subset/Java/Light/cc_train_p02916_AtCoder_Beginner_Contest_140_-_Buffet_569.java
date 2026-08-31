import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] array = new int[n][2];
		for (int i = 0; i < n; i++) {
			array[i][0] = sc.nextInt() - 1;
		}
		for (int i = 0; i < n; i++) {
			array[i][1] = sc.nextInt();
		}
		int[] c = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			c[i] = sc.nextInt();
		}
		long sum = 0L;
		int pi = -2;
		for (int i = 0; i < n; i++) {
			sum += array[array[i][0]][1];
			if (array[i][0] == pi + 1) {
				sum += c[pi];
			}
			pi = array[i][0];
		}
		System.out.println(sum);
	}
}
