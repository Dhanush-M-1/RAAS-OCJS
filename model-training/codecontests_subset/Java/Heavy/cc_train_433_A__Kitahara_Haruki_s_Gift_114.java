import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CF_433A_KitahraHarukisGift {
	static int[][] dp = new int[10001][101];
	static int[] arr;

	public static boolean recurse(int sum, int index) {
	
		if (sum == 0){
			return true;
			}
		if (sum < 0)
			return false;
		if(index>arr.length-1)
			return false ;
		
		if (dp[sum][index] != -1)
			return dp[sum][index] == 1 ? true : false;
		
		boolean Noskip = recurse(sum-arr[index],index+1);
		boolean skip = recurse(sum,index+1);
		dp[sum][index]= Noskip||skip?1:0;
		return Noskip||skip;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s1 = 0;
		int s2 = 0;
		int sum = 0;
		for (int i = 0; i < 10001; i++) {
			for (int j = 0; j < 101; j++)
				dp[i][j] = -1;
		}
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] == 100) {
				s1++;
				sum += 100;
			} else {
				s2++;
				sum += 200;
			}
		}

		System.out.println(recurse(sum / 2, 0) ? "YES" : "NO");
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(String s) throws Exception {
			br = new BufferedReader(new FileReader(s));
		}

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
}
