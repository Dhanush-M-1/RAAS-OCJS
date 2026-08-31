import java.util.*;
import java.io.*;

public class Trips {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> out = new ArrayDeque<>();
        ArrayDeque<Pair> edges = new ArrayDeque<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int curSize = n;
        ArrayList<Integer> graph[] = new ArrayList[n+1];
        int size[] = new int[n+1];
        int nEdges[] = new int[n+1];
        for (int i = 0; i< n+1; i++) {
            graph[i] = new ArrayList();
        }
        for (int i = 0; i < m;i++) {
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            graph[p1].add(p2);
            graph[p2].add(p1);
            size[p1]++;
            nEdges[p1]++;
            size[p2]++;
            nEdges[p2]++;
            edges.push(new Pair(p1, p2));
        }
        for(int i = 1; i < n+1; i++) {
            if (size[i] < k) {
                q.offer(i);
                size[i] = 0;
            }
        }
        while(!edges.isEmpty()) {
            while(!q.isEmpty()) {
                int curRem = q.poll();
                curSize--;
                for(int i = 0; i < nEdges[curRem]; i++) {
                    int node = graph[curRem].get(i);
                    size[node]--;
                    if (size[node] == k-1) {
                        q.add(node);
                        //size[node] = 0;
                    }
                }
            }
            out.push(curSize);
            Pair edge = edges.pop();
            int node1 = edge.a;
            int node2 = edge.b;
            nEdges[node1]--;
            nEdges[node2]--;
            //size[node1]--;
            //size[node2]--;
            boolean temp = size[node1] >= k;
            if (size[node2] >= k) {
                size[node1]--;
                if(size[node1] == k-1) {q.add(node1);}
            }
            if (temp) {
                size[node2]--;
                if(size[node2] == k-1) {q.add(node2);}
            }

        }
        while(!out.isEmpty()) {
            sb.append(out.pop());
            sb.append('\n');
        }
        System.out.print(sb.toString());

    }


    public static class Pair{
        int a,b;
        public Pair(int a, int b) {this.a=a;this.b=b;}
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }

        public FastScanner() {
            this(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String readNextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextInt();
            }
            return a;
        }
    }
}
