// practice with kaiboy
import java.io.*;
import java.util.*;

public class Main extends PrintWriter {
	Main() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		Main o = new Main(); o.main(); o.flush();
	}

	int ch(int n, int k) {
		return n < k ? 0 : k == 0 ? 1 : ch(n - 1, k - 1) * n / k;
	}
	int power(int a, int k) {
		return k == 0 ? 1 : power(a, k - 1) * a;
	}
	void main() {
		byte[] cc = sc.next().getBytes();
		int n = cc.length;
		int k = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int d = cc[i] - '0';
			if (d != 0)
				cnt++;
		}
		int ans = cnt == k ? 1 : 0;
		cnt = 0;
		for (int i = 0; i < n; i++) {
			int d = cc[i] - '0';
			if (d == 0)
				continue;
			ans += ch(n - 1 - i, k - cnt) * power(9, k - cnt);
			if (k > cnt)
				ans += ch(n - 1 - i, k - cnt - 1) * power(9, k - cnt - 1) * (d - 1);
			if (cnt++ == k)
				break;
		}
		println(ans);
	}
}
