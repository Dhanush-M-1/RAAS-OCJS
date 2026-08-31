// package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;
//****Use Integer Wrapper Class for Arrays.sort()****
public class BC5 {
    public static void main(String[] Args){
        FastReader scan=new FastReader();
        int t=scan.nextInt();
        StringBuilder print=new StringBuilder();
        while(t-->0) {
            Set<Integer> v1 = new HashSet<>();
            Set<Integer> v2 = new HashSet<>();
            int n = scan.nextInt();
            Node[] arr = new Node[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = new Node();
            }
            int m = scan.nextInt();
            int a = scan.nextInt();
            int b = scan.nextInt();
            for (int i = 0; i < m; i++) {
                int u = scan.nextInt();
                int v = scan.nextInt();
                arr[u].ns.add(v);
                arr[v].ns.add(u);
            }
            Queue<Integer> q = new LinkedList<>();
            ((LinkedList<Integer>) q).add(a);
            v1.add(a);
            while (!q.isEmpty()) {
                int cur = q.remove();
                for (Integer i : arr[cur].ns) {
                    if (i != b && !v1.contains(i)) {
                        ((LinkedList<Integer>) q).add(i);
                        v1.add(i);
                    }
                }
            }
            v1.remove(a);
            ((LinkedList<Integer>) q).add(b);
            v2.add(b);
            while (!q.isEmpty()) {
                int cur = q.remove();
                for (Integer i : arr[cur].ns) {
                    if (i != a && !v2.contains(i)) {
                        ((LinkedList<Integer>) q).add(i);
                        v2.add(i);
                    }
                }
            }
            v2.remove(b);
            Set<Integer> intsct = new HashSet<>();
            for (Integer i : v1) {
                if (v2.contains(i)) {
                    intsct.add(i);
                }
            }
            for (Integer i : intsct) {
                v1.remove(i);
                v2.remove(i);
            }
            long ans = (long)(v1.size()) * v2.size();
            print.append(ans+"\n");
        }
        System.out.println(print);
    }
    static class Node{
        ArrayList<Integer> ns;
        Node(){
            ns=new ArrayList<>();
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

}
