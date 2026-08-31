import java.io.*;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public class P1195D_2 {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        SimpleScanner scanner = new SimpleScanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        int n = scanner.nextInt();
        HashMap<Integer, List<String>> numMap = new HashMap<>();
        for (int i = 1; i <= 10; ++i)
            numMap.put(i, new ArrayList<>());
        for (int i = 0; i < n; ++i) {
            String t = scanner.next();
            List<String> nums = numMap.get(t.length());
            nums.add(t);
        }
        long[] base = new long[25];
        base[0] = 1;
        for (int i = 1; i < 25; ++i)
            base[i] = base[i - 1] * 10 % MOD;
        long ans = 0;
        for (int i = 1; i <= 10; ++i) {
            List<String> nums = numMap.get(i);
            for (String num : nums) {
                for (int j = 1; j <= 10; ++j) {
                    if (numMap.get(j).size() == 0)
                        continue;
                    for (int k = i - 1; k >= 0 && k >= i - j; --k) {
                        ans = (ans + (num.charAt(k) - '0') * (base[(i - k - 1) * 2] + base[(i - k - 1) * 2 + 1]) % MOD * numMap.get(j).size()) % MOD;
                    }
                    for (int k = i - j - 1; k >= 0; --k) {
                        ans = (ans + (num.charAt(k) - '0') * (base[j * 2 + (i - j - 1 - k)]) % MOD * numMap.get(j).size() * 2) % MOD;
                    }
                }
            }
        }
        writer.println(ans);
        writer.close();
    }

    private static class SimpleScanner {

        private static final int BUFFER_SIZE = 10240;

        private Readable in;
        private CharBuffer buffer;
        private boolean eof;

        SimpleScanner(InputStream in) {
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

        void checkEof() {
            if (eof)
                throw new NoSuchElementException();
        }

        char nextChar() {
            checkEof();
            char b = read();
            checkEof();
            return b;
        }

        String next() {
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

        int nextInt() {
            return Integer.valueOf(next());
        }

        long nextLong() {
            return Long.valueOf(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
