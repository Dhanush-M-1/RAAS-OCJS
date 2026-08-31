import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int minus = 0, plus = 1;
            List<Integer> sign = new ArrayList<>();
            sign.add(1);
            while (true) {
                String s = in.next();
                if (s.equals("=")) break;
                else if (s.equals("+")) {
                    sign.add(1);
                    plus++;
                } else if (s.equals("-")) {
                    sign.add(-1);
                    minus++;
                }
            }
            int num = in.nextInt();
            if (plus - num * minus > num || num * plus - minus < num) {
                out.println("Impossible");
                return;
            }
            out.println("Possible");
            int sofar = 0;
            boolean flag = true;
            for (int current : sign) {
                if (current == -1) minus--;
                else plus--;
                for (int x = 1; x <= num; x++) {
                    int min_left = sofar + current * x + plus - num * minus;
                    int max_left = sofar + current * x + num * plus - minus;
                    if (min_left <= num && num <= max_left) {
                        sofar += x * current;
                        if (!flag) out.print((current == -1 ? " - " : " + ") + x);
                        else out.print(x * current);
                        break;
                    }
                }
                flag = false;
            }
            out.println(" = " + num);
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

