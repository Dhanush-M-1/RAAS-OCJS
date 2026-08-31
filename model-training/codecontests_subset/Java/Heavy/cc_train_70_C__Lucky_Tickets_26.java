// practice with rainboy
import java.io.*;
import java.util.*;

public class CF70C extends PrintWriter {
	CF70C() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF70C o = new CF70C(); o.main(); o.flush();
	}

	int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	int rev(int a) {
		int r = 0;
		while (a > 0) {
			r = r * 10 + a % 10;
			a /= 10;
		}
		return r;
	}
	void main() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int w = sc.nextInt();
		int[] pp = new int[n + m];
		int[] qq = new int[n + m];
		for (int a = 1; a <= n; a++) {
			int r = rev(a), d = gcd(a, r);
			pp[a - 1] = a / d;
			qq[a - 1] = r / d;
		}
		for (int b = 1; b <= m; b++) {
			int r = rev(b), d = gcd(b, r);
			pp[n + b - 1] = r / d;
			qq[n + b - 1] = b / d;
		}
		Integer[] ii = new Integer[n + m];
		for (int i = 0; i < n + m; i++)
			ii[i] = i;
		Arrays.sort(ii, (i, j) -> pp[i] != pp[j] ? pp[i] - pp[j] : qq[i] - qq[j]);
		int z = 0;
		for (int i = 0; i < n + m; i++)
			pp[ii[i]] = i + 1 == n + m || pp[ii[i + 1]] != pp[ii[i]] || qq[ii[i + 1]] != qq[ii[i]] ? z++ : z;
		int[] kk = new int[z]; int[] ll = new int[z]; int k = 0;
		long ans = -1; int x_ = -1, y_ = -1;
		int j;
		for (j = n; j < n + m; j++)
			ll[pp[j]]++;
		j--;
		for (int i = 0; i < n; i++) {
			kk[pp[i]]++;
			k += ll[pp[i]];
			if (k < w)
				continue;
			while (j >= n && k - kk[pp[j]] >= w) {
				ll[pp[j]]--;
				k -= kk[pp[j]];
				j--;
			}
			int x = i + 1, y = j + 1 - n;
			if (ans == -1 || ans > (long) x * y) {
				ans = (long) x * y;
				x_ = x; y_ = y;
			}
		}
		if (ans == -1)
			println(-1);
		else
			println(x_ + " " + y_);
	}
}
