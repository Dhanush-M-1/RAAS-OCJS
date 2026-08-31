import java.io.*;
import java.util.*;

public class CodeForces {

	public void solve() throws IOException {
		int a = nextInt();
		double b = nextDouble();
		int c = nextInt();

		int t = Math.max(0, (int) Math.ceil((a * c - b * c) / b));
		out.print(t);
	}

	private String checkMask(int i) {
		String s = String.valueOf(i);
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < s.length(); j++) {
			if (s.charAt(j) == '4' || s.charAt(j) == '7') {
				sb.append(s.charAt(j));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		new CodeForces().run();
	}

	int NOD(int a, int b) {
		while (a != 0 && b != 0) {
			if (a >= b)
				a = a % b;
			else
				b = b % a;
		}
		return a + b;
	}

	BufferedReader reader;
	StringTokenizer tokenizer;
	PrintWriter out;
	boolean isOuterFile = false;

	public void run() {
		try {
			if (isOuterFile) {
				reader = new BufferedReader(new FileReader("input.txt"));
				out = new PrintWriter(new BufferedWriter(new FileWriter(
						"output.txt")));
			} else {
				reader = new BufferedReader(new InputStreamReader(System.in));
				out = new PrintWriter(System.out);
			}

			tokenizer = null;
			// long time = new Date().getTime();
			solve();
			// out.println(time - new Date().getTime());
			reader.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}
}