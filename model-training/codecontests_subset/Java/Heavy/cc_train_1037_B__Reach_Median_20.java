import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
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
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int s = in.nextInt();
            Integer[] ar = new Integer[n];
            for (int i = 0; i < n; i++)
                ar[i] = in.nextInt();
            Arrays.sort(ar);
            long ans;
            int curM = ar[n / 2];
            if (n == 1)
                ans = Math.abs(ar[0] - s);
            else {
                if (curM == s)
                    ans = 0;
                else if (curM < s)
                    ans = case1(ar, s);
                else
                    ans = case2(ar, s);
            }
            out.println(ans);
        }

        long case1(Integer[] ar, int s) {
            long res = 0;
            for (int j = ar.length / 2; j < ar.length; j++)
                if (ar[j] <= s)
                    res += s - ar[j];
            return res;
        }

        long case2(Integer[] ar, int s) {
            long res = 0;
            for (int j = ar.length / 2; j >= 0; j--)
                if (ar[j] >= s)
                    res += ar[j] - s;
            return res;
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

