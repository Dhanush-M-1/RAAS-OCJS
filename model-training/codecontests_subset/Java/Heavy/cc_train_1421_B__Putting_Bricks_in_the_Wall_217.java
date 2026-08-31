import java.util.*;
import java.io.*;

public class B1421 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			char[][] arr = new char[n][];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.next().toCharArray();
			}
			ArrayList<int[]> o1 = new ArrayList<int[]>();
			ArrayList<int[]> o2 = new ArrayList<int[]>();
			if (arr[0][1] == '1') {
				o1.add(new int[] { 1, 2 });
			} else {
				o2.add(new int[] { 1, 2 });
			}
			if (arr[1][0] == '1') {
				o1.add(new int[] { 2, 1 });
			} else {
				o2.add(new int[] { 2, 1 });
			}
			if (arr[n - 1][n - 2] == '0') {
				o1.add(new int[] { n, n - 1 });
			} else {
				o2.add(new int[] { n, n - 1 });
			}
			if (arr[n - 2][n - 1] == '0') {
				o1.add(new int[] { n - 1, n });
			} else {
				o2.add(new int[] { n - 1, n });
			}
			if (o1.size() < o2.size()) {
				pw.println(o1.size());
				for (int[] x : o1) {
					pw.println(x[0] + " " + x[1]);
				}
			} else {
				pw.println(o2.size());
				for (int[] x : o2) {
					pw.println(x[0] + " " + x[1]);
				}
			}

		}
		pw.close();

	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader f) {
			br = new BufferedReader(f);
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public int[] nextIntArr(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(next());
			}
			return arr;
		}

	}

}
