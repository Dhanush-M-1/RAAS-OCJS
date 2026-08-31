import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int n, m;
        n = in.nextInt();
        m = in.nextInt();
        Set<Integer> bulbs = new HashSet<>();
        for (int i = 1; i <= m; i++) {
            bulbs.add(i);
        }

        for (int i = 0; i < n; i++) {
            int now = in.nextInt();
            for (int j = 0; j < now; j++) {
                int x = in.nextInt();
                bulbs.remove(x);
            }
        }

        out.println(bulbs.isEmpty() ? "YES" : "NO");

        out.flush();
        in.close();
        out.close();
    }

    static class Reader {
        BufferedReader reader;
        StringTokenizer st;

        Reader(InputStreamReader stream) {
            reader = new BufferedReader(stream);
            st = null;
        }

        void close() throws IOException {
            reader.close();
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() throws IOException {
            return reader.readLine();
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

    }
}