import java.util.*;
import java.io.*;
import java.math.*;

public class A {
    public static StreamTokenizer in = new StreamTokenizer(System.in);
    public static boolean bg = true;

    public static void main(String[] args) throws Exception {
        long a = ni(), b = ni(), c = ni();
        long t = a* c;
        long fin = t/b;
        if (t%b!=0) fin++;
        System.out.println(fin-c);
    }

    public static int ni() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public static long nl() throws Exception {
        in.nextToken();
        return (long) in.nval;
    }

    public static double nd() throws Exception {
        in.nextToken();
        return in.nval;
    }

    public static String ns() throws Exception {
        in.nextToken();
        return in.sval;
    }

    public static int[] intl(int n1) throws Exception {
        int[] fin = new int[n1];
        for (int i = 0; i < n1; i++) {
            fin[i] = ni();
        }
        return fin;
    }

    public static long[] longl(int n1) throws Exception {
        long[] fin = new long[n1];
        for (int i = 0; i < n1; i++) {
            fin[i] = nl();
        }
        return fin;
    }

    public static double[] doublel(int n1) throws Exception {
        double[] fin = new double[n1];
        for (int i = 0; i < n1; i++) {
            fin[i] = nd();
        }
        return fin;
    }
}
