import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class SolutionD {

    public static void main(String[] args) throws IOException {
        new SolutionD()
                .initInputReader()
                .solve()
                .cleanup();
    }

    private SolutionD solve() throws IOException {
        int n = nextInt(), k = nextInt();
        int a = nextInt(), b = nextInt(), c = nextInt(), d = nextInt();

        if (n > 4 && k < n + 1) {
            System.out.println(-1);
            return this;
        } else if (n == 4) {
            System.out.println(-1);
            return this;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (i != a && i != b && i != c && i != d) {
                sb.append(i);
                sb.append(" ");
            }
        }

        String line = sb.toString();

        System.out.println(a + " " + c + " " + line + d + " " + b);
        System.out.println(c + " " + a + " " + line + b + " " + d);

        return this;
    }

    private final static int MOD = 1000000007;

    /*
     * Methods for reading input
     */

    private BufferedReader br;
    private StringTokenizer st;

    private SolutionD initInputReader() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        return this;
    }

    private void cleanup() throws IOException {
        br.close();
    }

    private int nextInt() throws IOException {
        checkEmptyTokenizer();
        return Integer.parseInt(st.nextToken());
    }

    private long nextLong() throws IOException {
        checkEmptyTokenizer();
        return Long.parseLong(st.nextToken());
    }

    private double nextDouble() throws IOException {
        checkEmptyTokenizer();
        return Double.parseDouble(st.nextToken());
    }

    private String nextString() throws IOException {
        checkEmptyTokenizer();
        return st.nextToken();
    }

    private void checkEmptyTokenizer() throws IOException {
        if (!st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
    }

    /*
     * Convenience methods
     */

    // Provides a default value if map doesn't have the key
    private <K, V> V getFromMap(Map<K, V> map, K key, V def) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return def;
    }

    private void print(String line, Object... args) {
        System.out.println(String.format(line, args));
    }
}
