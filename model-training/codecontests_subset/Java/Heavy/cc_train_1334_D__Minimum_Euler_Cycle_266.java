import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

import javax.swing.*;

import static java.util.Arrays.binarySearch;
import static java.util.Arrays.copyOfRange;

public class Main {

    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }
}

class Task {

    private static int mod = 1000000007;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int T = in.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = in.nextInt();
            long l = in.nextLong();
            long r = in.nextLong();
            long cur = 1;
            for (int x = 1; x < n; x++) {
                if (cur > r) {
                    break;
                }
                long rM = cur + 2 * (n - x) - 1;
                if (rM < l) {
                    cur = rM + 1;
                    continue;
                }
                int y = x + 1;
                for (long i = cur; i <= Math.min(rM, r); i += 2) {
                    if (i >= l) {
                        out.print(x + " ");
                    }
                    if (i + 1 >= l && i + 1 <= r) {
                        out.print(y + " ");
                    }
                    y++;
                }
                cur = rM + 1;
            }
            if (r == n * (n - 1L) + 1) {
                out.print(1);
            }
            out.println();
        }

    }

    // 2 * n 2 * n - 1
    // 1 2 1 3 1 n 2 3 2 4 2 n 3 4 3 5 3 n 1 n - 1 n

}

class InputReader {

    private final BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(nextLine());
        }
        return tokenizer.nextToken();
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

}
