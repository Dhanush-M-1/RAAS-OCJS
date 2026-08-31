import java.util.Scanner;

/**
 * @auther chao
 * @date 16/1/15
 */
public class CF1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long x = in.nextLong();
        long y = in.nextLong();

        long r2max = Long.MIN_VALUE;
        double r2min = Long.MAX_VALUE;
        long[] xx = new long[n+1];
        long[] yy = new long[n+1];
        for (int i = 0; i < n ;i++) {
            xx[i] = in.nextLong()-x;
            yy[i] = in.nextLong()-y;
            long r2 = square(xx[i]) + square(yy[i]);
            if (r2 > r2max) r2max = r2;
            if (r2 < r2min) r2min = r2;
        }
        yy[n] = yy[0];
        xx[n] = xx[0];
        for (int i = 0; i < n ;i++) {
            if (xx[i]*(xx[i]-xx[i+1])+yy[i]*(yy[i]-yy[i+1]) <= 0) continue;
            if (xx[i+1]*(xx[i+1]-xx[i])+yy[i+1]*(yy[i+1]-yy[i]) <= 0) continue;
            r2min = Math.min(r2min, 1.0*(xx[i]*yy[i+1]-xx[i+1]*yy[i])/(square(xx[i]-xx[i+1])+square(yy[i]-yy[i+1]))*(xx[i]*yy[i+1]-xx[i+1]*yy[i]));
            //r2min = Math.min(r2min, Line2D.ptSegDistSq(xx[i],yy[i],xx[i+1],yy[i+1],0,0));
        }
        System.out.println(Math.PI*(r2max-r2min));
    }
    private static long square(long v) {
        return v*v;
    }
}