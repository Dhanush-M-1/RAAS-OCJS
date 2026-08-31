import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author safadurimo
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
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            long[] a = new long[11];
            for (int i = 0; i < n; i++) {
                a[in.nextInt()]++;
            }
            long c = 0;
            for (int i = 0; i < 11; i++) {
                for (int j = i + 1; j < 11; j++) {
                    c = (c + a[i] * a[j]);
                }
            }
            out.println(c);
        }

    }
}
