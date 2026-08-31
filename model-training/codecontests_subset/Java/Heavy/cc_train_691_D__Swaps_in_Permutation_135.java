import java.io.*;
import java.util.*;

public class EC0014D {

	static int[] parent;
	static int[] rank;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] perm = new int[n];

		for (int i = 0; i < n; i++) {
			perm[i] = Integer.parseInt(st.nextToken());
		}

		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		rank = new int[n];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
		}

		ArrayList<Integer>[] sets = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			sets[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < n; i++) {
			sets[find(i)].add(i);
		}

		for (int i = 0; i < n; i++) {
			if (!sets[i].isEmpty()) {
				ArrayList<Integer> s = sets[i];
				int l = s.size();
				int[] permsub = new int[l];
				for (int j = 0; j < l; j++) {
					permsub[j] = perm[s.get(j)];
				}
				Arrays.sort(permsub);
				for (int j = 0; j < l; j++) {
					perm[s.get(j)] = permsub[l - 1 - j];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(perm[i]);
			if (i != n - 1) {
				sb.append(' ');
			}
		}
		System.out.println(sb);

	}

	static void union(int x, int y) {
		int rx = find(x);
		int ry = find(y);
		if (rx != ry) {
			if (rank[rx] < rank[ry]) {
				parent[rx] = ry;
			} else if (rank[rx] > rank[ry]) {
				parent[ry] = rx;
			} else {
				parent[ry] = rx;
				rank[rx]++;
			}
		}
	}

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

}
