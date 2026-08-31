import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
//        InputStream inputStream = new FileInputStream("sum.in");
        OutputStream outputStream = System.out;
//        OutputStream outputStream = new FileOutputStream("sum.out");


//        Path path = Paths.get(URI.create("file:///foo/bar/Main.java"));
//        System.out.print(path.getName(200));

//        Path p = Paths.get("/foo/bar/Main.java");
//        for (Path e : p) {
//            System.out.println(e);
//        }

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

    private int kol(int l, int r, int a, int b, int c) {
        if (l > r) {
            return -1;
        }

        int t = (l + r) >> 1;

        boolean flag = true;
        for (int i = 0; i <= c; i++) {
            if (1L * (t + i) * b < 1L * i * a) {
                flag = false;
                break;
            }
        }

        if (flag) {
            int k = kol(l, t - 1, a, b, c);
            if (k != -1) {
                return k;
            }
            return t;
        }

        return kol(t + 1, r, a, b, c);
    }

    public void solve(InputReader in, PrintWriter out) throws IOException {
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        int t = kol(0, 1000000000, a, b, c);
        out.print(t);
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
        int[] a = new int[count];
        for (int i = 0; i < count; i++) {
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
