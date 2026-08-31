import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int b = 0;
		int[] c = new int[n - 1];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			b += sc.nextInt();
		}

		for (int i = 0; i < n - 1; i++) {
			c[i] = sc.nextInt();
		}

		for (int i = 1; i < n; i++) {
			int r = a[i];
			int f = a[i - 1];
			if ((r - f) == 1) {
				b += c[f - 1];
			}
		}
		System.out.println(b);
	}
}