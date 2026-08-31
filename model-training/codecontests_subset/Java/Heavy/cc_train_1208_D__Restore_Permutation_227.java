// practice with rainboy
import java.io.*;
import java.util.*;

public class CF1208D extends PrintWriter {
	CF1208D() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1208D o = new CF1208D(); o.main(); o.flush();
	}

	long[] tr;
	int n_;
	void build(int n) {
		n_ = 1;
		while (n_ < n)
			n_ <<= 1;
		tr = new long[n_ * 2];
		for (int i = 0; i < n; i++)
			tr[n_ + i] = i + 1;
		for (int i = n_ - 1; i >= 1; i--)
			tr[i] = tr[i << 1] + tr[i << 1 | 1];
	}
	int query(long s) {
		int i = 1;
		while (i < n_)
			if (s >= tr[i << 1]) {
				s -= tr[i << 1];
				i = i << 1 | 1;
			} else
				i = i << 1;
		return i - n_;
	}
	void update(int i) {
		tr[i += n_] = 0;
		while (i > 1) {
			i >>= 1;
			tr[i] = tr[i << 1] + tr[i << 1 | 1];
		}
	}
	void main() {
		int n = sc.nextInt();
		long[] ss = new long[n];
		for (int i = 0; i < n; i++)
			ss[i] = sc.nextLong();
		build(n);
		int[] pp = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			int j = query(ss[i]);
			update(j);
			pp[i] = j + 1;
		}
		for (int i = 0; i < n; i++)
			print(pp[i] + " ");
		println();
	}
}
