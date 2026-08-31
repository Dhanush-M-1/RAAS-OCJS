import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader reader;
	static StringTokenizer tokenizer;
	static PrintWriter writer;

	static int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	static double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	static boolean eof = false;

	static String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	public static void main(String[] args) throws IOException {
		tokenizer = null;
		// reader = new BufferedReader(new FileReader("grave.in"));
		// writer = new PrintWriter(new FileWriter("grave.out"));
		reader = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
		writer = new PrintWriter(System.out);
		banana();
		reader.close();
		writer.close();
	}

	static List<ArrayList<Edge>> g = new ArrayList<ArrayList<Edge>>();

	static class Edge {
		int to, weight;

		public Edge(int _to, int _w) {
			to = _to;
			weight = _w;
		}
	}

	static long size[];
	static boolean used[];

	static void sizedfs(int v) {
		size[v] = 1;
		used[v] = true;
		for (int i = 0; i < g.get(v).size(); ++i) {
			int to = g.get(v).get(i).to;

			if (!used[to]) {
				sizedfs(to);
				size[v] += size[to];
			}
		}
	}

	static void banana() throws IOException {
		int n = nextInt();
		int m = nextInt();

		int a[] = new int[n];
		for (int i = 0; i < n; ++i)
			a[i] = nextInt();

		boolean used[] = new boolean[n + 1];
		int b[] = new int[m];
		for (int j = 0; j < m; ++j) {
			b[j] = nextInt();
		}

		List<Integer> x = new ArrayList<Integer>();
		for (int i = 0; i < m; ++i) {
			if (!used[b[i]]) {
				x.add(b[i]);
				used[b[i]] = true;
			}
		}
		Collections.reverse(x);
		int sum = 0;
		for (int i = 0; i < m; ++i) {
			for (int j = x.size() - 1; j >= 0; --j) {
				int cur = x.get(j);
				if (cur == b[i]) {
					x.remove(j);
					x.add(cur);
					break;
				} else
					sum += a[cur - 1];
			}
		}

		System.out.println(sum);
	}
}