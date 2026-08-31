import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Katushka on 11.03.2020.
 */
public class C {
    static int[] readArray(int size, InputReader in) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = in.nextInt();
        }
        return a;
    }

    static long[] readLongArray(int size, InputReader in) {
        long[] a = new long[size];
        for (int i = 0; i < size; i++) {
            a[i] = in.nextLong();
        }
        return a;
    }

    public static void main(String[] args) throws FileNotFoundException {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = in.nextInt();
        for (int k = 0; k < t; k++) {
            int n = in.nextInt();
            long l = in.nextLong();
            long r = in.nextLong();
            long i = 1;
            long s = 0;
            long kk = 0;
            while (s < l && i > 0) {
                kk++;
                i = n - kk + n - kk;
                s += i;
            }
            long s0 = s - i;
            long j = s0 + 1;
            long a = kk;
            long j1 = 0;
            StringBuilder ans = new StringBuilder();
            while (j <= r) {
                if (j == ((long) n) * (n - 1) + 1) {
                    a = 1;
                }
                if (j >= l) {
                    ans.append(a).append(' ');
                }
                j++;
                j1++;
                if (j1 >= i) {
                    kk++;
                    i = n - kk + n - kk;
                    j1 = 0;
                    a = kk;
                } else {
                    if (j1 == i - 1) {
                        a = n;
                    } else if (j1 % 2 == 0) {
                        a = kk;
                    } else {
                        a = kk + j1 / 2 + 1;
                    }
                }
            }
            out.println(ans.toString());
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
