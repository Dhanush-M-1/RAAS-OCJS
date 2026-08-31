import java.util.Scanner;

public class KIntegers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n + 1];
        int[] q = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            p[j] = in.nextInt();
            q[p[j]] = j;
        }
        BinaryIndexTree bit1 = new BinaryIndexTree(1, n);
        BinaryIndexTree bit2 = new BinaryIndexTree(1, n);
        StringBuilder builder = new StringBuilder();
        long curr = 0;
        for (int j = 1; j <= n; j++) {
            curr += bit1.query(q[j] + 1, n);
            //System.out.println("j = " + j + ", curr = " + curr);
            bit1.update(q[j], 1L);
            bit2.update(q[j], q[j]);
            int lower = 1;
            int upper = n;
            while (upper > lower) {
                int mid = (lower + upper + 1) / 2;
                if (bit1.query(1, mid - 1) > j / 2) {
                    upper = mid - 1;
                } else {
                    lower = mid;
                }
            }
            long above = bit1.query(upper + 1, n);
            long add1 =  bit2.query(upper + 1, n) - (((long) upper) * above) - ((above * (above + 1)) / 2L);
            long below = bit1.query(1, upper - 1);
            long add2 =  (((long) upper) * below) - ((below * (below + 1)) / 2L) - bit2.query(1, upper - 1);
            //System.out.println("upper = " + upper);
            //System.out.println("above = " + above + ", below = " + below);
            //System.out.println("add1 = " + add1 + ", add2 = " + add2);
            builder.append(curr + add1 + add2).append(' ');
        }
        System.out.println(builder);
    }

    static class BinaryIndexTree {
        final long[] val;
        final int treeFrom;

        BinaryIndexTree(int treeFrom, int treeTo) {
            val = new long[treeTo - treeFrom + 2];
            this.treeFrom = treeFrom;
        }

        void update(int index, long delta) {
            for (int i = index + 1 - treeFrom; i < val.length; i += i & -i) {
                val[i] += delta;
            }
        }

        long query(int to) {
            long res = 0;
            for (int i = to + 1 - treeFrom; i > 0; i -= i & -i) {
                res += val[i];
            }
            return res;
        }

        long query(int from, int to) {
            if (to < from) {
                return 0;
            }
            return query(to) - query(from - 1);
        }
    }
}
