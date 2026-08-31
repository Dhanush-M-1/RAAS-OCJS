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
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task
    {
        static int N = 101;
        static int K;
        static int dp[][][] = new int[N][4][2];

        public void solve(int testNumber, Scanner in, PrintWriter out)
        {
            String number = in.next(); // n
            K = in.nextInt(); // number of non-0 digits in a number
            init_dp();
            int digits[] = getDigitsFrom(number);
            out.print(digitOcc(0, 0, true, digits));
        }

        static int digitOcc(int index, int partialCount, boolean tight, int digits[])
        {
            if (partialCount > K) return 0; // fails condition
            if (index == digits.length) return boolToInt(partialCount == K); // out of boundary
            int answer = dp[index][partialCount][boolToInt(tight)];
            if (answer >= 0)
                return answer;

            answer = 0;
            for (int i = 0; i <= 9; ++i)
            {
                if (tight && (i > digits[index])) break; // forming too big number, current number exceeds n
                boolean nextTight = tight && (i == digits[index]);
                int nextCount = partialCount + boolToInt(i != 0); // checking condition over current digit
                answer += digitOcc(index + 1, nextCount, nextTight, digits);
            }
            dp[index][partialCount][boolToInt(tight)] = answer;
            return answer;
        }

        private int[] getDigitsFrom(String number)
        {
            int[] digits = new int[number.length()];
            int i = 0;
            for (char digit : number.toCharArray())
            {
                digits[i] = digit - '0';
                i++;
            }
            return digits;
        }

        static int boolToInt(boolean b)
        {
            return b ? 1 : 0;
        }

        static void init_dp()
        {
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    for (int k = 0; k < 2; k++)
                    {
                        dp[i][j][k] = -1;
                    }
                }
            }
        }

    }
}

