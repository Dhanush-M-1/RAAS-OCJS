import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt() - 1;
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += scanner.nextInt();
		}
		int[] c = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			c[i] = scanner.nextInt();
		}

		for (int i = 0; i < n - 1; i++) {
			if (a[i] + 1 == a[i + 1])
				sum += c[a[i]];
		}
		System.out.println(sum);

	}

}
