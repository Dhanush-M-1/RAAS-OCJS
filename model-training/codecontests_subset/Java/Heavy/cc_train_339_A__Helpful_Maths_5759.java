import java.io.*;
import java.util.*;

public class A {
    public static void solution(BufferedReader reader, PrintWriter out)
            throws IOException {
        In in = new In(reader);
        char[] formular = in.next().toCharArray();
        int[] cnt = new int[4];
        for (int i = 0; i < formular.length; i += 2)
            cnt[formular[i] - '0']++;
        int a = 0;
        for (int i = 1; i <= 3; i++)
            for (int j = 0; j < cnt[i]; j++)
                if (a == 0) {
                    out.print(i);
                    a++;
                }
                else
                    out.printf("+%d", i);
        out.println();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(
                new OutputStreamWriter(System.out)));
        solution(reader, out);
        out.close();
    }

    protected static class In {
        private BufferedReader reader;
        private StringTokenizer tokenizer = new StringTokenizer("");

        public In(BufferedReader reader) {
            this.reader = reader;
        }

        public String next() throws IOException {
            while (!tokenizer.hasMoreTokens())
                tokenizer = new StringTokenizer(reader.readLine());
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}
