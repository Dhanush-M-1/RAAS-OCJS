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
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int t = in.nextInt();
            int i;
            long ans = 0;
            int max = Integer.MIN_VALUE;
            for (i = 0; i < t; i++) {
                int a = in.nextInt();
                ans += a;
                max = a > max ? a : max;


            }
            long k;
            long lim = 2l * ans;
            for (k = max; t * k <= lim; k++) ;

            out.println(k);
        }

    }
}

