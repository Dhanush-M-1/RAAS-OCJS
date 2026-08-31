
import java.util.*;

public class RatKweshandCheese {

    public static double loge(double x) {
        return Math.log10(x) / Math.log10(Math.E);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        double y = in.nextDouble();
        double z = in.nextDouble();
        double ans[] = new double[12];
        for (int i = 0; i < 12; i++) {
            ans[i] = -1000000000;
        }
        boolean okx = true, oky = true, okz = true, ok;
        if (x <= 1.0) {
            okx = false;
        }
        if (y <= 1.0) {
            oky = false;
        }
        if (z <= 1.0) {
            okz = false;
        }
        ok = okx || oky || okz;
        if (ok) {
            if (okx) {
                ans[0] = z * Math.log(y) + Math.log(Math.log(x));
                ans[1] = y * Math.log(z) + Math.log(Math.log(x));
                ans[2] = Math.log(z) + Math.log(y * Math.log(x));
                ans[3] = ans[2];
            }
            if (oky) {
                ans[4] = z * Math.log(x) + Math.log(Math.log(y));
                ans[5] = x * Math.log(z) + Math.log(Math.log(y));
                ans[6] = Math.log(z) + Math.log(x * Math.log(y));
                ans[7] = ans[6];
            }
            if (okz) {
                ans[8] = y * Math.log(x) + Math.log(Math.log(z));
                ans[9] = x * Math.log(y) + Math.log(Math.log(z));
                ans[10] = Math.log(y) + Math.log(x * Math.log(z));
                ans[11] = ans[10];
            }
            int at = -1;
            double max = -1000000000;
            for (int i = 0; i < 12; i++) {
                //System.out.println(ans[i]);
                if (ans[i] > max && ans[i] != -1000000000) {
                    max = ans[i];
                    at = i;
                }
            }
            String exp;
            switch (at) {
                case 0:
                    exp = "x^y^z";
                    break;
                case 1:
                    exp = "x^z^y";
                    break;
                case 2:
                    exp = "(x^y)^z";
                    break;
                case 3:
                    exp = "(x^z)^y";
                    break;
                case 4:
                    exp = "y^x^z";
                    break;
                case 5:
                    exp = "y^z^x";
                    break;
                case 6:
                    exp = "(y^x)^z";
                    break;
                case 7:
                    exp = "(y^z)^x";
                    break;
                case 8:
                    exp = "z^x^y";
                    break;
                case 9:
                    exp = "z^y^x";
                    break;
                case 10:
                    exp = "(z^x)^y";
                    break;
                case 11:
                    exp = "(z^y)^x";
                    break;
                default:
                    exp = "no ans";
            }
            System.out.println(exp);
        }else{
            ans[0] = Math.pow(x, Math.pow(y, z));
            ans[1] = Math.pow(x, Math.pow(z, y));
            ans[2] = Math.pow(x, y*z);
            ans[3] = Math.pow(x, y*z);
            
            ans[4] = Math.pow(y, Math.pow(x, z));
            ans[5] = Math.pow(y, Math.pow(z, x));
            ans[6] = Math.pow(y, x*z);
            ans[7] = Math.pow(y, x*z);
            
            ans[8] = Math.pow(z, Math.pow(x, y));
            ans[9] = Math.pow(z, Math.pow(y, x));
            ans[10] = Math.pow(z, x*y);
            ans[11] = Math.pow(z, y*x);
            int at = -1;
            double max = -1000000000;
            for (int i = 0; i < 12; i++) {
                //System.out.println(ans[i]);
                if (ans[i] > max) {
                    max = ans[i];
                    at = i;
                }
            }
            String exp;
            switch (at) {
                case 0:
                    exp = "x^y^z";
                    break;
                case 1:
                    exp = "x^z^y";
                    break;
                case 2:
                    exp = "(x^y)^z";
                    break;
                case 3:
                    exp = "(x^z)^y";
                    break;
                case 4:
                    exp = "y^x^z";
                    break;
                case 5:
                    exp = "y^z^x";
                    break;
                case 6:
                    exp = "(y^x)^z";
                    break;
                case 7:
                    exp = "(y^z)^x";
                    break;
                case 8:
                    exp = "z^x^y";
                    break;
                case 9:
                    exp = "z^y^x";
                    break;
                case 10:
                    exp = "(z^x)^y";
                    break;
                case 11:
                    exp = "(z^y)^x";
                    break;
                default:
                    exp = "no ans";
            }
            System.out.println(exp);
        }
    }
}
