import java.util.*;
import java.io.*;
import java.math.BigInteger;
import static java.lang.Math.*;

public class Main implements Runnable {
	StringTokenizer tokenizer = new StringTokenizer("");
	BufferedReader in;
	PrintStream out;

	public void debug(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		new Thread(new Main()).start();
	}

	class Q implements Comparable <Q> {
		int a, b;

		Q(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public int compareTo(Q r) {
			return Long.signum((long)a * r.b - (long)b * r.a);
		}
	}

	int rev(int n) {
		int ret = 0;
		while (n > 0) {
			ret = (ret * 10) + n % 10;
			n /= 10;	
		}
		return ret;
	}

	final int N =  100005;

	TreeMap <Q, Integer> mapx = new TreeMap <Q, Integer>();
	TreeMap <Q, Integer> mapy = new TreeMap <Q, Integer>();

	void add(TreeMap <Q, Integer> map, Q q, int add) {
		map.put(q, map.get(q) == null ? add : map.get(q) + add);
	}

	int get(TreeMap <Q, Integer> map, Q q) {
		return map.get(q) == null ? 0 : map.get(q);
	}

	public void run() {
		try {
			Locale.setDefault(Locale.US);
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintStream(System.out);

			
			long time = System.currentTimeMillis();

			Q[] a = new Q[N], arev = new Q[N];
			for (int i = 1; i < N; i++) a[i] = new Q(i, rev(i));
			for (int i = 1; i < N; i++) arev[i] = new Q(rev(i), i);

			long ans = -1;
			int bx = -1, by = -1;

			int mX = nextInt(), mY = nextInt(), w = nextInt();
			for (int i = 1; i <= mY; i++) add(mapy, arev[i], 1);

			int have = 0;
			for (int cx = 1, cy = mY; cx <= mX; cx++) {
				have += get(mapy, a[cx]);
				add(mapx, a[cx], 1);
				while (cy > 1 && have - get(mapx, arev[cy]) >= w) {
					have -= get(mapx, arev[cy]);
					//System.out.println(cx + " " + cy + " " + have);
					add(mapy, arev[cy], -1);
					cy--;
				}
				if (have >= w && (ans == -1 || (long)cx * cy < ans)) {
					ans = (long) cx * cy;
					bx = cx;
					by = cy;
				}
			}

			//System.out.println(System.currentTimeMillis() - time);

			out.println(ans == -1 ? ans : (bx + " " + by));


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	boolean seekForToken() {
		while (!tokenizer.hasMoreTokens()) {
			String s = null;
			try {
				s = in.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (s == null)
				return false;
			tokenizer = new StringTokenizer(s);
		}
		return true;
	}

	String nextToken() {
		return seekForToken() ? tokenizer.nextToken() : null;
	}

	int nextInt() {
		return Integer.parseInt(nextToken());
	}

	long nextLong() {
		return Long.parseLong(nextToken());
	}

	double nextDouble() {
		return Double.parseDouble(nextToken());
	}

	BigInteger nextBig() {
		return new BigInteger(nextToken());
	}
}
