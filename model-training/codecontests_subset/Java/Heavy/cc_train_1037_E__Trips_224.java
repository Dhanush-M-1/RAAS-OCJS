//package contests.CF1037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class E {

    static ArrayList<Integer>[] adj;
    static int[] vis, going;
    static int NO = 3, YES = 2, VIS = 1;
    static int k;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner();
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();
        adj = new ArrayList[n];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        vis = new int[n];
        going = new int[n];

        int m = sc.nextInt();
        k = sc.nextInt();

        HashSet<Long> e = new HashSet<>();
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt()-1;
            edges[i][1] = sc.nextInt()-1;

            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);

            e.add(hash(edges[i][0], edges[i][1]));
        }


        TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) { ;
                if(going[i] != going[j])
                    return going[i] - going[j];
                return i - j;
            }
        });

        Arrays.fill(vis, YES);
        for (int i = 0; i < going.length; i++) {
            going[i] = adj[i].size();
        }
        for (int i = 0; i < n; i++) {
            set.add(i);
        }

        while(!set.isEmpty() && going[set.first()] < k){
            int a = set.pollFirst();
            vis[a] = NO;
            for (int b : adj[a]) {
                if(vis[b] == YES && e.contains(hash(a, b))){
                    set.remove(b);
                    going[b]--;
                    set.add(b);
                    e.remove(hash(a, b));
                }
            }
        }

        int[] ans = new int[m];
        for (int q = m-1; q >= 0; q--) {
            ans[q] = set.size();
            int u = edges[q][0];
            int v = edges[q][1];

            if(vis[u] == YES) {
                set.remove(u);
                if(vis[v] == YES && e.contains(hash(u, v)))
                    going[u]--;
                set.add(u);
            }

            if(vis[v] == YES) {
                set.remove(v);
                if(vis[u] == YES && e.contains(hash(u, v)))
                    going[v]--;
                set.add(v);
            }

            e.remove(hash(u, v));


            while(!set.isEmpty() && going[set.first()] < k){
                int a = set.pollFirst();
                vis[a] = NO;
                for (int b : adj[a]) {
                    if(vis[b] == YES && e.contains(hash(a, b))){
                        set.remove(b);
                        going[b]--;
                        set.add(b);
                        e.remove(hash(a, b));
                    }
                }
            }
        }


        for (int i = 0; i < m; i++) {
            pw.println(ans[i]);
        }


        pw.flush();
        pw.close();
    }


    static long hash(int a, int b){
        return Math.min(a, b) * 1000000l + Math.max(a, b);
    }
    static class Scanner{
        BufferedReader br;
        StringTokenizer st;
        public Scanner(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() throws IOException {
            while(st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
