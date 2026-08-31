import java.io.*;
import java.util.*;

public class Main {
    private static PrintWriter out;
    private static FastReader in;
    private static boolean[] used;
    private static ArrayList<Integer> component;

    private static class FastReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public FastReader(InputStream inputStream) {
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

    }

    public static void main(String[] args) throws FileNotFoundException {
        in = new FastReader(System.in);
        out = new PrintWriter(System.out);

        int n = in.nextInt(),
            m = in.nextInt();
        int[] W = new int[n];
        for (int i = 0; i < n; ++i) {
            W[i] = in.nextInt();
        }
        int[] B = new int[m];
        for (int i = 0; i < m; ++i) {
            B[i] = in.nextInt() - 1;
        }
        ArrayList<Integer> books = new ArrayList<>();
        for (int b : B) {
            if (!books.contains(b)) {
                books.add(b);
            }
        }
        int answer = 0;
        for (int b : B) {
            Iterator<Integer> it = books.iterator();
            while (it.hasNext()) {
                int current = it.next();
                if (current == b) {
                    it.remove();
                    books.add(0, current);
                    break;
                } else {
                    answer += W[current];
                }
            }
        }

        out.println(answer);
        out.flush();
    }
}