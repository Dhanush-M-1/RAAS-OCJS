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

        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        TIME_START = System.currentTimeMillis();
        Task t = new Task();
        t.solve(sc, pw);
        TIME_END = System.currentTimeMillis();
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        pw.close();
        System.out.println("Memory increased:" + (usedMemoryAfter - usedMemoryBefore) / 1000000);
        System.out.println("Time used: " + (TIME_END - TIME_START) + ".");
    }

    public static class Task {

        public int get(int[] q, int r) {
            if (q[0] == r) return q[1];
            return q[0];
        }
        int[] deg ;
        List<int[]> edges;
        List<Integer>[] edgesS ;
        boolean[] del ;
        boolean[] badedge ;



        public void solve(Scanner sc, PrintWriter pw) throws IOException {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            deg = new int[n];
            edges = new ArrayList<>();
            edgesS = new List[n];
            for (int i = 0; i < n; i++) {
                edgesS[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                edges.add(new int[]{a, b});
                edgesS[a].add(i);
                edgesS[b].add(i);
                deg[a]++;
                deg[b]++;
            }
            del = new boolean[n];
            badedge = new boolean[m];
            int dlt = 0;
            for (int i = 0; i < n; i++) {
                if (!del[i] && deg[i] < k) {
                    dlt += dfs(i, k);
                }
            }
            Arrays.fill(deg, 0);
            Arrays.fill(del, true);
            for (int i = 0; i < m; i++) {
                if (badedge[i]) continue;
                int[] e = edges.get(i);
                deg[e[0]]++;
                deg[e[1]]++;
                del[e[0]] = false;
                del[e[1]] = false;
            }
            int[] res = new int[m];
            res[m - 1] = n - dlt;

//            for (int i = m - 1; i > 0; i--) {
//                int[] toremove = edges.get(i);
//                int t1 = toremove[0], t2 = toremove[1];
//                edges.remove(i);
//                edgesS[t1].remove(edgesS[t1].size() - 1);
//                edgesS[t2].remove(edgesS[t2].size() - 1);
//                int tr = 0;
//                Arrays.fill(deg, 0);
//                Arrays.fill(badedge, false);
//                for (int j = 0; j < i; j++) {
//                    int[] e = edges.get(j);
//                    deg[e[0]]++;
//                    deg[e[1]]++;
//                }
//                Arrays.fill(del, false);
//                for (int j = 0; j < n; j++) {
//                    if (!del[j] && deg[j] < k) {
//                        tr += dfs(j, k);
//                    }
//                }
//                res[i - 1] = n - tr;
//            }

            for (int i = m - 1; i > 0; i--) {
                int[] toremove = edges.get(i);
                int t1 = toremove[0], t2 = toremove[1];
                edges.remove(i);
                edgesS[t1].remove(edgesS[t1].size() - 1);
                edgesS[t2].remove(edgesS[t2].size() - 1);
                int tr = 0;
                if (!badedge[i]) {
                    if (!del[t1] && !del[t2]) {
                        deg[t1]--;
                        deg[t2]--;
                        if (!del[t1] && deg[t1] < k) {
                            tr += dfs(t1, k);
                        }
                        if (!del[t2] && deg[t2] < k) {
                            tr += dfs(t2, k);
                        }
                    }
                }
                res[i - 1] = res[i] - tr;
            }
            for (int i = 0; i < m; i++) {
                pw.println(res[i]);
            }
        }

        public int dfs(int u, int k) {
            int cnt = 0;
            del[u] = true;
            cnt++;
            deg[u] = 0;
            for (int idx : edgesS[u]) {
                if (badedge[idx]) continue;
                badedge[idx] = true;
                int o = get(edges.get(idx), u);
                if (del[o]) continue;
                deg[o]--;
                if (deg[o] < k) {
                    cnt += dfs(o, k);
                }
            }
            return cnt;
        }
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader s) throws FileNotFoundException {
            br = new BufferedReader(s);
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
            return Double.parseDouble(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}