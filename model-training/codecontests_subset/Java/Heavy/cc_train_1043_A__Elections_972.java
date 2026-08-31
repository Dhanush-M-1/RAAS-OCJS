import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.OptionalInt;
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
        MyBufferedReader in = new MyBufferedReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, MyBufferedReader in, PrintWriter out) {
            int n = in.getAnInt();
            int[] d = in.getALineOfInts(n);
            double sum = Arrays.stream(d).sum();
            int max = Arrays.stream(d).max().getAsInt();
            out.println(Math.max(max, (int) (Math.floor(2.0 * sum / n) + 1)));
        }

    }

    static class MyBufferedReader {
        BufferedReader in;

        public MyBufferedReader(InputStream s) {
            this.in = new BufferedReader(new InputStreamReader(s));
        }

        public MyBufferedReader(BufferedReader in) {
            this.in = in;
        }

        public int getAnInt() {
            int res = -1;
            try {
                res = Integer.parseInt(new StringTokenizer(in.readLine()).nextToken());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return res;
        }

        public int[] getALineOfInts(int numExpected) {
            if (numExpected == 0) {
                try {
                    in.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new int[0];
            }

            int[] res = new int[numExpected];
            StringTokenizer st = null;
            try {
                st = new StringTokenizer(in.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < numExpected; i++)
                res[i] = Integer.parseInt(st.nextToken());
            return res;
        }

    }
}

