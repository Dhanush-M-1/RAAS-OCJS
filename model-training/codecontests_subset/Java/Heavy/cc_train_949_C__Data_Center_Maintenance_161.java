//package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        MyScanner sc = new MyScanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        long start = System.currentTimeMillis();
        Task t = new Task();
        t.solve(sc, pw);
        long end = System.currentTimeMillis();
//        pw.println("Used time " + (end - start) + "ms.");
        pw.close();
    }

    public static class Task {

        public void solve(MyScanner sc, PrintWriter pw) throws IOException {
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
            SCC scc = new SCC(n, m * 2);
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                if ((centers[a] + 1) % h == centers[b] && !used[a].contains(b)) {
                    scc.add_edge(a + 1, b + 1);
                    used[a].add(b);
                }
                if ((centers[b] + 1) % h == centers[a] && !used[b].contains(a)) {
                    scc.add_edge(b + 1, a + 1);
                    used[b].add(a);
                }
            }
            scc.run();
            int[] sizescc = new int[scc.group_cnt];
            Set<Integer>[] newRVEdge = new Set[scc.group_cnt];
            for (int i = 0; i < scc.group_cnt; i++) {
                newRVEdge[i] = new HashSet<>();
            }
            int[] deg = new int[scc.group_cnt];
            for (int i = 0; i < n; i++) {
                int sccI = scc.group_num[i + 1] - 1;
                sizescc[sccI] ++;
                for (int j : used[i]) {
                    int sccJ = scc.group_num[j + 1] - 1;
                    if (!newRVEdge[sccI].contains(sccJ) && sccI != sccJ){
                        newRVEdge[sccI].add(sccJ);
                        deg[sccI]++;
                    }
                }
            }
//            boolean[] visited = new boolean[scc.group_cnt];

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
                if (scc.group_num[i + 1] - 1 == minEndIdx) {
                    tp.add(i + 1);
                    cnt++;
                }
            }
            pw.println(cnt);
            for (int i = 0; i < cnt; i++) {
                pw.print(tp.get(i) + " ");
            }
            pw.println();

//            for (int i = 0; i < scc.group_cnt; i++) {
//                if (deg[i] == 0 && !visited[i]) {
//                    if (sizescc[i] < minEndVal) {
//                        minEndVal = sizescc[i];
//                        minEndIdx = i;
//                    }
//                    Stack<Integer> st = new Stack<>();
//                    st.push(i);
//                    visited[i] = true;
//                    while (!st.empty()) {
//                        int t = st.pop();
//                        for(int j : newRVEdge[t]) {
//                            if (!visited[j]) {
//                                visited[j] = true;
//                                st.push(j);
//                            }
//                        }
//                    }
//                }
//            }
//            int minim = Integer.MAX_VALUE;
//            Set<Integer> minidx = new HashSet<>();
//            List<Integer> tmpIdx = new ArrayList<>();
//            for (int i = 0; i < scc.group_cnt; i++) {
//                int cnt = 0;
//                if (!visited[i]) {
//                    tmpIdx.clear();
//                    Stack<Integer> st = new Stack<>();
//                    st.push(i);
//                    visited[i] = true;
//                    while (!st.empty()) {
//                        int t = st.pop();
//                        tmpIdx.add(t);
//                        cnt+=sizescc[t];
//                        for(int j : newRVEdge[t]) {
//                            if (!visited[j]) {
//                                visited[j] = true;
//                                st.push(j);
//                            }
//                        }
//                    }
//                    if (cnt < minim) {
//                        minidx.clear();
//                        minidx.addAll(tmpIdx);
//                        minim = cnt;
//                    }
//                }
//            }
//            if (minEndVal < minim) {

//            } else {
//                int cnt = 0;
//                List<Integer> tp = new ArrayList<>();
//                for (int i = 0; i < n; i++) {
//                    if (minidx.contains(scc.group_num[i + 1] - 1)) {
//                        tp.add(i + 1);
//                        cnt++;
//                    }
//                }
//                pw.println(cnt);
//                for (int i = 0; i < cnt; i++) {
//                    pw.print(tp.get(i) + " ");
//                }
//            }
//            pw.println();

        }

    }

    public static class SCC {
        public class Edge{
            int e, nxt;
            Edge(){}
        }
        public int V = 0, E = 0;
        public Edge[] e, er;
        public int[] sp, spr, group_num, stk;
        public int group_cnt;
        public boolean[] v;
        public void fill_forward(int x){
            v[x] = true;
            for (int i = sp[x]; i != 0; i = e[i].nxt) {
                if (!v[e[i].e]) fill_forward(e[i].e);
            }
            stk[++stk[0]] = x;
        }
        public void fill_backward(int x){
            v[x] = false;
            group_num[x] = group_cnt;
            for (int i = spr[x]; i != 0; i = er[i].nxt) {
                if (v[er[i].e]) fill_backward(er[i].e);
            }
        }
        public void add_edge(int v1, int v2){
            e[++E].e = v2; e[E].nxt = sp[v1]; sp[v1] = E;
            er[E].e = v1; er[E].nxt = spr[v2]; spr[v2] = E;
        }
        public SCC(int n, int m){
            e = new Edge[m + 10];
            er = new Edge[m + 10];
            V = n;
            for (int i = 0; i < m + 10; i++) {
                e[i] = new Edge();
                er[i] = new Edge();
            }
            sp = new int[n + 10];
            spr = new int[n + 10];
            group_num = new int[n + 10];
            stk = new int[n + 10];
            v = new boolean[n + 10];
        }
        public void run(){
            stk[0] = 0;
            Arrays.fill(v, false);
            for (int i = 1; i <= V; i++) {
                if (!v[i]) fill_forward(i);
            }
            group_cnt = 0;
            for (int i = stk[0]; i >= 1; i--) {
                if(v[stk[i]]) {
                    group_cnt++;
                    fill_backward(stk[i]);
                }
            }
        }
    }

    static class MyScanner {
        StringTokenizer st;
        BufferedReader br;

        public MyScanner(InputStream s){  br = new BufferedReader(new InputStreamReader(s));}

        public MyScanner(FileReader s) throws FileNotFoundException {br = new BufferedReader(s);}

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
