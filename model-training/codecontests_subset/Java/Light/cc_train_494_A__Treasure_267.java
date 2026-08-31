// practice with rainboy
import java.io.*;
import java.util.*;

public class CF494A extends PrintWriter {
	CF494A() { super(System.out); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF494A o = new CF494A(); o.main(); o.flush();
	}

	void main() {
		byte[] cc = sc.next().getBytes();
		int n = cc.length;
		int d = 0, k = 0, j = -1, dj = -1;
		for (int i = 0; i < n; i++) {
			if (cc[i] == '(')
				d++;
			else {
				if (cc[i] == '#') {
					k++;
					j = i;
					dj = d;
				}
				d--;
			}
			if (d < 0) {
				println(-1);
				return;
			}
		}
		int d_ = d;
		d = dj - d;
		for ( ; j < n; j++) {
			if (cc[j] == '(')
				d++;
			else
				d--;
			if (d < 0) {
				println(-1);
				return;
			}
		}
		while (--k > 0)
			println(1);
		println(d_ + 1);
	}
}
