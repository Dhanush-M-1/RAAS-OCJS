import java.io.*;
import java.util.*;

public class MainClass
{
    static int n = 0;
    static int m = 0;
    static Set<Integer>[] adj;
    static boolean[] visited;
    static int h = 0;
    static int[] H;
    static Game[] postOrder;
    static int clock = 0;
    static int UNVISITED = -1;
    static int id = 0;
    static int[] ids;
    static int[] low;
    static boolean[] onStack;
    static Stack<Integer> stack;
    static int sccCount = 0;
    static Set<Integer>[] modAdj;
    static int[] count;
    public static void main(String[] args)throws IOException
    {
        Reader in = new Reader();
        n = in.nextInt();
        m = in.nextInt();
        h = in.nextInt();
        adj = new HashSet[n];
        visited = new boolean[n];
        H = new int[n];
        ids = new int[n];
        low = new int[n];
        onStack = new boolean[n];
        stack = new Stack<>();

        for (int i=0;i<n;i++) adj[i] = new HashSet<>();
        for (int i=0;i<n;i++) H[i] = in.nextInt();
        int[] from = new int[m];
        int[] to = new int[m];
        for (int i=0;i<m;i++)
        {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            from[i] = x;    to[i] = y;
            if ((H[x] + 1) % h == H[y]) adj[x].add(y);
            if ((H[y] + 1) % h == H[x]) adj[y].add(x);
        }

        findSccs();
        modAdj = new HashSet[sccCount];
        postOrder = new Game[sccCount];
        count = new int[sccCount];
        for (int i=0;i<sccCount;i++)    modAdj[i] = new HashSet<>();
        for (int i=0;i<m;i++)
        {
            int x = from[i];
            int y = to[i];
            if (low[x] == low[y])continue;
            if ((H[x] + 1) % h == H[y]) modAdj[low[x]].add(low[y]);
            if ((H[y] + 1) % h == H[x])    modAdj[low[y]].add(low[x]);
        }
        for (int i=0;i<n;i++)   count[low[i]]++;
        visited = new boolean[sccCount];
        for (int i=0;i<sccCount;i++)    if (!visited[i])    explore(i);
        Arrays.sort(postOrder);
        long[] dp = new long[sccCount];
        for (int i=sccCount - 1;i>=0;i--)
        {
            int v = postOrder[i].v;
            dp[v] += postOrder[i].size;
            for (int u: modAdj[v])  dp[v] += dp[u];
        }
        long min = Long.MAX_VALUE;
        int idx = -1;
        for (int i=0;i<sccCount;i++)
        {
            if (dp[i] < min)
            {
                min = dp[i];
                idx = i;
            }
        }
        System.out.println(min);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<n;i++)
        {
            if (low[i] == idx)
            {
                stringBuilder.append(i + 1).append(" ");
            }
        }
        System.out.println(stringBuilder);
    }
    public static void explore(int v)
    {
        visited[v] = true;
        for (int u: modAdj[v]) if (!visited[u]) explore(u);
        postOrder[v] = new Game(v, clock++, count[v]);
    }
    public static void findSccs()
    {
        for (int i=0;i<n;i++)
            ids[i] = UNVISITED;
        for (int i=0;i<n;i++)
        {
            if (ids[i] == UNVISITED)
            {
                dfs(i);
            }
        }
    }
    public static void dfs(int at)
    {
        stack.push(at);
        onStack[at] = true;
        ids[at] = low[at] = id++;

        //Visit all neighbours and min low-link values on callback
        for (int to: adj[at])
        {
            if (ids[to] == UNVISITED)
                dfs(to);
            if (onStack[to])
                low[at] = Math.min(low[at], low[to]);
        }

        //After having visited all the neighbours of 'at'
        //if we're at the start of a SCC empty the seen
        //stack until we're back to the start of the SCC.

        if (ids[at] == low[at])
        {
            for (int node = stack.pop();;node = stack.pop())
            {
                onStack[node] = false;
                low[node] = sccCount;
                if (node == at)
                    break;
            }
            sccCount++;
        }
    }
}
class Game implements Comparable<Game>
{
    int v;
    int time;
    int size;

    public Game(int v, int time, int size)
    {
        this.v = v;
        this.time = time;
        this.size = size;
    }

    @Override
    public int compareTo(Game ob)
    {
        return ob.time - this.time;
    }
}
class Reader
{
    final private int BUFFER_SIZE = 1 << 16;
    private final DataInputStream din;
    private final byte[] buffer;
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