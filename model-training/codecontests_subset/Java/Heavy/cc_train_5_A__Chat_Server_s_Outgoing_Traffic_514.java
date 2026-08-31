import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A5 {
	Scanner in;
	PrintWriter out;

	public void solve() throws IOException {
		HashSet<String> set = new HashSet<String>();
		int ans = 0;
		while (in.hasNext()) {
			String query = in.nextLine();
			if (query.charAt(0) == '+') {
				set.add(query.substring(1));
			} else if (query.charAt(0) == '-') {
				set.remove(query.substring(1));
			} else {
				String[] temp = query.split(":");
				if (temp.length < 2) {
					continue;
				}
				ans += temp[1].length() * set.size();
			}
			System.err.println(set.size());
		}
		out.println(ans);
	}

	public void run() {
		try {
			InputStream inputStream = System.in;
			in = new Scanner(inputStream);
			out = new PrintWriter(System.out);
			solve();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
		}

		public boolean hasNext() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					String line = br.readLine();
					if (line == null) {
						return false;
					}
					st = new StringTokenizer(line);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (st != null && st.hasMoreTokens()) {
				return true;
			}
			return false;
		}

		public String next() {
			if (hasNext()) {
				return st.nextToken();
			}
			return null;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}

	public static void main(String[] args) {
		new A5().run();
	}
}