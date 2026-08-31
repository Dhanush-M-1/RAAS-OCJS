import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

import static java.lang.Math.*;

public class Solution implements Runnable {
	
	void solve() throws Exception {
		int n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int ln = 0;
		while ((1 << ln) <= r) ln++;
		ln++;
		int[][] pr = new int[ln][n];
		int[] l = new int[n];
		String[] strings = new String[n];
		for (int i = 0; i < n; i++) {
			l[i] = (strings[i] = sc.nextToken()).length();
		}
		for (int i = 0; i < n; i++) {
			pr[0][i] = i + 1;
		}
		for (int i = 0, j = 0, sm = 0; i < n; i++) {
			j = max(i, j);
			while (j < n && sm + l[j] <= c) {
				pr[0][j] = i;
				sm += l[j] + 1;
				j++;
			}
			sm -= (i < j ? l[i] + 1 : 0);
		}
//		out.println(Arrays.toString(pr[0]));
		for (int h = 1; h < ln; h++) {
			for (int i = 0; i < n; i++) {
				pr[h][i] = pr[h - 1][max(pr[h - 1][i] - 1, 0)];
			}
//			out.println(Arrays.toString(pr[h]));
		}
		int left = -1, right = -2;
		for (int i = 0; i < n; i++) {
			int len = r;
			int pos = i;
			for (int h = ln - 1; h >= 0; --h) {
				if ((1 << h) <= len) {
					pos = pr[h][max((pos < i ? pos - 1 : i), 0)];
					len -= (1 << h);
				}
			}
			if (right - left < i - pos) {
				left = pos;
				right = i;
			}
		}
		for (int i = left; i <= right; ) {
			int j = i;
			int sm = 0;
			while (j <= right && sm + l[j] <= c) {
				sm += l[j] + 1;
				j++;
			}
			for (int k = i; k < j; k++) {
				if (k != i) {
					out.print(" ");
				}
				out.print(strings[k]);
			}
			out.println();
			i = j;
		}
	}
	
	final String INPUT_FILE = "";
	final String OUTPUT_FILE = "";
	
	BufferedReader in;
	PrintWriter out;
	FastScanner sc;
	
	static Throwable throwable;
	
	public static void main(String[] args) throws Throwable {
		Thread thread = new Thread(null, new Solution(), "", (1 << 26));
		thread.start();
		thread.join();
		thread.run();
		if (throwable != null)
			throw throwable;
	}
	
	@Override
	public void run() {
		try {
			if (INPUT_FILE.equals(""))
				in = new BufferedReader(new InputStreamReader(System.in));
			else
				in = new BufferedReader(new FileReader(INPUT_FILE));
			if (OUTPUT_FILE.equals(""))
				out = new PrintWriter(System.out);
			else
				out = new PrintWriter(new FileWriter(OUTPUT_FILE));
			sc = new FastScanner(in);
			solve();
		} catch (Exception e) {
			throwable = e;
		} finally {
			out.close();
		}
	}
}

class FastScanner {
	BufferedReader reader;
	StringTokenizer strTok;
	
	FastScanner(BufferedReader reader) {
		this.reader = reader;
	}
	
	public String nextToken() throws Exception {
		while (strTok == null || !strTok.hasMoreTokens()) {
			strTok = new StringTokenizer(reader.readLine());
		}
		return strTok.nextToken();
	}
	
	public boolean EOF() throws Exception {
		if (strTok != null && strTok.hasMoreTokens()) {
			return false;
		} else {
			String line = reader.readLine();
			if (line == null)
				return true;
			strTok = new StringTokenizer(line);
			return false;
		}
	}
	
	public int nextInt() throws Exception {
		return Integer.parseInt(nextToken());
	}
	
	public double nextDouble() throws Exception {
		return Double.parseDouble(nextToken());
	}
	
	public long nextLong() throws Exception {
		return Long.parseLong(nextToken());
	}
}
