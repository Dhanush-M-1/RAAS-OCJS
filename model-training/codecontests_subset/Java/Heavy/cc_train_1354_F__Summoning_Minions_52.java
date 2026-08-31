import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Comparator;
import java.util.ArrayDeque;
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
        SummoningMinions solver = new SummoningMinions();
        solver.solve(1, in, out);
        out.close();
    }

    static class SummoningMinions {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int T = in.nextInt();
            while (T-- > 0) {
                int N = in.nextInt();
                int K = in.nextInt();
                int[][] arr = new int[N][3];
                for (int i = 0; i < N; i++) {
                    arr[i][0] = in.nextInt();
                    arr[i][1] = in.nextInt();
                    arr[i][2] = i + 1;
                }
                Arrays.sort(arr, new Comparator<int[]>() {

                    public int compare(int[] ints, int[] t1) {
                        return Integer.compare(ints[1], t1[1]);
                    }
                });
                long[][] dp = new long[N][K + 1];
                boolean[][] add = new boolean[N][K + 1];
                Arrays.fill(dp[0], Long.MIN_VALUE);
                dp[0][0] = (K - 1) * arr[0][1];
                dp[0][1] = (arr[0][0]);
                add[0][1] = true;
                for (int i = 1; i < N; i++) {
                    for (int j = 0; j <= K; j++) {
                        dp[i][j] = dp[i - 1][j] + (K - 1) * arr[i][1];
                        if (j > 0) {
                            if (dp[i - 1][j - 1] + arr[i][0] + arr[i][1] * (j - 1) > dp[i][j]) {
                                add[i][j] = true;
                                dp[i][j] = dp[i - 1][j - 1] + arr[i][0] + arr[i][1] * (j - 1);
                            }
                        }
                    }
                }
                int u = K;
                ArrayDeque<Integer> order = new ArrayDeque<>();
                ArrayList<Integer> not_added = new ArrayList<>();
                for (int i = N - 1; i >= 0; i--) {
                    if (add[i][u]) {
                        order.addFirst(arr[i][2]);
                        u--;
                    } else {
                        not_added.add(arr[i][2]);
                    }
                }
                StringBuilder str = new StringBuilder();
                str.append((2 * N - K) + "\n");
//            assert false;
                while (order.size() > 1) {
                    str.append(order.removeFirst() + " ");
                }
                for (int i : not_added) {
                    str.append(i + " ");
                    str.append((-i) + " ");
                }
                str.append(order.removeFirst() + " ");
                out.println(str.toString());
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

