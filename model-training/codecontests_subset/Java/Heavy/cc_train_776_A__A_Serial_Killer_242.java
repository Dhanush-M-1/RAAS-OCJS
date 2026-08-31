import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String victim1 = in.next();
        String victim2 = in.next();

        out.println(victim1 + " " + victim2);

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            String murdered = in.next();
            String replaced = in.next();

            if(victim1.equals(murdered)) {
                victim1 = replaced;
            } else {
                victim2 = replaced;
            }

            out.println(victim1 + " " + victim2);
        }

        out.close();
    }

    static class InputReader {
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