import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Contest {
	private static PrintWriter out = new PrintWriter(System.out);
	private static final Random random = new Random();
	private static int n, m, k, tc, x;
	private static int[] a;
	private static final int OO = (int) 1e9, mod = (int) 1e9 + 7;
	private static final int MAX = (int) (1e5 + 10);
	private static HashMap<Long, Boolean> allowed = new HashMap<>(), visited = new HashMap<Long, Boolean>();
	private static long[] dx = { 0, 1, -1, 0, 1, -1, 1, -1 };
	private static long[] dy = { 1, 0, 0, -1, 1, 1, -1, -1 };

	private static class Point {
		long pos, depth;

		Point(long p, long d) {
			this.pos = p;
			this.depth = d;
		}
	}

	private static long toIdx(long x, long y) {
		return (long) ((long)1e9 * x + y);
	}

	private static long BFS(long x0, long y0, long x1, long y1) {
		Queue<Point> qu = new LinkedList<>();
		qu.add(new Point(toIdx(x0, y0), 0));
		visited.put(toIdx(x0, y0), true);
		long dest = toIdx(x1, y1);
		while (!qu.isEmpty()) {
			Point cur = qu.poll();
			if(cur.pos < 0)
				System.out.println("ERROR");
			if (cur.pos == dest) {
				return cur.depth;
			}
		
			// cols*i + j
			for (int i = 0; i < 8; i++) {
				long newX = (long) (cur.pos / (long)1e9) + dx[i], newY = (long) (cur.pos % (long)1e9) + dy[i];
			//visited.containsKey(toIdx(newX, newY)) || 
				if (visited.containsKey(toIdx(newX, newY)) || !allowed.containsKey(toIdx(newX, newY)))
					continue;
				if(newX < 0 || newY < 0)
					System.out.println("ERROR");
				qu.add(new Point(toIdx(newX, newY), cur.depth + 1));
				visited.put(toIdx(newX, newY), true);
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long x0 = sc.nextLong() - 1, y0 = sc.nextLong() - 1, x1 = sc.nextLong() - 1, y1 = sc.nextLong() - 1;
		n = sc.nextInt();
		while (n-- > 0) {
			long i = sc.nextLong() - 1;
			long c1 = sc.nextLong() - 1, c2 = sc.nextLong() - 1;
			for (long j = c1; j <= c2; j++) {
				if(!allowed.containsKey(toIdx(i,j)))
						allowed.put((long) (1e9) * i + j, true);
			}
		}
		out.println(BFS(x0, y0, x1, y1));
		out.flush();
	}

	private static void ruffleSort(int[] a) {
		int n = a.length;// shuffle, then sosrt
		for (int i = 0; i < n; i++) {
			int oi = random.nextInt(n), temp = a[oi];
			a[oi] = a[i];
			a[i] = temp;
		}
		java.util.Arrays.sort(a);
	}

	private static class Scanner {
		public BufferedReader reader;
		public StringTokenizer st;

		public Scanner(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			st = null;
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					String line = reader.readLine();
					if (line == null)
						return null;
					st = new StringTokenizer(line);
				} catch (Exception e) {
					throw (new RuntimeException());
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}

}