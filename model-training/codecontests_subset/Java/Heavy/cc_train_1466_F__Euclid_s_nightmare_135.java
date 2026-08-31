import java.io.*;
import java.util.*;

public class CF1466F extends PrintWriter {
	CF1466F() { super(System.out); }
	static class Scanner {
		Scanner(InputStream in) { this.in = in; } InputStream in;
		byte[] bb = new byte[1 << 15]; int i, n;
		byte getc() {
			if (i == n) {
				i = n = 0;
				try { n = in.read(bb); } catch (IOException e) {}
			}
			return i < n ? bb[i++] : 0;
		}
		int nextInt() {
			byte c = 0; while (c <= ' ') c = getc();
			int a = 0; while (c > ' ') { a = a * 10 + c - '0'; c = getc(); }
			return a;
		}
	}
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1466F o = new CF1466F(); o.main(); o.flush();
	}

	static final int MD = 1000000007;
	int[] ds;
	int find(int i) {
		return ds[i] < 0 ? i : (ds[i] = find(ds[i]));
	}
	void join(int i, int j) {
		i = find(i);
		j = find(j);
		if (i == j)
			return;
		if (ds[i] > ds[j])
			ds[i] = j;
		else {
			if (ds[i] == ds[j])
				ds[i]--;
			ds[j] = i;
		}
	}
	void main() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		ds = new int[m]; Arrays.fill(ds, -1);
		boolean[] used = new boolean[m];
		int[] qu = new int[n]; int p = 1, cnt = 0;
		for (int l = 0; l < n; l++) {
			int k = sc.nextInt();
			int i = sc.nextInt() - 1;
			int i_ = find(i);
			if (k == 1) {
				if (used[i_])
					continue;
				used[i_] = true;
			} else {
				int j = sc.nextInt() - 1;
				int j_ = find(j);
				if (i_ == j_ || used[i_] && used[j_])
					continue;
				if (used[i_])
					used[j_] = true;
				else if (used[j_])
					used[i_] = true;
				else
					join(i_, j_);
			}
			p = p * 2 % MD;
			qu[cnt++] = l;
		}
		println(p + " " + cnt);
		for (int h = 0; h < cnt; h++)
			print(qu[h] + 1 + " ");
		println();
	}
}
