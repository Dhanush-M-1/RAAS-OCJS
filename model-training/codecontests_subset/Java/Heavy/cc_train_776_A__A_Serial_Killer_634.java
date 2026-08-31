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
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String first = in.next();
            String sec = in.next();
            int n = in.nextInt();
            out.println(first + " " + sec);
            for (int i = 0; i < n; i++) {
                String mur = in.next();
                String rep = in.next();
                if (mur.equals(first)) {
                    out.println(rep + " " + sec);
                    first = rep;
                } else {
                    out.println(first + " " + rep);
                    sec = rep;
                }
            }
        }

    }
}

