import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Class<?> here = new Object(){}.getClass().getEnclosingClass();
		try {
			String packageName = here.getPackage().getName();
			packageName = "src/" + packageName.replaceAll("\\.", "/") + "/";
			System.setIn(new FileInputStream(packageName + "input.txt"));
//			System.setOut(new PrintStream(new FileOutputStream(packageName + "output.txt")));
		} catch (FileNotFoundException e) {
		} catch (NullPointerException e) {
		}

		Object o = Class.forName(here.getName()).newInstance();
		o.getClass().getMethod("run").invoke(o);
	}

	static void tr(Object... os) {
		System.err.println(deepToString(os));
	}


	Scanner sc = null;
	PrintWriter out = null;
	public void run() throws Exception {
		sc = new Scanner(System.in);
		out = new PrintWriter(System.out);
		for (;sc.hasNext();) {
			solve();
			out.flush();
		}
		out.close();
	}

	void solve() {
		String line = sc.nextLine();

		int best = 0;
		String ans = null;

		Map<Integer,Integer> mp = new HashMap<Integer, Integer>();

		int[] dom = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for (int i = 0; i + 10 <= line.length(); i++) {
			char[] sub = line.substring(i, i + 10).toCharArray();

			boolean ok = true;
			if (!Character.isDigit(sub[0])) ok = false;
			if (!Character.isDigit(sub[1])) ok = false;
			if (sub[2] != '-') ok = false;
			if (!Character.isDigit(sub[3])) ok = false;
			if (!Character.isDigit(sub[4])) ok = false;
			if (sub[5] != '-') ok = false;
			if (!Character.isDigit(sub[6])) ok = false;
			if (!Character.isDigit(sub[7])) ok = false;
			if (!Character.isDigit(sub[8])) ok = false;
			if (!Character.isDigit(sub[9])) ok = false;

			if (!ok) continue;

			int dd = (sub[0] - '0') * 10 + (sub[1] - '0');
			int mm = (sub[3] - '0') * 10 + (sub[4] - '0');
			int yyyy = (sub[6] - '0') * 1000 +  (sub[7] - '0') * 100 +  (sub[8] - '0') * 10 +  (sub[9] - '0');

			if (!(2013 <= yyyy && yyyy <= 2015)) continue;
			if (!(1 <= mm && mm <= 12)) continue;
			if (!(1 <= dd && dd <= dom[mm])) continue;

			int hoge = yyyy * 10000 + mm * 100 + dd;

			if (mp.containsKey(hoge)) {
				mp.put(hoge, mp.get(hoge) + 1);
			} else {
				mp.put(hoge, 1);
			}
		}

		int most = 0;
		for (int i : mp.keySet()) {
			if (most < mp.get(i)) {
				most = mp.get(i);
				int v = i;
				int yyyy = v / 10000;
				int mm = (v % 10000) / 100;
				int dd = (v % 10000) % 100;
				ans = String.format("%02d-%02d-%04d", dd, mm, yyyy);
			}
		}
		out.println(ans);
	}


	void print(int[] a) {
		out.print(a[0]);
		for (int i = 1; i < a.length; i++) out.print(" " + a[i]);
		out.println();
	}

	class MyScanner {
		String line;
		BufferedReader reader;
		StringTokenizer tokenizer;

		public MyScanner(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public void eat() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					line = reader.readLine();
					if (line == null) {
						tokenizer = null;
						return;
					}
					tokenizer = new StringTokenizer(line);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}

		public String next() {
			eat();
			return tokenizer.nextToken();
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean hasNext() {
			eat();
			return (tokenizer != null && tokenizer.hasMoreElements());
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
}
