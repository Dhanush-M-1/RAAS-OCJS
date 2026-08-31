import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	InputStream in = System.in;
	PrintStream out = System.out;

	public void _main(String[] args) {
		Scanner sc = new Scanner(in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		boolean[] a = new boolean[N + 1];
		Arrays.fill(a, true);
		for (int i = 1; i <= M; i++) {
			a[sc.nextInt()] = false;
		}

		int[] ans = new int[N + 1];
		ans[0] = 1;
		ans[1] = 1;

		for (int i = 2; i <= N; i++) {
			ans[i] = 0;
			if (a[i - 2]) {
				ans[i] += ans[i - 2];
				ans[i] %= 1000000007;
			}
			if (a[i - 1]) {
				ans[i] += ans[i - 1];
				ans[i] %= 1000000007;
			}

		}

		out.println(ans[N]);

		sc.close();

	}

	public static void main(String[] args) {
		new Main()._main(args);
	}

}
