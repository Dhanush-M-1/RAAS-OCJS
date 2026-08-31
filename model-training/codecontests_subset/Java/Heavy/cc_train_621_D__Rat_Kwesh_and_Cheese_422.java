import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @auther chao
 * @date 16/1/31
 */

public class CF4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        double y = in.nextDouble();
        double z = in.nextDouble();
        EXP[] exps = new EXP[9];
        exps[0] = new EXP(x, y,   z, "x^y^z", 0);
        exps[1] = new EXP(x, z,   y, "x^z^y", 1);
        exps[2] = new EXP(x, y*z, 1, "(x^y)^z", 2);
        exps[3] = new EXP(y, x,   z, "y^x^z", 3);
        exps[4] = new EXP(y, z,   x, "y^z^x", 4);
        exps[5] = new EXP(y, x*z, 1, "(y^x)^z", 5);
        exps[6] = new EXP(z, x,   y, "z^x^y", 6);
        exps[7] = new EXP(z, y,   x, "z^y^x", 7);
        exps[8] = new EXP(z, x*y, 1, "(z^x)^y", 8);
        /*
        int p = 0;
        for (int i = 1; i < 9; i++) {
            if (exps[i].compareTo(exps[p]) > 0) p =i;
        }*/
        Arrays.sort(exps);
        System.out.println(exps[8].exp);

    }
}
class EXP implements Comparable<EXP>{
    double x;
    double y;
    double z;
    int p;
    String exp;
    public EXP(double x, double y, double z, String exp, int p) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.exp = exp;
        this.p = p;
    }
    public int compareTo(EXP exp) {
        double lnx1 = Math.log(x);
        double lnx2 = Math.log(exp.x);
        double cmp;
        int op = 1;
        if (lnx1 * lnx2 > 0) {
            if (lnx1 < 0) {
                op = -1;
                lnx1 = -lnx1;
                lnx2 = -lnx2;
            }
            cmp = (z*Math.log(y)+Math.log(lnx1))-(exp.z*Math.log(exp.y)+Math.log(lnx2));
        } else {
            cmp = lnx1 - lnx2;
        }
        if (op < 0) cmp = -cmp;
        if (cmp == 0) return exp.p - p;
        return cmp > 0 ? 1 : -1;

    }
}