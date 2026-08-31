import java.util.Scanner;

/**
 * Created by yakoub on 04/09/15.
 */
public class WoodCutter {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int steady[] = new int[n];
        int left[] = new int[n];
        int right[] = new int[n];
        int prev = scanner.nextInt();
        int prevH = scanner.nextInt();
        steady[0] = 0;
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            int cur = scanner.nextInt();
            int curH = scanner.nextInt();
            if ((prev + prevH) < cur) {
                if (i == 1)
                    right[0] = 1;
                else
                    right[i - 1] += 1 + Math.max(steady[i - 2], Math.max(right[i - 2], left[i - 2]));
            }
            steady[i] = Math.max(steady[i - 1], Math.max(left[i - 1], right[i - 1]));
            int curLeftMax = Integer.MIN_VALUE;
            if ((cur - curH) > prev) {
                curLeftMax = Math.max(left[i - 1], steady[i - 1]) + 1;
                if ((prev + prevH) < (cur - curH)) {
                    curLeftMax = Math.max(curLeftMax, right[i - 1] + 1);
                }
            }
            left[i] = Math.max(curLeftMax, steady[i]);
            prev = cur;
            prevH = curH;
        }
        if (n > 1)
            right[n - 1] = 1 + Math.max(steady[n - 2], Math.max(right[n - 2], left[n - 2]));
        System.out.println(Math.max(steady[n - 1], Math.max(left[n - 1], right[n - 1])));

    }

}
