import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Main {
    static  OutputWriter out;
    static Graph g;
    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(System.in);
        out = new OutputWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        g = new Graph(n);
        int[]a= new int[n];
        for (int i =0;i<n;i++)
        {
            a[i]=in.nextInt()-1;
        }
        for (int i =0;i<m;i++)
        {
            int x = in.nextInt()-1;
            int y = in.nextInt()-1;
            g.adjList[y].add(x);
        }
        int[]cntr = new int[n];
        for (int item:g.adjList[a[n-1]]
             ) {
            cntr[item]++;
        }
        int ans=0;
        for (int i =n-2;i>=0;i--)
        {
            if (cntr[a[i]]==n-i-ans-1)
            {
                ans++;
            }
            else
            {
                for (int item:g.adjList[a[i]]
                        ) {
                    cntr[item]++;
                }
            }
        }
        out.printLine(ans);
        out.flush();
    }

    static void MergeSort(int[] a, int p, int r)
    {
        if (p < r)
        {
            int q = (r + p) / 2;
            MergeSort(a,   p, q);
            MergeSort(a,   q + 1, r);
            Merge(a,  p, q, r);
        }
    }
    static void Merge(int[] a,int p, int q, int r)
    {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] R = new int[n1 + 1];
        int[] L = new int[n2 + 1];


        for (int i = 0; i < n1; i++)
        {
            R[i] = a[p + i];


        }
        R[n1] = Integer.MAX_VALUE;
        for (int i = 0; i < n2; i++)
        {
            L[i] = a[q + i + 1];


        }
        L[n2] =Integer.MAX_VALUE;
        int n = a.length;
        int j = 0;
        int k = 0;
        for (int i = p; i <= r; i++)
        {
            if (L[j] < R[k])
            {
                a[i] = L[j];


                j++;
            }
            else
            {
                a[i] = R[k];


                k++;
            }
        }
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
class pair  implements Comparable
{

    int key;
    int value;

    public pair(Object key, Object value) {

        this.key = (int)key;
        this.value=(int)value;

    }

    @Override
    public int compareTo(Object o) {
        pair temp =(pair)o;
        return  key-temp.key;
    }
}
class Scanner {

    StringTokenizer st;
    BufferedReader br;

    public Scanner(InputStream s) {
        br = new BufferedReader(new InputStreamReader(s));
    }

    public Scanner (FileReader f) {
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