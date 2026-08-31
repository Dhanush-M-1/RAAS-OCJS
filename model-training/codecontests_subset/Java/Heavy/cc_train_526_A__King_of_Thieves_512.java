import java.io.*;
import java.util.*;

public class Main {
    private static PrintWriter out;
    private static FastReader in;

    private static class FastReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public FastReader(InputStream inputStream)
                throws UnsupportedEncodingException {
            reader = new BufferedReader(
                    new InputStreamReader(inputStream), 1 << 16);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                }
                catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            try {
                return reader.readLine();
            }
            catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        /*in = new FastReader(new FileInputStream("input.txt"));
        out = new PrintWriter(new FileOutputStream("output.txt"));*/

        in = new FastReader(System.in);
        out = new PrintWriter(System.out);

        int n = in.nextInt();
        char[] level = in.next().toCharArray();
        boolean isGood = false;
        for (int i = 0; i < n; ++i) {
            for (int k = 1; i + 4 * k < n; ++k) {
                if (level[i] == level[i + k] &&
                    level[i + k] == level[i + 2 * k] &&
                    level[i + 2 * k] == level[i + 3 * k] &&
                    level[i + 3 * k] == level[i + 4 * k] &&
                    level[i + 4 * k] == '*') {
                    isGood = true;
                    break;
                }
            }
        }
        out.println(isGood ? "yes" : "no");

        out.flush();
    }

}