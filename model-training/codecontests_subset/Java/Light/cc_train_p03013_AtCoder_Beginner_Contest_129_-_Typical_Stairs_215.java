import java.util.Arrays;
import java.util.Scanner;
/**
 * 精進
 * @author linds_000
 *
 */
public class Main {

	public static void main(String[] args) {

		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());

		final long MOD = 1000000007L;
		boolean[] step = new boolean[n + 1];
		Arrays.fill(step, true);
		for (int i = 0; i < m; i++) {
			step[Integer.parseInt(sc.next())] = false;
		}

		long[] ans = new long[n + 1];

		ans[0] = 1L;
		for (int now = 0; now < n; now++) {
			for (int next = now + 1; next <= Integer.min(now + 2, n); next++) {
				if(step[next]) {
					ans[next] += ans[now];
					ans[next] %= MOD;
				}
			}
		}
		System.out.println(ans[n]);
	}

}
