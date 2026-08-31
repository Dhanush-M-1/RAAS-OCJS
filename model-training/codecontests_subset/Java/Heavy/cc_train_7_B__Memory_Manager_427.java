import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B implements Runnable {
	static class MyScanner {
		private BufferedReader br;
		private StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public void close() {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private String nextToken() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
					return null;
				}
			}
			return st.nextToken();
		}

		public String next() {
			return nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(nextToken());
		}

		public long nextLong() {
			return Long.parseLong(nextToken());
		}

		public double nextDouble() {
			return Double.parseDouble(nextToken());
		}
	}

	class Interval {
		public int from, to, number;

		public Interval(int from, int to, int number) {
			this.from = from;
			this.to = to;
			this.number = number;
		}	
	}
	
	private MyScanner in;
	private PrintWriter out;

	private void solve() {
		int op = in.nextInt();
		int mem = in.nextInt();
		LinkedList<Interval> ints = new LinkedList<Interval>();
		int cur = 0;
		for (int i = 0; i < op; ++i) {
			String s = in.next();
			if (s.charAt(0) == 'a') {
				boolean found = false;
				int size = in.nextInt();
				LinkedList<Interval> next = new LinkedList<Interval>();
				int from = 1;
				for (Iterator<Interval> it = ints.iterator(); it.hasNext();) {
					Interval ci = it.next();
					if (!found) {
						int to = ci.from - 1;
						if (to - from + 1 >= size) {
							found = true;
							next.add(new Interval(from, from + size - 1, ++cur));
						} else {
							from = ci.to + 1;
						}
					}
					next.add(ci);
				}
				if (!found) {
					if (mem - from + 1 >= size) {
						found = true;
						next.add(new Interval(from, from + size - 1, ++cur));
					} else {
						out.println("NULL");
					}
				}
				if (found) {
					out.println(cur);
				}
				ints = next;
			} else if (s.charAt(0) == 'e') {
				int num = in.nextInt();
				boolean found = false;
				for (Iterator<Interval> it = ints.iterator(); it.hasNext();) {
					Interval ci = it.next();
					if (ci.number == num) {
						found = true;
						it.remove();
						break;
					}
				}
				if (!found) {
					out.println("ILLEGAL_ERASE_ARGUMENT");
				}
			} else {
				int from = 1;
				for (Iterator<Interval> it = ints.iterator(); it.hasNext();) {
					Interval ci = it.next();
					int sz = ci.to - ci.from;
					ci.from = from;
					ci.to = from + sz;
					from = ci.to + 1;
				}
			}
		}
	}

	@Override
	public void run() {
		in = new MyScanner();
		out = new PrintWriter(System.out);
		solve();
		in.close();
		out.close();
	}

	public static void main(String[] args) {
		new B().run();
	}
}