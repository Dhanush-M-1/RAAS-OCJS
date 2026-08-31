import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		InputReader in = new InputReader();

		int N = in.nextInt();
		int M = in.nextInt();
		int[] A = new int[N];
		int[] B = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = in.nextInt();
		}
		for (int i = 0; i < N; i++) {
			B[i] = in.nextInt();
		}
		Arrays.sort(A);
		Arrays.sort(B);

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int x = 0;
			if (A[0] < B[i]) {
				x = B[i] - A[0];
			} else if (A[0] > B[i]) {
				x = M - A[0] + B[i];
			}
			boolean flag = true;
			for (int j = 0; j < N; j++) {
				if ((A[j] + x) % M != B[(i + j) % N]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				ans = Math.min(ans, x);
			}
		}

		System.out.println(ans);
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
