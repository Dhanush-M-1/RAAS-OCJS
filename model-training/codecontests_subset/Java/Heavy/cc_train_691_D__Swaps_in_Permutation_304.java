import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SwapsInPermutation {
	static boolean[] vis;

	public static void main(String[] args) throws Exception {
		InputReader r = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = r.nextInt();
		int m = r.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt();
		}
		ArrayList<Integer>[] adj = new ArrayList[n];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int from = r.nextInt() - 1;
			int to = r.nextInt() - 1;
			adj[from].add(to);
			adj[to].add(from);
		}
		vis = new boolean[n];
		for (int i = 0; i < arr.length; i++) {
			if (!vis[i]) {
				vis[i] = true;
				Queue<Integer> q = new LinkedList<Integer>();
				q.add(i);
				PriorityQueue<Integer> numbers = new PriorityQueue<Integer>();
				TreeSet<Integer> indices = new TreeSet<Integer>();
				while (!q.isEmpty()) {
					int front = q.remove();
					indices.add(front);
					numbers.add(-arr[front]);
					for (int x : adj[front]) {
						if (!vis[x]) {
							q.add(x);
							vis[x] = true;
						}
					}
				}
				for (int x : indices)
					arr[x] = -numbers.poll();
			}
		}
		for (int x : arr)
			out.println(x);
		out.close();
	}

	static class InputReader {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public InputReader(FileReader stream) {
			reader = new BufferedReader(stream);
			tokenizer = null;
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
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

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
