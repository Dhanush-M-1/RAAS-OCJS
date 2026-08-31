import java.io.*;
import java.util.*;

public class CF846B extends PrintWriter {
	CF846B() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF846B o = new CF846B(); o.main(); o.flush();
	}

	void main() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();
		int s = 0; int[] tt = new int[k];
		for (int h = 0; h < k; h++)
			s += tt[h] = sc.nextInt();
		Arrays.sort(tt);
		int ans = 0;
		for (int n_ = 0; n_ <= n && n_ <= m / s; n_++) {
			int sum = (k + 1) * n_;
			int m_ = m - s * n_;
			for (int h = 0; h < k; h++) {
				int cnt = Math.min(n - n_, m_ / tt[h]);
				sum += cnt;
				m_ -= tt[h] * cnt;
			}
			ans = Math.max(ans, sum);
		}
		println(ans);
	}
}
