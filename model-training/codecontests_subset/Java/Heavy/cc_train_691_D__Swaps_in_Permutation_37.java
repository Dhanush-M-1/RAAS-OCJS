import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;


public class D {

	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
	private static class V {
		private int idx;
		private int val;
		private ArrayList<V> ns = new ArrayList<V>();
	}
	
	public static void main(String[] args) throws IOException {
		String[] s = in.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		s = in.readLine().split(" ");
		V[] vs = new V[n];
		for (int i = 0; i < n; ++i) {
			vs[i] = new V();
			vs[i].idx = i;
			vs[i].val = Integer.parseInt(s[i]);
		}
		for (int i = 0; i < m; ++i) {
			s = in.readLine().split(" ");
			int u = Integer.parseInt(s[0]) - 1;
			int v = Integer.parseInt(s[1]) - 1;
			vs[u].ns.add(vs[v]);
			vs[v].ns.add(vs[u]);
		}
		int[] ans = new int[n];
		boolean[] seen = new boolean[n];
		for (int i = 0; i < n; ++i) {
			if (!seen[i]) {
				seen[i] = true;
				ArrayList<V> q = new ArrayList<V>();
				q.add(vs[i]);
				for (int j = 0; j < q.size(); ++j) {
					V curr = q.get(j);
					for (V next : curr.ns) {
						if (!seen[next.idx]) {
							seen[next.idx] = true;
							q.add(next);
						}
					}
				}
				int[] idxs = new int[q.size()];
				int[] vals = new int[q.size()];
				for (int j = 0; j < q.size(); ++j) {
					idxs[j] = q.get(j).idx;
					vals[j] = q.get(j).val;
				}
				Arrays.sort(idxs);
				Arrays.sort(vals);
				for (int j = 0; j < q.size(); ++j)
					ans[idxs[j]] = vals[q.size() - 1 - j];
			}
		}
		for (int curr : ans)
			out.print(curr + " ");
		out.println();
		out.flush();
	}

}
