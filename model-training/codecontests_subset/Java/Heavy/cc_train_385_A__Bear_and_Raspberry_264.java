//package A385;

/*
 * @author Abdulrahman Mobarak
 */


import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;


public class Main {

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {

        public void solve(int testNumber, InputReader input, PrintWriter out) throws IOException {
            int n,l;
            n = input.nextInt();
            l = input.nextInt();
            
            int arr[] = new int[n];
            arr[0] = input.nextInt();
            
            int ans = -1000;
            for (int i = 1; i < n; i++) {
                arr[i] = input.nextInt();
                ans = Math.max(ans, arr[i-1]-arr[i]);
            }
            
            out.println(ans-l > 0 ? ans-l : 0);
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
        
        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
