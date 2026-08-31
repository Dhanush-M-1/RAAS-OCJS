import java.io.*;
import java.util.*;

public class B {

	static ArrayList<Integer>[] adj;
	static boolean[] visited;

	static void dfs(int u) {
		visited[u] = true;
		for (int v : adj[u])
			if (!visited[v])
				dfs(v);
	}

	static int cnt(int a, int b) {
		Arrays.fill(visited, false);
		visited[b] = true;
		dfs(a);
		int ans = 0;
		for (int i = 0; i < visited.length; i++)
			if (!visited[i])
				ans++;
		return ans;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int n = sc.nextInt(), m = sc.nextInt(), a = sc.nextInt() - 1, b = sc.nextInt() - 1;
			adj = new ArrayList[n];
			visited = new boolean[n];
			for (int i = 0; i < n; i++) {
				adj[i] = new ArrayList();
			}
			while (m-- > 0) {
				int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
				adj[u].add(v);
				adj[v].add(u);
			}
			out.println(cnt(a, b) * 1L * cnt(b, a));
		}
		out.close();

	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		Scanner(String fileName) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(fileName));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}

	static void sort(int[] a) {
		shuffle(a);
		Arrays.sort(a);
	}

	static void shuffle(int[] a) {
		int n = a.length;
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			int tmpIdx = rand.nextInt(n);
			int tmp = a[i];
			a[i] = a[tmpIdx];
			a[tmpIdx] = tmp;
		}
	}

}