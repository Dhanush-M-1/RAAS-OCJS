import java.util.*;
import java.io.*;

public class F {
	Scanner in;
	PrintWriter out;

	int n;
	int[][] a;
	int res = 0;

	int read(int i, int j) {
		a[i][j] = in.nextInt();
		return (j < n - 1) ? read(i, j + 1) : ((i < n - 1) ? read(i + 1, 0) : 0);
	}

	int floyd(int k, int i, int j) {
		a[i][j] = Math.min(a[i][j], a[i][k] + a[k][j]);
		return (j < n - 1) ? (floyd(k, i, j + 1))
				: ((i < n - 1) ? (floyd(k, i + 1, 0)) : ((k < n - 1) ? (floyd(k + 1, 0, 0)) : (0)));
	}
	
	int max(int i, int j) {
		res = Math.max(res, a[i][j]);
		return (j < n - 1) ? max(i, j + 1) : ((i < n - 1) ? max(i + 1, 0) : 0);
	}

	public void solve() throws IOException {
		n = in.nextInt();
		a = new int[n][n];
		read(0, 0);
		floyd(0, 0, 0);
		max(0, 0);
		out.println(res);
	}

	public void run() {
		try {
			in = new Scanner(System.in);
			out = new PrintWriter(System.out);

			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] arg) {
		new F().run();
	}
}