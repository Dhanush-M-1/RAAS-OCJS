import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

public class KingsPath {
    public static void main(String[] args) {
        FasterScanner sc = new FasterScanner();
        
        int X0 = sc.nextInt();
        int Y0 = sc.nextInt();
        int X1 = sc.nextInt();
        int Y1 = sc.nextInt();
        int N = sc.nextInt();
        
        HashSet<Point> path = new HashSet<Point>();
        for (int i = 0; i < N; i++) {
        	int R = sc.nextInt();
        	int A = sc.nextInt();
        	int B = sc.nextInt();
        	for (int j = A; j <= B; j++) {
        		path.add(new Point(R, j));
        	}
        }
        
        HashMap<Point, Integer> visited = new HashMap<Point, Integer>();
        Queue<Point> q = new LinkedList<Point>();
        Point p0 = new Point(X0, Y0);
        visited.put(p0, 0);
        q.add(p0);
        while (!q.isEmpty()) {
        	Point p = q.poll();
        	int d = visited.get(p);
        	for (int dr = -1; dr <= 1; dr++) {
        		for (int dc = -1; dc <= 1; dc++) {
        			if (dr != 0 || dc != 0) {
        				Point next = new Point(p.X + dr, p.Y + dc);
        				if (path.contains(next) && !visited.containsKey(next)) {
        					q.add(next);
        					visited.put(next, d + 1);
        				}
        			}
        		}
        	}
        }
        
        Point pf = new Point(X1, Y1);
        System.out.println(visited.containsKey(pf) ? visited.get(pf) : -1);
    }
    
    public static class Point {
    	public int X, Y;
    	
    	public Point(int x, int y) {
    		this.X = x;
    		this.Y = y;
    	}
    	
    	@Override
    	public int hashCode() {
    		return this.X * 31 + this.Y * 17;
    	}
    	
    	@Override
    	public boolean equals(Object obj) {
    		Point p = (Point)obj;
    		return this.X == p.X && this.Y == p.Y;
    	}
    }
    
	public static class FasterScanner {
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = System.in.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public String nextLine() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}

		public String nextString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int nextInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
	        
	    public int[] nextIntArray(int n) {
	        int[] arr = new int[n];
	        for (int i = 0; i < n; i++) {
	            arr[i] = nextInt();
	        }
	        return arr;
	    }
        
		public long[] nextLongArray(int n) {
		    long[] arr = new long[n];
		    for (int i = 0; i < n; i++) {
		        arr[i] = nextLong();
		    }
		    return arr;
		}

	    private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}
	}
}