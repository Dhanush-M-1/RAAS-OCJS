import java.io.*;
import java.util.Locale;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        try {
            if (System.getProperty("ONLINE_JUDGE") != null) {
                in = new FastScanner(System.in);
                out = new PrintWriter(System.out);
            } else {
                in = new FastScanner(new File("input.txt"));
                out = new PrintWriter(new File("output.txt"));
            }
            Locale.setDefault(Locale.US);
            submit();
            in.close();
            out.close();
        } catch (Throwable throwable) {
            throwable.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    private void submit() throws IOException {
        if (true) {
            read();
            int ans = solve();
            out.print(ans);
        } else {
            stress();
        }
    }

    // C++ next_permutation() analog in Java
    boolean next_permutation(int[] p) {
        for (int a = p.length - 2; a >= 0; --a)
            if (p[a] < p[a + 1])
                for (int b = p.length - 1;; --b)
                    if (p[b] > p[a]) {
                        int t = p[a];
                        p[a] = p[b];
                        p[b] = t;
                        for (++a, b = p.length - 1; a < b; ++a, --b) {
                            t = p[a];
                            p[a] = p[b];
                            p[b] = t;
                        }
                        return true;
                    }
        return false;
    }

    private int stupid() {
        int answer[] = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = i;
        }
        int best = Integer.MAX_VALUE;
        do {
            int copy[] = new int[n];
            System.arraycopy(answer, 0, copy, 0, n);
            best = Math.min(best, getAmount(copy));
        } while (next_permutation(answer));
        return best;
    }

    private void stress() {
        read();
        final int TESTS = 100;
        Random r = new Random();
        final int MAXN = 10;
        final int MAXM = 30;
        final int MAXW = 100;
        for (int test = 0; test < TESTS; test++) {
            n = r.nextInt(MAXN) + 1;
            m = r.nextInt(MAXM) + 1;
            w = new int[n];
            b = new int[m];
            for (int i = 0; i < n; i++) {
                w[i] = r.nextInt(MAXW) + 1;
            }
            for (int i = 0; i < m; i++) {
                b[i] = r.nextInt(MAXN) + 1;
            }
            int my = solve();
            int good = stupid();
            if (my != good) {
                System.out.println("FAIL");
                System.out.println("My: " + my + " good: " + good);
                System.out.println(n + " " + m);
                for (int i = 0; i < n; i++) {
                    System.out.print(w[i] + " ");
                }
                System.out.println();
                for (int i = 0; i < m; i++) {
                    System.out.print(b[i] + " ");
                }
                System.out.println();
                return;
            }
        }

    }

    private int getAmount(int[] answer) {
        int amount = 0;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (answer[j] == b[i]) {
                    System.arraycopy(answer, 0, answer, 1, j - 1 + 1);
                    answer[0] = b[i];
                    amount += sum;
                    break;
                } else {
                    sum += w[answer[j]];
                }
            }
        }
        return amount;
    }

    private void read() {
        n = in.nextInt();
        m = in.nextInt();
        w = new int[n];
        b = new int[m];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
            b[i]--;
        }
    }

    int n;
    int m;
    int[] w;
    int[] b;

    int solve() {
        int answer[] = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int s1 = 0;
                int s2 = 0;
                int x = answer[i];
                int y = answer[j];
                int t1 = x;
                int t2 = y;
                for (int k = 0; k < m; k++) {
                    if (b[k] == x) {
                        if (t1 == y) {
                            s1 += w[y];
                            t1 = x;
                        }
                        if (t2 == y) {
                            s2 += w[y];
                            t2 = x;
                        }
                    }
                    if (b[k] == y) {
                        if (t1 == x) {
                            s1 += w[x];
                            t1 = y;
                        }
                        if (t2 == x) {
                            s2 += w[x];
                            t2 = y;
                        }
                    }
                }
                if (s1 > s2) {
                    answer[i] = y;
                    answer[j] = x;
                }
            }
        }
        return getAmount(answer);
    }
}

class FastScanner implements AutoCloseable {

    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public FastScanner(File file) {
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public FastScanner(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
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

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }
}