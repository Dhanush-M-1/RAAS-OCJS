import java.io.*;
import java.util.*;

public class Pr260B {
	public static void main(String[] args) throws IOException {
		new Pr260B().run();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out, true);
		solve();
		out.flush();
	}

	boolean isDate(String a) {
		if (a.charAt(0) != '-' && a.charAt(1) != '-') {
			if (a.charAt(2) == '-') {
				if (a.charAt(3) != '-' && a.charAt(4) != '-') {
					if (a.charAt(5) == '-') {
						if (a.charAt(6) != '-' && a.charAt(7) != '-'
								&& a.charAt(8) != '-' && a.charAt(9) != '-') {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	void isCorrectDate(String a) {
		int day = Integer.parseInt(a.substring(0, 2));
		int mouth = Integer.parseInt(a.substring(3, 5));
		int year = Integer.parseInt(a.substring(6, 10));
		if (year >= 2013 && year <= 2015) {
			if (mouth >= 1 && mouth <= 12) {
				if (dayIsForMouth(day, mouth)) {
					dif.add(a);
				}
			}
		}
	}

	boolean dayIsForMouth(int d, int m) {
		if (m <= 7) {
			if (m % 2 == 1) {
				return d > 0 && d <= 31;
			}
			if (m == 2) {
				return d > 0 && d <= 28;
			}
			return d > 0 && d <= 30;
		}
		if (m % 2 == 0) {
			return d > 0 && d <= 31;
		}
		return d > 0 && d <= 30;
	}

	ArrayList<String> dif;

	void solve() throws IOException {
		String s = nextToken();
		dif = new ArrayList<String>();
		for (int i = 0; i <= s.length() - 10; i++) {
			if (isDate(s.substring(i, i + 10))) {
				isCorrectDate(s.substring(i, i + 10));
			}
		}
		Collections.sort(dif);
		int mcnt = 1;
		String best = dif.get(0);
		int cnt = 1;
		for (int i = 1; i < dif.size(); i++) {
			if (dif.get(i).equals(dif.get(i - 1))) {
				cnt++;
				if (cnt > mcnt) {
					mcnt = cnt;
					best = dif.get(i);
				}
			} else {
				cnt = 1;
			}
		}
		out.println(best);
	}
}
