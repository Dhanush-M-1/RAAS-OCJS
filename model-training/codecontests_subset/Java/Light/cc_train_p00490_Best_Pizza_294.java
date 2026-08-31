
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		new Main().run();
	}

	private void run() throws IOException {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int[] d = new int[n];
		for (int i = 0; i < n; i++)
			d[i] = scanner.nextInt();
		Arrays.sort(d);
		int ans = c / a;
		for (int i = n - 1; i >= 0; i--) {
			c += d[i];
			a += b;
			ans = Math.max(ans, c / a);
		}
		System.out.println(ans);

	}
}