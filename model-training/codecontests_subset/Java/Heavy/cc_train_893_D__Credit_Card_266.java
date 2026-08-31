import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Aeroui
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
            int n = in.nextInt();
            int d = in.nextInt();

            long[] arr = new long[n + 1];
            for (int i = 1; i <= n; ++i) {
                long a = in.nextLong();
                arr[i] = a;
            }

        /*int cur = d;
        for(int i = n; i>= 1; --i) {
            cur -= arr[i];
            if(arr[i] == 0 && cur < 0) {
                out.println(-1);
                return;
            }
        }*/

            long added = 0;
            long extra = 0;
            long cur = 0;
            long ans = 0;
            for (int i = 1; i <= n; ++i) {
                if (arr[i] == 0) {
                    if (cur < 0) {
                        extra = 0;
                        cur = d;
                        ans++;
                    } else {
                        extra = Math.max(extra, 0);
                    }
                } else {
                    cur += arr[i];
                    extra += arr[i];
                    cur = Math.min(cur, d);

                    if (cur < extra) {
                        out.println(-1);
                        return;
                    }
                }
            }

            out.println(ans);
        }

    }
}

