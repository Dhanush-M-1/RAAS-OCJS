import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
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
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        GOldFloppyDrive solver = new GOldFloppyDrive();
        solver.solve(1, in, out);
        out.close();
    }

    static class GOldFloppyDrive {
        int n;
        int m;
        long[] arr;
        long[][] queries;

        public void readInput(Scanner sc) {
            n = sc.nextInt();
            m = sc.nextInt();
            arr = new long[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            queries = new long[m][3];
            for (int i = 0; i < m; i++) {
                queries[i][0] = sc.nextInt();
                queries[i][1] = i;
            }
        }

        public void solve(int testNumber, Scanner sc, PrintWriter pw) {
            int q = sc.nextInt();
            while (q-- > 0) {
                readInput(sc);
                long total = 0;
                long largest = 0;
                long max = 0;
                for (int i = 0; i < n; i++) {
                    total += arr[i];
                    largest = Math.max(total, largest);
                }
                if (total > 0) {
                    for (int i = 0; i < m; i++) {
                        if (queries[i][0] >= largest) {
                            long div = ((Math.max(queries[i][0] - largest, 0) + total - 1) / total);
                            queries[i][2] += div * n;
                            queries[i][0] -= div * total;
                        }
                    }
                }
                Arrays.sort(queries, (a, b) -> Long.compare(a[0], b[0]));
                long sum = 0;
                int j = 0;
                for (int i = 0; i < n; i++) {
                    sum += arr[i];
                    while (j < m && sum >= queries[j][0]) {
                        queries[j][2] += (i + 1);
                        j++;
                    }
                }
                while (j < m)
                    queries[j++][2] = 0;
                Arrays.sort(queries, (a, b) -> Long.compare(a[1], b[1]));
                for (int i = 0; i < m; i++)
                    pw.print((queries[i][2] - 1) + " ");
                pw.println();
            }
        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
                return st.nextToken();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

