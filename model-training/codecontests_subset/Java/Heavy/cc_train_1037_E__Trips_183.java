//package Cf.Codefest18;

import java.io.*;
import java.util.*;

/**
 * Author : NoRainInNorthrend
 * Date: 2018/9/3 18:51
 */
public class E {
    public static int n, m, k;
    public static List<Pair>[] g;
    public static int[] degree;
    public static int[] from, to;

    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        degree = new int[n + 1];
        from = new  int[m + 1];
        to = new int[m + 1];
        g = new List[n + 1];
        Set<Pair> treeSet = new TreeSet<>();
        boolean[] inSet = new boolean[n + 1];
        for(int i = 0; i <= n; i++) g[i] = new ArrayList<>();
        for(int i = 0; i < m; i++){
            from[i] = scanner.nextInt();
            to[i] = scanner.nextInt();
            g[from[i]].add(new Pair(to[i], i));
            g[to[i]].add(new Pair(from[i], i));
            degree[from[i]]++;
            degree[to[i]]++;
        }
        for(int i = 1; i <= n; i++){
            treeSet.add(new Pair(degree[i], i));
            inSet[i] = true;
        }
        Iterator iterator;
        while(true){
            iterator = treeSet.iterator();
            if(!iterator.hasNext()) break;
            Pair front = (Pair)iterator.next();
            if(front.first < k){
                int u = front.second;
                for(Pair pair : g[u]){
                    int v = pair.first;
                    if(inSet[v]){
                        treeSet.remove(new Pair(degree[v], v));
                        treeSet.add(new Pair(--degree[v] , v));
                    }
                }
                inSet[u] = false;
                treeSet.remove(front);
            }else {
                break;
            }
        }
        int[] ans = new int[m];
        for(int i = m - 1; i >= 0; i--){
            ans[i] = treeSet.size();
            int x = from[i], y = to[i];
            if(inSet[x] && inSet[y]){
                treeSet.remove(new Pair(degree[x], x));
                treeSet.add(new Pair(--degree[x], x));
                treeSet.remove(new Pair(degree[y], y));
                treeSet.add(new Pair(--degree[y], y));
                while(true){
                    iterator = treeSet.iterator();
                    if(!iterator.hasNext()) break;
                    Pair front = (Pair)iterator.next();
                    if(front.first < k){
                        int u = front.second;
                        for(Pair pair : g[u]){
                            if(pair.second >= i) continue;
                            int v = pair.first;
                            if(inSet[v]){
                                treeSet.remove(new Pair(degree[v], v));
                                treeSet.add(new Pair(--degree[v] , v));
                            }
                        }
                        inSet[u] = false;
                        treeSet.remove(front);
                    }else {
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < m; i++) out.println(ans[i]);
        out.flush();
    }

    static class Pair implements Comparable<Pair>{
        public int first;
        public int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        @Override
        public int compareTo(Pair o) {
            if(this.first == o.first){
                if(this.second == o.second){
                    return 0;
                }else{
                    return this.second > o.second ? 1 : -1;
                }
            }else{
                return this.first > o.first ? 1 : -1;
            }
        }
    }

    private static class FastScanner {
        StringTokenizer st;
        BufferedReader br;

        public FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public int nextInt() throws NumberFormatException, IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws NumberFormatException, IOException {
            return Double.parseDouble(next());
        }
    }
}
