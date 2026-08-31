import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.concurrent.LinkedBlockingDeque;

import javax.swing.border.Border;

public class a {

	public static long mod = (long) Math.pow(10, 9) + 7;
	public static int k = 0;

	private static class node {
		long min;
		long num;
		long gcd;

		node(long m, long n, long g) {
			min = m;
			num = n;
			gcd = g;
		}

	}

	public static class point implements Comparable<point> {
		long x;
		long y;
		long b;

		point(long x, long y, long b) {
			this.x = x;
			this.y = y;
			this.b = b;
		}

		@Override
		public int compareTo(point o) {
			if (k == 0)
				return (int) (o.x - x);
			else
				return (int) (y - o.y);

		}
	}

	public static int ch(long y) {
		int r = Long.bitCount(y);
		return r;
	}

	public static long gcd(long x, long y) {
		if (y == 0)
			return x;

		return gcd(y, x % y);
	}

	public static boolean ch[];
	public static ArrayList<Integer> prime;
	public static Queue<Integer> pp;

	public static void sieve(int k) {
		ch[0] = ch[1] = true;

		for (int i = 2; i <= k; i++) {
			if (!ch[i]) {
				prime.add(i);
				pp.add(i);
				for (int j = i + i; j <= k; j += i) {
					ch[j] = true;
				}
			}
		}

	}

	public static long pw(int x, int power, int mod) {
		if (power == 1)
			return x % mod;
		else if (power % 2 == 0)
			return pw((x % mod * x % mod) % mod, power / 2, mod);
		else
			return (pw(x, power - 1, mod) % mod * x % mod) % mod;

	}

	public static int swap[][];
	public static int parent[];

	public static boolean graph(int s, int e, int n) {
		boolean ch[] = new boolean[400];
		Arrays.fill(parent, -1);
		Queue<Integer> q = new LinkedList<>();
		ch[s] = true;
		if (s == e)
			return true;
		q.add(s);
		while (!q.isEmpty()) {
			int r = q.poll();

			if (r == e)
				return true;

			for (int i = 0; i < n; i++) {
				if (!ch[i] && swap[r][i] == 1) {
					q.add(i);
					parent[i] = r;
					ch[i] = true;

				}
			}
		}

		return false;

	}

	public static int a[];
	public static int index[];

	public static void solve(int s, int e) {

		while (parent[e] != -1) {
			index[a[parent[e]]] = e;
			index[a[e]] = parent[e];
			int temp = a[parent[e]];
			a[parent[e]] = a[e];
			a[e] = temp;
			e = parent[e];

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder qq = new StringBuilder();
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		String y[] = in.readLine().split(" ");
		int n = Integer.parseInt(y[0]);
		int m = Integer.parseInt(y[1]);
		int a[] = new int[n + 1];
		y = in.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(y[i - 1]);
		}
		y = in.readLine().split(" ");
		int day[] = new int[m];
		int c[] = new int[n];
		int ans[] = new int[n];
		int p = 0;
		HashSet<Integer> mp = new HashSet();
		for (int i = 0; i < day.length; i++) {
			day[i] = Integer.parseInt(y[i]);
			if (!mp.contains(day[i])) {
				ans[p++] = day[i];
				mp.add(day[i]);
			}

		}

		for (int i = 1; i <= n; i++) {
			if (!mp.contains(i))
				ans[p++] = i;
		}

		Stack<Integer> s = new Stack();

		for (int i = n - 1; i >= 0; i--) {
			s.add(ans[i]);
		}
		long answer = 0;
		Stack<Integer> temp = new Stack();
		for (int i = 0; i < m; i++) {
			int r = day[i];

			while (!s.isEmpty()) {
				int e = s.pop();
				// System.out.println(a[e]);

				if (e == r)
					break;
				temp.push(e);
				answer += (long)a[e];

			}

			while (!temp.isEmpty()) {
				s.push(temp.pop());
			}
			s.push(r);
		}
		System.out.println(answer);

		out.close();

	}
}