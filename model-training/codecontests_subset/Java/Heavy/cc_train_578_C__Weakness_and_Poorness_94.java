import java.io.*;
import java.util.*;

public class C320C
{
    public static StringTokenizer st;
    public static void nextLine(BufferedReader br) throws IOException
    {
        st = new StringTokenizer(br.readLine());
    }
    
    public static String next()
    {
        return st.nextToken();
    }
    
    public static int nextInt()
    {
        return Integer.parseInt(st.nextToken());
    }
    
    public static long nextLong()
    {
        return Long.parseLong(st.nextToken());
    }
    
    public static double nextDouble()
    {
        return Double.parseDouble(st.nextToken());
    }
    
    static int n;
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nextLine(br);
        n = nextInt();
        long[] a = new long[n];
        long[] ca = new long[n+1];
        nextLine(br);
        for (int i = 0; i < n; i++)
        {
            a[i] = nextInt();
        }
        if (n == 1)
        {
            System.out.println(0);
            return;
        }
        ca[0] = 0;
        for (int i = 0; i < n; i++)
        {
            ca[i+1] = ca[i] + a[i];
        } // so sum from x (incl) to y (excl) = ca[y] - ca[x]
        
        double left = -10000;
        double right = 10000;
        double ans = Long.MAX_VALUE;
        for (int kk = 0; kk < 100; kk++)
        {
            double mid = (left + right) / 2;
            
            double max1 = 0, max2 = 0;
            double min1 = 0, min2 = 0;
            for (int i = 0; i < n; i++)
            {
                max1 = Math.max(0, max1 + a[i] - mid);
                max2 = Math.max(max2, max1);
                min1 = Math.min(0, min1 + a[i] - mid);
                min2 = Math.min(min2, min1);
            }
            
            if (max2 < -min2)
            {
                right = mid;
                ans = Math.min(-min2, ans);
            }
            else
            {
                left = mid;
                ans = Math.min(max2, ans);
            }
        }
        System.out.printf("%.7f", ans);
    }
    
}
