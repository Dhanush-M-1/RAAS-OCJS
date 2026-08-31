import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    public static final String FILE_NAME = "in";

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
//        InputStream inputStream = new FileInputStream(FILE_NAME + ".in");
        OutputStream outputStream = System.out;
//        OutputStream outputStream = new FileOutputStream(FILE_NAME + ".out");

        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Answer solver = new Answer();
        solver.solve(in, out);
        out.close();
    }
}

class Answer {
    private final int INF = (int) (1e9 + 7);
    private final int MOD = (int) (1e9 + 7);
    private final int MOD1 = (int) (1e6 + 3);
    private final long INF_LONG = (long) (1e18 + 1);
    private final double EPS = 1e-9;

    private long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public void solve(InputReader in, PrintWriter out) throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();

        int[] a = in.nextArrayInt(n);

        int x = 0;
        for (int i = 0; i < n; i++) {
            if (k % a[i] == 0) {
                x = Math.max(a[i], x);
            }
        }

        int ans = k / x;
        out.println(ans);


    }
}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    InputReader(InputStream stream) {
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

    public int[] nextArrayInt(int count) {
        return nextArrayInt(0, count);
    }

    public int[] nextArrayInt(int start, int count) {
        int[] a = new int[start + count];
        for (int i = start; i < start + count; i++) {
            a[i] = nextInt();
        }
        return a;
    }

    public long[] nextArrayLong(int count) {
        long[] a = new long[count];
        for (int i = 0; i < count; i++) {
            a[i] = nextLong();
        }
        return a;
    }
}