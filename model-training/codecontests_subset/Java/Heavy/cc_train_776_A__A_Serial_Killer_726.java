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
            String arr[] = new String[2];
            arr[0] = in.next();
            arr[1] = in.next();
            int n = in.nextInt();
            out.println(arr[0] + " " + arr[1]);
            for (int i = 0; i < n; i++) {
                String str1 = in.next();
                String str2 = in.next();
                if (str1.equals(arr[0])) {
                    arr[0] = str2;
                } else if (str1.equals(arr[1])) {
                    arr[1] = str2;
                } else if (str2.equals(arr[0])) {
                    arr[0] = str1;
                } else if (str2.equals(arr[1])) {
                    arr[1] = str1;
                }
                out.println(arr[0] + " " + arr[1]);
            }
        }

    }
}

