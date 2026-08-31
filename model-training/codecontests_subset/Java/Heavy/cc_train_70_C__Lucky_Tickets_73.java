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
        int maxX = nextInt(), maxY = nextInt(), w = nextInt();
        Fraction[] xf = new Fraction[maxX + 1];
        Fraction[] yf = new Fraction[maxY + 1];
        for(int i = 1; i < xf.length; i++) xf[i] = new Fraction(i, rev(i));
        for(int i = 1; i < yf.length; i++) yf[i] = new Fraction(rev(i), i);

        HashMap<Fraction, Integer> mapX = new HashMap<Fraction, Integer>();
        HashMap<Fraction, Integer> mapY = new HashMap<Fraction, Integer>();

        long res = 1L << 50;
        int resX = -1, resY = -1;
        for(int i = 1; i <= maxX; i++)
            if(mapX.containsKey(xf[i])) mapX.put(xf[i], mapX.get(xf[i]) + 1);
            else mapX.put(xf[i], 1);

        //for(Map.Entry<Fraction, Integer> e : mapX.entrySet()) print(e.getKey() + " " + e.getValue());

        int curW = 0, y = 0;
        for(int x = maxX; x >= 1; x--)
        {
            while(y < maxY && curW < w)
            {
                y++;
                if(mapY.containsKey(yf[y])) mapY.put(yf[y], mapY.get(yf[y]) + 1);
                else mapY.put(yf[y], 1);

                if(mapX.containsKey(yf[y])) curW += mapX.get(yf[y]);
            }

            if(curW < w) break;

            if((long)x * y < res)
            {
                res = (long)x * y;
                resX = x;
                resY = y;
            }

            mapX.put(xf[x], mapX.get(xf[x]) - 1);
            if(mapY.containsKey(xf[x])) curW -= mapY.get(xf[x]);
        }

        if(resX == -1) out.println(-1);
        else out.println(resX + " " + resY);
    }

    class Fraction
    {
        int a, b;

        Fraction(int a, int b)
        {
            int g = gcd(a, b);
            a /= g;
            b /= g;
            this.a = a;
            this.b = b;
        }
        int gcd(int a, int b)
        {
            return b == 0 ? a : gcd(b, a % b);
        }
        public boolean equals(Object o)
        {
            Fraction f = (Fraction)o;
            return a == f.a && b == f.b;
        }
        public int hashCode()
        {
            return a * 3137 + b;
        }

        public String toString()
        {
            return a + "/" + b;
        }
    }
    int rev(int n)
    {
        int pow = 1;
        while(pow <= n) pow *= 10;
        int res = 0;
        while(n > 0)
        {
            pow /= 10;
            res += pow * (n % 10);
            n /= 10;
        }
        return res;
    }

    String next() throws IOException
    {
        while(tokenizer == null || !tokenizer.hasMoreTokens()) tokenizer = new StringTokenizer(input.readLine());
        return tokenizer.nextToken();
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

    BufferedReader input;
    PrintWriter out;
    StringTokenizer tokenizer;

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
