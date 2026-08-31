import java.io.*;
import java.util.*;

public class Main {
    static class TaskA {
        void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            char[] chars = in.next().toCharArray();
            int flag = 0;
            for (int i = 0; i < n-1; ++i) {
                if (chars[i] > chars[i+1]) {
                    flag = 1;
                    out.println("YES");
                    out.printf("%d %d\n", i+1, i+2);
                    break;
                }
            }
            if (flag == 0) {
                out.println("NO");
            }
        }
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA task = new TaskA();
        task.solve(in, out);
        out.close();
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (Exception e) {
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
