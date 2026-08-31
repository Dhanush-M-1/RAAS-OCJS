import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class B {

	static StringTokenizer st;
	static BufferedReader br;
	static PrintWriter pw;
	static ArrayList<Integer> []ages;
	static int[]size;
	static ArrayList<Integer> ans;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = nextInt();
		ages = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			ages[i] = new ArrayList<>();
		}
		size = new int[n+1];
		for (int i = 1; i <= n; i++) {
			int pi = nextInt();
			if (pi != 0) {
				ages[pi].add(i);
				ages[i].add(pi);
				size[pi]++;
				size[i]++;
			}
		}
		ans = new ArrayList<>();
		int root = 1;
		for (int i = 2; i <= n; i++) {
			if (size[i] % 2==0)
				root = i;
		}
		dfs(root, 0);
		for (int i = 1; i <= n; i++) {
			if (size[i] > 0) {
				System.out.println("NO");
				return;
			}
		}
		boolean[]used = new boolean[n+1];
		for (int i : ans) {
			used[i] = true;
		}
		for (int i = 1; i <= n; i++) {
			if (!used[i])
				ans.add(i);
		}
		pw.println("YES");
		for (int i : ans) {
			pw.println(i);
		}
		
		pw.close();
	}
	private static void dfs(int v, int p) {
		for (int to : ages[v]) {
			if (to==p)
				continue;
			dfs(to, v);
		}
		if (size[v] % 2==0) {
			dfs2(v, p);
		}
	}
	private static void dfs2(int v, int p) {
		size[v] = 0;
		ans.add(v);
		for (int to : ages[v]) {
			if (size[to]==0)
				continue;
			size[to]--;
		}
		for (int to : ages[v]) {
			if (to==p || size[to]==0)
				continue;
			if (size[to]%2==0) {
				dfs2(to, v);
			}
		}
	}
	private static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	private static long nextLong() throws IOException {
		return Long.parseLong(next());
	}
	private static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
	private static String next() throws IOException {
		while (st==null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
}
