import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, Scanner sc, PrintWriter out) {
            int days = sc.nextInt();
            int repairdays = sc.nextInt();
            long fixedlimit = sc.nextLong();
            long defectlimit = sc.nextLong();
            int q = sc.nextInt();

            BIT defect = new BIT(days + 1);
            BIT fixed = new BIT(days + 1);

            for (int i = 0; i < q; i++) {
                if (sc.nextInt() == 1) {
                    int day = sc.nextInt();
                    int order = sc.nextInt();
                    defect.add(day, Math.min(defectlimit, defect.range(day, day) + order) - defect.range(day, day));
                    fixed.add(day, Math.min(fixedlimit, fixed.range(day, day) + order) - fixed.range(day, day));
                } else {
                    int day = sc.nextInt();
                    out.println(defect.sum(day - 1) + fixed.range(day + repairdays, days));
                }
            }

        }

        class BIT {
            private long[] tree;

            BIT(int size) {
                this.tree = new long[size];
            }

            void add(int idx, long val) {
                while (idx < tree.length) {
                    tree[idx] += val;
                    idx += idx & -idx;
                }
            }

            long sum(int idx) {
                long res = 0;
                while (idx > 0) {
                    res += tree[idx];
                    idx -= idx & -idx;
                }
                return res;
            }

            long range(int from, int to) {
                return sum(to) - sum(from - 1);
            }

        }

    }
}
