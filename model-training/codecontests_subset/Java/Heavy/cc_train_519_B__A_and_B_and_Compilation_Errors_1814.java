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

            long N = in.nextLong();
            long sum = 0;


            for (long i = 0; i < N; i++) {
                sum = sum + in.nextLong();
            }

            for (int j = 1; j < 3; j++) {
                long temp = sum;
                for (long i = 0; i < N - j; i++) {
                    temp -= in.nextLong();
                }

                out.println(temp);
                sum = sum - temp;
                temp = sum;
            }


        }

    }
}

