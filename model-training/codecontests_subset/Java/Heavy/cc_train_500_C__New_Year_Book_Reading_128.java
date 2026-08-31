import java.lang.*;
import java.io.*;
import java.util.*;


public class Reading {
	
	public static void main(String[] args) throws java.lang.Exception {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(in, out);
		out.close();
	}
}

class TaskA {
	
	public void solve(InputReader in, PrintWriter out) {
		int n = in.nextInt(), m = in.nextInt();
		int[] w = new int[n+1];
		int[] b = new int[m];
		boolean[] visit = new boolean[n+1];
		int i, j, k;
		int ans = 0;
		
		for (i=1; i<=n; ++i)
			w[i] = in.nextInt();
		for (i=0; i<m; ++i)
			b[i] = in.nextInt();
		
		for (i=0; i<m; ++i) {
			Arrays.fill(visit, false);
			for (j=i-1; j>=0; --j) {
				if (b[j] == b[i])
					break;
				if (!visit[b[j]]) {
					visit[b[j]] = true;
					ans += w[b[j]];
				}
			}
		}
		out.println(ans);
	}
}

class InputReader {
	public BufferedReader reader;
	public StringTokenizer tokenizer;
	
	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = null;
	}
	
	public String next() {
		while (tokenizer==null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}
	
	public int nextInt() {
		return Integer.parseInt(next());
	}
	
	public long nextLong() {
		return Long.parseLong(next());
	}
}
