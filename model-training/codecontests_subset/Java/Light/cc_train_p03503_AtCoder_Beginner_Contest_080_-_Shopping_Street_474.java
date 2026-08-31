import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	InputStream in = System.in;
	PrintStream out = System.out;

	public void _main(String[] args) {
		Scanner sc = new Scanner(in);

		int N = sc.nextInt();
		int[][] F = new int[N][10];
		int[][] P = new int[N][10];

		for (int i = 0; i < N; i++) {
			F[i] = nextIntArray(sc, 10);
		}
		for (int i = 0; i < N; i++) {
			P[i] = nextIntArray(sc, 11);
		}

		sc.close();

		long ans = Long.MIN_VALUE;

		for (int a = 1; a <= 1023; a++) {

			int[] c = new int[N]; //店ごとの、joisinoと同時に空いている時間帯の数。
			for (int i = 0; i < N; i++) { //店iについて
				for (int k = 0; k < 10; k++) {
					int b = (a >> k) & 0x1; //joisinoがあいてるか
					if (b == 1 && F[i][k] == 1) {
						c[i]++;
					}
				}
			}

			long sum = 0;
			for (int i = 0; i < N; i++) {
				sum += P[i][c[i]];
			}

			ans = Math.max(ans, sum);
		}

		out.println(ans);

	}

	public static void main(String[] args) {
		new Main()._main(args);
	}

	@SuppressWarnings("unused")
	private int[] nextIntArray(Scanner sc, int n) {
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}
}
