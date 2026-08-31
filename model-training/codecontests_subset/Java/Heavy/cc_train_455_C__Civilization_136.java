import java.util.*;
import java.io.*;



public class Main {
    static OutputWriter out;
    static int[]parent;
    static int[]values;
    static int[]values1;
    static int[]ranks;
    static boolean[]visited;
    static boolean[]visited1;
    static Graph g;
    static int temp;
   static int edge;
    public static void main(String[] args)
    {
        InputReader in = new InputReader(System.in);
        out = new OutputWriter(System.out);
        int n = in.nextInt();
        parent = new int[n];
        values = new int[n];
        values1 = new int[n];
        visited1 = new boolean[n];
        ranks = new int[n];
        g = new Graph(n);
        visited= new boolean[n];
       for (int i =0;i<n;i++)
           parent[i]=i;
       int m =in.nextInt();
       int q = in.nextInt();
       for (int i=0;i<m;i++)
       {
           int x = in.nextInt()-1;
           int y = in.nextInt()-1;
           int p0= getParent(x);
           int p1 = getParent(y);
           g.adjList[x].add(y);
           g.adjList[y].add(x);
           if (p0!=p1)
           {
               if (ranks[p0]>=ranks[p1])
               {
                   ranks[p0]++;
                   parent[p1]=p0;
               }
               else
               {
                   ranks[p1]++;
                   parent[p0]=p1;
               }
           }
       }

       int[]length=new int[n];

       for (int i =0;i<n;i++)
       {
           if (!visited[i])
           {
               temp=0;
               edge =i;
               DFS(i);
temp=0;
               DFS1(edge);
               int p0= getParent(i);
               length[p0]=values1[edge];
           }
       }
       for (int i =0;i<q;i++)
       {
           int c = in.nextInt();
           if (c==1)
           {
               int p0=getParent(in.nextInt()-1);
               out.printLine(length[p0]);
           }
           else
           {
               int x = in.nextInt()-1;
               int y = in.nextInt()-1;
               int p0=getParent(x);
               int p1 = getParent(y);
               int u =0;
               if (ranks[p0]>=ranks[p1])
               {
                   ranks[p0]++;
                   parent[p1]=p0;
                   u=p0;
               }
               else
               {
                   u=p1;
                   ranks[p1]++;
                   parent[p0]=p1;
               }
               if (p1!=p0)
               if (length[p0]>=length[p1])
               {

                   length[u]=Math.max(length[p0],(1+length[p0])/2+(1+length[p1])/2+1);
               }
               else
               {

                   length[u]=Math.max(length[p1],(1+length[p0])/2+(1+length[p1])/2+1);
               }

           }
       }
        out.flush();
    }
    static void DFS1(int v)
    {

        DFSUtil1(v);
    }
    static  void DFSUtil1(int v)
    {
        visited1[v] = true;

        int i=0;
        int size = g.adjList[v].size();

        while (i<size)
        {
            int index = g.adjList[v].get(i);
            if (!visited1[index]) {
                values1[index]=values1[v]+1;
                if (values1[v]+1>temp)
                {
                    temp=values1[v]+1;
                    edge=index;
                }
                DFSUtil1(index);
            }
            i++;

        }
    }
    static void DFS(int v)
    {

        DFSUtil(v);
    }
    static  void DFSUtil(int v)
    {
        visited[v] = true;

        int i=0;
        int size = g.adjList[v].size();

        while (i<size)
        {
            int index = g.adjList[v].get(i);
            if (!visited[index]) {
                values[index]=values[v]+1;
                if (values[v]+1>temp)
                {
                    temp=values[v]+1;
                    edge=index;
                }
                DFSUtil(index);
            }
            i++;

        }
    }
  static int getParent(int i)
  {
      while (i!=parent[i])
          i=parent[i];
      return i;
  }
}
class MyScanner {

    StringTokenizer st;
    BufferedReader br;

    public MyScanner(InputStream s) {
        br = new BufferedReader(new InputStreamReader(s));
    }

    public MyScanner (FileReader f) {
        br = new BufferedReader(f);
    }

    public String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public String nextLine() throws IOException {
        return br.readLine();
    }

    public double nextDouble() throws IOException {
        String x = next();
        StringBuilder sb = new StringBuilder("0");
        double res = 0, f = 1;
        boolean dec = false, neg = false;
        int start = 0;
        if (x.charAt(0) == '-') {
            neg = true;
            start++;
        }
        for (int i = start; i < x.length(); i++)
            if (x.charAt(i) == '.') {
                res = Long.parseLong(sb.toString());
                sb = new StringBuilder("0");
                dec = true;
            } else {
                sb.append(x.charAt(i));
                if (dec)
                    f *= 10;
            }
        res += Long.parseLong(sb.toString()) / f;
        return res * (neg ? -1 : 1);
    }

    public boolean ready() throws IOException {
        return br.ready();
    }

    public boolean nextEmpty() throws IOException {
        String s = nextLine();
        st = new StringTokenizer(s);
        return s.isEmpty();
    }
}


class pair  implements Comparable
{
    int dist;
    int to;
    public pair(int to, int dist)
    {
        this.dist = dist;
        this.to = to;
    }
    @Override
    public int compareTo(Object o) {
        pair temp =(pair)o;
        if (dist<temp.dist)
            return -1;
        else if (dist>temp.dist)
            return 1;
        else
            return 0;
    }
}
class Graph {


    int n;
    ArrayList<Integer>[] adjList;

    public Graph(int n) {
        this.n = n;
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();
    }

}



class InputReader {

    private final InputStream stream;
    private final byte[] buf = new byte[8192];
    private int curChar, snumChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (snumChars == -1)
            throw new InputMismatchException();
        if (curChar >= snumChars) {
            curChar = 0;
            try {
                snumChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (snumChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long nextLong() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public int[] nextIntArray(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        return a;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public String nextLine() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

}

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }


    public void printLine(Object... objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }

    public void flush() {
        writer.flush();
    }

}