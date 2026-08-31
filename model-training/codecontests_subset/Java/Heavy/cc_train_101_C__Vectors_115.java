import static java.util.Arrays.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class C implements Runnable
{
    String file = "input";
    
    boolean TEST = false;
    
    void solve() throws IOException
    {
        long xa = nextInt(), ya = nextInt(),
        xb = nextInt(), yb = nextInt(),
        xc = nextInt(), yc = nextInt();
        
        boolean ok = false;
        ok |= canSolve(xc, -yc, xb - xa, yc, xc, yb - ya);
        ok |= canSolve(xc, -yc, xb + ya, yc, xc, yb - xa);
        ok |= canSolve(xc, -yc, xb + xa, yc, xc, yb + ya);
        ok |= canSolve(xc, -yc, xb - ya, yc, xc, yb + xa);
        if(ok) out.println("YES");
        else out.println("NO");
    }
    
    boolean canSolve(long a1, long b1, long c1, long a2, long b2, long c2)
    {
        if(a1 == 0 && b1 == 0 && c1 != 0) return false;
        if(a2 == 0 && b2 == 0 && c2 != 0) return false;
        if(a1 == 0)
        {
            if(b1 == 0) return c1 == 0;
            if(c1 % b1 != 0) return false;
            long y = c1 / b1;
            long ly = c2 - b2 * y;
            if(a2 == 0) return ly == 0;
            if(ly % a2 != 0) return false;
            return true;
        }
        if(a2 == 0)
        {
            if(b2 == 0) return c2 == 0;
            if(c2 % b2 != 0) return false;
            long y = c2 / b2;
            long ly = c1 - b1 * y;
            if(a1 == 0) return ly == 0;
            if(ly % a1 != 0) return false;
            return true;
        }
        
        long det = a2 * b1 - a1 * b2;
        long fy = c1 * a2 - c2 * a1;
        long fx = c1 * b2 - c2 * b1;
        
        //print(a1, b1, c1, a2, b2, c2, det, fy, fx);
        
        if(det == 0) 
        {
            if(fy != 0 || fx != 0) return false;
            return true;    
        }
        
        if(fy % det != 0) return false;
        if(fx % det != 0) return false;
        
        return true;
    }
    
    String next() throws IOException
    {
        while(st == null || !st.hasMoreTokens()) st = new StringTokenizer(input.readLine());
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
    
    void init() throws IOException
    {
        if(TEST) input = new BufferedReader(new FileReader(file + ".in")); 
        else input = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));
    }
    
    public static void main(String[] args) throws IOException
    {
        new Thread(null, new C(), "", 1 << 20).start();
    }
    
    public void run()
    {
        try
        {
            init();
            if(TEST) 
            {
                int runs = nextInt();
                for(int i = 0; i < runs; i++) solve();
            }
            else solve();
            out.close();        
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }
}