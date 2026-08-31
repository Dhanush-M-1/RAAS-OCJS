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
        TaskG solver = new TaskG();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskG {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long MAX = (long) (1e+18);
            int t = in.nextInt();
            while (t > 0) {
                t--;
                int n = in.nextInt();
                int q = in.nextInt();
                long[] ar = new long[n];
                double sum = 0;
                double[] prefSum = new double[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = in.nextInt();
                    sum += ar[i];
                    prefSum[i] = (i > 0 ? prefSum[i - 1] : 0) + ar[i];
                }
                int[] prefMaxPos = new int[n];
                prefMaxPos[0] = 0;
                for (int i = 1; i < n; i++)
                    if (prefSum[i] > prefSum[prefMaxPos[i - 1]])
                        prefMaxPos[i] = i;
                    else
                        prefMaxPos[i] = prefMaxPos[i - 1];
                long ln = n;
                for (; q > 0; q--) {
                    long x = in.nextInt();
                    long l = 0;
                    long r = MAX;
                    while (l + 1 < r) {
                        long mid = (l + r) / 2;
                        long rep = mid / ln;
                        long rest = mid % ln;
                        double maxSum;
                        if (rep >= 1) {
                            double dRep = rep;
                            double op1 = prefSum[prefMaxPos[n - 1]] + (dRep - 1) * sum;
                            double op2;
                            if (rest > 0)
                                op2 = prefSum[prefMaxPos[(int) rest - 1]] + dRep * sum;
                            else
                                op2 = dRep * sum;
                            double op3 = prefSum[prefMaxPos[n - 1]];
                            maxSum = Math.max(Math.max(op1, op2), op3);
                        } else {
                            if (rest == 0)
                                maxSum = 0;
                            else
                                maxSum = prefSum[prefMaxPos[(int) rest - 1]];
                        }
                        if (maxSum >= x)
                            r = mid;
                        else
                            l = mid;
                    }
                    if (r != MAX)
                        out.print(Math.max(0, r - 1) + " ");
                    else
                        out.print(-1 + " ");
                }
                out.println();
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

