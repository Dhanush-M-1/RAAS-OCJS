import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
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
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ABadTriangle solver = new ABadTriangle();
        solver.solve(1, in, out);
        out.close();
    }

    static class ABadTriangle {
        public void solve(int testNumber, Scanner sc, PrintWriter pw) {
            int q = sc.nextInt();
            while (q-- > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                Integer[] sort = new Integer[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                for (int i = 0; i < n; i++)
                    sort[i] = i;
                Arrays.sort(sort, (a, b) -> arr[a] - arr[b]);
                if (arr[sort[0]] + arr[sort[1]] <= arr[sort[n - 1]]) {
                    pw.println((sort[0] + 1) + " " + (sort[1] + 1) + " " + (sort[n - 1] + 1));
                } else
                    pw.println(-1);

            }
        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

