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
		
		
		int n = sc.nextInt(); // Number of citizens
		int x = sc.nextInt(); // Number of wizards
		int y = sc.nextInt(); // Percentage needed
		
		
		// (answer + x) / (n / 100) = y
		// answer + x = y * (n / 100)
		// answer * 100 + x * 100 = y * n
		// answer = y * (n / 100) - x
		// answer = Math.ceil((y*n - 100*x) / 100)
		
		int answer = (int)Math.ceil((double)(y*n - 100*x) / 100.0);
		
		out.println(Math.max(0, answer));
		
		out.close();
	}
}






















