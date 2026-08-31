import java.util.*;
import java.io.*;

public class A {
	FastScanner in;
	PrintWriter out;

	int[] toCnt(char[] c) {
		int[] res = new int[26];
		for (char cc : c)
			res[cc - 'a']++;
		return res;
	}
	
	public void solve() throws IOException {
		char[] a = in.next().toCharArray();
		char[] b = in.next().toCharArray();
		char[] c = in.next().toCharArray();
		int[] ca = toCnt(a), cb = toCnt(b), cc = toCnt(c);
		int maxB = 0, maxC = 0;
		for (int cntB = 0; cntB < a.length; cntB++) {
			int cntC = a.length;
			boolean ok = true;
			for (int j = 0; j < 26; j++) {
				if (1L * cb[j] * cntB > ca[j]) {
					ok = false;
					break;
				}
				if (cc[j] != 0)
					cntC = (int) Math.min(cntC, (ca[j] - 1L * cb[j] * cntB) / cc[j]);
			}
			if (ok && cntB + cntC > maxB + maxC) {
				maxB = cntB;
				maxC = cntC;
			}
		}
		StringBuffer res = new StringBuffer();
		for (int i = 0; i < maxB; i++) {
			res.append(b);
			for (int j = 0; j < 26; j++)
				ca[j] -= cb[j];
		}
		for (int i = 0; i < maxC; i++) {
			res.append(c);
			for (int j = 0; j < 26; j++) {
				ca[j] -= cc[j];
			}
		}
		for (int j = 0; j < 26; j++) {
			while (ca[j] > 0) {
				ca[j]--;
				res.append((char)(j + 'a'));
			}
		}
		out.println(res);
	}

	public void run() {
		try {
			in = new FastScanner();
			out = new PrintWriter(System.out);

			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
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

	public static void main(String[] arg) {
		new A().run();
	}
}