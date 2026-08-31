import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author dmytro.prytula
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        AMinimalnoeChislo solver = new AMinimalnoeChislo();
        solver.solve(1, in, out);
        out.close();
    }

    static class AMinimalnoeChislo {
        long L;
        long R;
        long D;
        int t;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            t = in.nextInt();
//        nes:
            while (t-- > 0) {
                L = in.nextLong();
                R = in.nextLong();
                D = in.nextLong();


                if (D < L) {
                    out.println(D);
                    continue;
                } else {
                    out.println(GeekLong.ceiling(R + 1, D) * D);
                }

//            for (long i = D; i < L; i += D) {
//                out.println(i);
//                continue nes;
//            }

//            for (long i = GeekLong.ceiling(R, D) * D; i <= INF; i+=D) {
//                out.println(i);
//                continue nes;
//            }


//            out.println(ans);
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

        public String nextToken() {
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
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

    }

    static class GeekLong {
        public static long ceiling(long n, long k) {
            return (n + k - 1) / k;
        }

    }
}

