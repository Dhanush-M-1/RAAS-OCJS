import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
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
            long p = 1;
            long m = 0;
            ArrayList<Character> sign = new ArrayList<>();
            String s = in.next();
            while (!s.equals("=")) {
                s = in.next();
                if (s.equals("+")) {
                    sign.add('+');
                    p++;
                } else if (s.equals("-")) {
                    sign.add('-');
                    m++;
                }
            }
            sign.add('=');
            int n = in.nextInt();
            long maxV = p * n - m;
            long minV = p - m * n;
            if (minV <= n && n <= maxV) {
                out.println("Possible");
                long pSum = m + n;
                if (pSum < p) {
                    pSum = p;
                }
                long mSum = pSum - n;
                ArrayList<Integer> pVal = new ArrayList<>();
                for (int i = 0; i < p; i++) {
                    int cur = (int) (pSum / (p - i)) + (pSum % (p - i) > 0 ? 1 : 0);
                    pVal.add(cur);
                    pSum -= cur;
                }
                ArrayList<Integer> mVal = new ArrayList<>();
                for (int i = 0; i < m; i++) {
                    int cur = (int) (mSum / (m - i)) + (mSum % (m - i) > 0 ? 1 : 0);
                    mVal.add(cur);
                    mSum -= cur;
                }
                boolean lastPlus = true;
                int indM = 0;
                int indP = 0;
                for (char c : sign) {
                    if (lastPlus) {
                        out.print(pVal.get(indP));
                        indP++;
                    } else {
                        out.print(mVal.get(indM));
                        indM++;
                    }
                    out.print(" " + c + " ");
                    if (c == '+') lastPlus = true;
                    else lastPlus = false;
                }
                out.print(n);
            } else {
                out.println("Impossible");
            }
        }

    }

    static class InputReader {
        private StringTokenizer tokenizer;
        private BufferedReader reader;

        public InputReader(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        private void fillTokenizer() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public String next() {
            fillTokenizer();
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

