import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastInput in = new FastInput(inputStream);
        FastOutput out = new FastOutput(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, FastInput in, FastOutput out) {
            int n = in.readInt();
            String s = in.readString();

            String best = "";
            int ans = -1;
            for (char a = 'A'; a <= 'Z'; a++) {
                for (char b = 'A'; b <= 'Z'; b++) {
                    String t = String.valueOf(a) + String.valueOf(b);
                    int res = 0;
                    for (int i = 0; i + 1 < n; i++) {
                        String x = String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i + 1));
                        if (x.equals(t)) res++;
                    }

                    if (res > ans) {
                        best = t;
                        ans = res;
                    }
                }
            }

            out.printLine(best);
        }

    }

    static class FastInput {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastInput(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in), 1 << 16);
            tokenizer = null;
        }

        public String read() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (Exception ex) {
                    throw new InputMismatchException();
                }
            }
            return tokenizer.nextToken();
        }

        public int readInt() {
            return Integer.parseInt(read());
        }

        public String readString() {
            return read();
        }

    }

    static class FastOutput {
        private PrintWriter writer;

        public FastOutput(OutputStream out) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));
        }

        public FastOutput(Writer w) {
            writer = new PrintWriter(w);
        }

        public void print(Object... args) {
            for (int i = 0; i < args.length; i++) {
                if (i > 0) writer.print(' ');
                writer.print(args[i]);
            }
        }

        public void printLine(Object... args) {
            print(args);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }
}

