import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        Problem A = new Problem();
        A.solve(in, out);
        out.close();
    }

    static class Problem {

        public void solve(Scanner in, PrintWriter out) {
            int min = Integer.MAX_VALUE;

            int n = in.nextInt();
            int k = in.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                min = k % arr[i] == 0 && k / arr[i] <= min ? k / arr[i] : min;
            }
            out.println(min);
        }
    }

    static class Scanner {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public Scanner(InputStream stream) {
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