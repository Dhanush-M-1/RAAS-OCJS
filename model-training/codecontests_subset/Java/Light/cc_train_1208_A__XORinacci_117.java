import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Tanzim Ibn Patowary
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
            for (int test = 0; test < testNumber; test++) {
                int n = in.nextInt();
                while (n-- != 0) {
                    int a = in.nextInt();
                    int b = in.nextInt();
                    int x = in.nextInt();
                    if (x % 3 == 0) {
                        out.println(a);
                    } else if (x % 3 == 1) {
                        out.println(b);
                    } else {
                        out.println(a ^ b);
                    }
                }
            }
        }

    }
}

