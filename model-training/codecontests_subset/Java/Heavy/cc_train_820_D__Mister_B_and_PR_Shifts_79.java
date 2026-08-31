import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author vikas.k
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int n = in.nextInt();

            int[] a = new int[n + 1];

            int cntNegative = 0;
            int cntPositive = 0;

            ArrayList<Integer>[] positive = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                positive[i] = new ArrayList<>();
            }

            long diff = 0;
            for (int i = 1; i <= n; i++) {
                a[i] = in.nextInt();

                if (a[i] > i) {
                    cntPositive++;
                    positive[a[i] - i].add(a[i]);
                } else {
                    cntNegative++;
                }
                diff += Math.abs(a[i] - i);
            }

            long mn = diff;
            int id = 0;

            for (int i = 1; i < n; i++) {
                int j = n - i + 1;
//            out.print(j+" "+diff+" ");
                diff = diff - Math.abs(a[j] - n) + a[j];
//            out.println(diff);
                cntPositive++;
                cntNegative--;
                if (i + a[j] - 1 < n) positive[i + a[j] - 1].add(a[j]);

                diff = diff + cntNegative - cntPositive;

//            out.println(diff +" "+ cntNegative +" "+ cntPositive);
//            out.println(positive[i]);
//            out.println();

                for (Integer e : positive[i]) {
                    cntPositive--;
                    cntNegative++;
                }

                if (diff < mn) {
                    mn = diff;
                    id = i;
                }
            }

            out.println(mn + " " + id);

        }

    }

    static class FastScanner {
        private BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastScanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String next() {
            if (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

