import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class B {
    private IO io;

    public static void main(String[] args) throws IOException {
        new B().run();
    }

    private void run() throws IOException {
        io = new IO(System.in, System.out);
        solve();
        io.out.flush();
    }

    private void solve() throws IOException {
        int n = io.nextInt();
        long[] sums = new long[3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n - i; j++) {
                sums[i] += io.nextInt();
            }
        }

        for (int i = 0; i < 2; i++) {
            io.out.println(sums[i] - sums[i + 1]);
        }
    }

    private static class IO {
        public static final Locale LOCALE = Locale.US;
        public InputStream is;
        public OutputStream os;
        public Scanner in;
        public BufferedReader reader;
        public StreamTokenizer tokenizer;
        public PrintWriter out;

        public IO(InputStream is, OutputStream os) {
            this.is = is;
            this.os = os;
            reader = new BufferedReader(new InputStreamReader(is));
            in = new Scanner(reader);
            tokenizer = new StreamTokenizer(reader);
            out = new PrintWriter(new OutputStreamWriter(os));
        }

        public int nextInt() throws IOException {
            tokenizer.nextToken();
            return (int) tokenizer.nval;
        }

        public void printf(String format, Object... args) {
            out.printf(LOCALE, format, args);
            out.flush();
        }
    }
}
