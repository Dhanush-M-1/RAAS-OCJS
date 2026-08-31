import java.io.*;
import java.nio.CharBuffer;
import java.util.*;

public class P1277E {

    public static void main(String[] args) {
        SimpleScanner scanner = new SimpleScanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        int caseNum = scanner.nextInt();
        while (caseNum-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            List<List<Integer>> links = new ArrayList<>();
            for (int i = 0; i < n; ++i)
                links.add(new LinkedList<>());
            for (int i = 0; i < m; ++i) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                links.get(u).add(v);
                links.get(v).add(u);
            }
            int[] cnt = new int[n];

            ArrayList<Integer> ansA = new ArrayList<>();
            cnt[a] = 1;
            for (int v : links.get(a)) {
                if (cnt[v] == 0) {
                    if (!dfs(v, b, links, cnt)) {
                        ansA.add(cnt[v]);
                    }
                }
            }

            Arrays.fill(cnt, 0);
            ArrayList<Integer> ansB = new ArrayList<>();
            cnt[b] = 1;
            for (int v : links.get(b)) {
                if (cnt[v] == 0) {
                    if (!dfs(v, a, links, cnt)) {
                        ansB.add(cnt[v]);
                    }
                }
            }
            long ans = 0;
            for (int x : ansA)
                for (int y : ansB)
                    ans += (long) x * y;
            writer.println(ans);
        }

        writer.close();
    }

    private static boolean dfs(int u, int t, List<List<Integer>> links, int[] cnt) {
        cnt[u] = 1;
        boolean flag = u == t;
        for (int v : links.get(u)) {
            if (cnt[v] == 0) {
                flag = dfs(v, t, links, cnt) || flag;
                cnt[u] += cnt[v];
            }
        }
        return flag;
    }

    private static class SimpleScanner {

        private static final int BUFFER_SIZE = 10240;

        private Readable in;
        private CharBuffer buffer;
        private boolean eof;

        private SimpleScanner(InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
            buffer = CharBuffer.allocate(BUFFER_SIZE);
            buffer.limit(0);
            eof = false;
        }


        private char read() {
            if (!buffer.hasRemaining()) {
                buffer.clear();
                int n;
                try {
                    n = in.read(buffer);
                } catch (IOException e) {
                    n = -1;
                }
                if (n <= 0) {
                    eof = true;
                    return '\0';
                }
                buffer.flip();
            }
            return buffer.get();
        }

        private void checkEof() {
            if (eof)
                throw new NoSuchElementException();
        }

        private char nextChar() {
            checkEof();
            char b = read();
            checkEof();
            return b;
        }

        private String next() {
            char b;
            do {
                b = read();
                checkEof();
            } while (Character.isWhitespace(b));
            StringBuilder sb = new StringBuilder();
            do {
                sb.append(b);
                b = read();
            } while (!eof && !Character.isWhitespace(b));
            return sb.toString();
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
