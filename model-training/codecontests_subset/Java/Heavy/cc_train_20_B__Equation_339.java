/**
 * Created by ankeet on 7/5/16.
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class B20 {

    public static BufferedReader read = null;
    public static PrintWriter out = null;
    public static StringTokenizer token = null;


    public static void solve()
    {
        long a = nlong(), b = nlong(), c = nlong();

        if(a==0 && b == 0 && c == 0)
        {
            out.println(-1);
        }
        else if(a == 0 )
        {
            if(b == 0 && c != 0)
            {
                out.println(0);
            }
            else
            {
                out.println(1);
                out.printf("%.5f", (-1.0*c)/b);
            }
        }
        else
        {
            if(b*b-4*a*c < 0)
            {
                out.println(0);
            }
            else if(b*b-4*a*c == 0)
            {
                out.println(1);
                out.printf("%.5f", (-1.0*b)/(2.0*a));
            }
            else
            {
                out.println(2);
                double r1 = (-b+Math.sqrt(b*b-4*a*c))/(2.0*a);
                double r2 = (-b-Math.sqrt(b*b-4*a*c))/(2.0*a);
                if(r1 > r2) out.printf("%.5f\n%.5f", r2,r1);
                else out.printf("%.5f\n%.5f", r1,r2);
            }
        }

    }

    public static void main(String[] args)
    {
        read = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.flush();
        out.close();

    }

    // i/o functions
    public static String next() // returns the next string
    {
        while(token == null || !token.hasMoreTokens())
        {
            try {
                token = new StringTokenizer(read.readLine());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return token.nextToken();
    }

    public static int nint()
    {
        return Integer.parseInt(next());
    }
    public static long nlong()
    {
        return Long.parseLong(next());
    }
    public static double ndouble()
    {
        return Double.parseDouble(next());
    }
    public static int[] narr(int n)
    {
        int[] a = new int[n];
        for(int i=0; i<n; i++) a[i] = nint();
        return a;
    }

    public static long[] nal(int n)
    {
        long[] a = new long[n];
        for(int i=0; i<n; i++) a[i] = nlong();
        return a;
    }


}



