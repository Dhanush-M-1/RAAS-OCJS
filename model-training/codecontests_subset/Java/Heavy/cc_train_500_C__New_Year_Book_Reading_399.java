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
 * @author To Huu Quan
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
        int m = in.nextInt();
        int[] w = new int[n + 1];
        for (int i = 1; i <= n; ++i)
            w[i] = in.nextInt();
        int[] b = new int[m + 1];
        for (int i = 1; i <= m; ++i)
            b[i] = in.nextInt();

        int[] pos = new int[n + 1];
        int[] a = new int[m + n + 1];
        int cur = m;
        for (int i = 1; i <= m; ++i)
            if (pos[b[i]] == 0) {
                ++cur;
                pos[b[i]] = cur;
                a[cur] = b[i];
            }

        cur = m;
        long res = 0;
        for (int i = 1; i <= m; ++i) {
            int p = pos[b[i]];
            int sum = 0;
            for (int j = 1; j < p; ++j) sum += w[a[j]];
            res += sum;
            a[p] = 0;
            a[cur] = b[i];
            pos[b[i]] = cur;
            --cur;
        }

        out.println(res);
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

