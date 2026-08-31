import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {

	public class Point {
		long x, y;
		int num;
		
		public Point(long x, long y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}

	long inf = 1000000000;
	long[] d = new long[100010];
	HashMap<Long, Point> hm = new HashMap<Long, Point>(200000);

	long key(long px, long py) {
		return (inf * (px - 1) + (py - 1));
	}
	
	void bfs(Point st) {
		ArrayDeque<Point> q = new ArrayDeque<Solution.Point>();
		q.addLast(st);
		d[st.num] = 0;
		long[] masx = {-1, -1, 0, 1, 1, 1, 0, -1}, masy = {0, 1, 1, 1, 0, -1, -1, -1};
		while (!q.isEmpty()) {
			Point from = q.pollFirst();
			for (int i = 0; i < 8; ++i) {
				long k = key(from.x + masx[i], from.y + masy[i]);
				if (hm.containsKey(k) && d[hm.get(k).num] == inf) {
					q.addLast(hm.get(k));
					d[hm.get(k).num] = d[from.num] + 1;
				}
			}
		}
	}

	void solve() throws IOException {
		int col = 0, distTo = 0;
		Point st = new Point (nextLong(), nextLong(), col++), 
				fin = new Point (nextLong(), nextLong(), 0);
		
		hm.put(key(st.x, st.y), st);
		if (!hm.containsKey(key(fin.x, fin.y))) {
			fin.num = col++;
			hm.put(key(fin.x, fin.y), fin);
			distTo = 1;
		}
		
		int n = nextInt();
		for (int i = 0; i < n; ++i) {
			long r = nextLong(), a = nextLong(), b = nextLong();
			for (long j = a; j <= b; ++j) {
				if (!hm.containsKey(key(r, j))) {
					hm.put(key(r, j), new Point(r, j, col++));
				}
			}
		}
		
		Arrays.fill(d, inf);
		bfs(st);
		
		if (d[distTo] == inf) {
			System.out.println(-1);
		} else {
			System.out.println(d[distTo]);
		}
	}

	BufferedReader br;
	StringTokenizer st;

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String s = br.readLine();
			if (s == null) {
				return "-1";
			}
			st = new StringTokenizer(s);
		}
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());

	}

	long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	void run() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		// out = new PrintWriter("path.out");
		solve();
		br.close();
		// out.close();
	}

	public static void main(String[] args) throws IOException {
		new Solution().run();
	}

}
