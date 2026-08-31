import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class cf {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner();
		int t = sc.nextInt();
		PrintWriter out = new PrintWriter(System.out);
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] p = new int[n];
			for (int i = 0; i < n; i++) {
				p[i] = sc.nextInt();
			}
			int g = 0;
			for (; g < n && p[g] == p[0]; g++)
				;
			int s = g + 1;
			for (; s + g < n && p[s + g] == p[2 * g]; s++)
				;
			int i;
			int mid = n / 2;
			for (i = mid-1; i >= 0 && p[i] == p[mid]; i--)
				;
			int b = i + 1 - s - g;
			if (b < 0 || b <= g || s + b + g > n / 2) {
				out.println("0 0 0");
			} else {
				out.println(g + " " + s + " " + b);
			}
		}
		out.close();
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreElements())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}

}
