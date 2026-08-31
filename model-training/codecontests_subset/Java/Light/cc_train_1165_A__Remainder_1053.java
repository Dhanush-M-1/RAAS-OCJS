import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author dwij
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ARemainder solver = new ARemainder();
        solver.solve(1, in, out);
        out.close();
    }

    static class ARemainder {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            in.nextLine();

            char[] a = in.nextLine().toCharArray();

            int count = 0;
            for (int i = 0; i < y; i++) {
                if (a[a.length - 1 - i] == '1') {
                    count++;
                }
            }

            if (a[a.length - 1 - y] == '0') {
                count++;
            }

            for (int i = y + 1; i < x; i++) {
                if (a[a.length - 1 - i] == '1') {
                    count++;
                }
            }


            out.println(count);

        }

    }
}

