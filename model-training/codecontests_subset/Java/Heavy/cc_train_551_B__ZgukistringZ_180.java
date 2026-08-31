/**
 * @problem http://codeforces.com/problemset/problem/551/B
 * @status 
 */
import java.io.*;
import java.util.*;

public class B {

	final int N = 26;

	String a, b, c;
	int w[], u[], v[];

	int n, m;

	void in() {
		a = in.nextLine();
		b = in.nextLine();
		c = in.nextLine();
	}

	int[] buildCountChars(String s) {
		int n[] = new int[N];
		Arrays.fill(n, 0);
		for (char c : s.toCharArray()) {
			n[c - 'a'] ++;
		}
		return n;
	}

	void buildWUV() {
		w = buildCountChars(a);
		u = buildCountChars(b);
		v = buildCountChars(c);
	}

	void searchNM() {
		n = 0;
		m = 0;
		for (int i = 0; i <= a.length() / b.length(); ++ i) {
			// w[k] - i*u[k] - j*v[k] >= 0

			boolean checkI = true;
			for (int k = 0; k < N; ++ k) {
				if (w[k] < i * u[k]) {
					checkI = false;
					break;
				}
			}
			if (!checkI) {
				continue;
			}

			// j <= (w[k] - i*u[k]) / v[k]

			int j = a.length() / c.length();
			for (int k = 0; k < N; ++ k) {
				if (v[k] == 0) {
					continue;
				}
				j = Math.min(j, (w[k] - i * u[k]) / v[k]);
			}

			// save max (n + m)

			if (i + j > n + m) {
				n = i;
				m = j;
			}
		}
	}

	void out() {
		char[] result = new char[a.length() + 1000];
		int k = 0;
		for (int i = 0; i < n; ++ i) {
			for (int j = 0; j < b.length(); ++ j) {
				result[k ++] = b.charAt(j);
			}
		}
		for (int i = 0; i < m; ++ i) {
			for (int j = 0; j < c.length(); ++ j) {
				result[k ++] = c.charAt(j);
			}
		}
		for (int i = 0; i < N; ++ i) {
			int wi = w[i] - n * u[i] - m * v[i];
			char ch = (char)('a' + i);
			for (int j = 0; j < wi; ++ j) {
				result[k ++] = ch;
			}
		}
		outln(new String(result, 0, k));
	}

	void main() {
		in();
		
		buildWUV();

		searchNM();

		if (n * b.length() + m * c.length() > a.length()) {
			outln("err: a.n = " + a.length() + ", b.n = " + b.length() + ", c.n = " + c.length() + ", n = " + n + ", m = " + m);
			for (int i = 0; i < N; ++ i) {
				out(w[i] + " ");
			}
			outln("");
			for (int i = 0; i < N; ++ i) {
				out(u[i] + " ");
			}
			outln("");
			for (int i = 0; i < N; ++ i) {
				out(v[i] + " ");
			}
			outln("");
		}

		out();
	}

	Scanner in = new Scanner(System.in);
    public static void main(String[] args) { new B().main(); }
    static void out(Object s) { System.out.print(s + ""); }
    static void outln(Object s) { System.out.println(s + ""); }

}