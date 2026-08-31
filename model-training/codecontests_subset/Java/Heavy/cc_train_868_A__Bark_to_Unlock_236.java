import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Zheng Sheng
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
            String s = in.next();
            int n = in.nextInt();
            String[] a = new String[n];
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                a[i] = in.next();
                if (a[i].equals(s)) flag = true;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    StringBuffer ss = new StringBuffer();
                    ss.append(a[i].charAt(1));
                    ss.append(a[j].charAt(0));
                    if (ss.toString().equals(s)) {
                        flag = true;
                    }
                }
            }
            if (flag) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }

    }
}

