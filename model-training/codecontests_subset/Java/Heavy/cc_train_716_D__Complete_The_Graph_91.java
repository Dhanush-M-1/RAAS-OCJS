import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class D {

	static StringTokenizer st;
	static BufferedReader br;
	static PrintWriter pw;
	static int[][]a;
	static int[][]b;
	static long[]d;
	static int n;
	static int[]q;
	static int[][]ages;
	static int[]size, p, v1, v2, w;
	static int qsize;
	static long[]D;
	static int m;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		n = nextInt();
		m = nextInt();
		int L = nextInt();
		int s = nextInt();
		int t = nextInt();
		s++;
		t++;
		a = new int[n+1][n+1];
		b = new int[n+1][n+1];
		q = new int[8*n+1];
		D = new long[8*n+1];
		v1 = new int[m+1];
		v2 = new int[m+1];
		w = new int[m+1];
		size = new int[n+1];
		p = new int[n+1];
		for (int i = 1; i <= m; i++) {
			v1[i] = nextInt();
			v2[i] = nextInt();
			v1[i]++;
			v2[i]++;
			size[v1[i]]++;
			size[v2[i]]++;
			w[i] = nextInt();
			if (w[i]==0)
				w[i] = -1;
			b[v1[i]][v2[i]] = b[v2[i]][v1[i]] = w[i];
		}
		ages = new int[n+1][];
		for (int i = 1; i <= n; i++) {
			ages[i] = new int[size[i]+1];
		}
		for (int i = 1; i <= n; i++) {
			size[i] = 0;
		}
		for (int i = 1; i <= m; i++) {
			ages[v1[i]][size[v1[i]]] = v2[i];
			ages[v2[i]][size[v2[i]]] = v1[i];
			
			size[v1[i]]++;
			size[v2[i]]++;
		}
		d = new long[n+1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a[i][j] = b[i][j];
				if (b[i][j]==-1)
					a[i][j] = 0;
			}
		}
		int INF = (int) (1e9+7);
		if (Dikstra(s, t, 1) > L || Dikstra(s, t, INF) < L) {
			System.out.println("NO");
			return;
		}
		int left = 0, right = INF;
		while (right-left > 1) {
			int mid = (left+right) >> 1;
			long shortes = Dikstra(s, t, mid);
			if (shortes > L)
				right = mid;
			else
				left = mid;
		}
		if (left==0) {
			System.out.println("NO");
			return;
		}
		int v = t;
		Dikstra(s, t, left);
		int need = (int) (L - d[t]);
		while (v != s) {
			if (a[p[v]][v]==left && b[p[v]][v]==-1) {
				b[p[v]][v] = b[v][p[v]] = 0;
				if (need > 0) {
					a[p[v]][v] = a[v][p[v]] = left+1;
					need--;
				}
			}
			v = p[v];
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (b[i][j]==-1)
					a[i][j] = INF;
			}
		}
		pw.println("YES");
		for (int i = 1; i <= n; i++) {
			for (int j = i+1; j <= n; j++) {
				if (a[i][j]==0)
					continue;
				pw.println((i-1)+" "+(j-1)+" "+a[i][j]);
			}
		}
		pw.close();
	}
	private static long Dikstra(int s, int t, int x) {
		for (int i = 1; i <= m; i++) {
			if (w[i]==-1)
				a[v1[i]][v2[i]] = a[v2[i]][v1[i]] = x;
		}
		long INF = (long) 1e18;
		Arrays.fill(d, INF);
		qsize = 0;
		d[s] = 0;
		add(s);
		boolean[]used = new boolean[n+1];
		Arrays.fill(p, 0);
		while (qsize >  0) {
			int v = pop();
			if (used[v])
				continue;
			used[v] = true;
			for (int i = 0; i < size[v]; i++) {
				int to = ages[v][i];
				if (a[v][to] != 0 && d[v] + a[v][to] < d[to]) {
					d[to] = d[v] + a[v][to];
					p[to] = v;
					add(to);
				}
			}
		}
		return d[t];
	}

	private static void add(int x) {
		q[++qsize] = x;
		D[qsize] = d[x];
		int v = qsize;
		while (v > 1) {
			if (D[v] < D[v >> 1]) {
				int t = q[v];
				q[v] = q[v >> 1];
				q[v >> 1] = t;
				long w = D[v];
				D[v] = D[v >> 1];
				D[v >> 1] = w;
				v >>= 1;
			}
			else
				break;
		}
	}
	
	private static int pop() {
		int res = q[1];
		q[1] = q[qsize];
		D[1] = D[qsize];
		qsize--;
		int v = 1;
		while (2*v <= qsize) {
			int min_id = v;
			if (D[2*v] < D[min_id])
				min_id = 2*v;
			if (2*v+1 <= qsize && D[2*v+1] < D[min_id])
				min_id = 2*v+1;
			if (min_id==v)
				break;
			int t = q[v];
			q[v] = q[min_id];
			q[min_id] = t;
			long w = D[v];
			D[v] = D[min_id];
			D[min_id] = w;
			v = min_id;
		}
		return res;
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