import java.io.BufferedReader; 
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution implements Runnable {
	private BufferedReader br;
	private StringTokenizer tok;
	private PrintWriter out;
	
	static final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
	
	static class Point {
		int x;
		int cnt;
		
		Point(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}
	
	static class Pair implements Comparable<Pair> {
		int x, y;
		int d;
		
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			if (x != o.x)
				return x - o.x;
			return y - o.y;
		}
	}
	
	TreeMap<Integer, ArrayList<Point>> pointMap;
	
	boolean isGoodPoint(int x, int y) {
		if (!pointMap.containsKey(x))
			return false;
		int l = 0, r = pointMap.get(x).size() - 1;
		if (y < pointMap.get(x).get(l).x)
			return false;
		while (l < r) {
			int m = (l + r) >> 1;
			if (y > pointMap.get(x).get(m).x) {
				l = m + 1;
			} else {
				r = m;
			}
		}
	//	out.print(" " + pointMap.get(x).get(l).x + " ");
		while (pointMap.get(x).get(l).x > y) {
			--l;
		}
		return pointMap.get(x).get(l).cnt > 0;
	}
			
	void solve() throws IOException {
		int x0 = nextInt();
		int y0 = nextInt();
		int x1 = nextInt();
		int y1 = nextInt();
		int n = nextInt();
		TreeMap<Integer, TreeMap<Integer, Integer>> myMap = new TreeMap<Integer, TreeMap<Integer, Integer>>();
		for (int i = 0; i < n; ++i) {
			int r = nextInt();
			int a = nextInt();
			int b = nextInt() + 1;
			if (!myMap.containsKey(r)) {
				myMap.put(r, new TreeMap<Integer, Integer>());
			}
			if (myMap.get(r).containsKey(a)) {
				int value = myMap.get(r).get(a);
				myMap.get(r).remove(a);
				myMap.get(r).put(a, value + 1);
			} else {
				myMap.get(r).put(a, 1);
			}
			if (myMap.get(r).containsKey(b)) {
				int value = myMap.get(r).get(b);
				myMap.get(r).remove(b);
				myMap.get(r).put(b, value - 1);
			} else {
				myMap.get(r).put(b, -1);
			}
		}
		pointMap = new TreeMap<Integer, ArrayList<Point>>();
		for (Map.Entry<Integer, TreeMap<Integer, Integer>> entry : myMap.entrySet()) {
			ArrayList<Point> ap = new ArrayList<Point>();
			int add = 0;
			for (Map.Entry<Integer, Integer> currentEntry : entry.getValue().entrySet()) {
				ap.add(new Point(currentEntry.getKey(), add + currentEntry.getValue()));
				add += currentEntry.getValue();
			}
			pointMap.put(entry.getKey(), ap);
		}
	/*	for (Map.Entry<Integer, ArrayList<Point>> entry : pointMap.entrySet()) {
			out.println(entry.getKey());
			for (int i = 0; i < entry.getValue().size(); ++i) {
				out.print(entry.getValue().get(i).x + " " + entry.getValue().get(i).cnt + "|");
			}
			out.println();
		}*/
		Queue<Pair> q = new LinkedList<Pair>();
		TreeSet<Pair> checkSet = new TreeSet<Pair>();
		int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
		int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
		q.add(new Pair(x0, y0));
		checkSet.add(new Pair(x0, y0));
		while (!q.isEmpty()) {
			Pair p = q.poll();
			if (p.x == x1 && p.y == y1) {
				out.print(p.d);
				return;
			}
			for (int i = 0; i < 8; ++i) {
				Pair np = new Pair(p.x + dx[i], p.y + dy[i]);
				np.d = p.d + 1;
				if (!checkSet.contains(np) && isGoodPoint(np.x, np.y)) {
					checkSet.add(np);
					q.add(np);
				}
			}
		}
		out.print(-1);
	}
		
	public void run() {
		try {
			if (ONLINE_JUDGE) {
				br = new BufferedReader(new InputStreamReader(System.in));
				out = new PrintWriter(System.out);
			} else {
				br = new BufferedReader(new FileReader(new File("input.txt")));
				out = new PrintWriter(new File("output.txt"));
			}
			solve();
			br.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void main(String[] args) {
		new Solution().run();
	}	
	
	String nextToken() throws IOException {
		while (tok == null || !tok.hasMoreTokens())
			tok = new StringTokenizer(br.readLine());
		return tok.nextToken();
	}
	
	String nextString() throws IOException {
		return nextToken();
	}
	
	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}
	
	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}
	
	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
	
	BigInteger nextBigInteger() throws IOException {
		return new BigInteger(nextToken());
	}
}