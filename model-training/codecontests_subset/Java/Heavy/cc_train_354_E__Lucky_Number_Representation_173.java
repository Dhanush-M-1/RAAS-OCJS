import java.io.*;
import java.util.*;

public class E {

	int[] dig = new int[] { 0, 4, 7 };

	int[] number;
	boolean[][] was;

	int numLen = 20;
	int nums = 6;

	int[][] cnt;

	long[] numbers;

	boolean solve(int pos, int per) {
		if (pos < 0) {
			if (per == 0) {
				for (int i = 0; i < numLen; i++) {
					int t = 0;
					for (int j = 0; j < 3; j++) {
						for (int k = 0; k < cnt[i][j]; k++) {
							numbers[t] = numbers[t] * 10L + dig[j];
							t++;
						}
					}
				}
				return true;
			} else {
				return false;
			}
		}
		if (was[pos][per]) {
			return false;
		}
		was[pos][per] = true;
		for (cnt[pos][0] = 0; cnt[pos][0] <= 6; cnt[pos][0]++) {
			for (cnt[pos][1] = 0; cnt[pos][1] + cnt[pos][0] <= 6; cnt[pos][1]++) {
				cnt[pos][2] = 6 - cnt[pos][0] - cnt[pos][1];
				if ((cnt[pos][1] * 4 + cnt[pos][2] * 7 + per) % 10 == number[pos]
						&& solve(pos - 1,
								(cnt[pos][1] * 4 + cnt[pos][2] * 7 + per) / 10)) {
					return true;
				}
			}
		}
		return false;

	}

	void solve() throws IOException {
		number = new int[numLen];
		was = new boolean[numLen][5];
		cnt = new int[numLen][3];
		numbers = new long[nums];
		long n = nextLong();
		for (int i = numLen - 1; i >= 0; i--) {
			number[i] = (int)(n % 10);
			n /= 10;
		}
		if (solve(numLen - 1, 0)) {
			for (int i = 0; i < nums - 1; i++) {
				out.print(numbers[i] + " ");
			}
			out.println(numbers[nums - 1]);
		} else {
			out.println("-1");
		}

	}

	void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		int n = nextInt();
		for (int i = 0; i < n; i++) {
			solve();
		}
		out.close();
	}

	public static void main(String[] args) throws IOException {
		new E().run();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String temp = in.readLine();
			if (temp == null) {
				return null;
			}
			st = new StringTokenizer(temp);
		}
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	long nextLong() throws IOException {
		return Long.parseLong(next());
	}

}
