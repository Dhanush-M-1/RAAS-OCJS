/**
 * Created by Anna on 14.03.2016.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TaskD {
    StringTokenizer st;
    PrintWriter out;
    BufferedReader in;

    public static void main(String[] args) throws IOException {
        TaskD solver = new TaskD();
        solver.open();
        solver.solve();
        solver.close();

    }


    class Decomposition {
        long[] array;
        long[] sums;
        int n;
        int cntParts;
        int partCapacity;

        long max;

        public Decomposition(int n, long max) {
            array = new long[n];
            this.n = n;
            this.partCapacity = (int) Math.sqrt(n);
            this.cntParts = this.n / this.partCapacity + (this.n % this.partCapacity == 0 ? 0 : 1);
            this.max = max;
            this.sums = new long[this.cntParts];
        }

        public void updateElement(long value, int ind) {
            if (value > this.max) value = this.max;
            int partNumber = ind / this.partCapacity;

            long old = this.array[ind];
            this.array[ind] = value;
            this.sums[partNumber] -= old;
            this.sums[partNumber] += value;

        }

        public long getSum(int from, int to) {
            if (from > to) return 0L;
            int fromPart = from / this.partCapacity;
            int toPart = to / this.partCapacity;
            long result = 0;
            if (fromPart == toPart) {
                for (int i = from; i <= to; i++) {
                    result += array[i];
                }
                return result;
            }

            for (int i = fromPart + 1; i < toPart; i++) {
                result += sums[i];
            }

            int fromEnd = (fromPart + 1) * partCapacity - 1;
            int toStart = toPart * partCapacity;

            for (int i = from; i <= fromEnd; i++) {
                result += array[i];
            }

            for (int i = toStart; i <= to; i++) {
                result += array[i];
            }

            return result;
        }


    }

    private void solve() throws IOException {
        int n = nextInt();
        int k = nextInt();
        int a = nextInt();
        int b = nextInt();
        long[] orders = new long[n];

        Decomposition before = new Decomposition(n, b);
        Decomposition after = new Decomposition(n, a);

        int q = nextInt();

        for (int i = 0; i < q; i++) {
            int type = nextInt();

            if (type == 1) {
                int day = nextInt() - 1;
                long cnt = nextLong();
                orders[day] += cnt;
                before.updateElement(orders[day], day);
                after.updateElement(orders[day], day);
            } else {
                int p = nextInt() - 1;
                int left = p - 1;
                int right = p + k;
                long result = before.getSum(0,left) + after.getSum(right,n-1);
                out.println(result);
            }
        }
    }

    private String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String str = in.readLine();
            if (str == null) return null;
            st = new StringTokenizer(str);
        }
        return st.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }


    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }


    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private void close() {
        out.close();
    }

    private void open() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }
}