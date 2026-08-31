import java.util.Scanner;

public class Template {

    public void solve() {
        Scanner in = new Scanner(System.in);
        int h_y = in.nextInt(), a_y = in.nextInt(), d_y = in.nextInt();
        int h_m = in.nextInt(), a_m = in.nextInt(), d_m = in.nextInt();
        int h = in.nextInt(), a = in.nextInt(), d = in.nextInt();

        int min = Integer.MAX_VALUE;
        for (int i = a_y; i <= 200; i++) {// ATK
            if (i <= d_m) continue;
            int cur =  (i - a_y) * a, time = (h_m % (i - d_m) == 0 ? h_m / (i - d_m) : h_m / (i - d_m) + 1);

            for (int j = d_y; j <= 100; j++) { //DEF
                int p = 0, cd = (j - d_y) * d;
                int curh = 1;
                if (j < a_m) {
                    curh = h_y - time * (a_m-j);
                    p += h * (1 - curh);
                }
                if (curh > 0) p = 0;
                if (p + cur + cd < min) min = p + cur + cd;
            }

        }

        System.out.println(min);

    }


    public static void main(String[] arg) {
        new Template().solve();

    }
}
