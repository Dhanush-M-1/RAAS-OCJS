import java.io.*;
import java.util.*;

public class CF1506F extends PrintWriter {
	CF1506F() { super(System.out); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1506F o = new CF1506F(); o.main(); o.flush();
	}

	void main() {
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] rr = new int[n];
			for (int i = 0; i < n; i++)
				rr[i] = sc.nextInt();
			int[] cc = new int[n];
			for (int i = 0; i < n; i++)
				cc[i] = sc.nextInt();
			Integer[] ii = new Integer[n];
			for (int i = 0; i < n; i++)
				ii[i] = i;
			Arrays.sort(ii, (i, j) -> cc[i] != cc[j] ? cc[i] - cc[j] : rr[i] - rr[j]);
			int ans = 0;
			for (int r_ = 1, c_ = 1, i = 0; i < n; i++) {
				int r = rr[ii[i]], c = cc[ii[i]];
				if (r_ == r && c_ == c)
					continue;
				int d_ = r_ - c_, d = r - c;
				if (d_ != d)
					ans += d - d_ >> 1;
				if ((d - d_ & 1) == 1 && (d_ & 1) == 1)
					ans++;
				if (d_ == d && (d & 1) == 0)
					ans += c - c_;
				r_ = r; c_ = c;
			}
			println(ans);
		}
	}
}
