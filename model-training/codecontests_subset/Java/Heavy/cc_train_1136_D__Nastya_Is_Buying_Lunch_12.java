import java.io.*;
import java.util.*;

public class D_NastyaIsBuyingLunch {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader inp = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solver solver = new Solver();
        solver.solve(inp, out);
        out.close();
    }

    private static class Solver {
        private void solve(InputReader inp, PrintWriter out) {
            int n = inp.nextInt(), m = inp.nextInt();
            int[] index = new int[n], p = new int[n], swapRight = new int[n], currI = new int[n], out_degree = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = inp.nextInt() - 1;
                index[p[i]] = i;
            }
            int[][] swaps = new int[n][], pairs = new int[m][2];
            int j = 0, curr = n - 1;
            for (int i = 0; i < m; i++) {
                int u = inp.nextInt() - 1, v = inp.nextInt() - 1;
                if (index[u] < index[v]) {
                    swapRight[u]++;
                    out_degree[v]++;
                    pairs[j][0] = u;
                    pairs[j][1] = v;
                    j++;
                }
            }
            for (int i = 0; i < n; i++) swaps[i] = new int[out_degree[i]];
            for (int i = 0; i < j; i++) swaps[pairs[i][1]][currI[pairs[i][1]]++] = pairs[i][0];
            for (int i = n - 2; i >= 0; i--) {
                int gap = curr - i;
                if (swapRight[p[i]] >= gap) {
                    curr--;
                    for (int prev: swaps[p[i]]) swapRight[prev]--;
                }
            }
            out.println(n - 1 - curr);
        }
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
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

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}