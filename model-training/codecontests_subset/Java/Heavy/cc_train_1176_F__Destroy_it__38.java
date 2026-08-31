import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author szfck
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskF solver = new TaskF();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskF {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            long[] dp = new long[10];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            for (int i = 0; i < n; i++) {
                int k = in.nextInt();
                long[] ndp = dp.clone();
                ArrayList<Integer> one = new ArrayList<>();
                int maxTwo = -1, maxThree = -1;
                for (int j = 0; j < k; j++) {
                    int c = in.nextInt(), d = in.nextInt();
                    if (c == 1) one.add(d);
                    else if (c == 2) maxTwo = Math.max(maxTwo, d);
                    else if (c == 3) maxThree = Math.max(maxThree, d);
                }
                Collections.sort(one);
                long maxOne1 = -1, maxOne2 = -1, maxOne3 = -1;
                if (one.size() > 0) maxOne1 = one.get(one.size() - 1);
                if (one.size() > 1) maxOne2 = one.get(one.size() - 2);
                if (one.size() > 2) maxOne3 = one.get(one.size() - 3);

                long chooseOne = Math.max(maxOne1, Math.max(maxTwo, maxThree));
                long chooseTwo = -1;
                long chooseTwoMax = -1;
                if (maxOne1 != -1) {
                    if (maxTwo != -1) {
                        chooseTwo = maxOne1 + maxTwo;
                        chooseTwoMax = Math.max(maxOne1, maxTwo);
                    }
                    if (maxOne2 != -1) {
                        if (maxOne1 + maxOne2 > chooseTwo) {
                            chooseTwo = maxOne1 + maxOne2;
                            chooseTwoMax = Math.max(maxOne1, maxOne2);
                        } else if (maxOne1 + maxOne2 == chooseTwo) {
                            chooseTwoMax = Math.max(chooseTwoMax, Math.max(maxOne1, maxOne2));
                        }
                    }
                }
                long chooseThree = -1;
                long chooseThreeMax = -1;
                if (maxOne3 != -1) {
                    chooseThree = maxOne1 + maxOne2 + maxOne3;
                    chooseThreeMax = maxOne1;
                }

                long[] choose = {0, chooseOne, chooseTwo, chooseThree};
                long[] chooseMax = {0, chooseOne, chooseTwoMax, chooseThreeMax};
                for (int j = 0; j < 10; j++) {
                    if (dp[j] == -1) continue;
                    for (int num = 1; num <= 3; num++) {
                        if (choose[num] == -1) continue;
                        if (j + num < 10) {
                            ndp[j + num] = Math.max(ndp[j + num], dp[j] + choose[num]);
                        } else {
                            ndp[(j + num) % 10] = Math.max(ndp[(j + num) % 10], dp[j] + choose[num] + chooseMax[num]);
                        }
                    }
                }
                dp = ndp;
            }
            long res = 0;
            for (int i = 0; i < 10; i++) {
                res = Math.max(dp[i], res);
            }
            out.println(res);
        }

    }
}

