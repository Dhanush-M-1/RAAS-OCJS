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
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, Scanner in, PrintWriter out) {


            int n = in.nextInt();
            int k = in.nextInt();


            int[] a = new int[n+1];
            int ans = 0;


            for (int i = 1; i <=n; i++) {
                a[i] = in.nextInt();
            }


            int sum = 0;
            int i = 0;

            while (sum < k) {

                i++;
                sum += i;


            }

            
                sum = sum - i;
                ans = a[k - sum];
            


            System.out.print(ans);


        }

    }
}

