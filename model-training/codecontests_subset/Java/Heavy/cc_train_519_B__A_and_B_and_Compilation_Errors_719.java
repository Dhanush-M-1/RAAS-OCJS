import java.io.*;
import java.util.*;
import java.lang.*;

public class AandBandCompilationErrors {

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

		FastReader sc = new FastReader();

		int n = sc.nextInt();
		long[] arr = new long[n];
		long[] arr2 = new long[n];
		long[] arr3 = new long[n];
		long sum = 0;
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextLong();
			sum = sum + arr[i];
		}
		for(int i=0; i<n-1; i++) {
			arr2[i] = sc.nextLong();
			sum = sum - arr2[i];
		}
		System.out.println(sum);
		sum = arr2[n-2];
		
		for(int i=0; i<n-2; i++) {
			arr3[i] = sc.nextLong();
			sum = sum + arr2[i] - arr3[i];
		}
		System.out.println(sum);
	}
}
