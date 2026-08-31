import java.awt.Container;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Civilization {

	public static int parent[];
	public static ArrayList<Integer> graph[];

	public static int find(int i) {
		if (parent[i] == i)
			return i;
		else
			return parent[i] = find(parent[i]);
	}

	public static int dp[];

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)
			return;

		dp[x] = Math.max(Math.max(dp[x], dp[y]), (dp[x] + 1) / 2 + (dp[y] + 1)
				/ 2 + 1);
		parent[y] = x;

	}

	public static int node = -1;
	public static int longest = -1;

	public static int ways[];

	public static void bfs(int i, int depth, int n, int w) {
		parent[i] = n;
		ways[i] = w;
		if (longest < depth) {

			longest = depth;
			node = i;

		}

		for (int j = 0; j < graph[i].size(); j++) {
			int node2 = graph[i].get(j);
			if (ways[node2] != w) {
				bfs(node2, depth + 1, n, w);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder qq = new StringBuilder();
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		String y[] = in.readLine().split(" ");
		int n = Integer.parseInt(y[0]);
		int m = Integer.parseInt(y[1]);
		int q = Integer.parseInt(y[2]);
		graph = new ArrayList[n + 1];
		parent = new int[n + 1];
		dp = new int[n + 1];
		ways=new int[n+1];

		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList();
			parent[i] = i;

		}

		for (int i = 0; i < m; i++) {
			y = in.readLine().split(" ");
			int one = Integer.parseInt(y[0]);
			int two = Integer.parseInt(y[1]);
			graph[one].add(two);
			graph[two].add(one);
		}
		for (int i = 1; i <= n; i++) {
			int p = find(i);
			if (p == i) {
				bfs(i, 0, i,1);
				longest = -1;
				bfs(node, 0, i,2);
				dp[p] = longest;
				longest = -1;

			}
		}
		for (int i = 0; i < q; i++) {
			y = in.readLine().split(" ");

			int on = Integer.parseInt(y[0]);
			if (on == 1)
				qq.append(dp[find(Integer.parseInt(y[1]))] + "\n");
			else
				union(Integer.parseInt(y[1]), Integer.parseInt(y[2]));

		}
		System.out.print(qq);
	}
}
