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


    public void solve(InputReader in, PrintWriter out) throws IOException {
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        if (a == 0 && b == 0 && c == 0) {
            out.print("-1");
            return;
        }

        int k = 0;
        double x1 = Double.MAX_VALUE;
        double x2 = Double.MAX_VALUE;

        if (a == 0) {
            if (b != 0) {
                k = 1;
                x1 = (-1d * c) / b;
            }
        } else {
            double d = 1L * b * b - 4L * a * c;
            if (1L * b * b - 4L * a * c == 0) {
                k = 1;
                x1 = (-1d * b) / (2 * a);
            } else if (1L * b * b - 4L * a * c > 0) {
                k = 2;
                x1 = (-b + Math.sqrt(d)) / (2 * a);
                x2 = (-b - Math.sqrt(d)) / (2 * a);
                double min = Math.min(x1, x2);
                double max = Math.max(x1, x2);

                x1 = min;
                x2 = max;
            }
        }

        out.println(k);
        if (k == 1) {
            out.println(x1);
        } else if (k == 2) {
            out.println(x1);
            out.println(x2);
        }

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
