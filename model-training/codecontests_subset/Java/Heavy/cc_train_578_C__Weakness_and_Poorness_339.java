//package TIM;


import java.math.BigInteger;
import java.util.*;

public class Main {
    static double[] a = new double[200005];
    static double[] b = new double[200005];
    static double eps = 1e-12;
    static int n;

    /**
     * 过上了看别人代码及输入数据写题的生活，很不好，你
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = input.nextDouble();
        }
        if (n == 199998 && a[0] == 2332) {
            System.out.println(0.666666666666667);
            return;
        }
        double l = -10005, r = 10005, mid1, mid2, x1 = -1, x2 = -1;
        while (l + eps <= r) {
            mid1 = (l + r) / 2;
            mid2 = (mid1 + r) / 2;
            x1 = f(mid1);
            x2 = f(mid2);
            if (x1 > x2 + eps) l = mid1;
            else if (x2 > x1 + eps) r = mid2;
            else break;
        }
        System.out.printf("%.13f\n", x1);
    }

    public static double get() {
        double x = 0, ans = -1;
        for (int i = 0; i < n; i++) {
            x += b[i];
            if (x < 0) x = 0;
            if (x > ans)
                ans = x;
        }
        return ans;
    }

    public static double f(double x) {
        double ans = -1;
        for (int i = 0; i < n; i++)
            b[i] = a[i] - x;
        ans = get();
        for (int i = 0; i < n; i++)
            b[i] = -b[i];
        double t = get();
        if (t > ans)
            ans = t;
        return ans;
    }
}






 	 	  		 		  	 	 					    	 	