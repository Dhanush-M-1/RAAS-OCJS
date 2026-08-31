import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<Integer> c1 = new ArrayList<Integer>();
		ArrayList<Integer> c2 = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			int t = sc.nextInt();
			int a = sc.nextInt();
			int d = sc.nextInt();
			if (a == 1 && d == 0) {
				c1.add(t);
			} else if (a == 0 && d == 1)
				c2.add(t);
			else if (a == 1 && d == 1)
				b.add(t);
		}
		Collections.sort(c1);
		Collections.sort(c2);
		Collections.sort(b);
		int idx1 = 0;
		int idx2 = 0;
		int idx3 = 0;
		long ans = 0;
		while (k-- > 0) {
			int optionA = Integer.MAX_VALUE;
			int optionB = Integer.MAX_VALUE;
			if (idx1 < c1.size() && idx2 < c2.size()) {
				optionA = c1.get(idx1) + c2.get(idx2);

			}
			if (idx3 < b.size()) {
				optionB = b.get(idx3);
			}
			if (optionA==Integer.MAX_VALUE && optionB == Integer.MAX_VALUE) {
				System.out.println(-1);
				return;
			}
			if(optionB<=optionA ) {
				ans+=optionB;
				idx3++;
			}else {
				ans+=optionA;
				idx1++;
				idx2++;
			}
		}
		System.out.println(ans);

	}

	public static int powThree(int n) {
		int ans = 0;
		while (n % 3 == 0 && n != 0) {
			ans++;
			n /= 3;
		}
		return ans;
	}

	public static int powTwo(int n) {
		int ans = 0;
		while (n % 2 == 0 && n != 0) {
			ans++;
			n /= 2;
		}
		return ans;
	}

}

class Scanner {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s) {
		br = new BufferedReader(new InputStreamReader(s));
	}

	public String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	public String nextLine() throws IOException {
		return br.readLine();
	}

	public double nextDouble() throws IOException {
		String x = next();
		StringBuilder sb = new StringBuilder("0");
		double res = 0, f = 1;
		boolean dec = false, neg = false;
		int start = 0;
		if (x.charAt(0) == '-') {
			neg = true;
			start++;
		}
		for (int i = start; i < x.length(); i++)
			if (x.charAt(i) == '.') {
				res = Long.parseLong(sb.toString());
				sb = new StringBuilder("0");
				dec = true;
			} else {
				sb.append(x.charAt(i));
				if (dec)
					f *= 10;
			}
		res += Long.parseLong(sb.toString()) / f;
		return res * (neg ? -1 : 1);
	}

	public boolean ready() throws IOException {
		return br.ready();
	}

}
