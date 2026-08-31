//package com.company;

import java.io.*;
import java.util.*;

public class Main {
    static long TIME_START, TIME_END;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream("Test.in"));
        PrintWriter pw = new PrintWriter(System.out);
//        PrintWriter pw = new PrintWriter(new FileOutputStream("Test.out"));
//        PrintWriter pw = new PrintWriter(new FileOutputStream("Test.in"));

        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        TIME_START = System.currentTimeMillis();
        Task t = new Task();
        t.solve(sc, pw);
        TIME_END = System.currentTimeMillis();
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        pw.close();
//        System.out.println("Memory increased:" + (usedMemoryAfter-usedMemoryBefore) / 1000000 );
//        System.out.println("Time used: " + (TIME_END - TIME_START) + ".");

    }


    public static class Task {
        public class SCC{
            List<Integer>[] edges;
            List<Integer>[] revEdges;
            boolean[] visited;
            int[] stack;
            int[] sccGroup;
            int stack_cnt;
            int group_cnt;
            int n, m;
            SCC(int n){
                this.n = n;
                init();
            }
            public void init() {
                edges = new List[n];
                revEdges = new List[n];
                for (int i = 0; i < n; i++) {
                    edges[i] = new ArrayList<>();
                    revEdges[i] = new ArrayList<>();
                }
                visited = new boolean[n];
                stack = new int[n];
                sccGroup = new int[n];
                stack_cnt = group_cnt = 0;
            }
            public void add_edge(int from, int to){
                edges[from].add(to);
                revEdges[to].add(from);
            }

            public void dfs1(int u){
                visited[u] = true;
                for (int v: edges[u]) {
                    if (!visited[v]) dfs1(v);
                }
                stack[stack_cnt++] = u;
            }

            public void dfs2(int u){
                visited[u] = false;
                sccGroup[u] = group_cnt;
                for (int v: revEdges[u]) {
                    if (visited[v]) dfs2(v);
                }
            }

            public void scc(){
                for(int i = 0;i < n; i++){
                    if (!visited[i]) dfs1(i);
                }
                for (int i = n - 1; i >= 0; i--) {
                    int u = stack[i];
                    if (visited[u]) {
                        dfs2(u);
                        group_cnt++;
                    }

                }
            }

        }

        public void solve(Scanner sc, PrintWriter pw) throws IOException {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int h = sc.nextInt();
            int[] centers = new int[n];
            for (int i = 0; i < n; i++) {
                centers[i] = sc.nextInt();
            }
            Set<Integer>[] used = new HashSet[n];
            for (int i = 0; i < n; i++) {
                used[i] = new HashSet<>();
            }
            SCC scc = new SCC(n);
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                if ((centers[a] + 1) % h == centers[b] && !used[a].contains(b)) {
                    scc.add_edge(a, b);
                    used[a].add(b);
                }
                if ((centers[b] + 1) % h == centers[a] && !used[b].contains(a)) {
                    scc.add_edge(b, a);
                    used[b].add(a);
                }
            }
            scc.scc();
            int[] sizescc = new int[scc.group_cnt];
            Set<Integer>[] newRVEdge = new Set[scc.group_cnt];
            for (int i = 0; i < scc.group_cnt; i++) {
                newRVEdge[i] = new HashSet<>();
            }
            int[] deg = new int[scc.group_cnt];
            for (int i = 0; i < n; i++) {
                int sccI = scc.sccGroup[i];
                sizescc[sccI] ++;
                for (int j : used[i]) {
                    int sccJ = scc.sccGroup[j];
                    if (!newRVEdge[sccI].contains(sccJ) && sccI != sccJ){
                        newRVEdge[sccI].add(sccJ);
                        deg[sccI]++;
                    }
                }
            }
            int minEndVal = Integer.MAX_VALUE;
            int minEndIdx = 0;
            for (int i = 0; i < scc.group_cnt; i++) {
                if (deg[i] == 0) {
                    if (sizescc[i] < minEndVal) {
                        minEndVal = sizescc[i];
                        minEndIdx = i;
                    }
                }
            }

            int cnt = 0;
            List<Integer> tp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (scc.sccGroup[i] == minEndIdx) {
                    tp.add(i + 1);
                    cnt++;
                }
            }
            pw.println(cnt);
            for (int i = 0; i < cnt; i++) {
                pw.print(tp.get(i) + " ");
            }
            pw.println();
        }




    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){  br = new BufferedReader(new InputStreamReader(s));}

        public Scanner(FileReader s) throws FileNotFoundException {br = new BufferedReader(s);}

        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}

        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}

        public double nextDouble() throws IOException { return Double.parseDouble(next()); }

        public boolean ready() throws IOException {return br.ready();}
    }
}
