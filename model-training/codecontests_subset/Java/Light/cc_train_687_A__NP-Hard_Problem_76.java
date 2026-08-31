import java.io.*;
import java.util.*;

public class CF687A {
	static class V {
		ArrayList<V> list = new ArrayList<>();
		int color;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		V[] vv = new V[n];
		for (int i = 0; i < n; i++)
			vv[i] = new V();
		int m = Integer.parseInt(st.nextToken());
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			vv[u].list.add(vv[v]);
			vv[v].list.add(vv[u]);
		}
		LinkedList<V> q = new LinkedList<>();
		for (int i = 0; i < n; i++)
			if (vv[i].color == 0) {
				vv[i].color = 1;
				q.addLast(vv[i]);
				while (!q.isEmpty()) {
					V u = q.removeFirst();
					for (V v : u.list) {
						if (v.color == u.color) {
							System.out.println(-1);
							return;
						}
						if (v.color == 0) {
							v.color = 3 - u.color;
							q.addLast(v);
						}
					}
				}
			}
		int k1 = 0, k2 = 0;
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < n; i++)
			if (vv[i].color == 1) {
				k1++;
				sb1.append((i + 1) + " ");
			} else {
				k2++;
				sb2.append((i + 1) + " ");
			}
		System.out.println(k1);
		System.out.println(sb1);
		System.out.println(k2);
		System.out.println(sb2);
	}
}
