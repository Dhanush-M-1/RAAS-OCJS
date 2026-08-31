// package com.MahmoudHamdy;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static final int INF = (int) 2e9;
    static final int N = (int) 1e6 + 100;


    public static void main(String[] args) throws IOException {
//        Scanner Sc = new Scanner("input.txt");
//        PrintWriter Out = new PrintWriter(new FileWriter("output.txt"));
        Scanner Sc = new Scanner(System.in);
        PrintWriter Out = new PrintWriter(System.out);

        par = new int[N];
        rank = new int[N];
        ans = new int[N];
        vis = new boolean[N];
        vec = new ArrayList<>();
        for(int i = 0; i < N; i ++)
        {
            vec.add(new ArrayList<>());
            ans[i] = 0;
            rank[i]= 0;
            par[i] = i;
        }
        int n = Sc.nextInt(), m = Sc.nextInt(), q = Sc.nextInt();
        for(int i = 0; i < m; i++)
        {
            int a = Sc.nextInt(), b = Sc.nextInt();
            vec.get(a).add(b);
            vec.get(b).add(a);
            merge(a, b);
        }
        for(int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dis = -1;
                node = 0;
                dfs(i, i, 0);
                dis = -1;
                dfs(node, node, 0);
                ans[p(i)] = dis;
            }
        }
        while(q-- > 0)
        {
            int t = Sc.nextInt();
            if(t == 1)
            {
                int x = Sc.nextInt();
                Out.println(ans[p(x)]);
            }else
            {
                int a = p(Sc.nextInt()), b = p(Sc.nextInt());
                if(a == b)
                    continue;
//                Out.println("** " + a + " " + ans[a]);
//                Out.println("** " + b + " " + ans[b]);
                ans[a] = Math.max(ans[a], Math.max(ans[b], (ans[a] + 1) / 2 + (ans[b] + 1) / 2 + 1));
//                Out.println("## " + a + " " + ans[a]);
                merge(b, a);
            }
        }
//        for(int i = 1 ; i <= n; i++)
//            Out.println(ans[i] + " " + p(i) + " " + ans[p(i)]);
        Out.flush();
        Out.close();
    }

    static int[] par, rank, ans;
    static int dis, node;
    static boolean[] vis;
    static ArrayList<ArrayList<Integer> > vec;

    static int p(int x)
    {
        if(x == par[x])
            return x;
        return par[x] = p(par[x]);
    }

    static void merge(int u, int v)
    {
        u = p(u);
        v = p(v);
        par[u] = v;
    }

    static void dfs(int v, int p, int l)
    {
        if(l > dis)
        {
            dis = l;
            node = v;
        }
        vis[v] = true;
        for(int i : vec.get(v))
            if(i != p)
                dfs(i, v, l + 1);

    }


    static class Comp
    {
        TreeMap<Integer, Integer> mop = new TreeMap<>();
        TreeSet<Integer> st = new TreeSet<>();

        void add(int x)
        {
            st.add(x);
        }
        int get(int x)
        {
            return mop.get(x);
        }
        void compress()
        {
            for(int i : st)
                mop.put(i, mop.size());
        }
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }
        Scanner(String s) throws FileNotFoundException { br = new BufferedReader(new FileReader(s)); }


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
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public boolean ready() throws IOException {
            return br.ready();
        }

    }

    static class pair implements Comparable<pair>{
        char f;long s;
        pair(char a,long b){f= a;s=b;}

        @Override
        public int compareTo(pair p) {
            if(s != p.s)
                return s > p.s ? 1 : -1;
            return f-p.f;
        }
    }
}