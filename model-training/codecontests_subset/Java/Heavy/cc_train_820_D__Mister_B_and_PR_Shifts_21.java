import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author OmarYasser
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, Scanner sc, PrintWriter out) {
            int n = sc.nextInt();
            int MAX = (int) 1e6 + n + 1234;

            long[] cum = new long[MAX];
            long[] instant = new long[MAX];
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt() - 1;
                if (i > a[i]) {
                    int distToN = n - i - 1;
                    if (distToN != 0) {
                        cum[1]++;
                        cum[distToN + 1]--;
                    }
                    if (a[i] != 0)
                        cum[n - i + a[i] + 1] += 2;
                } else if (i < a[i]) {
                    int distToNum = a[i] - i;
                    cum[1]--;
                    cum[distToNum + 1]++;
                    if (a[i] != n - 1) {
                        cum[distToNum + 1]++;
                        cum[n - i]--;
                    }
                } else {
                    if (i != n - 1) {
                        cum[1]++;
                        cum[n - i]--;

                    }
                }
                instant[n - i] += (a[i] - Math.abs(a[i] - (n - 1)));
                if (a[i] == 0) {
                    cum[n - i + 1] += 1;
                } else {
                    cum[n - i + 1] -= 1;
                }
            }

            for (int i = 1; i < cum.length; i++) {
                cum[i] = cum[i] + cum[i - 1];
            }
            long best = 0, cycle = 0;
            for (int i = 0; i < n; i++)
                best += Math.abs(a[i] - i);


            long bestOfBest = best;
            for (int i = 1; i < n; i++) {
                long here = best + cum[i] + instant[i];
                if (here < bestOfBest) {
                    bestOfBest = here;
                    cycle = i;
                }
                best = here;
            }
            out.println(bestOfBest + " " + cycle);
        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader f) {
            br = new BufferedReader(f);
        }

        public String next() {
            while (st == null || !st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

