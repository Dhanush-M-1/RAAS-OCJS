import java.io.*;
import java.util.*;

public class CF1136D {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] pp = new int[n];
		for (int i = 0; i < n; i++)
			pp[i] = Integer.parseInt(st.nextToken()) - 1;
		ArrayList[] adj = new ArrayList[n];
		for (int u = 0; u < n; u++)
			adj[u] = new ArrayList<Integer>();
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			adj[v].add(u);
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> list = adj[pp[n - 1]];
		for (int u : list)
			map.put(u, 1);
		int ans = 0, cnt = 1;
		for (int i = n - 2; i >= 0; i--) {
			int u = pp[i];
			if (map.getOrDefault(u, 0) == cnt)
				ans++;
			else {
				cnt++;
				list = adj[u];
				for (int u_ : list)
					map.put(u_, map.getOrDefault(u_, 0) + 1);
			}
		}
		System.out.println(ans);
	}
}
