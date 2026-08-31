import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}

	static class TaskC {
		long gcd(long a, long b) {
			return (a == 0) ? b : gcd(b % a, a);
		}

		public void solve(int testNumber, InputReader in, PrintWriter out) {
			long ax = in.nextInt();
			long ay = in.nextInt();
			long bx = in.nextInt();
			long by = in.nextInt();
			long cx = in.nextInt();
			long cy = in.nextInt();

			long dista = (bx - ax) * (bx - ax) + (by - ay) * (by - ay);
			long distb = (cx - bx) * (cx - bx) + (cy - by) * (cy - by);
			if(dista!=distb){
				out.println("No");
				return;
			}
			if (ax == bx || bx == ax || ax == cx) {
				if (ax == bx && bx == cx) {
					out.println("No");
					return;
				} else {
					out.println("Yes");
					return;
				}
			}
			long minx = Math.min(ax, Math.min(bx, cx));
			ax -= minx;
			bx -= minx;
			cx -= minx;
			long miny = Math.min(ay, Math.min(by, cy));
			ay -= miny;
			by -= miny;
			cy -= miny;

			long gcdX = gcd(ax, gcd(bx, cx));
			if (gcdX != 0) {
				ax /= gcdX;
				bx /= gcdX;
				cx /= gcdX;
			}

			long gcdY = gcd(ay, gcd(by, cy));
			if (gcdY != 0) {
				ay /= gcdY;
				by /= gcdY;
				cy /= gcdY;
			}

			double a = ay - by;
			a /= ax - bx;
			double b = ay;
			b -= a * ax;

			if (Math.abs(b + a * cx - cy) < 0.000000001) {
				out.println("No");
			} else {
				out.println("Yes");
			}
		}

	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
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

		public double nextFloat() {
			return Double.parseDouble(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

	}
}
