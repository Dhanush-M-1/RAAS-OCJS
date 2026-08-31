import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author iRawit
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
            int n = in.nextInt();
            int ar[] = new int[n];
            int max = 0, sum = 0;
            for (int i = 0; i < n; i++) {
                ar[i] = in.nextInt();
                sum += ar[i];
                if (ar[i] > max) {
                    max = ar[i];
                }
            }
            if (max * n - sum > sum)
                out.print(max);
            else if (max * n - sum == sum) {
                out.print(max + 1);
            } else {
                out.print((sum * 2) / n + 1);
            }

        }

    }
}

