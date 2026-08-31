import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author vinrar
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        AMinimumInteger solver = new AMinimumInteger();
        solver.solve(1, in, out);
        out.close();
    }

    static class AMinimumInteger {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int tc = in.nextInt();
            while (tc-- > 0) {
                int l = in.nextInt();
                int r = in.nextInt();
                int d = in.nextInt();

                if (d < l || d > r) {
                    System.out.println(d);
                } else {
                    System.out.println(d * ((r / d) + 1));
                }
            }
        }

    }
}

