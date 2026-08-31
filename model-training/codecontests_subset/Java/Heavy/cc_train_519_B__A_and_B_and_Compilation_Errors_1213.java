import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Mayur Kulkarni
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        BladeReader in = new BladeReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, BladeReader in, PrintWriter out) {
            int s = in.nextInt();
            Set<Integer> s1 = new HashSet<>();
            Map<Integer, Integer> s1m = new HashMap<>();
            for (int i = 0; i < s; i++) {
                int x = in.nextInt();
                if (s1m.containsKey(x)) {
                    s1m.put(x, s1m.get(x) + 1);
                } else {
                    s1m.put(x, 1);
                }
            }
            Set<Integer> s2 = new HashSet<>();
            Map<Integer, Integer> s2m = new HashMap<>();
            for (int i = 0; i < s - 1; i++) {
                int x = in.nextInt();
                if (s1m.get(x) > 1) {
                    s1m.put(x, s1m.get(x) - 1);
                    if (s1m.get(x) == 0) s1m.remove(x);
                } else {
                    s1m.remove(x);
                }
                if (s2m.containsKey(x)) {
                    s2m.put(x, s2m.get(x) + 1);
                } else {
                    s2m.put(x, 1);
                }
            }
            int tor = s1m.keySet().iterator().next();
            out.println(tor);
            s1m.clear();
            for (int i = 0; i < s - 2; i++) {
                int x = in.nextInt();
                if (s1m.containsKey(x)) {
                    s1m.put(x, s1m.get(x) + 1);
                } else {
                    s1m.put(x, 1);
                }
                if (s2m.get(x) > 1) {
                    s2m.put(x, s2m.get(x) - 1);
                    if (s2m.get(x) == 0) s2m.remove(x);
                } else {
                    s2m.remove(x);
                }
            }
            tor = s2m.keySet().iterator().next();
            out.println(tor);
        }
    }

    static class BladeReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public BladeReader(InputStream stream) {
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

