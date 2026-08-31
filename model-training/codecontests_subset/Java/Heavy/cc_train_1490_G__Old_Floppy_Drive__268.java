import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G {
    public static void main(String[] args) {
        new G().solve(System.in, System.out);
    }

    public void solve(InputStream in, OutputStream out) {
        InputReader inputReader = new InputReader(in);
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(out));

        int t = inputReader.nextInt();
        for (int t1 = 0; t1 < t; t1++) {
            int n = inputReader.nextInt();
            int m = inputReader.nextInt();

            List<Long> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a.add(inputReader.nextLong());
            }
            List<Long> x = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                x.add(inputReader.nextLong());
            }
            List<Long> result = solve(a, x);
            for (Long res : result) {
                writer.print(res + " ");
            }
            writer.println();
        }

        writer.close();
    }

    public List<Long> solve(List<Long> a, List<Long> x) {
        List<Long> result = new ArrayList<>();
        for (Long x1 : x) {
            result.add(-1L);
        }

        long sum = 0;
        for (long l : a) {
            sum += l;
        }

        long[] prefix = new long[a.size()];
        long[] maxPrefix = new long[a.size()];
        prefix[0] = a.get(0);
        maxPrefix[0] = prefix[0];
        for (int i = 1; i < a.size(); i++) {
            prefix[i] = a.get(i) + prefix[i - 1];
            maxPrefix[i] = Math.max(prefix[i], maxPrefix[i - 1]);
        }

        for (int xIndex = 0; xIndex < x.size(); xIndex++) {
            long xValue = x.get(xIndex);
            if (sum <= 0) {
                int found = find(maxPrefix, xValue);
                if (maxPrefix[found] >= xValue) {
                    result.set(xIndex, (long) found);
                }
            } else {
                if (xValue <= maxPrefix[a.size() - 1]) {
                    result.set(xIndex, (long) find(maxPrefix, xValue));
                    continue;
                }
                long remainder = (xValue - maxPrefix[a.size() - 1]) % sum;
                long fullCircle = (xValue - maxPrefix[a.size() - 1]) / sum + (remainder == 0 ? 0 : 1);
                long afterCircles = xValue - sum * fullCircle;
                if (afterCircles < 0) {
                    result.set(xIndex, fullCircle * a.size());
                } else {
                    result.set(xIndex, fullCircle * a.size() + find(maxPrefix, afterCircles));
                }
            }
        }
        return result;
    }

    public int find(long[] x, long elem) {
        int left = 0;
        int right = x.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            long m = x[middle];
            if (elem <= m) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    private static class InputReader {
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

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
