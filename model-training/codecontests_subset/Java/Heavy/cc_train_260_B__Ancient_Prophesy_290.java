// practice with kaiboy
import java.io.*;
import java.util.*;

public class CF260B extends PrintWriter {
	CF260B() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF260B o = new CF260B(); o.main(); o.flush();
	}

	byte[] cc;
	int[] dd = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	boolean check(int i) {
		if (cc[i + 2] != '-' || cc[i + 5] != '-')
			return false;
		if (cc[i + 6] != '2' || cc[i + 7] != '0' || cc[i + 8] != '1' || cc[i + 9] < '3' || cc[i + 9] > '5')
			return false;
		if (cc[i] == '-' || cc[i + 1] == '-' || cc[i + 3] == '-' || cc[i + 4] == '-')
			return false;
		int d = (cc[i] - '0') * 10 + (cc[i + 1] - '0');
		int m = (cc[i + 3] - '0') * 10 + (cc[i + 4] - '0');
		return m >= 1 && m <= 12 && d >= 1 && d <= dd[m];
	}
	void main() {
		cc = sc.next().getBytes();
		int n = cc.length;
		HashMap<String, Integer> mp = new HashMap<>();
		String s_ = null;
		int k_ = 0;
		for (int i = 0; i + 10 <= n; i++)
			if (check(i)) {
				String s = new String(cc, i, 10);
				int k = mp.getOrDefault(s, 0) + 1;
				mp.put(s, k);
				if (k_ < k) {
					k_ = k;
					s_ = s;
				}
			}
		println(s_);
	}
}
