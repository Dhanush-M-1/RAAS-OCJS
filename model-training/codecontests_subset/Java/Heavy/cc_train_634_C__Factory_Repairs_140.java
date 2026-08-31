import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.io.*;
import java.util.*;

public class EightVCFinalsD
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
    
    static long[] tree1, tree2;
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nextLine(br);
        int n = nextInt();
        int k = nextInt();
        long a = nextInt();
        long b = nextInt();
        int q = nextInt();
        tree1 = new long[n*4];
        tree2 = new long[n*4];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < q; i++)
        {
            nextLine(br);
            int op = nextInt();
            if (op == 1)
            {
                int day = nextInt();
                long orders = nextLong();
                long exist = val(tree2, day);
                if (exist < b)
                {
                    add(tree1, day, Math.min(b - exist, orders));
                }
                if (exist < a)
                {
                    add(tree2, day, Math.min(a - exist, orders));
                }
            }
            else
            {
                int day = nextInt();
                long before = sum(tree1, day - 1);
                long after = sum(tree2, n) - sum(tree2, day + k - 1);
                long ans = before + after;
                sb.append(ans + "\n");
            }
        }
        System.out.println(sb.toString());
    }
    
    static long sum(long[] tree, int i) 
    {
        long sum = 0;
        while(i > 0) 
        {
            sum += tree[i];
            i -= i & -i;
        }
            
        return sum;
    }
     
    static void add(long[] tree, int i, long k) 
    {
        while (i < tree.length)
        {
            tree[i] += k;
            i += i & -i;
        }
    }
    
    static long val(long[] tree, int i)
    {
        return sum(tree, i) - sum(tree, i-1);
    }
}