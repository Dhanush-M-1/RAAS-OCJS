import java.io.*;
import java.util.*;

public class CF1512G extends PrintWriter {
	CF1512G() { super(System.out); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1512G o = new CF1512G(); o.main(); o.flush();
	}

	static final int C = 10000000;
	void main() {
		int[] dp = new int[C];
		int[] aa = new int[C + 1]; Arrays.fill(aa, -1);
		for (int a = 1; a < C; a++) {
			for (int b = a; b < C; b += a)
				dp[b] += a;
			int c = dp[a];
			if (c <= C && aa[c] == -1)
				aa[c] = a;
		}
		int t = sc.nextInt();
		while (t-- > 0) {
			int c = sc.nextInt();
			println(aa[c]);
		}
	}
}
