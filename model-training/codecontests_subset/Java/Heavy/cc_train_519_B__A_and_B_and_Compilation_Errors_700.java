import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author AEroui
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
            long sum = 0;
            for (int i = 0; i < n; ++i) {
                sum += 1l * in.nextInt();
            }

            long tmpSum = 0;
            for (int i = 0; i < n - 1; ++i)
                tmpSum += 1l * in.nextInt();

            out.println(sum - tmpSum);
            sum = tmpSum;


            tmpSum = 0;
            for (int i = 0; i < n - 2; ++i)
                tmpSum += 1l * in.nextInt();

            out.println(sum - tmpSum);

        }

    }
}

