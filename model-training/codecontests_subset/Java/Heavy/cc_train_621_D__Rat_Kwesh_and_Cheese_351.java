
import java.util.*;
public class Solutions
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double z = sc.nextDouble();
        String[] s = new String[9];
        double[] v = new double[9];
        for (int i = 0; i <= 8; i++) v[i] = -100000000; 
        s[0] = "x^y^z";
        s[1] = "x^z^y";
        s[2] = "(x^y)^z";
        s[3] = "y^x^z";
        s[4] = "y^z^x";
        s[5] = "(y^x)^z";
        s[6] = "z^x^y";
        s[7] = "z^y^x";
        s[8] = "(z^x)^y";
        if (x > 1 || y > 1 || z > 1)
        {
            if (x > 1)
            {
                v[0] = z * Math.log(y) + Math.log(Math.log(x));
                v[1] = y * Math.log(z) + Math.log(Math.log(x));
                v[2] = Math.log(y*z) + Math.log(Math.log(x));
            }
            if (y > 1)
            {
                v[3] = z * Math.log(x) + Math.log(Math.log(y));
                v[4] = x * Math.log(z) + Math.log(Math.log(y));
                v[5] = Math.log(x*z) + Math.log(Math.log(y));
            }
            if(z > 1)
            {
                v[6] = y * Math.log(x) + Math.log(Math.log(z));
                v[7] = x * Math.log(y) + Math.log(Math.log(z));
                v[8] = Math.log(x*y) + Math.log(Math.log(z));
            }
        }
        else
        {
            v[0] = Math.pow(x,Math.pow(y,z));
            v[1] = Math.pow(x,Math.pow(z,y));;
            v[2] = Math.pow(x,y*z);
            v[3] = Math.pow(y,Math.pow(x,z));
            v[4] = Math.pow(y,Math.pow(z,x));
            v[5] = Math.pow(y,x*z);
            v[6] = Math.pow(z,Math.pow(x,y));
            v[7] = Math.pow(z,Math.pow(y,x));
            v[8] = Math.pow(z,y*x);
        }
        int index; double high = v[0]; int lowindex = 0;
        for (index = 1; index <= 8; index++)
        {
            if ( high < v[index] )
            {
                lowindex = index;
                high = v[index];
            }
        }
        System.out.println(s[lowindex]);
    }
}