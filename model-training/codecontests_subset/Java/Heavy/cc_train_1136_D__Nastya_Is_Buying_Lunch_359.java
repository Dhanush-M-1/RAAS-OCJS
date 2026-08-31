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
            int[] index = new int[n], p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = inp.nextInt() - 1;
                index[p[i]] = i;
            }
            int[] swapRight = new int[n];
            ArrayList<Integer>[] swaps = new ArrayList[n];
            for (int i = 0; i < n; i++) swaps[i] = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int u = inp.nextInt() - 1, v = inp.nextInt() - 1;
                if (index[u] < index[v]) {
                    swapRight[u]++;
                    swaps[v].add(u);
                } /*else {
                    swapRight[v]++;
                    swaps[u].add(v);
                }*/
            }
            int curr = n - 1;
            for (int i = n - 2; i >= 0; i--) {
                int gap = curr - i;
                if (swapRight[p[i]] >= gap) {
                    curr--;
                    for (int prev: swaps[p[i]]) {
                        swapRight[prev]--;
                    }
                }
            }
            out.println((n - 1) - curr);
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