import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


/**
 * Created by Katushka on 08.02.2020.
 */
public class CreditCard {

    public static void main(String[] args) throws FileNotFoundException {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = in.nextInt();
        long d = in.nextLong();

        long[] a = new long[n];
        long[] s = new long[n];
        long ss = 0;

        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
            s[i] = ss + a[i];
            ss = s[i];
        }

        long[] maxes = new long[n];
        long max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] > max) {
                max = s[i];
            }
            maxes[i] = max;
        }

        if (max > d) {
            out.println(-1);
        } else {
            int ans = 0;
            long add = 0;

            for (int i = 0; i < n; i++) {
                if (a[i] == 0) {
                    if (s[i] + add < 0) {
                        long newAdd = d - maxes[i] - add;
                        ans += 1;
                        if (s[i] + add + newAdd < 0) {
                            out.println(-1);
                            out.close();
                            return;
                        }
                        add += newAdd;
                    }
                }
            }
            out.println(ans);
        }
        out.close();
    }


    private static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
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

        public String nextString() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public char nextChar() {
            return next().charAt(0);
        }
    }
}
