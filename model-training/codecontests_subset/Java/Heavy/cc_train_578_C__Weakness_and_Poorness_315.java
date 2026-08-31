import java.util.*;
import java.io.*;
public class C578 {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n =input.nextInt();
    int[] a = new int[n];
    for(int i = 0; i<n; i++) a[i] = input.nextInt();
    double lo = -10000, hi = 10000;
    for(int iter = 0; iter<100; iter++)
    {
        double m1 = (lo+lo+hi)/3, m2 = (lo+hi+hi)/3;
        if(go(a, m1) < go(a, m2)) hi = m2;
        else lo = m1;
    }
    out.println(go(a, (lo+hi)/2));
    out.close();
}
static double go(int[] a, double x)
{
    double res = 0;
    double min = 0, max = 0, sum = 0;
    for(int i =0 ; i<a.length; i++)
    {
        sum += a[i] - x;
        res = Math.max(res, Math.max(max-sum, sum-min));
        min = Math.min(min, sum);
        max = Math.max(max, sum);
    }
    return res;
}
public static class input {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens())
            tokenizer = new StringTokenizer(reader.readLine());
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}
}
