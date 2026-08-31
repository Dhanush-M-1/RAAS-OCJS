import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer buffer;

	public static void solve() throws IOException {
		String[]s = in.readLine().split(" ");
		
		List<Integer>min = new ArrayList<Integer>();
		List<Integer>max = new ArrayList<Integer>();
		
		int maxVal = 0, minVal = 0, n = Integer.parseInt(s[s.length-1]);
		String prev = null;
		for (String x: s) {
			if ("?".equals(x)) {
				if (prev == null || "+".equals(prev)) {
					max.add(n);
					maxVal +=n;
					min.add(1);
					minVal += 1;
				} else { // minus
					max.add(1);
					maxVal -= 1;
					min.add(n);
					minVal -=n;
				}
			}
			else if ("+".equals(x)) prev = x;
			else if ("-".equals(x)) prev = x;
			else if ("=".equals(x)) continue;
		}

		if (n>maxVal || n<minVal) {
			out.println("Impossible");
		} else {
			out.println("Possible");
			int diff = maxVal - n;
			if (diff>0) {
				for (int i=0;i<max.size();i++) {
					int val = max.get(i);
					if (val==n) {
						if (diff>n-1) {
							max.set(i, 1);
							diff -= (val-1);
						} else {
							max.set(i, val-diff);
							break;
						}						
					} else if (val==1) {
						if (diff>n-1) {
							max.set(i, n);
							diff -= (n-1);
						} else {
							max.set(i, 1+diff);
							break;
						}
					}
				}				
			}
			int pos = 0;
			for (Integer x: max) {
				out.print(x + " ");
				while (pos<s.length && !"+".equals(s[pos]) && ! "-".equals(s[pos])) pos++;
				if (pos<s.length) {
					out.print(s[pos] + " ");
					pos++;
				}
			}
			out.println("= " + n);
		}
		
	}

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}

	static String next() {
		while (buffer == null || !buffer.hasMoreElements()) {
			try {
				buffer = new StringTokenizer(in.readLine());
			} catch (IOException e) {
			}
		}
		return buffer.nextToken();
	}

	static int ni() {
		return Integer.parseInt(next());
	}

	static long nl() {
		return Long.parseLong(next());
	}

	static double nd() {
		return Double.parseDouble(next());
	}

	static String ns() {
		return next();
	}

	static int[] ni(int n) {
		int[] res = new int[n];
		for (int i = 0; i < n; i++)
			res[i] = Integer.parseInt(next());
		return res;
	}

	static long[] nl(int n) {
		long[] res = new long[n];
		for (int i = 0; i < n; i++)
			res[i] = Long.parseLong(next());
		return res;
	}

	static double[] nd(int n) {
		double[] res = new double[n];
		for (int i = 0; i < n; i++)
			res[i] = Double.parseDouble(next());
		return res;
	}

	static String[] ns(int n) {
		String[] res = new String[n];
		for (int i = 0; i < n; i++)
			res[i] = next();
		return res;
	}

}
