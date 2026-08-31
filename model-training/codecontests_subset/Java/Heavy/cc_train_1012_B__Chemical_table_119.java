import java.util.*;
import java.io.*;
import static java.lang.Math.*;
public class Main
{  
    static MyScanner scan;
    static PrintWriter pw;
    static int baap[],weight[];
    public static void main(String[] args) {
        new Thread(null,null,"_",1<<25)
        {
           public void run()
           {
               try
               {
                   solve();
               }
               catch(Exception e)
               {  
                   e.printStackTrace();
                   System.exit(1);
               }
           }
        }.start();
    }
    static void solve() throws IOException
    {
        scan = new MyScanner();
        pw = new PrintWriter(System.out,true);
        StringBuilder sb = new StringBuilder();
        int n = ni();
        int m = ni();
        init(n+m);
        int a = ni();
        int ans = n+m;
        while(a-->0)
        {
            if(un(ni(),n+ni()))
                --ans;
        }
        pl(--ans);
        pw.flush();
        pw.close();
    }
    static void init(int n)
    {
        baap = new int[n+1];
        weight = new int[n+1];
        for(int i=0;i<=n;++i)
        {
            baap[i] = i;
            ++weight[i];
        }
    }
    static int gr(int a)
    {
        if(baap[a]==a)
            return a;
        return baap[a] = gr(baap[a]);
    }
    static boolean un(int a,int b)
    {
        int ra = gr(a);
        int rb = gr(b);
        if(ra==rb)
            return false;
        if(weight[rb]>weight[ra])
        {
            weight[rb]+=weight[ra];
            baap[ra] = rb;
        }
        else
        {
            weight[ra]+=weight[rb];
            baap[rb] = ra;
        }
        return true;
    }
    static int ni() throws IOException
    {
        return scan.nextInt();
    }
    static long nl() throws IOException
    {
        return scan.nextLong();
    }
    static double nd() throws IOException
    {
        return scan.nextDouble();
    }
    static String ne() throws IOException
    {
        return scan.next();
    }
    static String nel() throws IOException
    {
        return scan.nextLine();
    }
    static void pl()
    {
        pw.println();
    }
    static void p(Object o)
    {
        pw.print(o+" ");
    }
    static void pl(Object o)
    {
        pw.println(o);
    }
    static void psb(StringBuilder sb)
    {
        pw.print(sb);
    }
    static class MyScanner
    {
        BufferedReader br;
        StringTokenizer st;
        MyScanner()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String nextLine()throws IOException
        {
            return br.readLine();
        }
        String next() throws IOException
        {
            if(st==null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
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
    }
}