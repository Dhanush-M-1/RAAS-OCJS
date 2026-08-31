import java.io.*;
import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.fill;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;

public class Main {
	public static void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					try {
						if (new File("input.txt").exists())
							System.setIn(new FileInputStream("input.txt"));
					} catch (SecurityException e) {}
					new Main().run();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, "1", 1L << 24).start(); 
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");
	
	int MX;
	int MY;
	int W;
	
	Q[] qx;
	Q[] qy;
	
	Map<Q, Integer> mapX = new TreeMap<Q, Integer>();
	Map<Q, Integer> mapY = new TreeMap<Q, Integer>();
	
	void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		MX = nextInt();
		MY = nextInt();
		W = nextInt();
		
		qx = new Q [MX];
		qy = new Q [MY];

		for (int x = 1; x <= MX; x++)
			qx[x - 1] = new Q(x - 1, x, rev(x));
		for (int y = 1; y <= MY; y++)
			qy[y - 1] = new Q(y - 1, rev(y), y);
		
		for (Q q : qx)
			add(mapX, q);
		
		int bx = MX;
		int y;
		long by = 0;
		
		int cur = 0;
		for (y = 0; y < MY && cur < W; y++) {
			add(mapY, qy[y]);
			cur += get(mapX, qy[y]);
			by = y + 1;
		}
		
		if (cur < W) {
			out.println(-1);
			out.close();
			return;
		}
		
		long best = bx * by;
		
//		System.out.println(bx + " " + by + " " + best + " " + cur);
		
		for (int x = MX - 1; x > 0; x--) {
			cur -= get(mapY, qx[x]);
			rem(mapX, qx[x]);
			for (; y < MY && cur < W; y++) {
				add(mapY, qy[y]);
				cur += get(mapX, qy[y]);
			}
			if (cur < W)
				break;
			int cx = x;
			long cy = y;
			long ca = cx * cy;
			if (best > ca) {
				best = ca;
				bx = cx;
				by = cy;
			}
		}
		
		out.println(bx + " " + by);
		
		out.close();
	}

	void add(Map<Q, Integer> map, Q q) {
		if (!map.containsKey(q)) {
			map.put(q, 1);
		} else {
			map.put(q, map.get(q) + 1);
		}
	}
	
	void rem(Map<Q, Integer> map, Q q) {
		if (map.containsKey(q)) {
			int v = map.get(q);
			if (v == 1)
				map.remove(q);
			else
				map.put(q, v - 1);
		}
	}
	
	int get(Map<Q, Integer> map, Q q) {
		return map.containsKey(q) ? map.get(q) : 0;
	}

	int rev(int x) {
		return Integer.parseInt(new StringBuffer(x + "").reverse().toString());
	}
	
	long gcd(long a, long b) {
		while (a > 0L && b > 0L)
			if (a > b)
				a %= b;
			else
				b %= a;
		return a + b;
	}
	
	class Q implements Comparable<Q> {
		int id;
		long num;
		long den;
		
		Q(int id, long num, long den) {
			this.id = id;
			long gcd = gcd(num, den);
			this.num = num / gcd;
			this.den = den / gcd;
		}

		@Override
		public int compareTo(Q q) {
			long m1n = num * q.den;
			long m2n = q.num * den;
			if (m1n != m2n)
				return  m1n < m2n ? -1 : 1;
//			return id - q.id;
			return 0;
		}
	}
	
	/*************************************************************** 
	 * Input 
	 **************************************************************/
	String nextToken() throws IOException {
		while (!st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}
	
	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}
	
	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}
	
	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
	
	String nextLine() throws IOException {
		st = new StringTokenizer("");
		return in.readLine();
	}
	
	boolean EOF() throws IOException {
		while (!st.hasMoreTokens()) {
			String s = in.readLine();
			if (s == null)
				return true;
			st = new StringTokenizer(s);
		}
		return false;
	}
}
