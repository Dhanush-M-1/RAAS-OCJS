import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Hieu Le
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] x = new int[n];
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            h[i] = in.nextInt();
        }
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            if (i == 0) dp[i][0] = 1;
            else if (x[i] - h[i] > x[i - 1]) {
                dp[i][0] = Math.max(dp[i - 1][0] + 1, dp[i - 1][1] + 1);
                if (h[i - 1] + h[i] < x[i] - x[i - 1])
                    dp[i][0] = Math.max(dp[i][0], dp[i - 1][2] + 1);
            }
            if (i > 0) {
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][2]);
            }
            if (i == n - 1 || x[i] + h[i] < x[i + 1])
                dp[i][2] = dp[i][1] + 1;
        }
        int res = Math.max(dp[n - 1][0], dp[n - 1][1]);
        res = Math.max(res, dp[n - 1][2]);
        out.println(res);
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

}

