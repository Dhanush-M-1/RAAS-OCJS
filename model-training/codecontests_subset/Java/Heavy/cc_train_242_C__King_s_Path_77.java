import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class C {

	static int[] x = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] y = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int MAXN = 1000000000;

	static class Cell implements Comparable<Cell> {
		int x, y;

		Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Cell o) {
			if (x != o.x)
				return x - o.x;
			else
				return y - o.y;
		}

	}

	static boolean valid(int r, int c) {
		if (!set.contains(new Cell(r, c)))
			return false;
		return c <= MAXN && r <= MAXN && c >= 1 && r >= 1;
	}

	static Integer bfs(int r0, int c0, int rF, int cF) {
		TreeMap<Cell, Integer> dist = new TreeMap<Cell, Integer>();
		Queue<Cell> q = new LinkedList<Cell>();
		q.add(new Cell(r0, c0));
		dist.put(new Cell(r0, c0), 0);
		while (!q.isEmpty()) {
			Cell cur = q.remove();

			for (int k = 0; k < 8; k++) {
				int newR = cur.x + x[k];
				int newC = cur.y + y[k];
				if (valid(newR, newC)) {
					if (dist.get(new Cell(newR, newC)) == null) {
						dist.put(new Cell(newR, newC), dist.get(cur) + 1);
						q.add(new Cell(newR, newC));
					}
				}
			}
		}
		return dist.get(new Cell(rF, cF));
	}

	static TreeMap<Integer, Integer> min;
	static TreeMap<Integer, Integer> max;
	static TreeSet<Cell> set;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int x0 = sc.nextInt();
		int y0 = sc.nextInt();
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		set = new TreeSet<Cell>();

		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int row = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			for (int j = a; j <= b; j++)
				set.add(new Cell(row, j));
		}
		Integer sol = (bfs(x0, y0, x1, y1));
		if (sol == null)
			out.println(-1);
		else
			out.println(sol);

		out.flush();
		out.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}