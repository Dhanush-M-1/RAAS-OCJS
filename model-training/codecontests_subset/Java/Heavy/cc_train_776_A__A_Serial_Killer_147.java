import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author vsocolov
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
            final String firstLeftVictim = in.next();
            final String firstRightVictim = in.next();
            final int n = in.nextInt(); //nr of days

            out.println(firstLeftVictim + " " + firstRightVictim);

            String[] victims = { firstLeftVictim, firstRightVictim };
            for (int i = 0; i < n; i++)
            {
                final String leftVictim = in.next();
                final String rightVictim = in.next();

                for (int j = 0; j < victims.length; j++)
                {
                    if (victims[j].equals(leftVictim))
                    {
                        victims[j] = rightVictim;
                    }
                }

                out.println(victims[0] + " " + victims[1]);
            }
        }

    }
}

