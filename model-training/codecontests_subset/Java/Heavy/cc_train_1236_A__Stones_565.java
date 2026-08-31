import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C1236A {

	static class Reader {
		BufferedReader br;
		StringTokenizer st;

		public Reader() {
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

	static int m = -1;
	static int[][][] map;

	public static void main(String[] args) {
		Reader r = new Reader();

		map = new int[101][101][101];
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				Arrays.fill(map[i][j], -1);
			}
		}

		int n = r.nextInt();

		for (int i = 0; i < n; i++) {
			int a = r.nextInt();
			int b = r.nextInt();
			int c = r.nextInt();
			System.out.println(recur(a, b, c));
		}

	}

	static int recur(int a, int b, int c) {

		if (map[a][b][c] != -1) {
//			System.out.println("vis");
			return map[a][b][c];
		}

		int x = 0;
		if (a > 0 && b > 1) {
			x = 3 + recur(a -  1, b - 2, c);
		} 
		if (b > 0 && c > 1) {
			x = Integer.max(3 + recur(a, b - 1, c - 2), x);
		}
		
		map[a][b][c] = x;
		return x;
		
	}
}
