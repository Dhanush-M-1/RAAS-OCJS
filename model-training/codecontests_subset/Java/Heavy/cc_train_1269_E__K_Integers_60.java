import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Comparator;
import java.util.Collections;
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
        KIntegers solver = new KIntegers();
        solver.solve(1, in, out);
        out.close();
    }

    static class KIntegers {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int N = in.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            int[] p = new int[N];
            FenwickTree invert = new FenwickTree(N);
            for (int i = 0; i < N; i++) {
                p[i] = in.nextInt();
                arr.add(i);
            }
            Collections.sort(arr, new Comparator<Integer>() {

                public int compare(Integer integer, Integer t1) {
                    return Integer.compare(p[integer], p[t1]);
                }
            });
            long res = 0;
            FenwickTree sum = new FenwickTree(N);
            for (long i = 1; i <= N; i++) {
                int nextInd = arr.get((int) (i - 1));
                res += invert.sum(nextInd, N - 1);
                sum.add(nextInd, nextInd);
                invert.add(nextInd, 1);
                int mid = getMid(invert);
                if ((i) % 2 == 1) {
                    out.println(res - sum.sum(0, mid - 1) + sum.sum(mid + 1, N - 1) - ((i / 2) * (i / 2 + 1)));
                } else {
                    out.println(res + mid * (i / 2) - sum.sum(0, mid - 1) + sum.sum(mid + 1, N - 1) - mid * ((i - 1) / 2) - ((i / 2) * (i / 2 + 1)) / 2 - (((i - 1) / 2) * ((i - 1) / 2 + 1)) / 2);
                }
            }
        }

        public int getMid(FenwickTree tree) {
            int low = 0;
            int high = tree.size - 1;
            while (low < high) {
                int mid = (low + high + 1) / 2;
                if (tree.sum(mid - 1) <= tree.sum(tree.size - 1) / 2) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            return high;
        }

        public class FenwickTree {
            public long[] BIT;
            public int size = 0;

            public FenwickTree(int N) {
                BIT = new long[N];
                size = N;
            }

            public void add(int id, int add) {
                for (int i = id; i < size; i |= i + 1) {
                    BIT[i] += add;
                }
            }

            public long sum(int l, int r) {
                return sum(r) - sum(l - 1);
            }

            public long sum(int r) {
                if (r < 0 || r >= size) {
                    return 0;
                }
                long res = 0;
                for (int i = r; i >= 0; i = ((i) & (i + 1)) - 1) {
                    res += BIT[i];
                }
                return res;
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

