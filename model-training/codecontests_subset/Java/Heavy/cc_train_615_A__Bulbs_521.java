import java.io.*;
import java.util.*;

public class Bulbs {
	static final Input in = new Input();
	static final PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int n=in.nextInt(), m=in.nextInt();
		boolean[] on = new boolean[m];
		Arrays.fill(on, false);
		for(int i=0; i<n; i++) {
			int xi=in.nextInt();
			for(int j=0; j<xi; j++)
				on[in.nextInt()-1]=true;
		}
		for(int i=0; i<m; i++) {
			if(!on[i]) {
				out.println("NO");
				out.close();
				return;
			}
		}
		out.println("YES");
		out.close();
	}

	static class Input {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String next() {
			while(st==null||!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}