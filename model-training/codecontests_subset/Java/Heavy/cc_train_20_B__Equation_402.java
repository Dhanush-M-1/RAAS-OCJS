import static java.util.Arrays.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class B implements Runnable
{
    String file = "input";
    
    void init() throws IOException
    {
        //input = new BufferedReader(new FileReader(file + ".in"));
        input = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedWriter(new FileWriter(file + ".out")));
    }
    double EPS = 1e-9;
    void solve() throws IOException
    {
        long A = nextInt(), B = nextInt(), C = nextInt();
        if(A == 0)
        {
            if(B == 0)
            {
                if(C == 0) System.out.println(-1);
                else System.out.println(0);
            }
            else
            {
                System.out.println(1);
                System.out.printf("%.5f", -1. * C / B);
            }
        }
        else
        {
            long delta = B * B - 4 * A * C;
            if(delta >= 0)
            {
                if(delta == 0)
                {
                    double x = - B / 2. / A;
                    System.out.println(1);
                    System.out.printf("%.5f", x);
                }
                else
                {
                    double x1 = (- B - sqrt(delta)) / 2. / A;
                    double x2 = (- B + sqrt(delta)) / 2. / A;
                    System.out.println(2);
                    if(A < 0)
                    {
                        double t = x1;
                        x1 = x2;
                        x2 = t;
                    }
                    System.out.printf("%.5f\n%.5f", x1, x2);
                }
            }
            else
                System.out.println(0);
        }
    }
    
    String next() throws IOException
    {
        if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(input.readLine());
        return st.nextToken();
    }
    
    int nextInt() throws IOException
    {
        return Integer.parseInt(next());
    }
    
    long nextLong() throws IOException
    {
        return Long.parseLong(next());
    }
    
    double nextDouble() throws IOException
    {
        return Double.parseDouble(next());
    }
    
    void print(Object... o)
    {
        System.out.println(deepToString(o));
    }
    
    void gcj(Object o)
    {
        String s = String.valueOf(o);
        out.println("Case #" + test + ": " + s);
        System.out.println("Case #" + test + ": " + s);
    }
    
    BufferedReader input;
    PrintWriter out;
    StringTokenizer st;
    int test;
    
    public static void main(String[] args) throws IOException
    {
        new Thread(null, new B(), "", 1 << 20).start();
    }
    
    public void run()
    {
        try
        {
            init();
            solve();
            out.close();        
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }
}