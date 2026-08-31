import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Atanas
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
            int X = in.nextInt();
            int Y = in.nextInt();

            for (int add = 0; ; ++add) {

                // x + add / (x + add + N) >= Y
                if ((X + add) * 100 >= (Y * N)) {
                    out.println(add);
                    return;
                }
            }

        }

    }
}

