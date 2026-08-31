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

	Q [] a, arev;

	int rev(int n) {
		int ret = 0;
		while (n > 0) {
			ret = (ret * 10) + n % 10;
			n /= 10;	
		}
		return ret;
	}

	final int N =  100005;

	TreeMap <Q, TreeSet<Integer>> map = new TreeMap <Q, TreeSet<Integer>>();

	int get(int xf, int y) {
		TreeSet <Integer> set =  map.get(arev[xf]);
		return set == null ? 0 : set.headSet(y + 1).size();	
	}

	public void run() {
		try {
			Locale.setDefault(Locale.US);
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintStream(System.out);

			
			long time = System.currentTimeMillis();

			a = new Q[N];
			arev = new Q[N];
			for (int i = 1; i < N; i++) a[i] = new Q(i, rev(i));
			for (int i = 1; i < N; i++) arev[i] = new Q(rev(i), i);

			for (int i = 1; i < N; i++) {
				TreeSet <Integer> hset = map.get(a[i]);
				if (hset == null) {
					TreeSet <Integer> set = new TreeSet <Integer> ();
					set.add(i);
					map.put(a[i], set);
				} else {
					hset.add(i);
				}
			}

			long ans = -1;
			int X = -1, Y = -1;

			int mX = nextInt(), mY = nextInt(), w = nextInt();

			int cX = mX, cY = mY;
			int have = 0;
			for (int i = 1; i <= cX; i++) have += get(i, cY);

			int g;
			while (have - (g = get(cY, cX)) >= w) {
				have -= g;
				cY--;
			}


			while (cX > 0) {
				if (have >= w) {
					if (ans == -1 || (long)cX * cY < ans) {
						ans = (long)cX * cY;
						X = cX;
						Y = cY;
					}
				}
				have -= get(cX, cY);
				cX--;
				while (have < w && cY < mY) {
					cY++;
					have += get(cY, cX);
				}
			}

			//System.out.println(System.currentTimeMillis() - time);

			out.println(ans == -1 ? ans : (X + " " + Y));


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
