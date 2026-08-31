import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task385A {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] x = new int[n];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			x[i] = Integer.parseInt(st.nextToken());
		}
		
		int p = 0;
		for (int i = 0; i < n - 1; i++) {
			int t = x[i] - x[i + 1] - c;
			if (t > p) { p = t; }
		}
		
		System.out.println(p);
	}
}