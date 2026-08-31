import java.io.*;
import java.util.*;
import java.math.*;

public class Main 
{
    public static void main ( String[] args ) throws IOException
    {
        Scanner in = new Scanner(System.in);
        BufferedReader Reader = new BufferedReader(new InputStreamReader(System.in));
        FastScanner sc = new FastScanner(Reader);
        double A = in.nextDouble(), B = in.nextDouble(), C = in.nextDouble();
        if (A != 0 && B != 0 && C != 0)
        {
            double D = B * B - 4 * A *C;
            if (D > 0)
            {
                double x1 = (-B - Math.sqrt(D)) / (2 * A), x2 = (-B + Math.sqrt(D)) / (2 * A);
                System.out.printf("2\n%.10f\n%.10f", Math.min(x1, x2), Math.max(x1,  x2));
            }
            if (D == 0)
                System.out.printf("1\n%.10f", -B / (2 * A));
            if (D < 0)
                System.out.print(0);
        }
        if (A == 0 && B != 0 && C != 0)
            System.out.printf("1\n%.10f", -C / B);
        if (A != 0 && B == 0 && C != 0)
            if (C <= 0)
                System.out.printf("2\n%.10f %.10f", -Math.sqrt(-C / A), Math.sqrt(-C / A));
            else
                System.out.print(0);
        if (A != 0 && B != 0 && C ==0)
        {
            double x1 = 0, x2 = -B / A;
            System.out.printf("2\n%.10f %.10f", Math.min(x1, x2), Math.max(x1,  x2));
        }
        if (A == 0 && B == 0 && C != 0)
            System.out.print(0);
        if (A == 0 && B != 0 && C == 0 || A != 0 && B ==0 && C == 0)
            System.out.printf("1\n0");
        if (A == 0 && B == 0 && C == 0)
            System.out.print(-1);
        System.out.close();
    }
}

class FastScanner
{
    private BufferedReader Reader;
    private StringTokenizer Tokenizer;
    public FastScanner (BufferedReader Reader)
    {
        this.Reader = Reader;
    }
    public String nextToken() throws IOException
    {
        while (Tokenizer == null || !Tokenizer.hasMoreTokens())
            Tokenizer = new StringTokenizer(Reader.readLine());
        return Tokenizer.nextToken();
    }
    public int nextInt() throws NumberFormatException, IOException
    {
        return Integer.parseInt(nextToken());
    }
    public long nextLong() throws NumberFormatException, IOException
    {
        return Long.parseLong(nextToken());
    }
    public double nextDouble() throws NumberFormatException, IOException
    {
        return Double.parseDouble(nextToken());
    }
}
