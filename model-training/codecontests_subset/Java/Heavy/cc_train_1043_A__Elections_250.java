import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author dmytro.prytula
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        AVibori solver = new AVibori();
        solver.solve(1, in, out);
        out.close();
    }

    static class AVibori {
        public void solve(int testNumber, InputReader in, PrintWriter out) {

            int n = in.nextInt();
            int[] a = in.nextArr(n);

            int sum = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < a.length; i++) {
                sum += a[i];
                max = Math.max(max, a[i]);
            }

            int all = max * n;
            int sum2 = all - sum;
            int k = max;
            while (sum2 <= sum) {
                sum2 += n;
                k++;
            }
            out.println(k);
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String nextToken() {
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
            return Integer.parseInt(nextToken());
        }

        public int[] nextArr(int size) {
            return Arrays.stream(new int[size]).map(c -> nextInt()).toArray();
        }

    }
}

