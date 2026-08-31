import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintStream out = System.out;
        TaskA taskA = new TaskA();
        taskA.solve(in, out);

    }

    static class TaskA {
        void solve(InputReader in, PrintStream out) {
            int q = in.nextInt();
            for (int i = 0; i < q; i++) {
                double l = in.nextDouble(), r = in.nextDouble(), d = in.nextDouble();
                if (l > d) {
                    out.println((int)d);
                } else {
                    out.println(r % d == 0 ? (int)(r+d) : (int) (d * (int)Math.ceil(r / d) ));
                }
            }
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        double nextDouble() {return Double.parseDouble(next());}
    }
}
