// upsolve with rainboy
import java.io.*;
import java.util.*;

public class CF920E {
	static ArrayList[] vv;
	static TreeSet<Integer> s = new TreeSet<>();
	@SuppressWarnings("unchecked")
	static int dfs(int i) {
		ArrayList<Integer> list = vv[i];
		int m = list.size(), size = 1;
		for (int h = 0; h < m - 1; h++) {
			int p = list.get(h), q = list.get(h + 1);
			while (true) {
				Integer j = s.higher(p);
				if (j == null || j >= q)
					break;
				s.remove(j);
				size += dfs(j);
			}
		}
		return size;
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		vv = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			vv[i] = new ArrayList<Integer>();
			vv[i].add(-1);
			vv[i].add(n);
		}
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			vv[i].add(j);
			vv[j].add(i);
		}
		for (int i = 0; i < n; i++)
			Collections.sort(vv[i]);
		for (int i = 0; i < n; i++)
			s.add(i);
		ArrayList<Integer> cc = new ArrayList<>();
		while (!s.isEmpty()) {
			int i = s.pollFirst();
			cc.add(dfs(i));
		}
		pw.println(cc.size());
		Collections.sort(cc);
		for (int c : cc)
			pw.print(c + " ");
		pw.println();
		pw.close();
	}
}
