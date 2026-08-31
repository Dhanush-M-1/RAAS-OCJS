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
            int positives = 1;
            int negs = 0;
            int n = 0;
            ArrayList<Boolean> IsPos = new ArrayList<>();
            IsPos.add(true);

            while (true) {
                String t = in.next();

                if (t.equals("?")) continue;
                if (t.equals("+")) {
                    positives++;
                    IsPos.add(true);
                    continue;
                }
                if (t.equals("-")) {
                    negs++;
                    IsPos.add(false);
                    continue;
                }
                if (t.equals("=")) {
                    n = in.nextInt();
                    break;
                }
            }

            int minPos = positives;
            int minNeg = negs;
            int maxPos = positives * n;
            int maxNeg = negs * n;

            int minSum = minPos - maxNeg;
            int maxSum = maxPos - minNeg;

            if (minSum <= n && maxSum >= n) {
                out.println("Possible");
            } else {
                out.println("Impossible");
                return;
            }

            int negSum = 0;
            if (negs > 0)
                for (int i = n; i <= maxPos; ++i) {
                    int val = i - n;
                    if (val >= minNeg && val <= maxNeg) negSum = val;
                }

            int posSum = n + negSum;

            int posValDef = posSum / positives;
            int posValOff = posSum % positives;

            int negValDef = 0;
            int negValOff = 0;

            if (negs > 0) {
                negValDef = negSum / negs;
                negValOff = negSum % negs;
            }
            String res = "";


            for (boolean pos : IsPos) {
                int cur = 0;
                if (pos) {
                    cur = posValDef;
                    if (posValOff > 0) {
                        cur++;
                        posValOff--;
                    }
                    res += "+ ";
                } else {
                    cur = negValDef;
                    if (negValOff > 0) {
                        cur++;
                        negValOff--;
                    }
                    res += "- ";
                }
                res += cur + " ";
            }

            out.println(res.substring(2) + " = " + n);


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

