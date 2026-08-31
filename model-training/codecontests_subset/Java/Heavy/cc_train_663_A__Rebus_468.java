import java.io.*;
import java.util.*;

public class B {

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int plusCount = 1;
            int minusCount = 0;
            boolean plus = true;
            char[] signs = new char[128];
            int[] values = new int[128];
            int count = 0;
            while (true) {
                String buf = in.next();
                //debug(0, buf);
                buf = in.next();
                //debug(1, buf);
                if (buf.equals("=")) {
                    break;
                }
                signs[count++] = buf.charAt(0);
                if (buf.equals("+")) {
                    plusCount++;
                } else {
                    minusCount++;
                }
            }
            int n = in.nextInt();
            if (n * plusCount - minusCount >= n && 1 * plusCount - n * minusCount <= n) {
                Arrays.fill(values, 1);
                int current = plusCount - minusCount;
                while (current != n) {
                    if (current < n) {
                        for (int i = 0; i <= count; ++i) {
                            if (i == 0 || signs[i - 1] == '+') {
                                if (values[i] != n) {
                                    if (current + n - 1 > n) {
                                        values[i] += n - current;
                                        current = n;
                                    } else {
                                        values[i] += n - 1;
                                        current += n - 1;
                                    }
                                }
                            }
                        }
                    } else {
                        for (int i = 1; i <= count; ++i) {
                            if (signs[i - 1] == '-') {
                                if (values[i] != n) {
                                    if (current - (n - 1) < n) {
                                        values[i] += current - n;
                                        current = n;
                                    } else {
                                        values[i] += n - 1;
                                        current -= n - 1;
                                    }
                                }
                            }
                        }

                    }
                }
                out.println("Possible");
                for (int i = 0; i <= count; ++i) {
                    if (i > 0) {
                        out.print(" " + signs[i - 1] + " ");
                    }
                    out.print(values[i]);
                }
                out.println(" = " + n);
            } else {
                out.println("Impossible");
            }
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = new StringTokenizer("");
        }

        public String next() {
            while (!tokenizer.hasMoreTokens()) {
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        try {
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            InputReader in = new InputReader(inputStream);
            PrintWriter out = new PrintWriter(outputStream);
            Task solver = new Task();
            solver.solve(1, in, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}

