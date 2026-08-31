import java.util.*;
import java.io.*;

public class aaaaaaaaaaaaaaaa {
	public void run() throws Exception {
		FastReader file = new FastReader();
		int times = file.nextInt();
		String[][] mat = new String[times-1][times-1];
		for (int i = 0; i < times-1; i++) {
			for (int j = 0; j < times - 1; j++) {
				mat[i][j] = Integer.toString((i + 1) * (j + 1), times);
			}
		}
		for (String[] i : mat) {
			for (String a : i) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {
		new aaaaaaaaaaaaaaaa().run();
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
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

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
