

import java.util.*;

import java.io.*;
import java.text.*;

public class E2_1374 {

	public static int bs(ArrayList<Pair> a, int key) {
		int lo = 0;
		int hi = a.size() - 1;
		int ans = -1;
		while (lo <= hi) {
			int mid = lo + hi >> 1;
			if (a.get(mid).val <= key) {
				ans = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return ans;
	}

	static class Pair implements Comparable<Pair> {
		int idx, val;

		public Pair(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}

		public int compareTo(Pair p) {
			return val - p.val;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<Pair>[] arr = new ArrayList[4];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<Pair>();
			arr[i].add(new Pair(0, 0));
		}
		for (int i = 0; i < n; i++) {
			int t = sc.nextInt();
			int x = sc.nextInt() | (sc.nextInt() << 1);
			arr[x].add(new Pair(i + 1, t));
		}
		for (ArrayList<Pair> al : arr)
			Collections.sort(al);
		int[][] presum = new int[4][];
		int[] ans = { 0, 0, 0, 0, Integer.MAX_VALUE, 0 };
		for (int i = 0; i < presum.length; i++) {

			presum[i] = new int[arr[i].size()];
			if (arr[i].size() == 0)
				continue;
			presum[i][0] = arr[i].get(0).val;
			for (int j = 1; j < presum[i].length; j++) {
				presum[i][j] = presum[i][j - 1] + arr[i].get(j).val;
			}
		}
		for (int d = 0; d < arr[3].size(); d++) {

			int c = Math.max(k - d, 0);

			if (c >= arr[1].size() || c >= arr[2].size())
				continue;
			if (d + 2 * c > m)
				continue;
			int lo = 0;
			int hi = (int) 1e4;
			int[] bsans = null;
			while (lo <= hi) {
				int mid = lo + hi >> 1;
				int idx0 = bs(arr[0], mid);
				int idx1 = Math.max(bs(arr[1], mid), c);
				int idx2 = Math.max(bs(arr[2], mid), c);
				int cand = presum[0][idx0] + presum[1][idx1] + presum[2][idx2] + presum[3][d];
				if (idx0 + idx1 + idx2 + d >= m) {
					bsans = new int[] { idx0, idx1, idx2, d, cand - (idx0 + idx1 + idx2 + d - m) * mid, mid };
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}
			if (bsans != null) {
				if (bsans[4] < ans[4]) {
					ans = bsans;
				}
			}
		}
		if (ans[4] == Integer.MAX_VALUE) {
			pw.println(-1);
		} else {
			pw.println(ans[4]);
			while (ans[0] + ans[1] + ans[2] + ans[3] > m) {
				for (int i = 0; i < 4; i++) {
					if (arr[i].get(ans[i]).val == ans[5]) {
						ans[i]--;
						break;
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j <= ans[i]; j++) {
					pw.print(arr[i].get(j).idx + " ");
				}
			}

		}
		pw.close();

	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader r) {
			br = new BufferedReader(r);
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
			return Double.parseDouble(next());
		}

		public int[] nextIntArr(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++)
				arr[i] = nextInt();
			return arr;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
