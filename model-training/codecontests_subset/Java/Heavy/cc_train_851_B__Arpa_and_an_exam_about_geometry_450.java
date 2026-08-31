import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author HossamDoma
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
        public void solve(int testNumber, InputReader in, PrintWriter out) {

            int ax = in.nextInt();
            int ay = in.nextInt();

            int bx = in.nextInt();
            int by = in.nextInt();

            int cx = in.nextInt();
            int cy = in.nextInt();

            long ab = (long) (ax - bx) * (ax - bx) + (long) (ay - by) * (ay - by);
            long bc = (long) (bx - cx) * (bx - cx) + (long) (by - cy) * (by - cy);
            long ac = (long) (ax - cx) * (ax - cx) + (long) (ay - cy) * (ay - cy);
            
            // out.println(ab + " " + ac + " " + bc);
            
            if (ab != bc || (long) ax * (by - cy) + (long) bx * (cy - ay) + (long) cx * (ay - by) == 0) {
                out.println("No");
            } else
                out.println("Yes");
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