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
            int N = in.nextInt();
            int p1 = 1, p2 = 2, spec = 3;
            for (int i = 0; i < N; i++) {
                int temp = in.nextInt();
                if (temp == p1) {
                    int c = p2;
                    p2 = spec;
                    spec = c;
                } else if (temp == p2) {
                    int c = p1;
                    p1 = spec;
                    spec = c;
                } else {
                    out.println("NO");
                    return;
                }
            }
            out.println("YES");
        }

    }
}

