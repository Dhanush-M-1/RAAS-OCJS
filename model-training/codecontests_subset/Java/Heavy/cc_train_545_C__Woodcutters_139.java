import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class CF {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        int T = 1;//in.nextInt();
        for ( ; T != 0; T--) solver.solve(in, out);
        out.close();
    }
}

class Task {
    public void solve(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] x = new int[n + 1];
        int[] h = new int[n + 1];
        int[][] f = new int[n + 1][3];
        x[0] = -(int)1e9;
        h[0] = 0;
        for (int i = 1; i <= n; ++i) {
            x[i] = in.nextInt();
            h[i] = in.nextInt();
            for (int j = 0; j < 3; ++j) {
                for (int k = 0; k < 3; ++k) {
                    int tj = j - 1, tk = k - 1;
                    int mj = Math.min(x[i], x[i] + tj * h[i]), mk = Math.max(x[i - 1], x[i - 1] + tk * h[i - 1]);
                    if (mk < mj) f[i][j] = Math.max(f[i][j], f[i - 1][k] + (j != 1 ? 1 : 0));
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 3; ++i) {
            ans = Math.max(ans, f[n][i]);
        }
        out.println(ans);
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