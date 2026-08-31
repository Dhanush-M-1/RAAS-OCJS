import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solutions {
	static Scanner in = new Scanner();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) throws NumberFormatException, IOException {
		int nodes = in.nextInt();
		int k = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		if (nodes == k || k == nodes - 1 || nodes == 4) {
			out.append("-1\n");
			out.close();
			return;
		}

		out.print(a + " " + c + " ");
		for (int i = 1; i <= nodes; i++) {
			if (i != a && i != b && i != c && i != d) {
				out.print(i + " ");
			}
		}
		out.print(d + " " + b);
		StringBuilder path2 = new StringBuilder();
		path2.append(c + " " + a + " ");
		for (int i = 1; i <= nodes; i++) {
			if (i != a && i != b && i != c && i != d) {
				path2.append(i + " ");
			}
		}
		path2.append(b + " " + d);
		out.println();
		out.print(path2);

		out.flush();
		out.close();
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		Scanner(String file) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(file));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}

	}

}
