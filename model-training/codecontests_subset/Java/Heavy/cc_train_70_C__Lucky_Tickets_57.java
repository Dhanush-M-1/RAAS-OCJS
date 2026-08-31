import java.io.*;

import java.util.*;
import java.math.*;

public class Main implements Runnable {

	int rev(int x) {
		int ans = 0;
		while (x != 0) {
			ans *= 10;
			ans += x % 10;
			x /= 10;
		}
		return ans;
	}

	class Elem implements Comparable<Elem> {
		int x;
		int y;

		public Elem(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(Elem arg0) {
			if (x == arg0.x) {
				return y - arg0.y;
			}
			return x - arg0.x;
		}

	}

	class Rat {
		int nom;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + denom;
			result = prime * result + nom;
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
			Rat other = (Rat) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (denom != other.denom)
				return false;
			if (nom != other.nom)
				return false;
			return true;
		}

		int denom;

		int gcd(int a, int b) {
			if (a == 0) {
				return b;
			}
			if (b < a) {
				return gcd(b, a);
			}
			return gcd(b % a, a);
		}

		public Rat(int nom, int denom) {
			int d = gcd(nom, denom);
			this.nom = nom / d;
			this.denom = denom / d;
		}

		private Main getOuterType() {
			return Main.this;
		}
	}

	final int max = (int) 1e5 + 5;

	
	
	int[] tree;
	int n;

	void init (int nn)
	{
		n = nn;
		tree = new int[nn];
	}

	int sum (int r)
	{
		int result = 0;
		for (; r >= 0; r = (r & (r+1)) - 1)
			result += tree[r];
		return result;
	}

	void inc (int i)
	{
		for (; i < n; i = (i | (i+1)))
			++tree[i];
	}

	int sum (int l, int r)
	{
		return sum (r) - sum (l-1);
	}
	
	private void solve() throws IOException {
		HashMap<Rat, ArrayList<Integer>> map = new HashMap<Rat, ArrayList<Integer>>();
		int maxx = nextInt();
		int maxy = nextInt();
		int w = nextInt();
		init(max + 5);
		for (int i = 1; i <= max; ++i) {
			Rat r = new Rat(i, rev(i));
			if (!map.containsKey(r)) {
				map.put(r, new ArrayList<Integer>());
			}
			map.get(r).add(i);
		}
		long min = ((long) max) * max;
		int ax = -1;
		int ay = -1;
		for (int y = 1; y <= maxy; ++y) {
			Rat rk = new Rat(rev(y), y);
			if (map.containsKey(rk)) {
				for (int x : map.get(rk)) {
					inc(x);
				}
			}
			int l = 0;
			int r = max;
			while (r - l > 1) {
				int m = (r + l) / 2;
				if (sum(m) < w) {
					l = m;
				} else {
					r = m;
				}
			}
			if (r <= maxx && ((long) r) * y < min) {
				
				min = ((long) r) * y;
				ax = r;
				ay = y;
			}
		}
		if (ax == -1) {
			out.println(-1);
		} else {
			out.println(ax + " " + ay);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Main()).start();

	}

	private BufferedReader br;
	private StringTokenizer st;
	private PrintWriter out;

	@Override
	public void run() {
		try {
			Locale.setDefault(Locale.US);
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
			out = new PrintWriter(System.out);
			solve();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}

	}

	String next() throws IOException {
		while (!st.hasMoreTokens()) {
			String temp = br.readLine();
			if (temp == null) {
				return null;
			}
			st = new StringTokenizer(temp);
		}
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	long nextLong() throws IOException {
		return Long.parseLong(next());
	}

}
