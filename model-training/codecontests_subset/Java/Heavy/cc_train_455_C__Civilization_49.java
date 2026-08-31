import java.io.*;
import java.util.*;

public class MainClass
{
    static ArrayList<Integer> B = new ArrayList<>();
    static int start = -1;
    static int ll = -1;
    public static void main(String[] args)throws IOException
    {
        Reader in = new Reader();
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        DSU dsu = new DSU(n);
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i=0;i<n;i++)   adj[i] = new ArrayList<>();
        for (int i=0;i<m;i++)
        {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            adj[x].add(y);
            adj[y].add(x);
        }
        for (int i=0;i<n;i++)   dsu.makeSet(i);
        boolean[] visited = new boolean[n];
        for (int i=0;i<n;i++)
        {
            if (!visited[i])
            {
                start = ll = -1;
                B.clear();
                explore(adj, i, visited, 1, 1);
                B.clear();
                explore(adj, start, visited, 1, 0);
                int diameter = ll;
                for (int j=0;j<B.size();j++)
                {
                    if (B.get(j) != i)
                    {
                        dsu.parent[B.get(j)] = i;
                    }
                }
                dsu.ans[i] = diameter - 1;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (q-- > 0)
        {
            int type = in.nextInt();
            if (type == 1)
            {
                int x = in.nextInt() - 1;
                int pp = dsu.findSet(x);
                stringBuilder.append(dsu.ans[pp]).append("\n");
            }
            else
            {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                dsu.unionSets(x, y);
            }
        }
        System.out.println(stringBuilder);
    }
    public static void explore(ArrayList<Integer>[] adj, int v, boolean[] visited, int count, int flag)
    {
        visited[v] = true;
        B.add(v);
        if (count > ll)
        {
            ll = count;
            start = v;
        }
        for (int u: adj[v])
        {
            if (!visited[u])
                explore(adj, u, visited, count + 1, flag);
        }
        if (flag == 1)
            visited[v] = false;
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
class DSU
{
    int[] parent;
    int[] size;
    int[] ans;
    DSU(int n)
    {
        this.parent = new int[n];
        this.size = new int[n];
        this.ans = new int[n];
        Arrays.fill(parent, -1);
    }

    public void makeSet(int v)
    {
        parent[v] = v;
        size[v] = 1;
    }

    public int findSet(int v)
    {
        if (v == parent[v]) return v;
        return parent[v] = findSet(parent[v]);
    }

    public void unionSets(int a, int b)
    {
        a = findSet(a);
        b = findSet(b);
        if (a != b)
        {
            if (size[a] < size[b])
            {
                int temp = a;
                a = b;
                b = temp;
            }
            parent[b] = a;
            size[a] += size[b];
            int x = Math.max(ans[a], ans[b]);
            ans[a] = Math.max(x, (ans[a] + 1) / 2 + (ans[b] + 1) / 2 + 1);
        }
    }
}


