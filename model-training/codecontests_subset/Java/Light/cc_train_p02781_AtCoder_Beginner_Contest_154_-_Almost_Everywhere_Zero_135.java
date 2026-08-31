import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author AnandOza
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        EAlmostEverywhereZero solver = new EAlmostEverywhereZero();
        solver.solve(1, in, out);
        out.close();
    }

    static class EAlmostEverywhereZero {
        int n;
        int[] digits;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            char[] input = in.next().toCharArray();
            n = input.length;
            digits = new int[n];
            for (int i = 0; i < n; i++) {
                digits[i] = input[i] - '0';
            }
            int k = in.nextInt();

            long answer = f(0, k, true);

            out.println(answer);
        }

        private long f(int i, int k, boolean equal) {
            if (k == 0)
                return 1;

            long answer = 0;
            for (int j = i; j < n; j++) {
                if (equal) {
                    answer += digits[j] == 0 ? 0 : f(j + 1, k - 1, true);
                    answer += Math.max(digits[j] - 1, 0) * f(j + 1, k - 1, false);
                } else {
                    answer += 9 * f(j + 1, k - 1, false);
                }
                if (digits[j] > 0)
                    equal = false;
            }
            return answer;
        }

    }

    static class InputReader {
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
}

