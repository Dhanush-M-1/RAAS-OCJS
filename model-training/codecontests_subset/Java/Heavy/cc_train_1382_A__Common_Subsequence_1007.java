import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Codeforces {
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		FastReader in = new FastReader();
		int t = in.nextInt();
		boolean[] a, b;
		int[] arrA;
		int[] arrB;
		while (t-- > 0) {
			a = new boolean[1002];
			b = new boolean[1002];
			int n = in.nextInt();
			int m = in.nextInt();
			arrA = new int[n];
			arrB = new int[m];
			for (int i = 0; i < n; i++) {
				arrA[i] = in.nextInt();
				a[arrA[i]] = true;
			}
			for (int i = 0; i < m; i++) {
				arrB[i] = in.nextInt();
				b[arrB[i]] = true;
			}

			if (n >= m)
				print(arrA, b);
			else
				print(arrB, a);

		}
		out.close();

	}

	public static void print(int[] arrA, boolean[] b) {

		for (int i = 0; i < arrA.length; i++)
			if (b[arrA[i]]) {
				out.println("YES");
				out.println(1 + " " + arrA[i]);
				return;
			}

		out.println("NO");

	}

}

class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));

	}

	public FastReader(File f) throws FileNotFoundException {
		br = new BufferedReader(new FileReader(f));
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