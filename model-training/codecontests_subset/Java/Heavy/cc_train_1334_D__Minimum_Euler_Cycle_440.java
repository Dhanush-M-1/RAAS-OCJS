import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
        DMinimumEulerCycle solver = new DMinimumEulerCycle();
        solver.solve(1, in, out);
        out.close();
    }

    static class DMinimumEulerCycle {
        public void solve(int testNumber, Scanner sc, PrintWriter pw) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                long a = sc.nextLong();
                long b = sc.nextLong();
                long[] arr = new long[n];
                arr[0] = 2 * n - 2;
                for (int i = 1; i < n - 1; i++) arr[i] = arr[i - 1] + 2 * (n - i - 1);
                arr[n - 1] = arr[n - 2] + 1;
                int in = 0;
                int la = 0;
                int l = 0;
                int h = n - 1;
                while (l <= h) {
                    int mid = (l + h) / 2;
                    if (arr[mid] >= a) {
                        in = mid;
                        h = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                l = 0;
                h = n - 1;
                while (l <= h) {
                    int mid = (l + h) / 2;
                    if (arr[mid] >= b) {
                        la = mid;
                        h = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                for (int i = in; i <= la; i++) {

                    int[] tmp = new int[2 * (n - i) - 2];
                    int idx = 0;
                    if (i == n - 1) pw.print(1);
                    else {
                        for (int j = i + 2; j <= n; j++) {
                            tmp[idx] = i + 1;
                            if (idx + 1 < tmp.length) tmp[idx + 1] = j;
                            idx += 2;
                        }
                        if (i == in) {
                            if (i == la) {
                                int s = (int) (a - (i == 0 ? 0 : arr[i - 1]) - 1);
                                int e = (int) (b - (i == 0 ? 0 : arr[i - 1]));
                                for (int j = s; j < e; j++) pw.print(tmp[j] + " ");
                            } else {
                                int s = (int) (a - (i == 0 ? 0 : arr[i - 1]) - 1);
                                for (int j = s; j < tmp.length; j++) pw.print(tmp[j] + " ");

                            }
                        } else if (i == la) {
                            int e = (int) (b - (i == 0 ? 0 : arr[i - 1]));
                            for (int j = 0; j < e; j++) pw.print(tmp[j] + " ");
                        } else {
                            for (int j = 0; j < tmp.length; j++) pw.print(tmp[j] + " ");

                        }
                    }
                }
                pw.println();
            }
            pw.flush();
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

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

