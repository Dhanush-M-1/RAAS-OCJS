


import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.util.*;

@SuppressWarnings("Duplicates")
// author @mdazmat9
public class codeforces{
    static long abs=1000000007;
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int test = 1;
        for (int ind = 0; ind < test; ind++) {
           int n=sc.nextInt();
           String s=sc.next();
           boolean bool=false;
           int index=-1;
           for(int i=0;i<n-1;i++){
               if(s.charAt(i)>s.charAt(i+1)){
                   bool=true;
                   index=i+1;
                   break;
               }
           }
           if(bool){
               out.println("YES");
               out.println(index+" "+(index+1));
           }
           else out.println("NO");
        }


        out.flush();
    }






    public static double logb( double a, double b )
    {
        return Math.log(a) / Math.log(b);
    }

    static long fast_pow(long a, long b) {
        if(b == 0)
            return 1L;

        long val = fast_pow(a, b / 2);

        if(b % 2 == 0)
            return val * val % mod;
        else
            return val * val % mod * a % mod;
    }
    static long mod = (long)1e9 + 7;
    static   void shuffle(int[] a) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }
    static long gcd(long a , long b)
    {
        if(b == 0)
            return a;
        return gcd(b , a % b);
    }

}
class Scanner {
    public BufferedReader reader;
    public StringTokenizer st;

    public Scanner(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        st = null;
    }

    public String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                String line = reader.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            } catch (Exception e) {
                throw (new RuntimeException());
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}

class OutputWriter {
    BufferedWriter writer;

    public OutputWriter(OutputStream stream) {
        writer = new BufferedWriter(new OutputStreamWriter(stream));
    }

    public void print(int i) throws IOException {
        writer.write(i);
    }

    public void print(String s) throws IOException {
        writer.write(s);
    }

    public void print(char[] c) throws IOException {
        writer.write(c);
    }

    public void close() throws IOException {
        writer.close();
    }

}
class Pair {
    int x;
    int y;

    // Constructor
    public Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
class Compare {

    static void compare_x(Pair arr[], int n)
    {
        // Comparator to sort the pair according to second element
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override public int compare(Pair p1, Pair p2)
            {
                return (p1.x - p2.x);
            }
        });
    }
    static void compare_y(Pair arr[], int n)
    {
        // Comparator to sort the pair according to second element
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override public int compare(Pair p1, Pair p2)
            {
                return (p1.y - p2.y);
            }
        });
    }
}

class Graph {

    int V;
    ArrayList<Integer>[] adjListArray;

    // constructor
    Graph(int V) {
        this.V = V;

        adjListArray = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adjListArray[i] = new ArrayList<>();
        }
    }

    // Adds an edge to an undirected graph
    void addEdge(int src, int dest) {

        adjListArray[src].add(dest);
        adjListArray[dest].add(src);
    }


    ArrayList<Integer> DFSUtil(int u, boolean visited[], int parent,ArrayList<Integer> list)
    {
        // Mark the current node as visited
        visited[u] = true;

        for (int i = 0; i < adjListArray[u].size(); i++) {
            int n = adjListArray[u].get(i);
            list.add(n);

            if (!visited[i]) {
                DFSUtil(n, visited, u,list);
            }
        }
        return list;

    }


    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int r,int c) {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];
        ArrayList<Integer> list=new ArrayList<>();
        // Call the recursive helper function to print DFS traversal
        boolean bool=true;

    }


}