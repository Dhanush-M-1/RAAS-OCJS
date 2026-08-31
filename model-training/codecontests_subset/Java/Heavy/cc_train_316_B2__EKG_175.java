// practice with kaiboy
import java.io.*;
import java.util.*;

public class CF316B2 extends PrintWriter {
	CF316B2() { super(System.out); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF316B2 o = new CF316B2(); o.main(); o.flush();
	}

	int[] pp;
	int find(int i) {
		return pp[i] < 0 ? i : (pp[i] = find(pp[i]));
	}
	void main() {
		int n = sc.nextInt();
		int x = sc.nextInt() - 1;
		pp = new int[n];
		for (int i = 0; i < n; i++)
			pp[i] = sc.nextInt() - 1;
		int k = 1;
		while (pp[x] != -1) {
			k++;
			x = pp[x];
		}
		for (int i = 0; i < n; i++)
			pp[find(i)]--;
		int[] qu = new int[n]; int cnt = 0;
		int m = 0;
		for (int i = 0; i < n; i++)
			if (i != x && pp[i] < 0)
				m += qu[cnt++] = -pp[i] - 1;
		boolean[] used = new boolean[m + 1];
		used[0] = true;
		for (int h = 0; h < cnt; h++) {
			int c = qu[h];
			for (int a = m; a >= c; a--)
				if (used[a - c])
					used[a] = true;
		}
		for (int a = 0; a <= m; a++)
			if (used[a])
				println(k + a);
	}
}
