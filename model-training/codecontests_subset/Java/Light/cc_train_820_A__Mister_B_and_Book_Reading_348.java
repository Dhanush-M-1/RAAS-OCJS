import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Toni Rajkovski
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
            int totalPages = in.nextInt();
            int v = in.nextInt();
            int maxSpeed = in.nextInt();
            int acc = in.nextInt();
            int reread = in.nextInt();
            int read = 0;
            int numDays = 0;
            while (read < totalPages) {
                int dayRead = v + numDays * acc;
                dayRead = Math.min(dayRead, maxSpeed);
                if (numDays > 0) {
                    dayRead -= reread;
                }
                read += dayRead;
                numDays++;
            }
            out.print(numDays);
        }

    }
}

