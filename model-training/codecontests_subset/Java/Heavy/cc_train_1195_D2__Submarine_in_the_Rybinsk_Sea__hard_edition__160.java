import java.util.*;
import java.io.*;
import static java.lang.Math.*;
import java.math.BigInteger;
public class Main
{
    static MyScanner scan;
    static PrintWriter pw;
    static long MOD = 998244353;
    static long INF = 1_000_000_000_000_000_000L;
    static long inf = 2_000_000_000;
    public static void main(String[] args) {
        new Thread(null,null,"BaZ",1<<25)
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
        //initIo(true);
        initIo(false);
        StringBuilder sb = new StringBuilder();
        int n = ni();
        int arr[] = new int[n];
        int freq[] = new int[11];
        for(int i=0;i<n;++i) {
            arr[i] = ni();
            ++freq[Integer.toString(arr[i]).length()];
        }
        long ten[] = new long[21];
        for(int i=0;i<=20;++i) {
            if(i==0) {
                ten[i] = 1;
            }
            else {
                ten[i] = (10*ten[i-1])%MOD;
            }
        }
//        pa("freq", freq);
//        pa("ten", ten);
        long ans = 0;
        for(int i=0;i<n;++i) {
            for(int len=1;len<=10;++len) {
                if(freq[len]==0) {
                    continue;
                }
                long iska = 0;
                int rem_len = len, pos = 0, curr = 0;
                long temp = arr[i];
                while(temp>0) {
                    if(curr==1 && rem_len>0) {
                        rem_len--;
                    }
                    else {
                        iska+=(freq[len] * ((temp%10)*ten[pos])%MOD);
                        iska%=MOD;
                        temp/=10;
                    }
                    curr^=1;
                    pos++;
                }
                ans = (ans + iska)%MOD;
            }
        }
        for(int i=0;i<n;++i) {
            for(int len=1;len<=10;++len) {
                if(freq[len]==0) {
                    continue;
                }
                long iska = 0;
                int rem_len = len, pos = 0, curr = 1;
                long temp = arr[i];
                while(temp>0) {
                    if(curr==1 && rem_len>0) {
                        rem_len--;
                    }
                    else {
                        iska+=(freq[len] * ((temp%10)*ten[pos])%MOD);
                        iska%=MOD;
                        temp/=10;
                    }
                    curr^=1;
                    pos++;
                }
                ans = (ans + iska)%MOD;
            }
        }
        pl(ans);
        pw.flush();
        pw.close();
    }
    static void initIo(boolean isFileIO) throws IOException {
        scan = new MyScanner(isFileIO);
        if(isFileIO) {
            pw = new PrintWriter("/Users/amandeep/Desktop/output.txt");
        }
        else {
            pw = new PrintWriter(System.out, true);
        }
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
    static void pa(String arrayName, Object arr[])
    {
        pl(arrayName+" : ");
        for(Object o : arr)
            p(o);
        pl();
    }
    static void pa(String arrayName, int arr[])
    {
        pl(arrayName+" : ");
        for(int o : arr)
            p(o);
        pl();
    }
    static void pa(String arrayName, long arr[])
    {
        pl(arrayName+" : ");
        for(long o : arr)
            p(o);
        pl();
    }
    static void pa(String arrayName, double arr[])
    {
        pl(arrayName+" : ");
        for(double o : arr)
            p(o);
        pl();
    }
    static void pa(String arrayName, char arr[])
    {
        pl(arrayName+" : ");
        for(char o : arr)
            p(o);
        pl();
    }
    static void pa(String listName, List list)
    {
        pl(listName+" : ");
        for(Object o : list)
            p(o);
        pl();
    }
    static void pa(String arrayName, Object[][] arr) {
        pl(arrayName+" : ");
        for(int i=0;i<arr.length;++i) {
            for(Object o : arr[i])
                p(o);
            pl();
        }
    }
    static void pa(String arrayName, int[][] arr) {
        pl(arrayName+" : ");
        for(int i=0;i<arr.length;++i) {
            for(int o : arr[i])
                p(o);
            pl();
        }
    }
    static void pa(String arrayName, long[][] arr) {
        pl(arrayName+" : ");
        for(int i=0;i<arr.length;++i) {
            for(long o : arr[i])
                p(o);
            pl();
        }
    }
    static void pa(String arrayName, char[][] arr) {
        pl(arrayName+" : ");
        for(int i=0;i<arr.length;++i) {
            for(char o : arr[i])
                p(o);
            pl();
        }
    }
    static void pa(String arrayName, double[][] arr) {
        pl(arrayName+" : ");
        for(int i=0;i<arr.length;++i) {
            for(double o : arr[i])
                p(o);
            pl();
        }
    }
    static class MyScanner
    {
        BufferedReader br;
        StringTokenizer st;
        MyScanner(boolean readingFromFile) throws IOException
        {
            if(readingFromFile) {
                br = new BufferedReader(new FileReader("/Users/amandeep/Desktop/input.txt"));
            }
            else {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
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