import java.io.*;
import java.util.*;

public class CF1420D extends PrintWriter {
	CF1420D() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1420D o = new CF1420D(); o.main(); o.flush();
	}

	static final int MD = 998244353;
	int[] ff, gg;
	int inv(int a, long x) {
		return a == 1 ? (int) x : inv(a - MD % a, x * (MD / a + 1) % MD);
	}
	void init(int n) {
		ff = new int[n];
		gg = new int[n];
		for (int f = 1, i = 0; i < n; i++) {
			gg[i] = inv(ff[i] = f, 1);
			f = (int) ((long) f * (i + 1) % MD);
		}
	}
	int ch(int n, int k) {
		return (int) ((long) ff[n] * gg[k] % MD * gg[n - k] % MD);
	}
	void main() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		init(n);
		int[] aa = new int[n * 2];
		for (int i = 0; i < n * 2; i++)
			aa[i] = sc.nextInt() << 1 | i & 1;
		aa = Arrays.stream(aa).boxed().sorted().mapToInt($->$).toArray();
		int ans = 0, l = 0;
		for (int i = 0; i < n * 2; i++)
			if ((aa[i] & 1) == 0) {
				l++;
				if (l >= k)
					ans = (ans + ch(l - 1, k - 1)) % MD;
			} else
				l--;
		println(ans);
	}
}
