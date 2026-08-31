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
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int N = in.nextInt();
            int topLeft = 0;
            int cnt1 = 0;
            int cnt2 = 0;
            int[][] matrix = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                char[] s = in.next().toCharArray();
                for (int j = 1; j <= N / 4; j++) {
                    char c = s[j - 1];
                    int bit = Integer.parseInt(Character.toString(c), 16);
                    for (int b = 0; b < 4; b++) {
                        if (((bit) & (1 << b)) > 0) {
                            matrix[i][j * 4 - b] = 1;
                        }
                    }
                }
            }
            for (int guess = N; guess >= 1; guess--) {
                if (N % guess == 0) {
                    boolean flag = true;
                    for (int i = 1; i <= N / guess; i++) {
                        for (int j = 1; j <= N / guess; j++) {
                            int start = matrix[i * guess][j * guess];
                            for (int ki = 0; ki < guess; ki++) {
                                for (int kj = 0; kj < guess; kj++) {
                                    if (matrix[i * guess - ki][j * guess - kj] != start) {
                                        flag = false;
                                        break;
                                    }
                                }
                                if (!flag) {
                                    break;
                                }
                            }
                            if (!flag) {
                                break;
                            }
                        }
                        if (!flag) {
                            break;
                        }
                    }
                    if (flag) {
                        out.println(guess);
                        return;
                    }
                }
            }
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

