import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] argv) {
		new Main().run();
	}

	void run() {

		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
		try {
			solve();
		} finally {
			out.close();
		}
	}

	PrintWriter out;
	Scanner in;

	void result(long n) {
		long res = 1;
		int cnt = 0;
		long N = n;
		if (n == 1) {
			out.println("1\n0");
			return;
		}
		m: for (long i = 2; i * i <= n; i++) {
			while (n % i == 0) {
				cnt++;
				if (cnt <= 2)
					res *= i;
				if (cnt > 2)
					break m;
				n /= i;
			}
		}

		if (n > 1) {
			cnt++;
			if (cnt < 2) {
				res *= n;
			}
		}
		if (cnt == 1) {
			out.println(1);
			out.println(0);
			return;
		}
		if (cnt == 2) {
			out.println(2);
			return;
		}
		out.println(1);
		out.println(res);

	}

	void solve() {
		result(in.nextLong());
	}
}