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
		
		
		
		int n = sc.nextInt(); // buttons
		int m = sc.nextInt(); // bulbs
		
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			
			for (int j = 0; j < x; j++) {
				set.add(sc.nextInt());
			}
		}
		
		
		
		if (set.size() == m) {
			out.println("YES");
		}
		else {
			out.println("NO");
		}
		
		
		
		
		
		out.close();
	}
}











