import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoodJumps {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int n = in.nextInt();
        String st = in.next();
        for (int i = 0; i < n; i++) {
            if (st.charAt(i) == '.') {
                continue;
            }
            if (isGood(st, i)) {
                System.out.println("yes");
                return;
            }
        }
        System.out.println("no");
    }

    private static boolean isGood(String st, int start) {
        for (int d = 1; d < st.length(); d++) {
            boolean good = true;
            for (int i = start; i < start + 5 * d; i += d) {
                if (i >= st.length() || st.charAt(i) == '.') {
                    good = false;
                    break;
                }
            }
            if (good) {
                return true;
            }
        }
        return false;
    }

    public static class InputReader {
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}
