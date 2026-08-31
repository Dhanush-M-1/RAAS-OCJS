//
import java.math.*;
import java.util.*;
import java.io.*;
  
public class Main { 
  
    static BufferedReader in;
    static PrintWriter out = new PrintWriter(System.out);
    static String file = "../in";
    static int test = 10; // 0 for local testing, 1 for std input
    static int inf = 1_000_000, mod = 1_000_000_007;

    void swap(int[]ary, int i, int j)
    {
        int t = ary[i];
        ary[i] = ary[j];
        ary[j] = t;
    }
    
    String[] split() throws Exception
    {
        return in.readLine().split(" ");
    }

    int readInt() throws Exception
    {
        return Integer.valueOf(in.readLine());
    }

    long[] toLongArray() throws Exception
    {
        String[] sp = split();
        int n = sp.length;
        long[] ary = new long[n];
        for(int i = 0; i < n; i++) ary[i] = Long.valueOf(sp[i]);
        return ary;
    }

    int[] toIntArray() throws Exception
    {
        String[] sp = split();
        int n = sp.length;
        int[] ary = new int[n];
        for(int i = 0; i < n; i++) ary[i] = Integer.valueOf(sp[i]);
        return ary;
    }

    String reverse(String str)
    {
        return new StringBuilder(str).reverse().toString();
    }


    long pow(long a, int pow)
    {
        long res = 1;
        while(pow > 0)
        {
            if(pow % 2 != 0) {
                res *= a;
                res %= mod;
            }
            a = a * a;
            a %= mod;
            pow /= 2;
        }

        return res;
    }

    public static void main(String[] args) throws Exception
    {
        int _k = Integer.valueOf("1");
        if(test > 0) in = new BufferedReader(new InputStreamReader(System.in));
        else in = new BufferedReader(new FileReader(file));
        if(test < 0) {String[] str = in.readLine().split(" ");}
/***********************************************************************/
/***********************************************************************/
/***********************************************************************/
/***********************************************************************/
        // System.out.println((-100 + 0) / 2);

        new Main().d();
        out.flush();
    }

    void d() throws Exception
    {
        int n = readInt();
        Queue<String> q = new LinkedList<>();
        q.offer("");
        char[] cs = {'a','b','c','d','e','f','g','h','i','j'};
        for(int i = 0; i < n; i++)
        {
            Queue<String> q2 = new LinkedList<>();
            while(!q.isEmpty())
            {
                String cur = q.poll();
                for(char c = 'a'; c <= cs[i]; c++)
                {
                    if(c > 'a' && cur.indexOf(c - 1) < 0) continue;
                    q2.offer(cur + String.valueOf(c));
                }
            }
            q = q2;
        }
        for(String str : q) out.println(str);
    }

    void c() throws Exception
    {
        long[] ary = toLongArray();
        long a = ary[0], b = ary[1], c = ary[2];

        long left = a * b;
        long right = (c - a - b);
        if(right < 0)
        {
            out.println("No");
            return;
        }

        right = right * right;
        for(int i = 0; i < 4; i++) right -= left;
        
        if(right > 0) out.println("Yes");
        else out.println("No");
    }
    
    void b() throws Exception
    {
        long[] ary = toLongArray();
        long h = ary[0], w = ary[1];
        if(h == 1 || w == 1)
        {
            out.println("1");
            return;
        }
        long ans = 0;
        // 0 2 4 6 ..
        //  1 3 5 7..
        ans += (h / 2) * w;
        if(h % 2 != 0) ans += (w + 1) / 2;
        out.println(ans);
    }

    void a() throws Exception
    {
        int[] ary = {1, 1, 1, 2, 1, 2, 1, 5, 2, 2, 1, 5, 1, 2, 1, 14, 1, 5, 1, 5, 2, 2, 1, 15, 2, 2, 5, 4, 1, 4, 1, 51};
        int k = readInt();
        out.println(ary[k - 1]);
    }

}