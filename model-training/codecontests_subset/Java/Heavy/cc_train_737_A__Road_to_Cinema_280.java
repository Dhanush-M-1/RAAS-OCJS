//package com.company;

import java.io.*;
import java.util.*;

public class Main {
    static long TIME_START, TIME_END;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream("Test.in"));
        PrintWriter pw = new PrintWriter(System.out);
//        PrintWriter pw = new PrintWriter(new FileOutputStream("Test.in"));
        TIME_START = System.currentTimeMillis();
        Task t = new Task();
        t.solve(sc, pw);
        TIME_END = System.currentTimeMillis();
//        pw.println("Time used: " + (TIME_END - TIME_START) + ".");
        pw.close();
    }


    public static class Task {
        int n, k;
        long s, t;
        long[] c, v, g;
        long[] sortedG;
        long[] prefixG;
        public void solve(Scanner sc, PrintWriter pw) throws IOException {
            n = sc.nextInt();
            k = sc.nextInt();
            s = sc.nextLong();
            t = sc.nextLong();
            c = new long[n];
            v = new long[n];
            g = new long[k + 1];
            sortedG = new long[k + 2];
            prefixG = new long[k + 2];
            for (int i = 0; i < n; i++) {
                c[i] = sc.nextInt();
                v[i] = sc.nextInt();
            }
            long prefix = 0;
            for (int i = 0; i < k; i++) {
                g[i] = sc.nextInt();
            }
            g[k] = s;
            Arrays.sort(g);
            for (int i = 0; i <= k; i++) {
                sortedG[i] = g[i] - prefix;
                prefix = g[i];
            }
            sortedG[k + 1] = Integer.MAX_VALUE;
            Arrays.sort(sortedG);
            sortedG[k + 1] = 0;
            prefix = 0;
            for (int i = 0; i <= k + 1; i++) {
                prefixG[i] = sortedG[i] + prefix;
                prefix += sortedG[i];
            }
            List<Long> good = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                long fuel = v[i];
                if (fuel < sortedG[k]) continue;
                int s1 = find((fuel + 1) / 2);
                long b_first = prefixG[s1] - sortedG[s1];
                long b_second = (k + 1 - s1) * fuel - (prefixG[k] - prefixG[s1] + sortedG[s1]);
                long a = prefixG[k] - (b_first + b_second);
                if (2 * a + b_first + b_second <= t) {
                    good.add(c[i]);
                }
            }
            long min = Integer.MAX_VALUE;
            for (long ci : good) {
                min = Math.min(min, ci);
            }
            pw.println(min == Integer.MAX_VALUE ? -1 : min);
        }

        public int find(long x) {
            int lo = 0; int hi = k + 1;
            while (lo < hi) {
                int mid = lo + hi; mid /= 2;
                if (sortedG[mid] == x) return mid;
                if (sortedG[mid] < x) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo;
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
