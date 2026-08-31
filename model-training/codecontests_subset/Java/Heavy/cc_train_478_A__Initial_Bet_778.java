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
 * @author Mehul Sharma
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


            int n1 = in.nextInt();
            int n2 = in.nextInt();
            int n3 = in.nextInt();
            int n4 = in.nextInt();
            int n5 = in.nextInt();

            int sum = n1 + n2 + n3 + n4 + n5;

            int res = 0;

            if (sum % 5 == 0) {
                if (sum == 0) {
                    res = -1;
                } else
                    res = sum / 5;
            } else {
                res = -1;
            }


            System.out.println(res);


        }

    }
}

