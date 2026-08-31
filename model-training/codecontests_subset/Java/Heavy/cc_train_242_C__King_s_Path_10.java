import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main implements Runnable {

	public static final int INF = Integer.MAX_VALUE / 2;

	class cell {

		int x;
		int y;

		public cell(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			cell other = (cell) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		private Main getOuterType() {
			return Main.this;
		}

	}

	private void solve() throws IOException {
		int x0 = nextInt();
		int y0 = nextInt();
		int x1 = nextInt();
		int y1 = nextInt();
		int n = nextInt();
		HashSet<cell> map1 = new HashSet<cell>();
		HashMap<cell, Integer> map2 = new HashMap<cell, Integer>();
		for (int i = 0; i < n; ++i) {
			int r = nextInt();
			int a = nextInt();
			int b = nextInt();
			for (int k = a; k <= b; ++k) {
				map1.add(new cell(r, k));
			}
		}
		// for(cell c: map1){
		// out.println( c.x +" , " +c.y );
		// }
		Queue<cell> q = new ArrayDeque<cell>();
		cell first = new cell(x0, y0);
		q.add(first);
		map2.put(new cell(x0, y0), 0);
		while (!q.isEmpty()) {
			cell c = q.remove();
//			out.println("saque " + c.x + " , " + c.y);
			int v = map2.get(c) + 1;
			if (map1.contains(new cell(c.x + 1, c.y))) {
				if (!map2.containsKey(new cell(c.x + 1, c.y))) {
					map2.put(new cell(c.x + 1, c.y), v);
					q.add(new cell(c.x + 1, c.y));
				}
			}
			if (map1.contains(new cell(c.x - 1, c.y))) {
				if (!map2.containsKey(new cell(c.x - 1, c.y))) {
					map2.put(new cell(c.x - 1, c.y), v);
					q.add(new cell(c.x - 1, c.y));
				}
			}
			if (map1.contains(new cell(c.x, c.y + 1))) {
				if (!map2.containsKey(new cell(c.x, c.y + 1))) {
					map2.put(new cell(c.x, c.y + 1), v);
					q.add(new cell(c.x, c.y + 1));
				}
			}
			if (map1.contains(new cell(c.x, c.y - 1))) {
				if (!map2.containsKey(new cell(c.x, c.y - 1))) {
					map2.put(new cell(c.x, c.y - 1), v);
					q.add(new cell(c.x, c.y - 1));
				}
			}
			// -
			if (map1.contains(new cell(c.x + 1, c.y + 1))) {
				if (!map2.containsKey(new cell(c.x + 1, c.y + 1))) {
					map2.put(new cell(c.x + 1, c.y + 1), v);
					q.add(new cell(c.x + 1, c.y + 1));
				}
			}
			if (map1.contains(new cell(c.x - 1, c.y - 1))) {
				if (!map2.containsKey(new cell(c.x - 1, c.y - 1))) {
					map2.put(new cell(c.x - 1, c.y - 1), v);
					q.add(new cell(c.x - 1, c.y - 1));
				}
			}
			if (map1.contains(new cell(c.x - 1, c.y + 1))) {
				if (!map2.containsKey(new cell(c.x - 1, c.y + 1))) {
					map2.put(new cell(c.x - 1, c.y + 1), v);
					q.add(new cell(c.x - 1, c.y + 1));
				}
			}
			if (map1.contains(new cell(c.x + 1, c.y - 1))) {
				if (!map2.containsKey(new cell(c.x + 1, c.y - 1))) {
					map2.put(new cell(c.x + 1, c.y - 1), v);
					q.add(new cell(c.x + 1, c.y - 1));
				}
			}
		}

		if (map2.containsKey(new cell(x1, y1))) {
			out.println(map2.get(new cell(x1, y1)));
		} else {
			out.println(-1);
		}
	}

	private BufferedReader in;
	private PrintWriter out;
	private StringTokenizer st;
	private String FNAME = "";

	private void eat(String s) {
		st = new StringTokenizer(s);
	}

	String next() throws IOException {
		while (!st.hasMoreTokens()) {
			String line = in.readLine();
			if (line == null) {
				return null;
			}
			eat(line);
		}
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	public static void main(String[] args) throws IOException {
		new Thread(null, new Main(), "Main", 1 << 25).start();
	}

	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(new OutputStreamWriter(System.out));
			// in = new BufferedReader(new FileReader(FNAME + ".in"));
			// out = new PrintWriter(new FileWriter(FNAME + ".out"));
			eat("");
			solve();
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(586);
		}
	}

}
