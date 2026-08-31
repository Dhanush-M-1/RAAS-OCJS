import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Wolfgang Beyer
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
        boolean[][] mat;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            mat = new boolean[n + 1][n + 1];
            for (int i = 0; i <= n; i++) {
                mat[i] = new boolean[n + 1];
            }
            for (int row = 1; row <= n; row++) {
                String s = in.next();
                for (int col = 1; col <= n; col += 4) {
                    String c = s.substring((col - 1) / 4, (col - 1) / 4 + 1);
                    int dec = Integer.parseInt(c, 16);
                    if ((dec & 8) != 0) {
                        mat[row][col] = true;
                    }
                    if ((dec & 4) != 0) {
                        mat[row][col + 1] = true;
                    }
                    if ((dec & 2) != 0) {
                        mat[row][col + 2] = true;
                    }
                    if ((dec & 1) != 0) {
                        mat[row][col + 3] = true;
                    }
                }
            }

            int result = 1;
            for (int i = n; i > 1; i--) {
                if (n % i != 0) continue;
                boolean possible = true;
                for (int row = 1; row <= n / i; row++) {
                    for (int col = 1; col <= n / i; col++) {
                        if (!compare(1 + (row - 1) * i, row * i, 1 + (col - 1) * i, col * i)) {
                            possible = false;
                            break;
                        }
                    }
                    if (!possible) break;
                }
                if (possible) {
                    result = i;
                    break;
                }
            }

            out.println(result);
        }

        boolean compare(int top, int bottom, int left, int right) {
            boolean soll = mat[top][left];
            for (int row = top; row <= bottom; row++) {
                for (int col = left; col <= right; col++) {
                    if (mat[row][col] != soll) {
                        return false;
                    }
                }
            }
            return true;
        }

    }

    static class InputReader {
        private static BufferedReader in;
        private static StringTokenizer tok;

        public InputReader(InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            try {
                while (tok == null || !tok.hasMoreTokens()) {
                    tok = new StringTokenizer(in.readLine());
                    //tok = new StringTokenizer(in.readLine(), ", \t\n\r\f"); //adds commas as delimeter
                }
            } catch (IOException ex) {
                System.err.println("An IOException was caught :" + ex.getMessage());
            }
            return tok.nextToken();
        }

    }
}

