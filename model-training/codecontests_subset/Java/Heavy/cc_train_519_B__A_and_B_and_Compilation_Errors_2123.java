import java.io.*;
import java.util.*;


public class Main {

    static class Task {
        //////////////////  Solution    /////////////////////////////////////
        public void solve(InputReader in, PrintWriter out) throws Exception {
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n-1];
            int[] c = new int[n-2];
            for (int i = 0; i < n; i++) a[i] = in.nextInt();
            for (int i = 0; i < n-1; i++) b[i] = in.nextInt();
            for (int i = 0; i < n-2; i++) c[i] = in.nextInt();
            long a1 = 0, b1 = 0, c1 = 0;
            for (int x: a) a1 += x;
            for (int x: b) b1 += x;
            for (int x: c) c1 += x;
            out.println(a1-b1);
            out.println(b1-c1);
        }
        //////////////////////////////////////////////////////////////////////
    }

    public static void main(String[] args) throws Exception{
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(in, out);
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
        public Character nextChar(){
            return next().charAt(0);
        }
        public String nextLine() throws IOException {
            return reader.readLine();
        }
        public long nextLong(){ return Long.parseLong(next()); }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public double nextDouble() { return Double.parseDouble(next()); }

    }
}