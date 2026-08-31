// practice with kaiboy
import java.io.*;
import java.util.*;

public class CF1269B extends PrintWriter {
	CF1269B() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1269B o = new CF1269B(); o.main(); o.flush();
	}

	int[] aa, bb, cc; int n, m;
	boolean check(int x) {
		for (int i = 0; i < n; i++)
			cc[i] = (aa[i] + x) % m;
		Arrays.sort(cc);
		for (int i = 0; i < n; i++)
			if (cc[i] != bb[i])
				return false;
		return true;
	}
	void main() {
		n = sc.nextInt();
		m = sc.nextInt();
		aa = new int[n];
		bb = new int[n];
		cc = new int[n];
		for (int i = 0; i < n; i++)
			aa[i] = sc.nextInt();
		for (int i = 0; i < n; i++)
			bb[i] = sc.nextInt();
		Arrays.sort(bb);
		int x_ = m;
		for (int i = 0; i < n; i++) {
			int x = (bb[i] - aa[0] + m) % m;
			if (x_ > x && check(x))
				x_ = x;
		}
		println(x_);
	}
}
