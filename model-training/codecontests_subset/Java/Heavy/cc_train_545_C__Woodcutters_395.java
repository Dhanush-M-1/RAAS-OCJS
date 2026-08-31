import java.util.StringTokenizer;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		FastReader in = new FastReader();
		PrintWriter b = new PrintWriter(new BufferedOutputStream(System.out));
		int n = in.nextInt();
		int grid[][] = new int[n][2];
		if (n == 1) {
			System.out.println(n); // special case
			return;
		}

		for (int i = 0; i < n; i++) {
			grid[i][0] = in.nextInt();
			grid[i][1] = in.nextInt();

		}

		int ans = 2;
		for (int i = 1; i < n - 1; i++) {

			if (grid[i][0] - grid[i - 1][0] > grid[i][1])
				ans++;
			else if (grid[i + 1][0] - grid[i][0] > grid[i][1]) {
				ans++;
				grid[i][0] += grid[i][1];

			}

		}

		b.println(ans);

		b.close();
	}
}

class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));

	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return st.nextToken();

	}

	int nextInt() {

		return Integer.parseInt(next());
	}

	double nextDouble() {

		return Double.parseDouble(next());
	}

	long nextLong() {

		return Long.parseLong(next());
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return str;

	}

}
