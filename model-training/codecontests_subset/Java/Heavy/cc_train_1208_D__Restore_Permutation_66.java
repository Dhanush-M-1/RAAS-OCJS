import java.io.*;
import java.util.*;

public class RestorePermutation {

    static class FenwickTree {

        int n;
        long[] BIT;

        FenwickTree(int n) {
            this.n = n;
            BIT = new long[n + 1];
        }

        void update(int i, long x) {
            for (; i <= n; i += i&-i) {
                BIT[i] += x;
            }
        }

        int searchNum(long prefSum) {
            int num = 0;
            long sum = 0;
            for (int i = 19; i >= 0; --i) {
                if (num + (1 << i) <= n && sum + BIT[num + (1 << i)] <= prefSum) {
                    num += (1 << i);
                    sum += BIT[num];
                }
            }
            return num + 1;
        }
    }

    public static void main(String[] args) {
        FastReader in = new FastReader(System.in);
//        FastReader in = new FastReader(new FileInputStream("input.txt"));
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter(new FileOutputStream("output.txt"));


        int n = in.nextInt();

        long[] s = new long[n + 1];
        FenwickTree ft = new FenwickTree(n);

        for (int i = 1; i <= n; ++i) {
            ft.update(i, i);
            s[i] = in.nextLong();
        }

        int[] p = new int[n + 1];

        for (int i = n; i >= 1; --i) {
            p[i] = ft.searchNum(s[i]);
            ft.update(p[i], -p[i]);
        }

        for (int i = 1; i <= n; ++i)
            out.print(p[i] + " ");
        out.println();




        out.close();
    }

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }

        Double nextDouble() {
            return Double.parseDouble(next());
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }

        String nextLine() {
            String x = "";
            try {
                x = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return x;
        }
    }
}
