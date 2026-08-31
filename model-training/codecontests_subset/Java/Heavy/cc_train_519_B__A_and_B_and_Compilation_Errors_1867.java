import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;
import java.io.BufferedReader;
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
        LinkedHashMap<Integer, Integer> hash = new LinkedHashMap<>();

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                if (hash.containsKey(x)) hash.replace(x, hash.get(x) + 2);
                else hash.put(x, 2);
            }
            n--;

            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                hash.replace(x, hash.get(x) - 1);
            }
            n--;

            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                hash.replace(x, hash.get(x) - 1);
                if (hash.get(x) == 0) hash.remove(x);
            }

            if (hash.size() == 1) {
                int x = hash.keySet().iterator().next();
                out.println(x);
                out.println(x);
                return;
            }
            int[] ans = new int[2];
            for (int x : hash.keySet()) {
                ans[hash.get(x) / 2] = x;
            }

            for (int i = 1; i >= 0; i--) {
                out.println(ans[i]);
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

