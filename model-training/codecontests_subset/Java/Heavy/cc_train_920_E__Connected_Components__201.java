import java.io.*;
import java.util.*;

public class Main {

	public static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32765);
			tokenizer = null;
		}

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(System.in), 32765);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public char nextChar() {
			return next().charAt(0);
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int[] nextIntArr(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = this.nextInt();
			}
			return arr;
		}

		public Integer[] nextIntegerArr(int n) {
			Integer[] arr = new Integer[n];
			for (int i = 0; i < n; i++) {
				arr[i] = new Integer(this.nextInt());
			}
			return arr;
		}

		public int[][] next2DIntArr(int n, int m) {
			int[][] arr = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = this.nextInt();
				}
			}
			return arr;
		}

		public int[] nextSortedIntArr(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = this.nextInt();
			}
			Arrays.sort(arr);
			return arr;
		}

		public long[] nextLongArr(int n) {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = this.nextLong();
			}
			return arr;
		}

		public long[] nextSortedLongArr(int n) {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = this.nextInt();
			}
			Arrays.sort(arr);
			return arr;
		}

		public char[] nextCharArr(int n) {
			char[] arr = new char[n];
			for (int i = 0; i < n; i++) {
				arr[i] = this.nextChar();
			}
			return arr;
		}
	}

	public static InputReader scn = new InputReader();
	public static PrintWriter out = new PrintWriter(System.out);

	public static TreeSet<Integer>[] gr;
	public static TreeSet<Integer> set = new TreeSet<>();
	public static int scc = 0, n;

	public static void main(String[] args) {
		// InputStream inputStream = System.in; // Useful when taking input other than
		// console eg file handling // check ctor of inputReader
		// To print in file use this:- out = new PrintWriter("destination of file")
		// including extension");
//		System.out.println("GO");

		n = scn.nextInt();
		int m = scn.nextInt();
		gr = new TreeSet[n + 1];
		for (int i = 1; i <= n; i++) {
			gr[i] = new TreeSet<>();
			set.add(i);
		}
		while (m-- > 0) {
			int u = scn.nextInt(), v = scn.nextInt();
			gr[u].add(v);
			gr[v].add(u);
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (!set.contains(i)) {
				continue;
			}
			scc = 0;
			dfs(i);
			ans.add(scc);
		}

		Collections.sort(ans);
		out.println(ans.size());
		for (Integer x : ans) {
			out.print(x + " ");
		}
		out.println();
		out.close();
	}

	public static void dfs(int u) {
		scc++;
		set.remove(u);
		boolean ok = true;
		while (ok) {
			ok = false;
			for (int i : set) {
				if (set.contains(i) && !gr[u].contains(i)) {
					dfs(i);
					ok = true;
					break;
				}
			}
		}
	}
}
