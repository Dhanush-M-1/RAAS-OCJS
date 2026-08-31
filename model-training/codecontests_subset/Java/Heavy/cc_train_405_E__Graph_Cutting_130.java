import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class E {
	static ArrayList<Integer>[] graph;
	static Set<Integer>[] map;
	static PrintWriter bw;
	static boolean [] vis;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		bw = new PrintWriter(System.out);
		String[] tokens = bf.readLine().split(" ");
		int n = Integer.parseInt(tokens[0]);
		graph = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++)
			graph[i] = new ArrayList<Integer>();
		int m = Integer.parseInt(tokens[1]);
		if (m % 2 == 1) {
			System.out.println("No solution");
			return;
		}
		for (int i = 0; i < m; i++) {
			tokens = bf.readLine().split(" ");
			int u = Integer.parseInt(tokens[0]);
			int v = Integer.parseInt(tokens[1]);
			graph[u].add(v);
			graph[v].add(u);
		}
		map = new Set[n + 1];
		for (int i = 1; i <= n; i++)
			map[i] = new HashSet<Integer>();
		vis = new boolean [n+1];
		solve(n);
		bw.close();
	}

	private static int solve(int u) throws IOException {
		// TODO Auto-generated method stub
		if(vis[u])return 0;
		vis[u] = true;
		ArrayList<Integer> available = new ArrayList<Integer>();
		for (int v : graph[u]){
			if(!map[u].contains(v)&&!map[v].contains(u)){
				map[u].add(v);
				available.add(v);
			}
		}
		Queue<Integer> unpaired = new LinkedList<Integer>();
		for (int v : available) {
			int w = solve(v);
			if (w == 0) {
				unpaired.add(v);
			} else {
				bw.println(u + " " + v + " " + w);
			}
		}
		while (unpaired.size() >= 2) {
			bw.println(unpaired.poll() + " " + u + " "
					+ unpaired.poll());
		}
		if (!unpaired.isEmpty())
			return unpaired.poll();
		return 0;
	}
}
