import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() { while (st == null || !st.hasMoreElements()) {
            try { st = new StringTokenizer(br.readLine()); }
            catch (IOException e) { e.printStackTrace(); } }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }

        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }

    static class Graph{
        int V;
        ArrayList[] adj;
        Graph(int V){
            this.V=V;
            adj=new ArrayList[V+1];
            for(int i=0;i<=V;i++){
                adj[i]=new ArrayList<>();
            }
        }
    }

    static void addEdge(int a,int b,Graph g){
        g.adj[a].add(b);
        g.adj[b].add(a);
    }

    public static void main(String[] args) throws IOException {
        FastReader ip = new FastReader();
        OutputStream output = System.out;
        PrintWriter out = new PrintWriter(output);
        int n=ip.nextInt();
        int m=ip.nextInt();
        int arr[]=new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=ip.nextInt();
        }
        Graph g=new Graph(n);
        while(m-->0){
            int a=ip.nextInt();
            int b=ip.nextInt();
            if(a!=b){
                addEdge(a,b,g);
            }

        }
        boolean vis[]=new boolean[n+1];
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> al=new ArrayList<>();
        ArrayList<Integer> pos=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                q.add(i);
            }
            if(!vis[i]) {
                while (!q.isEmpty()) {
                    int k=q.poll();
                    al.add(arr[k]);
                    pos.add(k);
                    vis[k]=true;
                    ArrayList<Integer> list = g.adj[k];
                    for(Integer x:list){
                        if(!vis[x]){
                            q.add(x);
                        }
                    }
                }
//                out.println(pos);
                HashSet<Integer> hs=new HashSet<>();
                HashSet<Integer> hs1=new HashSet<>();
                hs.addAll(al);
                hs1.addAll(pos);
                al.clear();
                pos.clear();
                al.addAll(hs);
                pos.addAll(hs1);
               Collections.sort(pos);
               Collections.sort(al,Collections.reverseOrder());

                for(int j=0;j<pos.size();j++){
                    arr[pos.get(j)]=al.get(j);
                }
                al.clear();
                pos.clear();
            }
        }

       for(int i=1;i<=n;i++){
           out.print(arr[i]+" ");
       }

        out.close();
    }
}