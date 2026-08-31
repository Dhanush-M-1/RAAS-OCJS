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
 *
 * @author Nasko
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

            int N = in.nextInt();
            String line = in.nextLine();
            ArrayList<Integer> ar = new ArrayList<Integer>();
            boolean[] can = new boolean[1001];
            for (int i = 0; i < line.length(); ++i) {
                if (line.charAt(i) == '*') {
                    ar.add(i);
                    can[i] = true;
                }
            }

            for (int i = 0; i < ar.size(); ++i) {
                int start = ar.get(i);
                for (int j = 1; j <= 100; ++j) {
                    boolean magic = true;
                    int tt = start;
                    for (int t = 0; t < 4; ++t) {
                        tt += j;
                        if (tt <= 100) {
                            magic &= can[tt];
                        } else magic = false;
                    }
                    if (magic) {
                        out.println("yes");
                        return;
                    }
                }
            }
            out.println("no");
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

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }
}

