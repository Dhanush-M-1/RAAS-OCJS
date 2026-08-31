import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(in, out);
        out.close();
    }

    public static class TaskA {
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            String s = in.next();
            int main = 0, other = 0;
            for (int i = 0; i < n; i++)
                if (s.charAt(i) == '8')
                    main++;
                else
                    other++;
            int can = main;
            int real = other / 10;
            if (can <= real)
                out.println(can);
            else {
                int best = real;
                while (true) {
                    can--;
                    other++;
                    real = other / 10;
                    best = Math.max(best, Math.min(can, real));
                    if (can <= 0)
                        break;
                }
                out.println(best);
            }
        }
    }

    public static class InputReader {
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