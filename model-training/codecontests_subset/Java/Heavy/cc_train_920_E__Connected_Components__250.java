import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;



public class E {

	static StringTokenizer st;
	static BufferedReader br;
	static PrintWriter pw;
	static Set<Integer>[]ages;
	static int cnt, n;
	static Set<Integer> notUsed;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		n = nextInt();
		int m = nextInt();
		ages = new TreeSet[n+1];
		for (int i = 1; i <= n; i++) {
			ages[i] = new TreeSet<>();
		}
		for (int i = 1; i <= m; i++) {
			int v1 = nextInt();
			int v2 = nextInt();
			ages[v1].add(v2);
			ages[v2].add(v1);
		}
		ArrayList<Integer> ans = new ArrayList<>();
		notUsed = new TreeSet<>();
		for (int i = 1; i <= n; i++) {
			notUsed.add(i);
		}
		for (int i = 1; i <= n; i++) {
			if (notUsed.contains(i)) {
				cnt = 0;
				dfs(i);
				ans.add(cnt);
			}
		}
		Collections.sort(ans);
		pw.println(ans.size());
		for (int i : ans) {
			pw.print(i+" ");
		}
		pw.close();
	}
	private static void dfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		notUsed.remove(v);
		cnt = 1;
		ArrayList<Integer> removed = new ArrayList<>();
		while (!q.isEmpty()) {
			v = q.poll();
			for (int i : notUsed) {
				if (!ages[v].contains(i)) {
					q.add(i);
					removed.add(i);
					cnt++;
				}
			}
			for (int i : removed) {
				notUsed.remove(i);
			}
			removed.clear();
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