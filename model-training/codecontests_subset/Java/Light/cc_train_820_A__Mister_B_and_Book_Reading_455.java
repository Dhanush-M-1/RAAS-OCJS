import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author raghumdani
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int c = in.nextInt(), v0 = in.nextInt(), v1 = in.nextInt(), a = in.nextInt(), l = in.nextInt();

            int cur = v0, days = 0;

            while (c > 0) {
                int tot = Math.min(cur, v1);
                int ext = days == 0 ? tot : tot - l;
                c -= ext;
                days++;
                cur += a;
            }

            out.println(days);
        }

    }
}

