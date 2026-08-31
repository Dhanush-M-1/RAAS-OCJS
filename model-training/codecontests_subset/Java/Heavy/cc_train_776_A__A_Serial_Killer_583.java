import java.io.*;
import java.util.*;

public class Main {
    final private Input input;
    final private PrintWriter output;

    public class Input {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        Input() throws FileNotFoundException {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextLine() throws IOException {
            return reader.readLine();
        }

        String nextToken() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(nextLine());
            }
            return tokenizer.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(nextToken());
        }

        long nextLong() throws IOException {
            return Long.parseLong(nextToken());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(nextToken());
        }
    }

    public Main() throws FileNotFoundException {
        input = new Input();
        output = new PrintWriter(System.out);
    }

    private void close() {
        output.flush();
    }

    public static void main(String[] args) throws IOException {
        Main solver = new Main();
        solver.solve();
        solver.close();
    }

    private void solve() throws IOException {
        String a = input.nextToken();
        String b = input.nextToken();
        System.out.println(a + " " + b);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            String x = input.nextToken();
            String y = input.nextToken();
            String u = y;
            String v = (Objects.equals(a, x) ? b : a);
            a = u;
            b = v;
            System.out.println(a + " "+ b);
        }
    }
}