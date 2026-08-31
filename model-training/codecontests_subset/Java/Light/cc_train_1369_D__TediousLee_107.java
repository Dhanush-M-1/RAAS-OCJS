// upsolve with kaiboy
import java.io.*;
import java.util.*;

public class CF1369D extends PrintWriter {
	CF1369D() { super(System.out); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1369D o = new CF1369D(); o.main(); o.flush();
	}

	static final int N = 2000000, MD = 1000000007;
	void mult(int[][] aa, int[][] bb, int[][] cc) {
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				long c = 0;
				for (int k = 0; k < 4; k++)
					c += (long) aa[i][k] * bb[k][j];
				cc[i][j] = (int) (c % MD);
			}
	}
	void power(int[][] aa, int[][] pp, int[][] tt, int k) {
		if (k == 0) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++)
					pp[i][j] = 0;
				pp[i][i] = 1;
			}
			return;
		}
		if ((k & 1) != 0) {
			power(aa, pp, tt, k >> 1);
			mult(pp, pp, tt);
			mult(tt, aa, pp);
		} else {
			power(aa, tt, pp, k >> 1);
			mult(tt, tt, pp);
		}
	}
	void main() {
		int[][] aa = new int[4][4];
		int[][] pp = new int[4][4];
		int[][] tt = new int[4][4];
		aa[0][0] = 1;
		aa[1][2] = 2; aa[1][3] = 1;
		aa[2][2] = 2; aa[2][3] = 3;
		aa[3][0] = 1; aa[3][2] = 6; aa[3][3] = 5;
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			power(aa, pp, tt, (n - 1) / 3);
			int i = 1 + (n - 1) % 3;
			println((pp[i][0] + pp[i][3]) * 4L % MD);
		}
	}
}
