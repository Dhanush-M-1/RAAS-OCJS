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
		int[] p = nextIntArray1origin(sc, N);

		sc.close();

		int ans = 0;

		for (int i = N; i >= 2; i--) {
			// 後ろから確定させていく(i==2まで)
			if (p[i] == i) {
				ans++;
				int tmp = p[i];
				p[i] = p[i - 1];
				p[i - 1] = tmp;
			}
		}

		if (p[1] == 1) {
			ans++;
		}

		out.println(ans);
	}

	public static void main(String[] args) {
		new Main()._main(args);
	}

	@SuppressWarnings("unused")
	private int[] nextIntArray1origin(Scanner sc, int n) {
		int[] result = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}
}
