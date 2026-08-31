import java.util.*;
import java.math.*;
import java.io.*;
import java.text.*;

public class A {
    static class Node implements Comparable<Node>{
        long x;
        long y;
        public Node(long x,long y){
            this.x=x;
            this.y=y;
        }
        public int compareTo(Node c){
            int i=Long.compare(this.x,c.x);
            if(i!=0) return i;
            i=Long.compare(this.y,c.y);
            return i;
        }
        public boolean equals(Object o){
            if(o instanceof Node){
                Node c = (Node)o;
                return x == c.x && y==c.y;
            }
            return false;
        }
        public int hashCode(){
            return (int)(x+y);//for simplicity reason
        }
    }
    //public static PrintWriter pw;
    public static PrintWriter pw = new PrintWriter(System.out);

    public static void solve() throws IOException {
    //	pw=new PrintWriter(new FileWriter("C:\\Users\\shree\\Downloads\\small_output_in"));
            FastReader sc = new FastReader();
            int n=sc.I(); int m=sc.I();
            a=new int[n+1];
            for(int i=1;i<=n;i++) a[i]=sc.I();
            graph=new ArrayList[n+1];
            vis=new boolean[n+1];

            for(int i=1;i<=n;i++) graph[i]=new ArrayList<>();

            while(m-->0){
                int x=sc.I(); int y=sc.I();
                graph[x].add(y); graph[y].add(x);
            }

            for(int i=1;i<=n;i++){
                if(!vis[i]){
                    dfs(i);
                    Collections.sort(v1);
                    Collections.sort(v2,Collections.reverseOrder());
                   for(int j=0;j<v1.size();j++){
                       a[v1.get(j)]=v2.get(j);
                   }
                    v1.clear();
                    v2.clear();
                }
            }
            for(int i=1;i<=n;i++) pw.print(a[i]+" ");


            pw.close();

    }
    static int a[];
    static ArrayList<Integer> graph[];
   static boolean vis[];
    static ArrayList<Integer> v1=new ArrayList<>();
    static ArrayList<Integer> v2=new ArrayList<>();

    static void dfs(int v){
        vis[v]=true;
        v1.add(v);
        v2.add(a[v]);

        for(int u : graph[v]){
            if(!vis[u]) dfs(u);
        }
    }
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                try {

                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "1", 1 << 26).start();

    }

    static BufferedReader br;
    static long M = (long) 1e9 + 7;

    static class FastReader {

        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            //br=new BufferedReader(new FileReader("C:\\Users\\shree\\Downloads\\B-small-practice.in"));
            br = new BufferedReader(new InputStreamReader(System.in));

        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int I() {
            return Integer.parseInt(next());
        }

        long L() {
            return Long.parseLong(next());
        }

        double D() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public boolean hasNext() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String s = br.readLine();
                if (s == null) {
                    return false;
                }
                st = new StringTokenizer(s);
            }
            return true;
        }

    }
}