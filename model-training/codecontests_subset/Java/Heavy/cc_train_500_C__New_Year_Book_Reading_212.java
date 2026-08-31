import java.util.Arrays;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.math.BigInteger;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author minhthai
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
        int n = in.nextInt(), m = in.nextInt();
        int []w = new int[n], memo = new int[501];
        int []b = new int[m];

        for(int i = 0; i < n; ++i)
            w[i] = in.nextInt();

        for(int i = 0; i < m; ++i)
            b[i] = in.nextInt();

        int ans = 0;
        for(int i = 0; i < m; ++i) {
            int lift = 0;
            for(int j = i - 1; j >= 0 && b[j] != b[i]; --j) {
                if(memo[b[j]] == 0) {
                    lift += w[b[j] - 1];
                    memo[b[j]] = 1;
                }
            }
            Arrays.fill(memo, 0);
            ans += lift;
        }

        out.println(ans);
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
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
