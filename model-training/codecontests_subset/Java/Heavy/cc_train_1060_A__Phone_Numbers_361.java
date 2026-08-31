

import java.io.OutputStream;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.PrintWriter;
        import java.util.StringTokenizer;
        import java.util.Random;
        import java.io.IOException;
        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        static final long BUBEN = 100;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = Integer.parseInt(in.next());
            char[] arr = in.next().toCharArray();
//            int count[] = new int[10];
            int min = Integer.MAX_VALUE;
            int count8 = 0;
            int elevenCount = 0;
            int num = 0;

            for (char e : arr) {
                if(e=='8')count8++;
                 elevenCount++;

            }
            while(count8>0 && elevenCount>0){
                if(count8+elevenCount>=11 && n>=11)
                    num++;
                count8-=1;
                elevenCount-=10;
                n-=11;

            }
            out.println(num);
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

        public long nextLong() {
            return Long.parseLong(next());
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

