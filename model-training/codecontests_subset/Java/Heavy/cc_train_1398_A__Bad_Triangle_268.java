import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Temp {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Solution sol = new Solution();
		int t = in.nextInt();
		for (int i = 0; i < t; ++i)
			sol.aSolve(in, out);
//			sol.bSolve(in, out);
//			sol.cSolve(in, out);
		out.close();
	}

	private static class Solution {
		private void aSolve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			long[] a = new long[n];
			for (int i = 0; i < n; ++i)
				a[i] = in.nextInt();
			if (a[0] + a[1] <= a[n - 1]) {
				out.println("1 2 " + n);
				return;
			}
			out.println(-1);
		}

		private void bSolve(InputReader in, PrintWriter out) {
			char[] s = in.next().toCharArray();
			ArrayList<Integer> cons = new ArrayList<>();
			int n = s.length;
			for (int i = 0; i < n; ++i) {
				int r = 0;				
				if (s[i] == '1') {
					for (int j = i; j<n; ++j) {
						if (s[j] == '1') {
							r++;
							if (j + 1 == n) {
								cons.add(r);
								i = j;
							}
						}
						else if (s[j] == '0') {
							cons.add(r);
							i = j;
							break;
						}
					}
				}
			}
			Collections.sort(cons);
			Collections.reverse(cons);
			int ans = 0;
			boolean alice = true;
			for (int i = 0; i < cons.size(); ++i) {
				if (alice) {
					ans += cons.get(i);
					alice = false;
				} else {
					alice = true;
				}
			}
			out.println(ans);
		}
		private void cSolve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			char[] dum = in.next().toCharArray();
			int[] a = new int[n];
			for (int i = 0; i < n; ++i)
				a[i] = dum[i] - '0';
			int ans = 0;
			for (int i = 0; i < n; ++i) {
				int pref = a[i];
				for (int j = 0; j < n; ++j) {
					if (pref == j - i + 1) {
						++ans;
						break;
					}
					if (i == j) continue;
					pref += a[j];
//					out.println(pref + " " + (j - i));
				}
			}
			out.println(ans);
		}
	}
	

	private static class InputReader {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		private InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 9000000);
			tokenizer = null;
		}

		private String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		private int nextInt() {
			return Integer.parseInt(next());
		}

		private long nextLong() {
			return Long.parseLong(next());
		}
	}
}
