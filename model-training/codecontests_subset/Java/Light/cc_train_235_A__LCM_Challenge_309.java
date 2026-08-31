import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author zodiacLeo
 */
public class Main
{
    public static void main(String[] args)
    {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC
    {
        public void solve(int testNumber, Scanner in, PrintWriter out)
        {
            long max = -1;
            long n = in.nextLong();
            for (long i = Math.max(1, n - 100); i <= n; i++)
            {
                for (long j = i; j <= n; j++)
                {
                    for (long k = j; k <= n; k++)
                    {
                        max = Math.max(max, lcm(i, lcm(j, k)));
                    }
                }
            }
            out.println(max);
        }

        public long lcm(long a, long b)
        {
            return a * b / gcd(a, b);
        }

        public long gcd(long a, long b)
        {
            return b == 0 ? a : gcd(b, a % b);
        }

    }
}

