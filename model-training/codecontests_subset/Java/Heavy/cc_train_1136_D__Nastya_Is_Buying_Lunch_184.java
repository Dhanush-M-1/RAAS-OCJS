import java.io.*;
import java.util.*;

public class D {
    public static void main(String[] args) throws IOException {
        try (Input input = new StandardInput(); PrintWriter writer = new PrintWriter(System.out)) {
            int n = input.nextInt(), m = input.nextInt();
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = input.nextInt();
            }
            List[] g = new List[n + 1];
            for (int i = 0; i <= n; i++) {
                g[i] = new ArrayList<Integer>();
                g[i].add(i);
            }
            for (int i = 0; i < m; i++) {
                int u = input.nextInt();
                int v = input.nextInt();
                g[u].add(v);
            }
            Set<Integer> badGuys = new HashSet<>();
            badGuys.add(p[n - 1]);
            int answer = 0;
            for (int k = n - 2; k >= 0; k--) {
                int u = p[k];
                int niceness = 0;
                for (Object o : g[u]) {
                    int v = (int)o;
                    if (badGuys.contains(v)) {
                        niceness++;
                    }
                }
                if (niceness == badGuys.size()) {
                    answer++;
                } else {
                    badGuys.add(u);
                }
            }
            writer.println(answer);
        }
    }

    interface Input extends Closeable {
        String next() throws IOException;

        default int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        default long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }

    private static class StandardInput implements Input {
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        private StringTokenizer stringTokenizer;

        @Override
        public void close() throws IOException {
            reader.close();
        }

        @Override
        public String next() throws IOException {
            if (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                stringTokenizer = new StringTokenizer(reader.readLine());
            }
            return stringTokenizer.nextToken();
        }
    }
}