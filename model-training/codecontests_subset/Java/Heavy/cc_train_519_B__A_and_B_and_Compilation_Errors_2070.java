import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
            int[] first = new int[n];
            int[] second = new int[n - 1];
            int[] third = new int[n - 2];
            for (int i = 0; i < n; i++) {
                first[i] = in.nextInt();
            }
            Arrays.sort(first);
            for (int i = 0; i < n - 1; i++) {
                second[i] = in.nextInt();
            }
            Arrays.sort(second);

            int upto = upto(first, second, out);
            first = null;

            for (int i = 0; i < n - 2; i++) {
                third[i] = in.nextInt();
            }
            Arrays.sort(third);
            upto(second, third, out);
        }

        int upto(int[] first, int[] second, PrintWriter out) {
            for (int i = 0; i < second.length; i++) {
                if (first[i] != second[i]) {
                    out.println(first[i]);
                    return i;
                }
            }
            out.println(first[second.length]);
            return second.length;
        }

    }
}

