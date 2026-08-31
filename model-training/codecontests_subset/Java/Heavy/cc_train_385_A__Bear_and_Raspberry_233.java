import java.util.*;
import java.io.*;

public class File {
	public static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
		
		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e) {
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
	}
	
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		
		
		
		int n = sc.nextInt(); // Number of days
		int c = sc.nextInt(); // Number of kilos of raspberry
		
		int[] prices = new int[n]; // Price of 1 barrel in raspberries.
		for (int i = 0; i < n; i++) {
			prices[i] = sc.nextInt();
		}
		
		
		int res = 0;
		for (int d = 0; d + 1 < n; d++) {
			res = Math.max(res, prices[d] - prices[d+1] - c);
		}
		
		
		if (res > 0) {
			out.println(res);
		}
		else {
			out.println(0);
		}
		
		
		
		out.close();
	}
}






















