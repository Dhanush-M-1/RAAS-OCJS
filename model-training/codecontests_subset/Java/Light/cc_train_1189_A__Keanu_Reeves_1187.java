import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Shahab
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
            String s = in.next();

            if (isGood(s)) {
                out.println("1");
                out.println(s);
            } else {
                out.println("2");
                out.print(s.substring(0, s.length() - 1));
                out.print(" ");
                out.println(s.charAt(s.length() - 1));
            }
        }

        private boolean isGood(String s) {
            int cnt1 = 0;
            int cnt0 = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') cnt1++;
                else cnt0++;
            }

            return cnt0 != cnt1;
        }

    }
}

