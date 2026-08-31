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
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA
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
            int nums[] = CPUtils.readIntArray(N, in);
            if (nums[0] + nums[1] <= nums[N - 1])
            {
                out.println(1 + " " + 2 + " " + (N));
            } else
            {
                out.println(-1);
            }
        }

    }

    static class CPUtils
    {
        public static int[] readIntArray(int size, Scanner in)
        {
            int[] array = new int[size];
            for (int i = 0; i < size; i++)
            {
                array[i] = in.nextInt();
            }
            return array;
        }

    }
}

