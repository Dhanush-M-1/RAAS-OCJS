import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Martin Böschen
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
            int c = in.nextInt();
            int vo = in.nextInt();
            int v1 = in.nextInt();
            int a = in.nextInt();
            int l = in.nextInt();
            int page = 0;

            int steps = 0;
            while (page < c) {
                steps++;
                if (page > 0) {
                    page -= l;
                }
                page += Math.min(v1, vo + (steps - 1) * a);
            }
            out.println(steps);
        }

    }
}

