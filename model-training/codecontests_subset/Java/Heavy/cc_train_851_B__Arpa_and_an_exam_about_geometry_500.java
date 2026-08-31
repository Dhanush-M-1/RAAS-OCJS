import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Yuan Lei
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
            long x, y;
            TaskB.Point A, B, C;
            x = in.nextInt();
            y = in.nextInt();
            A = new TaskB.Point(x, y);
            x = in.nextInt();
            y = in.nextInt();
            B = new TaskB.Point(x, y);
            x = in.nextInt();
            y = in.nextInt();
            C = new TaskB.Point(x, y);
            TaskB.Point D = new TaskB.Point(A.x - B.x, A.y - B.y);
            TaskB.Point E = new TaskB.Point(B.x - C.x, B.y - C.y);
            if (D.mod() == E.mod()) {
                if (D.x * E.y - D.y * E.x == 0) {
                    out.println("No");
                } else {
                    out.println("Yes");
                }
            } else {
                out.println("No");
            }

        }

        static class Point {
            public long x;
            public long y;

            public Point(long x, long y) {
                this.x = x;
                this.y = y;
            }

            public long mod() {
                return x * x + y * y;
            }

        }

    }
}

