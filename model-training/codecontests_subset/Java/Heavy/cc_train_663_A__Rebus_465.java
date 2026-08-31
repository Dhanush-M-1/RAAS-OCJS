import java.io.*;
import java.util.*;

public class A {
	FastScanner in;
	PrintWriter out;

	void solve() {
		ArrayList<Integer> a = new ArrayList<>();
		int sign = 1;
		int posc = 0, negc = 0;
		while (true) {
			in.next();
			a.add(sign);
			if (sign == 1) {
				posc++;
			} else {
				negc++;
			}
			String s = in.next();
			if (s.equals("-")) {
				sign = -1;
			} else if (s.equals("+")) {
				sign = 1;
			} else {
				break;
			}
		}
		int n = in.nextInt();
		int[] pos = new int[posc];
		int pc = 0;
		Arrays.fill(pos, 1);
		int[] neg = new int[negc];
		Arrays.fill(neg, 1);
		int nc = 0;
		int A = posc, B = negc;
		while (A - B < n && pc < posc) {
			if (pos[pc] < n) {
				pos[pc]++;
				A++;
			} else {
				pc++;
			}
		}
		while (A - B > n && nc < negc) {
			if (neg[nc] < n) {
				neg[nc]++;
				B++;
			} else {
				nc++;
			}
		}
		if (A - B != n) {
			out.println("Impossible");
			return;
		}
		out.println("Possible");
		pc = 0;
		nc = 0;
		boolean first = true;
		for (int x : a) {
			if (!first) {
				out.print(x > 0 ? " + " : " - ");
			}
			first = false;
			out.print(x > 0 ? pos[pc++] : neg[nc++]);
		}
		out.println(" = " + n);
	}

	void run() {
		in = new FastScanner();
		out = new PrintWriter(System.out);

		solve();

		out.close();
	}

	class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(in.br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}
	}

	public static void main(String[] args) {
		new A().run();
	}
}