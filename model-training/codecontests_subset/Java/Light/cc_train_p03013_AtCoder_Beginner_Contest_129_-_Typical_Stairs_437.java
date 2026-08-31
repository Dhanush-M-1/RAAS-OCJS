import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] broken = new boolean[n];
		Arrays.fill(broken, false);
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			broken[sc.nextInt() - 1] = true;
		}
		sc.close();
		long mod = 1000000007;
		long now = 0;// いま
		long prev1 = 1;// いっこまえ
		long prev2 = 0;// にこまえ
		for (int i = 0; i < n; i++) {
			if (!broken[i]) {
				now = prev1 + prev2;
				now %= mod;
			} else {
				now = 0;
			}
			prev2 = prev1;
			prev2 %= mod;
			prev1 = now;
			prev1 %= mod;
		}
		System.out.println(now);
	}
}
