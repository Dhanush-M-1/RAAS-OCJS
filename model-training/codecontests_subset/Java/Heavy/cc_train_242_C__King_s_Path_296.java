import java.io.*;
import java.util.*;


public class Main {
	
	static InputReader in = new InputReader(System.in);
//	static PrintWriter out = new PrintWriter(System.out);
	
	static int[] dx = {-1, -1, -1, 0, 0, +1, +1, +1};
	static int[] dy = {-1, 0, +1, -1, +1, -1, 0, +1};
	
	
	public static void main(String[] args) throws IOException {

		int x0 = in.nextInt();
		int y0 = in.nextInt();
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		
		int n = in.nextInt();
		
		Set<Pair> allowed = new HashSet<>();
		for(int i=0; i<n; ++i) {
			int r = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			for(int k=a; k <= b; ++k)
				allowed.add(new Pair(r, k));
		}

		Map<Pair, Integer> dist = new HashMap<>();
		Queue<Pair> q = new ArrayDeque<>();
		
		Pair src = new Pair(x0, y0);
		Pair dest = new Pair(x1, y1);
		dist.put(dest, 0);
		q.add(dest);
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int d = dist.get(p);
			for(int i=0; i<8; ++i) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				Pair np = new Pair(nx, ny);
				if(!allowed.contains(np))
					continue;
				if(!dist.containsKey(np) || d + 1 < dist.get(np)) {
					dist.put(np, d + 1);
					q.add(np);
				}
			}
		}
		
		int ans = -1;
		if(dist.containsKey(src))
			ans = dist.get(src);
		System.out.println(ans);
		
//		out.close();
	}
	
	static class Pair implements Comparable<Pair> {
		int x, y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
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
			Pair other = (Pair) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public int compareTo(Pair o) {
			return this.x != o.x ? this.x - o.x : this.y - o.y;
		}
	}
}



class InputReader {

	private final InputStream stream;
	private final byte[] buf = new byte[8192];
	private int curChar, snumChars;

	public InputReader(InputStream st) {
		this.stream = st;
	}

	public int read() {
		if (snumChars == -1)
			throw new InputMismatchException();
		if (curChar >= snumChars) {
			curChar = 0;
			try {
				snumChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (snumChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	public int nextInt() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public long nextLong() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		long res = 0;
		do {
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public int[] nextIntArray(int n) {
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
		}
		return a;
	}

	public String readString() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
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

	public boolean isSpaceChar(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	private boolean isEndOfLine(int c) {
		return c == '\n' || c == '\r' || c == -1;
	}

}