import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();

		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			int M = in.nextInt();
			char[] S = in.nextLine().toCharArray();
			int[] P = new int[M];
			for (int i = 0; i < M; i++) {
				P[i] = in.nextInt() - 1;
			}
			long[] psum = new long[N];
			long[] ans = new long[26];
			for (int i = 0; i < M; i++) {
				psum[P[i]]++;
			}
			psum[N - 1]++;
			for (int i = N - 2; i >= 0; i--) {
				psum[i] += psum[i + 1];
			}
			for (int i = 0; i < N; i++) {
				ans[S[i] - 97] += psum[i];
			}
			for (int i = 0; i < 26; i++) {
				out.append(ans[i]).append(' ');
			}
			out.setCharAt(out.length() - 1, '\n');
		}

		System.out.print(out);
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer st;

		public InputReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(nextLine());
			}
			return st.nextToken();
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
