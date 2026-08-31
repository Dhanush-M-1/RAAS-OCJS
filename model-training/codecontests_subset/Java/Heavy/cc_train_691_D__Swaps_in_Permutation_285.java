import java.io.*;
import java.util.*;

import java.util.StringTokenizer;
public class l{
    static ArrayList<Integer>[] adjList;
    static int V;
    static boolean[]visited;
    static int[]val;
    static ArrayList<Integer>arr;
    static void bfs(int s)
    {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        visited[s] = true;
        arr.add(s);
        while(!q.isEmpty())
        {
            int u = q.remove();

            for(int v: adjList[u])
                if(!visited[v])
                {
                    arr.add(v);
                    visited[v] = true;
                    q.add(v);
                }
        }
    }
    static void graph() throws IOException {
        int m = sc.nextInt();
        adjList= new ArrayList[V];
        val = new int[V];
        for (int i =0;i<V;i++){
            val[i]=sc.nextInt();
        }
        for (int i =0;i<V;i++){
            adjList[i]= new ArrayList<>();
        }

        while (m-->0){
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            adjList[u].add(v);
            adjList[v].add(u);
        }
        visited= new boolean[V];
    }
    static Scanner sc;
    public static void main (String[]args) throws IOException {
        sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        V= sc.nextInt();
        graph();
        for (int i =0;i<V;i++){
            if (!visited[i]){
                arr= new ArrayList<>();
                bfs(i);
                Collections.sort(arr);
                ArrayList<Integer>ff= new ArrayList<>();
                for (int j:arr){
                    ff.add(val[j]);
                }
                Collections.shuffle(ff);
                Collections.sort(ff);
                for (int j=0;j<arr.size();j++)
                    val[arr.get(j)]=ff.get(arr.size()-j-1);

            }
        }
        for (int i=0;i<V;i++){
            pw.print(val[i]);
            pw.print(" ");
        }
        pw.flush();
        pw.close();

    }
    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}

        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}

        public double nextDouble() throws IOException
        {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if(x.charAt(0) == '-')
            {
                neg = true;
                start++;
            }
            for(int i = start; i < x.length(); i++)
                if(x.charAt(i) == '.')
                {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                }
                else
                {
                    sb.append(x.charAt(i));
                    if(dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg?-1:1);
        }

        public boolean ready() throws IOException {return br.ready();}


    }
}