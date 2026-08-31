// package Self;

import java.util.Scanner;
import java.util.Set;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

	static FastReader scn = new FastReader();

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String[] args) {

		int t = 1;
		StringBuilder sb = new StringBuilder();
		t = scn.nextInt();
		int maxN = (int) 2e5 + 10;
		long[] dp = new long[maxN];
		long mod = (long) (1e9 + 7);

		for (int i = 0; i < 10; i++) {
			dp[i] = 1;
		}

		for (int i = 10; i < dp.length; i++) {
			dp[i] = (dp[i - 10] + dp[i - 9]) % mod;
		}

		while (t-- > 0) {

			int n = scn.nextInt();
			int m = scn.nextInt();
			long ans = 0;

			while (n > 0) {
				int rem = n % 10;
				ans = (ans + dp[m + rem]) % mod;
				n /= 10;
			}

			sb.append(ans);
			sb.append("\n");
		}

		System.out.println(sb);

	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static long[] longInput(int n) {

		long[] arr = new long[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextLong();
		}

		return arr;

	}

	public static int[] input(int n) {

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		return arr;

	}

}