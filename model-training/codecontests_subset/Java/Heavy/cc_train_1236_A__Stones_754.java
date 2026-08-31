import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class CF {
    public static int getMax (int x, int y) {
        int ret = 0;
        if (x > y/2) {
            y /= 2; 
            ret += y * 2; 
            ret += y;
        } else { 
            ret += x * 2; 
            ret += x;
        }
        return ret;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int ret = getMax(b, c);
            //System.out.println("first " + ret);
            if (b > c/2) {
                b -= c/2;
            } else {
                b  = 0;
            }
            //System.out.println("b " + b);
            ret += getMax(a, b);
            //System.out.println("final" + ret);
            System.out.println(ret);
        }

    }
}
