import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	
	Scanner in;
	static PrintWriter out;
	
	
	
	
	static class Scanner {
		StreamTokenizer in;
		
		Scanner(InputStream is) {
			in = new StreamTokenizer(new BufferedReader(new InputStreamReader(is)));
		}
		
		int nextInt() {
			try {
				in.nextToken();
				return (int)in.nval;
			} catch (IOException e) {
				throw new Error();
			}
		}
	}
	
	
	static class Point implements Comparable <Point> {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int compareTo(Point second) {
			if (this.x != second.x) {
				return this.x - second.x;
			} else {
				return this.y - second.y;
			}
		}
	}
	
	static class Line implements Comparable <Line> {
		int row;
		int lo;
		int hi;
		
		Line(Scanner in) {
			row = in.nextInt();
			lo = in.nextInt();
			hi = in.nextInt();
		}
		
		public int compareTo(Line second) {
			if (this.row != second.row) {
				return this.row - second.row;
			} else {
				if (this.lo != second.lo) {
					return this.lo - second.lo;
				}
				return this.hi - second.hi;
			}
		}
	}
	
	TreeMap <Point, Integer> points = new TreeMap<Main.Point, Integer>();
	

	void solve() {
		int xFrom = in.nextInt();
		int yFrom = in.nextInt();
		int xTo = in.nextInt();
		int yTo = in.nextInt();
		
		int n = in.nextInt();
		Line []lines = new Line[n];
		int sumLen = 0;
		for (int i = 0; i < lines.length; i++) {
			lines[i] = new Line(in);
			sumLen += lines[i].hi - lines[i].lo + 1;
			
		}
		asserT(sumLen <= 100000);
		for (int i = 0; i < lines.length; i++) {
			for (int p = lines[i].lo; p <= lines[i].hi; p++) {
				points.put(new Point(lines[i].row, p), 10000000);
			}
		}
		
		Queue <Point> q = new LinkedList <Point>();
		q.add(new Point(xFrom, yFrom));
		Point always = new Point(0, 0);
		points.put(new Point(xFrom, yFrom), 0);
		while (!q.isEmpty()) {
			Point curr = q.poll();
			int dist = points.get(curr);
			if (curr.x == xTo && curr.y == yTo) {
				out.println(dist);
				return;
			}
			
			for (int dy = -1; dy <= 1; dy++) {
				for (int dx = -1; dx <= 1; dx++) {
					if (dx == 0 && dy == 0) {
						continue;
					}
					always.x = curr.x + dx;
					always.y = curr.y + dy;
					
					Integer dst = points.get(always);
					if (dst != null) {
						if (dst > dist + 1) {
							Point np = new Point(always.x, always.y);
							points.put(np, dist + 1);
							q.add(np);
						}
					}
				}
			}
		}
		out.println(-1);
	}
	
	static void asserT(boolean e) {
		if (!e) {
			throw new Error();
		}
	}
	
	
	public void run() {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
		
		try {
			solve();
		} finally {
			out.close();
		}
	}
	
	public static void main(String[] args) {
		new Main().run();
	}

} 