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
 *
 * @author baukaman
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
            int n = in.nextInt();
            int k = in.nextInt();

            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            int c = in.nextInt() - 1;
            int d = in.nextInt() - 1;

            if (k == n - 1 || k == n || n == 4) {
                out.println(-1);
                return;
            }

            int[] t = new int[n];

            for (int i = 0; i < n; i++) {
                t[i] = i;
            }

            for (int i = 0; i < n; i++)
                for (int j = 0; j + 1 < n; j++) {
                    if (t[j + 1] == a || t[j + 1] == b || t[j + 1] == c || t[j + 1] == d) {
                        int temp = t[j + 1];
                        t[j + 1] = t[j];
                        t[j] = temp;
                    }
                }


            t[0] = a;
            t[1] = b;
            t[2] = c;
            t[3] = d;


            out.print((a + 1) + " " + (c + 1) + " ");
            for (int i = 4; i < n; i++)
                out.print((t[i] + 1) + " ");
            out.print((d + 1) + " " + (b + 1));

            out.println();

            out.print((c + 1) + " " + (a + 1) + " ");
            for (int i = 4; i < n; i++)
                out.print((t[i] + 1) + " ");
            out.print((b + 1) + " " + (d + 1));


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

