import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		Point a = new Point(sc.nextLong(), sc.nextLong()), b = new Point(sc.nextLong(), sc.nextLong()), c = new Point(sc.nextLong(), sc.nextLong());
		out.println(a.distance(b) == b.distance(c) && !Point.collinear(a, b, c) ? "Yes" : "No");
		
		out.flush();
		out.close();
	}
	
	static class Point {
		long x, y;
		
		static final double EPS = 1e-9;
		
		public Point(long a, long b) {
			x = a;
			y = b;
		}
		
		public long distance(Point p) {
			return sq(x - p.x) + sq(y - p.y);
		}
		
		public long sq(long x) {
			return x * x;
		}
		
		public static boolean collinear(Point p, Point q, Point r) {
			return new Vector(p, q).cross(new Vector(p, r))  == 0;
		}
		
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
		
	}
	
	static class Vector {
		long x, y;
		
		static final double EPS = 1e-9;
		
		public Vector(long a, long b) {
			x = a;
			y = b;
		}
		
		public Vector(Point a, Point b) {
			this(b.x - a.x, b.y - a.y);
		}
		
		public long cross(Vector b) {
			return x*b.y - y*b.x;
		}
		
		public double norm_sq() {
			return x*x + y*y;
		}
		
		public Vector reverse() {
			return new Vector(x*-1, y*-1);
		}
	}



	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner(FileReader f) {
			br = new BufferedReader(f);
		}

		public Scanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public boolean Ready() throws IOException {
			return br.ready();
		}

		public void waitForInput(long time) {
			long ct = System.currentTimeMillis();
			while(System.currentTimeMillis() - ct < time) {};
		}

	}

}