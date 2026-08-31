
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
			int n = sc.nextInt();
			String s = sc.next();
			solve(s, n);
		
	}

	private static void solve(String s, int n) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n - 1; i++) {
			String t = "" + s.charAt(i) + s.charAt(i + 1);
			map.put(t, map.getOrDefault(t, 0) + 1);
		}
		int max = Integer.MIN_VALUE;
		String ans = "";
		for (String t : map.keySet()) {
			if (map.get(t) > max) {
				max = map.get(t);
				ans = t;
			}
		}
		System.out.println(ans);
	}

	static void sort(int[] a) {
		ArrayList<Integer> l = new ArrayList<>();
		for (int i : a)
			l.add(i);
		Collections.sort(l);
		for (int i = 0; i < a.length; i++)
			a[i] = l.get(i);
	}

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

}
