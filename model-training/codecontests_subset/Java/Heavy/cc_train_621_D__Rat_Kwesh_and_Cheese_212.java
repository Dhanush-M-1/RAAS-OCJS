import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class C341D
{

private static StringTokenizer st;
    
    public static void nextLine(BufferedReader br) throws IOException
    {
        st = new StringTokenizer(br.readLine());
    }
    
    public static int nextInt()
    {
        return Integer.parseInt(st.nextToken());
    }
    
    public static String next()
    {
        return st.nextToken();
    }
    
    public static long nextLong()
    {
        return Long.parseLong(st.nextToken());
    }

    public static double nextDouble()
    {
        return Double.parseDouble(st.nextToken());
    }
    
    static String[] expressions = {
        "x^y^z", "x^z^y", "(x^y)^z", "(x^z)^y",
        "y^x^z", "y^z^x", "(y^x)^z", "(y^z)^x",
        "z^x^y", "z^y^x", "(z^x)^y", "(z^y)^x"
    };
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nextLine(br);
        double x = nextDouble();
        double y = nextDouble();
        double z = nextDouble();
        int count = 0;
        if (x > 1) count++;
        if (y > 1) count++;
        if (z > 1) count++;
        double[][] val = new double[12][];
        double[] a = new double[12];
        double[] b = new double[12];
        val[0] = new double[] {x, y, z};
        val[1] = new double[] {x, z, y};
        val[2] = new double[] {x, y, z};
        val[3] = new double[] {x, z, y};
        val[4] = new double[] {y, x, z};
        val[5] = new double[] {y, z, x};
        val[6] = new double[] {y, x, z};
        val[7] = new double[] {y, z, x};
        val[8] = new double[] {z, x, y};
        val[9] = new double[] {z, y, x};
        val[10] = new double[] {z, x, y};
        val[11] = new double[] {z, y, x};
        
        
        if (count == 3)
        {
            for (int i = 0; i < 12; i++)
            {
                if (i % 4 > 1)
                {
                    a[i] = dblLog2(val[i][0], val[i][1], val[i][2]);
                }
                else
                {
                    a[i] = dblLog(val[i][0], val[i][1], val[i][2]);
                }
            }
            int max = 0;
            for (int i = 1; i < 12; i++)
            {
                if (a[i] > a[max])
                {
                    max = i;
                }
            }
            max = correct(max);
            System.out.println(expressions[max]);
            return;
        }
        else if (count == 2)
        {
            for (int i = 0; i < 12; i++)
            {
                if (val[i][0] <= 1)
                {
                    a[i] = -1;
                    continue;
                }
                if (i % 4 > 1)
                {
                    a[i] = log2(val[i][0], val[i][1], val[i][2]);
                }
                else
                {
                    a[i] = log(val[i][0], val[i][1], val[i][2]);
                }
            }
            int max = 0;
            for (int i = 1; i < 12; i++)
            {
                if (a[i] > a[max])
                {
                    max = i;
                }
            }
            max = correct(max);
            System.out.println(expressions[max]);
            return;
        }
        else
        {
            for (int i = 0; i < 12; i++)
            {
                if (i % 4 > 1)
                {
                    a[i] = pow2(val[i][0], val[i][1], val[i][2]);
                }
                else
                {
                    a[i] = pow(val[i][0], val[i][1], val[i][2]);
                }
            }
            int max = 0;
            for (int i = 1; i < 12; i++)
            {
                if (a[i] > a[max])
                {
                    max = i;
                }
            }
            max = correct(max);
            System.out.println(expressions[max]);
            return;
        }
    }
    
    static int correct(int val)
    {
        if (val == 3 || val == 7 || val == 11)
        {
            return val - 1;
        }
        return val;
    }
    
    static double log(double a, double b, double c)
    {
        return Math.pow(b, c) * Math.log(a);
    }
    
    static double log2(double a, double b, double c)
    {
        return b * c * Math.log(a);
    }
    
    static double dblLog(double a, double b, double c)
    {
        return c * Math.log(b) + Math.log(Math.log(a));
    }
    
    static double dblLog2(double a, double b, double c)
    {
        return Math.log(c) + Math.log(b) + Math.log(Math.log(a));
    }
    
    static double pow(double a, double b, double c)
    {
        return Math.pow(a, Math.pow(b, c));
    }
    
    static double pow2(double a, double b, double c)
    {
        return Math.pow(Math.pow(a, b), c);
    }

}