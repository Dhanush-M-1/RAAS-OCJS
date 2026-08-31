import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class K3 {
	static Scanner in = new Scanner();
	static ArrayList<Edge> adj[];
	static int n, m;
	static boolean EdgeVis[];
	static LinkedList<Triple> ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		/**
		 * Given a simple graph G has |E(G)| = m , if m = 0 (mod 2) <=> G has
		 * paratition into P2 (We can prove that By contradiction) We can solve
		 * this problem by L(G) such that L(G) is line graph but TLE We solve
		 * problem By Good DFS ! O(V+E) linear time Generally , paratition
		 * problem is NP problem :D
		 **/
		n = in.nextInt();
		m = in.nextInt();
		adj = new ArrayList[n];
		EdgeVis = new boolean[m];
		ans = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			int u = in.nextInt() - 1;
			int v = in.nextInt() - 1;
			adj[u].add(new Edge(v, i));
			adj[v].add(new Edge(u, i));
		}
		if (m % 2 != 0) {
			System.out.println("No solution");
			System.exit(0);
		}
		dfs(0);
		for (Triple triple : ans) {
			System.out.println(triple);
		}

	}

	static int dfs(int node) {
		ArrayList<Integer> arroud = new ArrayList<>();
		for (Edge e : adj[node]) {
			if (!EdgeVis[e.id]) {
				arroud.add(e.to);
				EdgeVis[e.id] = true;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for (Integer u : arroud) {
			int ret = dfs(u);
			if (ret == -1) {
				q.add(u);
			} else {
				/*
				 * P2 iso 
				 *    node_____u______ret
				 */
				ans.add(new Triple(node, u, ret));
			}
		}
		while (q.size() >= 2) {
			int poll1 = q.poll();
			int poll2 = q.poll();
			/*
			 * P2 iso
			 *      node
			 *     /   \
			 *    /     \
			 *   poll1   poll2
			 */
			ans.add(new Triple(poll1, node, poll2));
		}
		if (q.size() == 1) {
			return q.poll();
		}
		return -1;
	}

	static class Triple {
		int a, b, c;

		public Triple(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public String toString() {
			return (a + 1) + " " + (b + 1) + " " + (c + 1);
		}

	}

	static class Edge {
		int to, id;

		public Edge(int to, int id) {
			this.to = to;
			this.id = id;
		}

	}

	static class Scanner {// Fast I/O
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
