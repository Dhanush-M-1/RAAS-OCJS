import java.io.*;
import java.util.*;

public class E990{

	private void solve() throws Exception {
		int n = nextInt();
		int m = nextInt();
		int k = nextInt();
		int[] relocate = new int[n+1];
		for(int i = 0; i < m; i++) relocate[nextInt()] = -1;
		long[] a = new long[k+1];
		for(int i = 1; i <= k; i++) a[i] = nextLong();

		
		int longest = 0;
		int last = -1;
		for(int i = 0; i <= n; i++) {
			if(relocate[i] == -1) relocate[i] = last;
			else {
				longest = Math.max(longest, i-last-1);
				relocate[i] = i;
				last = i;
			}
		}
		if(relocate[0] == -1) {
			out.println(-1);
			return;
		}
		
		long best = 1L<<60;
		for(int t = longest+1; t <= k; t++) {
			int s = 0;
			long count = 1;
			while(s+t < n) {
				count++;
				s = s+t;
				s = relocate[s];
			}
			best = Math.min(count*a[t], best);
		}
		out.println(best==1L<<60?-1:best);
	}
	
	public static void main(String[] args) {
		(new E990()).run();
	}

	private BufferedReader in;
	private PrintWriter out;
	private StringTokenizer tokenizer;

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
			out = new PrintWriter(System.out);
			solve();
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	private long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	private float nextFloat() throws IOException {
		return Float.parseFloat(nextToken());
	}

	private String nextLine() throws IOException {
		return new String(in.readLine());
	}

	private String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(in.readLine());
		}
		return tokenizer.nextToken();
	}


}