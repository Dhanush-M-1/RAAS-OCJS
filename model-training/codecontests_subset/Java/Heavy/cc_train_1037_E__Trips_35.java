/**
 * BaZ :D
 */
import java.util.*;
import java.io.*;
import static java.lang.Math.*;
public class Main
{  
    static Reader scan;
    static PrintWriter pw;
    static HashSet<Integer> good;
    static HashSet<Integer> adj[];
    static int n,m,k,ans[];
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
        scan = new Reader();
        pw = new PrintWriter(System.out,true);
        StringBuilder sb = new StringBuilder();
        n = ni();
        m = ni();
        k = ni();
        good = new HashSet();
        adj = new HashSet[n+1];
        for(int i=1;i<=n;++i)
        {
            good.add(i);
            adj[i] = new HashSet();
        }
        int x[] = new int[m];
        int y[] = new int[m];
        for(int i=0;i<m;++i) {
            int u = ni();
            int v = ni();
            x[i] = u;
            y[i] = v;
            adj[u].add(v);
            adj[v].add(u);
        }
        ans = new int[m];
        ArrayList<Integer> bad = new ArrayList();
        for(int i=1;i<=n;++i) {
            if(adj[i].size()<k) {
                bad.add(i);
            }
        }
        for(int e:bad)
        {  
            if(good.contains(e))
               remove(e);
        }
        ans[m-1] = good.size();
        for(int i=m-2;i>=0;--i) {
            int u = x[i+1];
            int v = y[i+1];
            adj[u].remove(v);
            adj[v].remove(u);
            if(adj[u].size()<k && good.contains(u))
                remove(u);
            if(adj[v].size()<k && good.contains(v))
                remove(v);
            ans[i] = good.size();
        }
        for(int e:ans) {
             sb.append(e);
             sb.append("\n");
        }
        psb(sb);
        pw.flush();
        pw.close();
    }
    static void remove(int x) {
        good.remove(x);
        ArrayList<Integer> bad = new ArrayList();
        for(int e:adj[x]) {
            adj[e].remove(x);
            if(adj[e].size()<k)
                bad.add(e);
        }
        for(int e:bad)
            remove(e);
        adj[x].clear();
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
    static void pa(String listName, List<Object> list) 
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
    static class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException {
        din = new DataInputStream(new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException {
        byte[] buf = new byte[64];
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }

    public long nextLong() throws IOException {
        long ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }

    public double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (c == '.') while ((c = read()) >= '0' && c <= '9') ret += (c - '0') / (div *= 10);
        if (neg) return -ret;
        return ret;
    }

    private void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1) buffer[0] = -1;
    }

    private byte read() throws IOException {
        if (bufferPointer == bytesRead) fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException {
        if (din == null) return;
        din.close();
    }
}
}