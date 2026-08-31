import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int c = in.nextInt();
            int v0 = in.nextInt();
            int v1 = in.nextInt();
            int a = in.nextInt();
            int l = in.nextInt();

            if (c <= v0) {
                out.println(1);
                return;
            }

            int now = v0;
            int cv = v0;
            for (int i = 2; ; i++) {
                cv = Math.min(cv + a, v1);
                if (now + cv - l >= c) {
                    out.println(i);
                    return;
                }
                now += cv - l;
            }
        }

    }
}

