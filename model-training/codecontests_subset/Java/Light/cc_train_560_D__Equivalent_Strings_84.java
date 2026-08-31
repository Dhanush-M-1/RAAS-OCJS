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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();

            String ss1 = sort(s1);
            String ss2 = sort(s2);

            out.println(ss1.equals(ss2) ? "YES" : "NO");
        }

        public String sort(String s) {
            if (s.length() % 2 == 1) return s;

            String s1 = sort(s.substring(0, s.length() / 2));
            String s2 = sort(s.substring(s.length() / 2));

            if (s1.compareTo(s2) > 0) return s1 + s2;
            return s2 + s1;
        }

    }
}

