// practice with rainboy
import java.io.*;
import java.util.*;

public class CF518E extends PrintWriter {
	CF518E() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF518E o = new CF518E(); o.main(); o.flush();
	}

	static final int INF = 0x3f3f3f3f;
	boolean solve(int[] aa, int i0, int k, int n) {
		int a_ = -INF;
		for (int i = -1, j; i < n; i = j) {
			j = i + 1;
			while (j < n && aa[i0 + j * k] == INF)
				j++;
			int b_ = j == n ? INF : aa[i0 + j * k];
			if (b_ - a_ < j - i)
				return false;
			int m = j - i - 1;
			int r = (m - 1) / 2;
			int l = r - m + 1;
			if (r >= b_) {
				r = b_ - 1;
				l = r - m + 1;
			}
			if (l <= a_) {
				l = a_ + 1;
				r = l + m - 1;
			}
			for (int h = i + 1; h < j; h++)
				aa[i0 + h * k] = l++;
			a_ = b_;
		}
		return true;
	}
	void main() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] aa = new int[n];
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			aa[i] = s.charAt(0) == '?' ? INF : Integer.parseInt(s);
		}
		for (int i0 = 0; i0 < k; i0++)
			if (!solve(aa, i0, k, (n - 1 - i0) / k + 1)) {
				println("Incorrect sequence");
				return;
			}
		for (int i = 0; i < n; i++)
			print(aa[i] + " ");
		println();
	}
}
