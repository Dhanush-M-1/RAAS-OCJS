import java.io.*;
import java.util.*;
import java.math.*;

@SuppressWarnings("unused")
public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		InputStream inputStream = System.in;
		// InputStream inputStream = new FileInputStream(new File(
		// "C:\\Users\\Administrator\\Codeblocks\\First\\1.in"));
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

// 使用对象时,首先考虑是否要采用深复制

class TaskA {
	static final int mod = (int) 1e9 + 7;
	static final int INF = 0x7fffffff;
	static final double eps = 1e-15;
	static final int maxn = (int) 1e6;

	// 声明全局变量
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		long[] X = new long[5555];
		long[] Add = new long[5555];

		int[] op = new int[5555];
		int[] l = new int[5555];
		int[] r = new int[5555];
		int[] z = new int[5555];

		Arrays.fill(X, (int) 1e9);
		Arrays.fill(Add, 0);

		int N = in.nextInt(), M = in.nextInt();
		boolean flag = true;

		for (int i = 0; i < M; i++) {
			int t = in.nextInt(), L = in.nextInt(), R = in.nextInt(), x = in
					.nextInt();
			op[i] = t;
			l[i] = L;
			r[i] = R;
			z[i] = x;
			if (!flag)
				continue;
			if (t == 1) {
				for (int j = L; j <= R; j++) {
					X[j] += x;
					Add[j] += x;
				}
			} else {
				boolean Update = false;
				for (int j = L; j <= R; j++) {
					if (X[j] >= x) {
						X[j] = x;
						Update = true;
					}
				}
				if (!Update)
					flag = false;
			}
		}

		for (int i = 1; i <= N; i++) {
			X[i] -= Add[i];
			if (Math.abs(X[i]) > 1e9)
				flag = false;
		}

		if (flag) {
			for (int i = 0; i < M; i++) {
				if (op[i] == 1) {
					for (int j = l[i]; j <= r[i]; j++)
						X[j] += z[i];
				} else {
					long maxx = X[l[i]];
					for (int j = l[i]; j <= r[i]; j++) {
						maxx = Math.max(maxx, X[j]);
					}
					if (maxx != z[i]) {
						flag = false;
						break;
					}
				}
			}
		}

		if (!flag)
			out.println("NO");
		else {
			out.println("YES");
			for (int i = 1; i <= N; i++) {
				out.print(X[i] - Add[i]);
				if (i == N)
					out.print("\n");
				else
					out.print(" ");
			}
		}
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
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
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

	public double nextDouble() {
		return Double.parseDouble(next());
	}

}

		 		 		   		 	 	  		 	   		 		