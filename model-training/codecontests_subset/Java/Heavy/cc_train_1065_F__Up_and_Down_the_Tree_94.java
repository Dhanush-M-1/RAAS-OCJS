// practice with rainboy
import java.io.*;
import java.util.*;

public class CF1065F extends PrintWriter {
	CF1065F() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1065F o = new CF1065F(); o.main(); o.flush();
	}

	int[] oo, oj; int __ = 1;
	int link(int o, int j) {
		oo[__] = o; oj[__] = j;
		return __++;
	}
	int[] ae, hh, dp, dq;
	void init(int n, int m) {
		oo = new int[1 + m]; oj = new int[1 + m];
		ae = new int[n]; hh = new int[n];
		dp = new int[n]; dq = new int[n];
	}
	int n, k;
	int dfs1(int i, int d) {
		if (ae[i] == 0)
			return d;
		int d_ = n;
		for (int o = ae[i]; o != 0; o = oo[o]) {
			int j = oj[o];
			d_ = Math.min(d_, dfs1(j, d + 1));
		}
		hh[i] = d_ - d;
		return d_;
	}
	void dfs2(int i) {
		if (ae[i] == 0) {
			dp[i] = 1;
			return;
		}
		for (int o = ae[i]; o != 0; o = oo[o]) {
			int j = oj[o];
			dfs2(j);
			if (hh[j] < k)
				dp[i] += dp[j];
		}
	}
	void dfs3(int i) {
		int x = 0;
		for (int o = ae[i]; o != 0; o = oo[o]) {
			int j = oj[o];
			dfs3(j);
			x = Math.max(x, hh[j] < k ? dq[j] - dp[j] : dq[j]);
		}
		dq[i] = dp[i] + x;
	}
	void main() {
		n = sc.nextInt();
		k = sc.nextInt();
		init(n, n - 1);
		for (int i = 1; i < n; i++) {
			int p = sc.nextInt() - 1;
			ae[p] = link(ae[p], i);
		}
		dfs1(0, 0);
		dfs2(0);
		dfs3(0);
		println(dq[0]);
	}
}
