// practice with kaiboy
import java.io.*;
import java.util.*;

public class CF1081D extends PrintWriter {
	CF1081D() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1081D o = new CF1081D(); o.main(); o.flush();
	}

	int[] ds, kk;
	int find(int i) {
		return ds[i] < 0 ? i : (ds[i] = find(ds[i]));
	}
	int join(int i, int j) {
		i = find(i);
		j = find(j);
		if (i == j)
			return 0;
		int k;
		if (ds[i] > ds[j]) {
			ds[i] = j;
			k = kk[j] += kk[i];
		} else {
			if (ds[i] == ds[j])
				ds[i]--;
			ds[j] = i;
			k = kk[i] += kk[j];
		}
		return k;
	}
	void main() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		ds = new int[n]; Arrays.fill(ds, -1);
		kk = new int[n];
		for (int h = 0; h < k; h++) {
			int i = sc.nextInt() - 1;
			kk[i] = 1;
		}
		int[] uu = new int[m];
		int[] vv = new int[m];
		int[] ww = new int[m];
		Integer[] hh = new Integer[m];
		for (int h = 0; h < m; h++) {
			uu[h] = sc.nextInt() - 1;
			vv[h] = sc.nextInt() - 1;
			ww[h] = sc.nextInt();
			hh[h] = h;
		}
		Arrays.sort(hh, (h1, h2) -> ww[h1] - ww[h2]);
		int w_ = 0;
		for (int h = 0; h < m; h++) {
			int h_ = hh[h];
			if (join(uu[h_], vv[h_]) == k) {
				w_ = ww[h_];
				break;
			}
		}
		while (k-- > 0)
			print(w_ + " ");
		println();
	}
}
