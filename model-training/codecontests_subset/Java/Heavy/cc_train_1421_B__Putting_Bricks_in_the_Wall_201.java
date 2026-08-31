import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Equal {
    static class pair implements Comparable<pair> {
        int v, w;

        public pair(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(pair o) {
            if (v == o.v)
                return w - o.w;
            return o.v - v;
        }
    }

    static class tri implements Comparable<tri> {
        int v, i, j;

        public tri(int v, int i, int j) {
            this.v = v;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(tri o) {

            return v - o.v;
        }
    }

    static ArrayList<Integer>[] tree;
    static int timer = 0;
    static int[] timein;
    static int[] timeout;
    static int[][] powerParent;
    static int[] depth;
    static int[][] minWeight;

    static void dfs(int u, int parent) {

        timein[u] = ++timer;
//        powerParent[u][0] = parent;
////        minWeight[u][0] = weight;
//        if (parent == -1)
//            powerParent[u][0] = u;
//        for (int i = 1; i <= 32; i++) {
//            powerParent[u][i] = powerParent[powerParent[u][i - 1]][i - 1];
//            minWeight[u][i] = Math.min(minWeight[u][i - 1], minWeight[powerParent[u][i - 1]][i - 1]);
//        }
        for (int i = 0; i < tree[u].size(); i++) {
            int v = tree[u].get(i);
            if (v == parent)
                continue;
            depth[v] = depth[u] + 1;
            dfs(v, u);
        }


        timeout[u] = timer;
    }

    static boolean isAncestor(int u, int v) {
        return timein[u] <= timein[v] && timeout[v] <= timeout[u];
    }

    static int lca(int u, int v) {
        if (isAncestor(u, v))
            return u;
        if (isAncestor(v, u))
            return v;
        for (int i = 32; i >= 0; i--) {
            int temp = powerParent[u][i];
            if (!isAncestor(temp, v)) {
                u = temp;
            }
        }
        return powerParent[u][0];
    }

    static int distance(int u, int v) {
        return depth[u] + depth[v] - 2 * depth[lca(u, v)];
    }

    static int nthAncestor(int u, int n) {
        int c = -1;

        while (n > 0) {
            c++;
            if (n % 2 == 0) {
                n /= 2;
                continue;
            }
            u = powerParent[u][c];
            n /= 2;

        }
        return u;
    }

    static int nthMinWeight(int u, int n) {
        int c = -1;

        int min = (int) (1e9);
        while (n > 0) {
            c++;
            if (n % 2 == 0) {
                n /= 2;
                continue;
            }
            min = Math.min(min, minWeight[u][c]);
            u = powerParent[u][c];
            n /= 2;

        }
        return min;
    }


    static class SegmentTree {        // 1-based DS, OOP

        int N;            //the number of elements in the array as a power of 2 (i.e. after padding)
        int[] array, lazy;
        double[] sTree;

        public SegmentTree(int[] in) {
            array = in;
            N = in.length - 1;
            sTree = new double[N << 1];        //no. of nodes = 2*N - 1, we add one to cross out index zero
            lazy = new int[N << 1];
            build(1, 1, N);
        }

        public void build(int node, int b, int e)    // O(n)
        {
            if (b == e)
                sTree[node] = array[b];
            else {
                int mid = b + e >> 1;
                build(node << 1, b, mid);
                build(node << 1 | 1, mid + 1, e);
                sTree[node] = sTree[node << 1] + sTree[node << 1 | 1];
            }
        }


        public void update_point(int index, double oval, double nval)            // O(log n)
        {
            index += N - 1;
            sTree[index] -= oval;
            sTree[index] += nval;
            while (index > 1) {
                index >>= 1;
                sTree[index] = sTree[index << 1] + sTree[index << 1 | 1];
            }
        }


        public void update_range(int i, int j, double oval, double nval)        // O(log n)
        {
            update_range(1, 1, N, i, j, oval, nval);
        }

        public void update_range(int node, int b, int e, int i, int j, double oval, double nval) {
            if (i > e || j < b)
                return;
            if (b >= i && e <= j) {
                sTree[node] -= oval;
                sTree[node] += nval;

            } else {
                int mid = b + e >> 1;
//                propagate(node, b, mid, e);
                update_range(node << 1, b, mid, i, j, oval, nval);
                update_range(node << 1 | 1, mid + 1, e, i, j, oval, nval);
                sTree[node] = sTree[node << 1] + sTree[node << 1 | 1];
            }

        }

//        public void propagate(int node, int b, int mid, int e) {
//            lazy[node << 1] += lazy[node];
//            lazy[node << 1 | 1] += lazy[node];
//            sTree[node << 1] += (mid - b + 1) * lazy[node];
//            sTree[node << 1 | 1] += (e - mid) * lazy[node];
//            lazy[node] = 0;
//        }

        public double query(int i, int j) {
            return query(1, 1, N, i, j);
        }

        public double query(int node, int b, int e, int i, int j)    // O(log n)
        {
            if (i > e || j < b)
                return 0;
            if (b >= i && e <= j)
                return sTree[node];
            int mid = b + e >> 1;
//            propagate(node, b, mid, e);
            double q1 = query(node << 1, b, mid, i, j);
            double q2 = query(node << 1 | 1, mid + 1, e, i, j);
            return q1 + q2;

        }
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static int NumOfOccIn(char[] c) {
        int ans = 0;
        char[] pattern = {'a', 'b', 'a', 'c', 'a', 'b', 'a'};
        for (int i = 0; i < c.length; i++) {
            int j = i;
            for (; j < c.length; j++) {
                if (j == i + 7)
                    break;
                if (c[j] != pattern[j - i])
                    break;
            }
            if (j == i + 7)
                ans++;
        }
        return ans;
    }

    static char[] cc;

    static int NumOccAfterUpdate(char[] c, int start) {
        int ans = 0;
        cc = c.clone();
        char[] pattern = {'a', 'b', 'a', 'c', 'a', 'b', 'a'};
        for (int i = start; i < c.length; i++) {
            if (i == start + 7)
                break;
            if (cc[i] == '?') {
                cc[i] = pattern[i - start];
            }
            if (cc[i] == pattern[i - start])
                continue;
            else return 0;
        }
        return NumOfOccIn(cc);
    }

    static long pow(int a, int e) {
        long res = 1;
        while (e-- > 0)
            res *= a;
        return res;
    }

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new FileReader("name.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n=Integer.parseInt(br.readLine());
            char[] []s=new char[n][n];
            for (int i = 0; i <n ; i++) {
                s[i]=br.readLine().toCharArray();
            }
            int  a=s[0][1]-'0';
            int  b=s[1][0]-'0';
            int  c=s[n-1][n-2]-'0';
            int d= s[n-2][n-1]-'0';
            int f=2-a-b;
            f+=c+d;
            int se=2-c-d;
            se+=a+b;
            if(f<se){
                out.println(f);
                if(a!=1)
                    out.println("1 2");
                if(b!=1)
                    out.println("2 1");
                if(c!=0)
                    out.println(n+" "+(n-1));
                if(d!=0)
                    out.println((n-1)+" "+(n));

            }
            else{
                out.println(se);
                if(a!=0)
                    out.println("1 2");
                if(b!=0)
                    out.println("2 1");
                if(c!=1)
                    out.println(n+" "+(n-1));
                if(d!=1)
                    out.println((n-1)+" "+(n));
            }
        }
        out.flush();
        out.close();

    }


}