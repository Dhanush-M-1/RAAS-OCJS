import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        //BufferedReader br = new BufferedReader(new FileReader(new File("test.in")));
        //int tests = (Integer.parseInt(br.readLine()));
        int tests=1;
        solve(tests, in, out);
        out.close();
    }

    static void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
        for(int ii=0;ii<testNumber;ii++) {
            int size = in.nextInt()/11;
            //int size = (Integer.parseInt(br.readLine())) / 11;
            String s = in.next();
            //String s = br.readLine();
            int threshold = size;
            char[] card = s.toCharArray();
            int ans = 0;
            for (int i = 0; i < card.length && threshold > 0; i++) {
                if (card[i] == '8') {
                    threshold--;
                    ans++;
                }
            }
            out.println(ans);
        }
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
