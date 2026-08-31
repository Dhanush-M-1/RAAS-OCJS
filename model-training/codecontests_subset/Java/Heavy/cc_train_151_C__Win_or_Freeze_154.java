import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author HossamDoma
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

    static class TaskC {
        public void solve(int testNumber, InputReader in, PrintWriter out) {

            long n = in.nextLong();

            ArrayList<Long> ls = fact(n);

            if (ls.size() <= 1)
                out.println("1\n0");
            else if (ls.size() == 2)
                out.println("2");
            else
                out.println("1\n" + ls.get(1) * ls.get(2));
        }

        private ArrayList<Long> fact(long n) {

            ArrayList<Long> tmp = new ArrayList<>();

            for (int i = 2, d = 1; (long) i * i <= n && tmp.size() < 3; i += d, d = 2) {
                while (n % i == 0) {
                    tmp.add((long) i);
                    n /= i;
                }
            }

            if (n > 1)
                tmp.add(n);

            return tmp;
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

        public Long nextLong() {
            return Long.parseLong(next());
        }

    }
}

