import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int yh, ya, yd;
        int mh, ma, md;
        int sh, sa, sd;
        yh = scan.nextInt();
        ya = scan.nextInt();
        yd = scan.nextInt();
        mh = scan.nextInt();
        ma = scan.nextInt();
        md = scan.nextInt();
        sh = scan.nextInt();
        sa = scan.nextInt();
        sd = scan.nextInt();
        int res = Integer.MAX_VALUE;
        for (int i=0; i<=200; i++) {
            for (int j=0; j<=100; j++) {
                int yAtk = Math.max(0, ya + i - md);
                int mAtk = Math.max(0, ma - yd - j);

                if (yAtk == 0) continue;

                int mDeadTime = (mh + yAtk - 1) / yAtk;
                int yRemain = Math.max(0, mDeadTime * mAtk + 1 - yh);
                res = Math.min(res, i * sa + j * sd + yRemain * sh);
            }
        }
        System.out.println(res);
    }
}