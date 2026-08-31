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
        BAAndBAndCompilationErrors solver = new BAAndBAndCompilationErrors();
        solver.solve(1, in, out);
        out.close();
    }

    static class BAAndBAndCompilationErrors {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            long first = 0;
            long second = 0;
            long third = 0;
            for (int i = 0; i < n; i++) {
                first = first + in.nextInt();
            }
            for (int i = 0; i < n - 1; i++) {
                second = second + in.nextInt();
            }

            for (int i = 0; i < n - 2; i++) {
                third = third + in.nextInt();
            }
            out.println(first - second);
            out.println(second - third);
        }

    }
}

