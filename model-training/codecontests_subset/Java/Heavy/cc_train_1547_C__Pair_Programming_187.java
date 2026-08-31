import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) {
        new C().solve(System.in, System.out);
    }

    public void solve(InputStream in, OutputStream out) {
        InputReader inputReader = new InputReader(in);
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(out));

        int t = inputReader.nextInt();
        for (int t1 = 0; t1 < t; t1++) {
            int k = inputReader.nextInt();
            int n = inputReader.nextInt();
            int m = inputReader.nextInt();
            int[] first = new int[n];
            for (int i = 0; i < n; i++) {
                first[i] = inputReader.nextInt();
            }
            int[] second = new int[m];
            for (int i = 0; i < m; i++) {
                second[i] = inputReader.nextInt();
            }
            List<Integer> result = solve(k, n, m, first, second);
            if (result.isEmpty()) {
                writer.println("-1");
            } else {
                for (Integer x : result) {
                    writer.print(x + " ");
                }
                writer.println();
            }
        }

        writer.close();
    }

    public List<Integer> solve(int k, int n, int m, int[] first, int[] second) {
        List<Integer> result = new ArrayList<>();
        int firstPointer = 0;
        int secondPointer = 0;
        while (firstPointer < n || secondPointer < m) {
            if (firstPointer < n && first[firstPointer] == 0) {
                k++;
                result.add(first[firstPointer]);
                firstPointer++;
                continue;
            }
            if (secondPointer < m && second[secondPointer] == 0) {
                k++;
                result.add(second[secondPointer]);
                secondPointer++;
                continue;
            }
            if (firstPointer < n && secondPointer < m) {
                if (first[firstPointer] <= second[secondPointer]) {
                    if (first[firstPointer] > k) {
                        return Collections.emptyList();
                    }
                    result.add(first[firstPointer]);
                    firstPointer++;
                    continue;
                } else {
                    if (second[secondPointer] > k) {
                        return Collections.emptyList();
                    }
                    result.add(second[secondPointer]);
                    secondPointer++;
                    continue;
                }
            }
            if (firstPointer < n) {
                if (first[firstPointer] > k) {
                    return Collections.emptyList();
                }
                result.add(first[firstPointer]);
                firstPointer++;
                continue;
            }
            if (second[secondPointer] > k) {
                return Collections.emptyList();
            }
            result.add(second[secondPointer]);
            secondPointer++;
        }
        return result;
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
