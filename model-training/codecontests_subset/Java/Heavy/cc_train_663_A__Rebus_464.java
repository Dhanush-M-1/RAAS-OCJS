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
 *
 * @author MottoX
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
            List<Integer> list = new ArrayList<>();
            list.add(1);
            in.next();
            while (true) {
                String sgn = in.next();
                if (sgn.equals("+")) {
                    list.add(1);
                } else if (sgn.equals("-")) {
                    list.add(-1);
                } else {
                    break;
                }
                in.next();
            }
            int n = in.nextInt();
            int pos = 0, neg = 0;
            for (Integer val : list) {
                if (val == 1) {
                    pos++;
                } else {
                    neg++;
                }
            }
            int curVal = pos - neg;
            int maxVal = curVal + pos * (n - 1);
            int minVal = curVal - neg * (n - 1);
            if (minVal > n || maxVal < n) {
                out.println("Impossible");
            } else {
                out.println("Possible");
                int need = n - curVal;
                if (need >= 0) {
                    for (int i = 0; i < list.size(); i++) {
                        int val = list.get(i);
                        if (val == 1) {
                            int add = Math.min(n - 1, need);
                            list.set(i, val + add);
                            need -= add;
                        }
                    }
                } else {
                    need = -need;
                    for (int i = 0; i < list.size(); i++) {
                        int val = list.get(i);
                        if (val == -1) {
                            int add = Math.min(n - 1, need);
                            list.set(i, val - add);
                            need -= add;
                        }
                    }
                }
                out.print(list.get(0));
                for (int i = 1; i < list.size(); i++) {
                    out.print(" " + (list.get(i) > 0 ? "+ " : "- ") + Math.abs(list.get(i)));
                }
                out.println(" = " + n);
            }
        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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

