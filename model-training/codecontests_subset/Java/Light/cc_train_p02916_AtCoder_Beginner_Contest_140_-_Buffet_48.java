
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];
			int[] c = new int[n - 1];

			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
				a[i]--;
			}
			for (int i = 0; i < n; i++) {
				b[i] = scanner.nextInt();
			}
			for (int i = 0; i < n - 1; i++) {
				c[i] = scanner.nextInt();
			}

			int ans = 0;
			for (int i = 0; i < n; i++) {
				ans += b[a[i]];
				if (i > 0 && a[i] == a[i - 1] + 1) {
					ans += c[a[i - 1]];
				}
			}

			System.out.println(ans);
		}
	}
}
