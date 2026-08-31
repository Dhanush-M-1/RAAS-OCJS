// practice with kaiboy
import java.io.*;
import java.util.*;

public class CF180D extends PrintWriter {
	CF180D() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF180D o = new CF180D(); o.main(); o.flush();
	}

	static final int A = 26;
	void main() {
		byte[] aa = sc.next().getBytes();
		byte[] bb = sc.next().getBytes();
		int n = aa.length;
		int m = bb.length;
		int[] kk_ = new int[A];
		for (int i = 0; i < n; i++) {
			int a = aa[i] - 'a';
			kk_[a]++;
		}
out:
		for (int j = m; j >= 0; j--) {
			int[] kk = Arrays.copyOf(kk_, A);
			for (int i = 0; i < j; i++) {
				int a = bb[i] - 'a';
				if (kk[a] == 0)
					continue out;
				kk[a]--; aa[i] = (byte) (a + 'a');
			}
			int a = j == m ? -1 : bb[j] - 'a';
			for (int b = a + 1; b < A; b++)
				if (kk[b] > 0) {
					kk[b]--; aa[j] = (byte) (b + 'a');
					a = 0;
					while (++j < n) {
						while (kk[a] == 0)
							a++;
						kk[a]--; aa[j] = (byte) (a + 'a');
					}
					println(new String(aa));
					return;
				}
		}
		println(-1);
	}
}
