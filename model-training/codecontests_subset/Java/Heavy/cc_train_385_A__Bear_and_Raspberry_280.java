import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class ProblemA {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		String[] nc = in.readLine().split(" ");
		int n = Integer.valueOf(nc[0]);
		int c = Integer.valueOf(nc[1]);
		String[] xi = in.readLine().split(" ");
		int[] x = new int[n];
		for (int i = 0 ; i < n ; i++) {
			x[i] = Integer.valueOf(xi[i]);
		}
		
		int max = 0;
		for (int i = 0 ; i < n - 1 ; i++) {
			int p = x[i] - x[i+1] - c;
			max = Math.max(max, p);
		}
		out.println(max);
		out.flush();
	}

	
	public static void debug(Object... o) {
		System.err.println(Arrays.deepToString(o));
	}
}

