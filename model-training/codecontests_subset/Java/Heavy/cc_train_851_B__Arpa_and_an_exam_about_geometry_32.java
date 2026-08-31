
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ArpaAndAnExamAboutGeometry {

	static long sq(long x) {
		return x * x;
	}

	static class Point {
		long x, y;

		Point(int a, int b) {
			x = a;
			y = b;
		}

		long dist2(Point p) {
			return sq(x - p.x) + sq(y - p.y);
		}

		static boolean collinear(Point a, Point b, Point c) {
			return Math.abs(new Vector(a, b).cross(new Vector(a, c))) <= 0;
		}

		@Override
		public String toString() {
			return x + " " + y;
		}
	}

	static class Vector {
		long x, y;

		Vector(Point a, Point b) {
			x = b.x - a.x;
			y = b.y - a.y;
		}

		long cross(Vector v) {
			return (x * v.y) - (y * v.x);
		}
	}

	public static void main(String[] args) throws IOException {
		MyScanner sc = new MyScanner(System.in);
		Point a = new Point(sc.nextInt(), sc.nextInt()), b = new Point(sc.nextInt(), sc.nextInt()),
				c = new Point(sc.nextInt(), sc.nextInt());
		if (a.dist2(b) == b.dist2(c) && !Point.collinear(a, b, c))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
		}

		public MyScanner(String filename) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(filename)));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
	}
}