import java.util.*;
import java.io.*;
public class e {
	static int n, m, a, b;
	static ArrayDeque[] edges;
	static boolean[] seen;
	public static void main(String[] args) {
		FS sc = new FS();
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		for(int tt = 1; tt <= t; ++tt) {
			n = sc.nextInt();
			m = sc.nextInt();
			a = sc.nextInt() - 1;
			b = sc.nextInt() - 1;

			edges = new ArrayDeque[n];
			for(int i = 0; i < n; ++i) edges[i] = new ArrayDeque<>();
			for(int i = 0; i < m; ++i) {
				int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
				edges[u].add(v);
				edges[v].add(u);
			}

			seen = new boolean[n];
			long sumX = 0;
			seen[a] = true;
			for(int next : (ArrayDeque<Integer>) edges[a]) {
				if(seen[next]) continue;
				int add = dfs(next, b);
				if(add != -1) sumX += add;
			}

			seen = new boolean[n];
			long sumY = 0;
			seen[b] = true;
			for(int next : (ArrayDeque<Integer>) edges[b]) {
				if(seen[next]) continue;
				int add = dfs(next, a);
				if(add != -1) sumY += add;
			}
			
			long out = (long)sumX * sumY;
			pw.println(out);
		}
		pw.flush();
	}
	static int dfs(int idx, int flag) {
		seen[idx] = true;
		int out = 1;
		boolean seenFlag = false;
		if(idx == flag) seenFlag = true;
		for(int next : (ArrayDeque<Integer>) edges[idx]) {
			if(!seen[next]) {
				int get = dfs(next, flag);
				if(get == -1) seenFlag = true;
				out += get;
			}
		}
		if(seenFlag) return -1;
		return out;
	}
	static class FS {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		String next() {
			while(!st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(Exception e) {}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
}