import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Main implements Runnable
{
    boolean multiple = true;

    HashMap<Integer, HashSet<Integer>> graph;
    boolean[] visited;
    boolean found;
    int target;

    void solve() throws Exception
    {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;
        graph = new HashMap<>();

        for (int i = 0; i < n; i++)
            graph.put(i, new HashSet<>());
        for (int i = 0; i < m; i++)
        {
            int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[n];
        visited[a] = true;

        long sideA = 0, sideB = 0;

        for (Integer nA : graph.get(a))
        {
            if (visited[nA])
                continue;
            found = false;
            target = b;
            long temp = dfs(nA);
            if (!found)
                sideA += temp;
        }

        visited = new boolean[n];
        visited[b] = true;

        for (Integer nB : graph.get(b))
        {
            if (visited[nB])
                continue;
            found = false;
            target = a;
            long temp = dfs(nB);
            if (!found)
                sideB += temp;
        }

        System.out.println(sideA * sideB);
    }

    long dfs(int v)
    {
        if (v == target)
            found = true;
        long ans = 1;
        visited[v] = true;
        for (Integer n : graph.get(v))
            if (!visited[n])
                ans += dfs(n);
        return ans;
    }

    long inv(long a, long b)
    {
        return 1 < a ? b - inv(b % a, a) * b / a : 1;
    }

    long gcd(long a, long b)
    {
        return a == 0 ? b : gcd(b % a, a);
    }

    class Node// implements Comparable<Node>
    {
        char val;
        long hard;
        Node(char V, long H)
        {
            val = V;
            hard = H;
        }

//        @Override
//        public int compareTo(Node o)
//        {
//            return t - o.t;
//        }
    }

    void print(Object[] arr)
    {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    @Override
    public void run()
    {
        try
        {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            sc = new FastScanner(in);
            if (multiple)
            {
                int q = sc.nextInt();
                for (int i = 0; i < q; i++)
                    solve();
            }
            else
                solve();
        }
        catch (Throwable uncaught)
        {
            Main.uncaught = uncaught;
        }
        finally
        {
            out.close();
        }
    }

    public static void main(String[] args) throws Throwable
    {
        Thread thread = new Thread(null, new Main(), "", (1 << 26));
        thread.start();
        thread.join();
        if (Main.uncaught != null) {
            throw Main.uncaught;
        }
    }

    static Throwable uncaught; BufferedReader in; FastScanner sc; PrintWriter out;
}

class FastScanner
{
    BufferedReader in;
    StringTokenizer st;

    public FastScanner(BufferedReader in)
    {
        this.in = in;
    }

    public String nextToken() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }
}