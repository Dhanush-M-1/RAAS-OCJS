import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF {

	static InputReader in = new InputReader(System.in);

	public static void main(String[] args) {

		int n = in.nextInt();

		int[][] arr = new int[2][n];

		for (int i = 0; i < n; i++) {
			arr[0][i] = in.nextInt();
			arr[1][i] = in.nextInt();
		}

		if (n == 1)
			System.out.println(1);
		else if (n == 2)
			System.out.println(2);
		else {
			int count = 2;

			for (int i = 1; i < n - 1; i++) {
				if (arr[1][i] < arr[0][i] - arr[0][i - 1]) {
					count++;
				} else if (arr[0][i + 1] - arr[0][i] > arr[1][i]) {
					count++;
					arr[0][i] += arr[1][i];
				}

			}

			System.out.println(count);
		}
	}
}

class InputReader {
	private BufferedReader reader;
	private StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = null;
	}

	public String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}

	public String readLine() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public long nextLong() {
		return Long.parseLong(next());
	}

	public double nextDouble() {
		return Double.parseDouble(next());
	}

	public float nextFloat() {
		return Float.parseFloat(next());
	}

}