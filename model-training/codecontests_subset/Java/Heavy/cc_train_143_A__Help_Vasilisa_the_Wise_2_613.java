import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
            int r1 = in.nextInt();
            int r2 = in.nextInt();
            int c1 = in.nextInt();
            int c2 = in.nextInt();
            int d1 = in.nextInt();
            int d2 = in.nextInt();

            for (int i = 1111; i <= 9999; i++)
            {
                String s = i + "";
                if (contains0(s)) continue;
                int[][] cells = new int[2][2];
                cells[0] = new int[]{s.charAt(0) - '0', s.charAt(1) - '0'};
                cells[1] = new int[]{s.charAt(2) - '0', s.charAt(3) - '0'};
                if (r1 == cells[0][0] + cells[0][1] &&
                            r2 == cells[1][0] + cells[1][1] &&
                            c1 == cells[0][0] + cells[1][0] &&
                            c2 == cells[1][1] + cells[0][1] &&
                            d1 == cells[0][0] + cells[1][1] &&
                            d2 == cells[0][1] + cells[1][0]
                )
                {
                    if (isValid(cells))
                    {
                        out.println(cells[0][0] + " " + cells[0][1]);
                        out.println(cells[1][0] + " " + cells[1][1]);
                        return;
                    }
                }
            }
            out.print(-1);
        }

        private boolean contains0(String s)
        {
            return (s.charAt(0) == '0' || s.charAt(1) == '0' || s.charAt(2) == '0' || s.charAt(3) == '0');
        }

        private boolean isValid(int[][] cells)
        {
            int nums[] = {cells[0][0], cells[0][1], cells[1][0], cells[1][1]};
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 1; i++)
            {
                if (nums[i] == nums[i + 1]) return false;
            }
            return true;
        }

    }
}

