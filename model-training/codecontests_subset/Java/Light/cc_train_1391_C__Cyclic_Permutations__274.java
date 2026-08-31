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
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC
    {
        public void solve(int testNumber, Scanner in, PrintWriter out)
        {
            int MOD = 1_000_000_007;
            int N = in.nextInt();

            long nFactorial = 1, nUnimodalPerm = 1;
            for (int i = 1; i <= N; i++)
            {
                nFactorial = nFactorial * i % MOD;
                if (i != N) nUnimodalPerm = nUnimodalPerm * 2 % MOD;
            }
            out.print((nFactorial - nUnimodalPerm + MOD) % MOD);
        }

    }
}

