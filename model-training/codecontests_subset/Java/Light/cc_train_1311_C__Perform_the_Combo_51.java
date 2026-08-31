import java.io.*;
import java.util.*;

public class CF1311C extends PrintWriter {
	CF1311C() { super(System.out); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1311C o = new CF1311C(); o.main(); o.flush();
	}

	static final int A = 26;
	void add(long[] uu, int[] vv) {
		for (int a = 0; a < A; a++)
			uu[a] += vv[a];
	}
	void main() {
		int t = sc.nextInt();
		int[] kk = new int[A];
		long[] ss = new long[A];
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			byte[] cc = sc.next().getBytes();
			Arrays.fill(kk, 0);
			int[][] pp = new int[n][];
			for (int i = 0; i < n; i++) {
				int a = cc[i] - 'a';
				kk[a]++;
				pp[i] = Arrays.copyOf(kk, A);
			}
			Arrays.fill(ss, 0);
			add(ss, pp[n - 1]);
			while (m-- > 0) {
				n = sc.nextInt();
				add(ss, pp[n - 1]);
			}
			for (int a = 0; a < A; a++)
				print(ss[a] + " ");
			println();
		}
	}
}
