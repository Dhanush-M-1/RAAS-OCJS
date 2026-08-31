import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static class Node
    {
        int i;
        int j;
        long val;
        public Node(int i, int j, long val)
        {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
    static HashSet<Point> vis, valid;
    static int p, q;
    static void zap() throws IOException {
        int x, y;
        x = nextInt() - 1;
        y = nextInt() - 1;
        p = nextInt() - 1;
        q = nextInt() - 1;
        int n = nextInt();
        vis = new HashSet<Point>();
        valid = new HashSet<Point>();
        for(int i=0;i<n;i++)
        {
            int r = nextInt() - 1;
            int a = nextInt() - 1;
            int b = nextInt() - 1;
            for(int j=a;j<=b;j++)
                valid.add(new Point(r,j));
        }
        out.println(bfs(new Node(x,y,0)));
    }
    static long bfs(Node O)
    {
        int[][] dir = {{1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}};
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(O);
        vis.add(new Point(O.i, O.j));
        while(!queue.isEmpty())
        {
            Node head = queue.poll();
            if(head.i == p && head.j == q)
                return head.val;
            for(int[] c : dir)
            {
                int new_i = head.i + c[0];
                int new_j = head.j + c[1];
                Point temp = new Point(new_i, new_j);
                if(!vis.contains(temp) && within(new_i, new_j) && valid.contains(temp))
                {
                    queue.add(new Node(new_i, new_j, head.val + 1));
                    vis.add(new Point(new_i, new_j));
                }
            }
        }
        return -1;
    }
    static boolean within(int i, int j)
    {
        if(i >=0 && i < 1000000000 && j >=0 && j< 1000000000)
            return true;
        return false;
    }

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args) throws IOException {
        InputStream input = System.in;
        br = new BufferedReader(new InputStreamReader(input));
        out = new PrintWriter(System.out);
        zap();
        out.close();
    }

    static long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    static String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                return null;
            }
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }
}