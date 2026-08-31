import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main
{
    public static void main(String[] args)
    {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB
    {
        public void solve(int testNumber, Scanner in, PrintWriter out)
        {
            int T = in.nextInt();
            while (T-- > 0)
            {
                solve(in, out);
            }
        }

        private void solve(Scanner in, PrintWriter out)
        {
            int N = in.nextInt();
            int cnt = 0;
            while (true)
            {
                if (N == 1) break;
                if (N % 6 == 0)
                {
                    N /= 6;
                    cnt++;
                } else if (N % 3 == 0)
                {
                    N *= 2;
                    cnt++;
                } else
                {
                    cnt = -1;
                    break;
                }
            }
            out.println(cnt);
        }

    }
}

