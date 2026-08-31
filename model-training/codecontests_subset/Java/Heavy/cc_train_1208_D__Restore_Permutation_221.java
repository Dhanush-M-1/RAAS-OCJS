import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.Vector;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
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
        DRestorePermutation solver = new DRestorePermutation();
        solver.solve(1, in, out);
        out.close();
    }

    static class DRestorePermutation {
        public void solve(int testNumber, Scanner sc, PrintWriter pw) {
            int n = sc.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextLong();
            FenwickTree ft = new FenwickTree(n + 1);
            for (int i = 1; i <= n; i++)
                ft.point_update(i, i);
            Stack<Integer> st = new Stack<>();
            for (int i = n - 1; i >= 0; i--) {
                st.add(ft.findIndex(arr[i]) + 1);
                ft.point_update(st.peek(), -st.peek());
            }
            while (!st.isEmpty())
                pw.print(st.pop() + " ");
        }

        public class FenwickTree {
            int n;
            long[] ft;

            FenwickTree(int size) {
                n = size;
                ft = new long[n + 1];
            }

            void point_update(int k, int val) {
                while (k <= n) {
                    ft[k] += val;
                    k += k & -k;
                }        //min?
            }

            int findIndex(long cumFreq) {
                int msk = n;
                while ((msk & (msk - 1)) != 0)
                    msk ^= msk & -msk;            //msk will contain the MSB of n

                int idx = 0;
                while (msk != 0) {
                    int tIdx = idx + msk;
                    if (tIdx <= n && cumFreq >= ft[tIdx]) {
                        idx = tIdx;
                        cumFreq -= ft[tIdx];
                    }
                    msk >>= 1;
                }
                if (cumFreq != 0)
                    return -1;
                return idx;
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

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

