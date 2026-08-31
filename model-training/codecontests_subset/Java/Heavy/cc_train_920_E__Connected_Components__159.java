//package practice.pset1;

import java.io.*;
import java.util.*;

public class R920E {

    static int n;
    static TreeSet<Integer> unvisited;
    static HashSet<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        n = sc.nextInt();
        adj = new HashSet[n];
        for (int i = 0; i < n; i++)
            adj[i] = new HashSet<>();

        unvisited = new TreeSet<>();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            adj[a].add(b);
            adj[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            unvisited.add(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(unvisited.contains(i))
                res.add(dfs(i));
        }

        pw.println(res.size());
        Collections.sort(res);
        for (int i = 0; i < res.size(); i++) {
            pw.print(res.get(i) + " ");
        }
        pw.println();

        pw.flush();
        pw.close();
    }


    static int dfs(int u){
        unvisited.remove(u);
        int cnt = 1;
        if(unvisited.isEmpty())
            return cnt;
        Integer v = unvisited.first();
        while(v != null) {
            if(!adj[u].contains(v))
                cnt += dfs(v);
            v = unvisited.higher(v);
        }
        return cnt;
    }

    static class Scanner
    {
        StringTokenizer st; BufferedReader br;
        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
        public Scanner(String s) throws FileNotFoundException {	br = new BufferedReader(new FileReader(new File(s)));}
        public String next() throws IOException {while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());return st.nextToken();}
        public int nextInt() throws IOException {return Integer.parseInt(next());}
        public long nextLong() throws IOException {return Long.parseLong(next());}
        public String nextLine() throws IOException {return br.readLine();}
        public boolean ready() throws IOException {return br.ready();}
    }
}
