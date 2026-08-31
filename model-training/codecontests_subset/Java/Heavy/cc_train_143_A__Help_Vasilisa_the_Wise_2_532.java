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
		
		
		int r1 = sc.nextInt();
		int r2 = sc.nextInt();
		
		int c1 = sc.nextInt();
		int c2 = sc.nextInt();
		 
		int d1 = sc.nextInt();
		int d2 = sc.nextInt();
		
		int[][] res = new int[2][2];
		boolean found = false;
		
		for (int r1c1 = 1; r1c1 <= 9; r1c1++) {			
			for (int r1c2 = 1; r1c2 <= 9; r1c2++) {
				if (r1c2 == r1c1) continue;
				
				for (int r2c1 = 1; r2c1 <= 9; r2c1++) {
					if (r2c1 == r1c1 || r2c1 == r1c2) continue;
					
					for (int r2c2 = 1; r2c2 <= 9; r2c2++) {
						if (r2c2 == r1c1 || r2c2 == r1c2 || r2c2 == r2c1) continue;
						
						if ((r1 == (r1c1 + r1c2)) &&
							(r2 == (r2c1 + r2c2)) &&
							(c1 == (r1c1 + r2c1)) &&
							(c2 == (r1c2 + r2c2)) &&
							(d1 == (r1c1 + r2c2)) &&
							(d2 == (r1c2 + r2c1))) {
							found = true;
							res[0][0] = r1c1;
							res[0][1] = r1c2;
							res[1][0] = r2c1;
							res[1][1] = r2c2;
						}
					}
				}
			}
		}
		
		if (found) {
			out.println(res[0][0] + " " + res[0][1]);
			out.println(res[1][0] + " " + res[1][1]);
		}
		else {
			out.println(-1);
		}
		
		
		out.close();
	}
}






















