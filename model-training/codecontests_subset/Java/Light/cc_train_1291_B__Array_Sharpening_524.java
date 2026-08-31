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
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                int n = in.nextInt();
                int[] a = new int[n];
                for (int j = 0; j < n; j++) {
                    a[j] = in.nextInt();
                }
                int prefixEndIndex = 0;
                for (int j = 0; j < n; j++) {
                    if (a[j] < j) break;
                    prefixEndIndex = j;
                }
                int suffixStartIndex = n - 1;
                for (int j = n - 1; j >= 0; j--) {
                    if (a[j] < n - j - 1) break;
                    suffixStartIndex = j;
                }
                if (suffixStartIndex <= prefixEndIndex) out.println("Yes");
                else out.println("No");
            }

        }

    }
}

