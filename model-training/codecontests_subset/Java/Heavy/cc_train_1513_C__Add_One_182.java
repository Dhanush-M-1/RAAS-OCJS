//package boj_main;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	public static MyScanner sc = new MyScanner();

	static int pi(String s) {
		return Integer.parseInt(s);
	}

	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
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

	static boolean palindrome(int s, int e, int[] arr, int[][] chk) {
		if (e - s == 0) {
			return true;
		} else if (chk[s][e] != 0) {
			if (chk[s][e] == 1) {
				return false;
			} else {
				return true;
			}
		} else {
			int left = s;
			int right = e;
			while ((right - left) >= 1) {

				if (arr[right] != arr[left]) {
					chk[left][right] = 1;
					return false;
				}
				left += 1;
				right -= 1;
			}

			left = s;
			right = e;
			while ((right - left) > 1) {
				chk[left][right] = 2;
				left += 1;
				right -= 1;
			}
		}
		return true;

	}

	static int get(int n, int s) {
		int sum = 0;
		for(int i=0; i<10; i++) {
			sum += arrr[n+s][i];
			sum%=(int)(1e9+7);
		}
		return sum;
	}
	static int[][] arrr = new int[200010][10];
	public static void main(String[] args) throws Exception {
		arrr[0][0] = 1;
		for(int i=0; i<200009; i++) {
			int temp = arrr[i][9];
				for(int l=8; l>=0; l--) {
					arrr[i+1][l+1] = arrr[i][l];
				}
				arrr[i+1][0] = temp;
				arrr[i+1][1] += temp;
				arrr[i+1][1]%=(int)(1e9+7);
			}
//		for(int i=0; i<100; i++) {
//			for(int j=0; j<10; j++) {
//				System.out.print(arrr[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			char[] ch = sc.next().toCharArray();
			int[] arr = new int[10];
			for(int j=0; j<ch.length; j++) {
				arr[ch[j]-'0']++;
			}
			int k = sc.nextInt();
			
			long sum = 0;
			for(int j=0; j<10; j++) {
				sum += (long)arr[j]*get(j, k);
				sum%=(int)(1e9+7);
			}
			out.println(sum);
			
				
		}
		out.flush();
	}

}
