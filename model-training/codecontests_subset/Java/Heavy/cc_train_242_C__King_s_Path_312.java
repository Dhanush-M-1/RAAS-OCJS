import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class KingsPath {
	static class P implements Comparable<P> {
		int x, y, c;

		public P(int xx, int yy) {
			x = xx;
			y = yy;
		}

		public P(int xx, int yy, int cc) {
			x = xx;
			y = yy;
			c = cc;
		}

		@Override
		public int compareTo(KingsPath.P o) {
			if (x == o.x)
				return y - o.y;
			return x - o.x;
		}

	}

	public static void main(String[] args) throws IOException {
		InputReader r = new InputReader(System.in);
		int x0 = r.nextInt();
		int y0 = r.nextInt();
		int x1 = r.nextInt();
		int y1 = r.nextInt();
		int n = r.nextInt();
		TreeSet<P> set = new TreeSet<P>();
		for (int i = 0; i < n; i++) {
			int row = r.nextInt();
			int a = r.nextInt();
			int b = r.nextInt();
			for (int j = a; j <= b; j++) {
				set.add(new P(row, j));
				P p = new P(row,j);
			}
		}
		TreeSet<P> visited = new TreeSet<P>();
		LinkedList<P> q = new LinkedList<P>();
		q.add(new P(x0, y0, 0));
		visited.add(new P(x0, y0, 0));
		int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dy = { -1, 0, 1, -1, 1, 1, 0, -1 };
		while (!q.isEmpty()) {
			P front = q.remove();
			if (front.x == x1 && front.y == y1) {
				System.out.println(front.c);
				return;
			}
			for (int k = 0; k < dx.length; k++) {
				int nx = front.x + dx[k];
				int ny = front.y + dy[k];
				P p = new P(nx, ny);
				
				if (visited.contains(p) || !set.contains(p))
					continue;
				visited.add(new P(nx,ny));
				p.c = front.c + 1;
				q.add(p);
			}
		}
		System.out.println(-1);
	}

	static class InputReader {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public InputReader(FileReader stream) {
			reader = new BufferedReader(stream);
			tokenizer = null;
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
