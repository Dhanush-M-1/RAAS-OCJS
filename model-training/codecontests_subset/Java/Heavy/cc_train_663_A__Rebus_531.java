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
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String line = null;
            try {
                line = in.reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String tokens[] = line.split(" ");
            int pluses = 1;
            int minuses = 0;
            int numbers = 0;
            int N = 0;
            for (String token : tokens) {
                if ("+".equals(token)) {
                    pluses++;
                } else if ("-".equals(token)) {
                    minuses++;
                } else if ("?".equals(token)) {
                    numbers++;
                } else if ("=".equals(token)) {

                } else {
                    N = Integer.parseInt(token);
                }
            }

            for (int x = pluses; x <= pluses * N; x++) {
                int y = x - N;
                if (possible(pluses, x, N) && possible(minuses, y, N)) {
                    ArrayList<Integer> pl = generate(pluses, x, N);
                    ArrayList<Integer> mi = generate(minuses, y, N);
                    int i = 0;
                    int j = 0;
                    out.println("Possible");
                    boolean fromPluses = true;
                    for (String token : tokens) {
                        if ("+".equals(token)) {
                            fromPluses = true;
                            out.print("+ ");
                        } else if ("-".equals(token)) {
                            fromPluses = false;
                            out.print("- ");
                        } else if ("?".equals(token)) {
                            if (fromPluses) {
                                out.print(pl.get(i++) + " ");
                            } else {
                                out.print(mi.get(j++) + " ");
                            }
                        } else if ("=".equals(token)) {
                            out.print("= ");
                        } else {
                            out.print(N);
                        }
                    }
                    out.println();
                    return;
                }
            }
            out.println("Impossible");
        }

        private ArrayList<Integer> generate(int numbers, int X, int N) {
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < numbers; i++) {
                int numbersAfterMe = numbers - i - 1;
                int minimalAfterMe = numbersAfterMe * 1;
                int maximalForMe = Math.min(N, X - minimalAfterMe);
                ans.add(maximalForMe);
                X -= maximalForMe;
            }
            return ans;
        }

        private boolean possible(int numbers, int X, int N) {
            return X >= numbers && X <= N * numbers;
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

    }
}

