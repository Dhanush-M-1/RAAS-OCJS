import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Mouna Cheikhna
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public static final int MAX = 1000000;

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int[] as = new int[n];

            for (int i = 0; i < n; i++) {
                as[i] = in.nextInt();
            }

            int timeMe = 0;
            int timeFriend = 0;

            if (as[n - 1] <= MAX / 2) {
                out.println(as[n - 1] - 1);
                return;
            } else if (as[0] > MAX / 2) {
                out.println(MAX - as[0]);
                return;
            }

            int idx = search(MAX / 2, as);
            int mm = MAX / 2;
            if (as[idx] <= mm) {
                timeMe = as[idx] - 1;
                if (idx + 1 < n) {
                    timeFriend = MAX - as[idx + 1];
                }
            }
            if (as[idx] > mm) {
                if (idx - 1 >= 0) {
                    timeMe = as[idx - 1] - 1;
                }
                timeFriend = MAX - as[idx];
            }

            out.println(Math.max(timeMe, timeFriend));
        }

        public static int search(int value, int[] a) {

            if (value < a[0]) {
                return 0;
            }
            if (value > a[a.length - 1]) {
                return a.length - 1;
            }

            int lo = 0;
            int hi = a.length - 1;

            while (lo <= hi) {
                int mid = (hi + lo) / 2;

                if (value < a[mid]) {
                    hi = mid - 1;
                } else if (value > a[mid]) {
                    lo = mid + 1;
                } else {
                    return mid;
                }
            }
            // lo == hi + 1
            return (a[lo] - value) < (value - a[hi]) ? lo : hi;
        }

    }
}

