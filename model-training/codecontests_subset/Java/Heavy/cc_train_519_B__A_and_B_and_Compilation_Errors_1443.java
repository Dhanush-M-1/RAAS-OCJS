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
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();

            long a = 0;
            long b = 0;
            long c = 0;

            for (int i = 0; i < n; ++i) {
                int nb = in.nextInt();
                a += nb;
            }

            for (int i = 0; i < n - 1; ++i) {
                int nb = in.nextInt();
                b += nb;
            }

            for (int i = 0; i < n - 2; ++i) {
                int nb = in.nextInt();
                c += nb;
            }

            out.println(a - b);
            out.println(b - c);
        }

    }
}

