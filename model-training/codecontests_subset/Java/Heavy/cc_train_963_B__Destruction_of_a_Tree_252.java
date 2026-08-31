import java.util.*;
import java.io.*;
public class MainClass
{
    static int n;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] size;
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException
    {
        Reader in = new Reader();
        n = in.nextInt();
        adj = new ArrayList[n];
        visited = new boolean[n];
        size = new int[n];
        for (int i=0;i<n;i++)   adj[i] = new ArrayList<>();
        for (int i=0;i<n;i++)
        {
            int x = in.nextInt() - 1;
            if (x == -1)    continue;
            adj[x].add(i);
            adj[i].add(x);
        }
        if (n % 2 == 0) System.out.println("NO");
        else
        {
            explore(0);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("YES\n");
            Arrays.fill(visited, false);
            recur(0);
            for (int i: ans)
                stringBuilder.append(i + 1).append("\n");
            System.out.println(stringBuilder);
        }
    }
    public static void recur(int v)
    {
        visited[v] = true;
        for (int u: adj[v]) if (!visited[u] && size[u] % 2 == 0)
            recur(u);
        ans.add(v);
        for (int u: adj[v]) if (!visited[u] && size[u] % 2 == 1)
            recur(u);
    }
    public static void explore(int v)
    {
        visited[v] = true;
        size[v]++;
        for (int u: adj[v]) if (!visited[u])
        {
            explore(u);
            size[v] += size[u];
        }
    }
}
class Reader
{
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader()
    {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException
    {
        din = new DataInputStream(new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException
    {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1)
        {
            if (c == '\n')
                break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException
    {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do
        {
            ret = ret * 10 + c - '0';
        }  while ((c = read()) >= '0' && c <= '9');

        if (neg)
            return -ret;
        return ret;
    }

    public long nextLong() throws IOException
    {
        long ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }

    public double nextDouble() throws IOException
    {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();

        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');

        if (c == '.')
        {
            while ((c = read()) >= '0' && c <= '9')
            {
                ret += (c - '0') / (div *= 10);
            }
        }

        if (neg)
            return -ret;
        return ret;
    }

    private void fillBuffer() throws IOException
    {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException
    {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException
    {
        if (din == null)
            return;
        din.close();
    }
}