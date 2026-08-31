import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B implements Runnable {

    SimpleTextReader in;
    PrintWriter out;

    int n;
    String statuses;

    @Override
    public void run() {
        in = new SimpleTextReader(System.in);
        out = new PrintWriter(System.out);

        n = in.nextInt();
        statuses = in.nextToken();

        int countBet = 0;
        for (int i = 0; i < n; i++) {
            if (statuses.charAt(i) == 'I') {
                countBet++;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (statuses.charAt(i) == 'F') continue;
            if (statuses.charAt(i) == 'A' && countBet == 0) {
                ans++;
            } else if (statuses.charAt(i) == 'I' && countBet == 1) {
                ans++;
            }
        }

        out.print(ans);

        out.close();
    }

    public class SimpleTextReader {
        private final BufferedReader in;
        private StringTokenizer tokenizer = new StringTokenizer("");

        public SimpleTextReader(InputStream inputStream) {
            in = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String nextToken() {
            while (!tokenizer.hasMoreTokens()) {
                String line = null;
                try {
                    line = in.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (line == null) {
                    return null;
                }
                tokenizer = new StringTokenizer(line);
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public BigInteger nextBigInt() {
            return new BigInteger(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }

        public void close() throws IOException {
            in.close();
        }
    }

    public static void main(String[] args) {
        new Thread(new B()).start();
    }
}