import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            int p = in.nextInt();
            int[] people = new int[n];
            int[] keys = new int[k];
            for (int i = 0; i < n; i++) people[i] = in.nextInt();
            for (int i = 0; i < k; i++) keys[i] = in.nextInt();
            Arrays.sort(people);
            Arrays.sort(keys);
            long min = Long.MAX_VALUE;
            for (int i = 0; i <= k - n; i++) {
                long cur = 0;
                for (int j = i; j < i + n; j++) {
                    cur = Math.max(cur, Math.abs(keys[j] - people[j - i]) + Math.abs(keys[j] - p));
                }
                min = Math.min(min, cur);
            }
            out.println(min);
        }

    }

    static class InputReader {
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
}

