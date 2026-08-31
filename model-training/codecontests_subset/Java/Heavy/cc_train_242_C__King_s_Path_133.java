import java.io.*;
import java.util.*;

public class C {

	void run() throws IOException {
		int m = 100000, h = 0, t = 0;
		int y_s = ni() - 1, x_s = ni() - 1, y_f = ni() - 1, x_f = ni() - 1;
		long inf = 1000000000;
		HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
		int[] u = new int[m], d = new int[m], l = new int[m], r = new int[m];
		int[] ul = new int[m], ur = new int[m], dl = new int[m], dr = new int[m];
		for (int i = 0; i < m; i++)
			ul[i] = ur[i] = dl[i] = dr[i] = u[i] = d[i] = l[i] = r[i] = -1;

		int k = ni();
		m = 0;
		for (int i = 0, cur; i < k; i++) {
			long y = ni() - 1, a = ni() - 1, b = ni() - 1;
			for (long j = a; j <= b; j++) {
				long c = inf * y + j;
				long left = c - 1;
				long right = c + 1;
				long up = inf * (y + 1) + j;
				long down = inf * (y - 1) + j;

				long tul = up - 1;
				long tur = up + 1;
				long tdl = down - 1;
				long tdr = down + 1;

				hm.put(c, m);
				if (j > 0 && hm.containsKey(left)) {
					cur = hm.get(left);
					r[cur] = m;
					l[m] = cur;
				}
				if (j + 1 < inf && hm.containsKey(right)) {
					cur = hm.get(right);
					l[cur] = m;
					r[m] = cur;
				}
				if (y + 1 < inf && hm.containsKey(up)) {
					cur = hm.get(up);
					d[cur] = m;
					u[m] = cur;
				}
				if (y > 0 && hm.containsKey(down)) {
					cur = hm.get(down);
					u[cur] = m;
					d[m] = cur;
				}

				if (y + 1 < inf && j > 0 && hm.containsKey(tul)) {
					cur = hm.get(tul);
					dr[cur] = m;
					ul[m] = cur;
				}
				if (y + 1 < inf && j + 1 < inf && hm.containsKey(tur)) {
					cur = hm.get(tur);
					dl[cur] = m;
					ur[m] = cur;
				}

				if (y > 0 && j > 0 && hm.containsKey(tdl)) {
					cur = hm.get(tdl);
					ur[cur] = m;
					dl[m] = cur;
				}
				if (y > 0 && j + 1 < inf && hm.containsKey(tdr)) {
					cur = hm.get(tdr);
					ul[cur] = m;
					dr[m] = cur;
				}
				m++;
			}
		}
		int[] q = new int[m];
		long[] p = new long[m];
		Arrays.fill(p, inf);
		int finish = hm.get(x_f + y_f * inf);
		int start = hm.get(x_s + y_s * inf);
		p[start] = 0;
		q[h++] = start;
		while (h != t) {
			int i = q[t++];
			long v = p[i] + 1;
			if (u[i] != -1 && v < p[u[i]]) {
				p[u[i]] = v;
				q[h++] = u[i];
			}
			if (d[i] != -1 && v < p[d[i]]) {
				p[d[i]] = v;
				q[h++] = d[i];
			}

			if (r[i] != -1 && v < p[r[i]]) {
				p[r[i]] = v;
				q[h++] = r[i];
			}
			if (l[i] != -1 && v < p[l[i]]) {
				p[l[i]] = v;
				q[h++] = l[i];
			}
			if (ul[i] != -1 && v < p[ul[i]]) {
				p[ul[i]] = v;
				q[h++] = ul[i];
			}
			if (dl[i] != -1 && v < p[dl[i]]) {
				p[dl[i]] = v;
				q[h++] = dl[i];
			}

			if (dr[i] != -1 && v < p[dr[i]]) {
				p[dr[i]] = v;
				q[h++] = dr[i];
			}
			if (ur[i] != -1 && v < p[ur[i]]) {
				p[ur[i]] = v;
				q[h++] = ur[i];
			}

		}
		long z = p[finish];
		if (z == inf)
			z = -1;
		pw.print(z);

	}

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	int ni() throws IOException {
		return Integer.parseInt(next());
	}

	String nl() throws IOException {
		return br.readLine();
	}

	PrintWriter pw;
	BufferedReader br;
	StringTokenizer st;

	public static void main(String[] args) throws IOException {
		long timeout = System.currentTimeMillis();
		boolean CF = System.getProperty("ONLINE_JUDGE") != null;
		PrintWriter _pw = new PrintWriter(System.out);
		BufferedReader _br = new BufferedReader(CF ? new InputStreamReader(System.in) : new FileReader(new File("in.txt")));
		new C(_br, _pw).run();
		if (!CF) {
			_pw.println();
			_pw.println(System.currentTimeMillis() - timeout);
		}
		_br.close();
		_pw.close();
	}

	public C(BufferedReader _br, PrintWriter _pw) {
		br = _br;
		pw = _pw;
	}
}
