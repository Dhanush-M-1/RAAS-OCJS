import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author heifrank
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
        int[] a;
        int[] exp;

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            a = new int[n + 1];
            exp = new int[n + 1];
            Arrays.fill(exp, 0);

            int qsz = 0;
            long sumP = 0, sumN = 0;

            for (int i = 1; i <= n; i++) {
                a[i] = in.nextInt();
                int t = a[i] - i;
                if (t <= 0) {
                    sumN -= t;
                } else {
                    sumP += t;
                    exp[t]++;
                    qsz++;
//                queue.add(t);
                }
            }

            int curTime = 1;
            long minv = sumP + sumN;
            int pos = 0;

            for (int i = 1; i < n; i++) {
                int rpos = n - i + 1;
                int elem = a[rpos];

                int sz = qsz;
                sumN -= n - elem;
                sumN += n - sz - 1;

                sumP -= sz;
                sumP += elem - 1;

                int tt = curTime + elem - 1;
                if (tt < n) {
                    exp[tt]++;
                }
                qsz++;

                qsz -= exp[curTime];
//            queue.offer(curTime + elem - 1);
//            while (!queue.isEmpty() && queue.peek() == curTime) queue.poll();

                if (sumP + sumN < minv) {
                    minv = sumP + sumN;
                    pos = i;
                }
                curTime++;
            }
            out.println(minv + " " + pos);
        }

    }
}

