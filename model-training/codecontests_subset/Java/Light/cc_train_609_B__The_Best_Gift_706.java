import static java.lang.Math.*; 

import java.io.*; 
import java.util.*; 
import java.math.*;

public class Main {
	BufferedReader in; 
	PrintWriter out;
	StringTokenizer st; 

	String next() {
		while (st==null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(in.readLine());
			} catch (Exception e) {}
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

	public void run() throws Exception {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		int n = nextInt(), m = nextInt();
		int[] cnt = new int[m + 1];
		for (int i = 0; i < n; i++) {
			cnt[nextInt()]++;
		}
		long ans = n * 1L * (n - 1) / 2;
		for (int i = 1; i <= m; i++) {
			ans -= cnt[i] * 1L * (cnt[i] - 1) / 2;
		}		
		out.println(ans);
		out.close(); 
 	}
	
	public static void main(String[] args) throws Exception {
		new Main().run(); 
	}

}