import java.util.*;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class C146 {
	static Scanner in = new Scanner(System.in);
	static PrintWriter w = new PrintWriter(System.out, true);

	static int ni() {
		return in.nextInt();
	}

	static String nl() {
		return in.nextLine();
	}

	static void pl(int v) {
		w.println(v);
	}

	static void pl(String s) {
		w.println(s);
	}

	static long gcd(long a, long b) {
		if (a == 0) return b;
		if (b == 0) return a;
		return gcd(b, a % b);
	}

	static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}

	public static void main(String[] args) {
		int n = ni();
		if (n == 1) {
			pl(1);
			return;
		}
		boolean[] s = new boolean[1000001];
		int[] ps = new int[80000];
		int pc = 0;
		for (int i = 2; i < 1000001; i++) {
			if (s[i]) continue;
			ps[pc++] = i;
			for (int j = i + i; j < 1000001; j += i)
				s[j] = true;
		}
		ps = Arrays.copyOf(ps, pc);
		int pos = Arrays.binarySearch(ps, n);
		if (pos >= 0) pos++;
		else pos = -pos -1;
		int mr = ps[max(0, pos - 3)];
		long mm = -1;
		for (long i = mr; i <= n; i++) {
			for (long j = mr; j <= n; j++) {
				for (long k = mr; k <= n; k++) {
					long mmm = lcm(lcm(i, j), k);
					if (mmm > mm) mm = mmm;
				}
			}
		}
		w.println(mm);
	}
}