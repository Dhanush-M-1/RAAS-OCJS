import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
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
        ProblemAASerialKiller solver = new ProblemAASerialKiller();
        solver.solve(1, in, out);
        out.close();
    }

    static class ProblemAASerialKiller {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            HashSet<String> set = new HashSet<>();
            set.add(in.next());
            set.add(in.next());
            for (String s : set) out.print(s + " ");
            out.println();
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                set.remove(in.next());
                set.add(in.next());
                for (String s : set) out.print(s + " ");
                out.println();
            }
        }

    }

    static class InputReader {
        private StringTokenizer tokenizer;
        private BufferedReader reader;

        public InputReader(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        private void fillTokenizer() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public String next() {
            fillTokenizer();
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

