

import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;
public class Wtf {
    public static void main(String[] args) throws IOException {
        Ifmo ifmo = new Ifmo();
    }
}

class Ifmo {
    ArrayList<Integer> Graph[];
    int n, l, m, primes, timer;
    char[][] field;
    ArrayList<FUCKINGVERTEX> Ribs;
    int[][] roofs, ans, up;
    Vertex[][] highes;
    ArrayList<Integer> fin;
    static int cur;
    int[] p, size, tin, tout;
    boolean[] used;
    int logn;
    int[][] pref;
    int[][] longest;
    int[][][] dp = new int[31][31][51];
    long mod;
    HashMap<Integer, Long>[] tree, bit;
    Ifmo() throws IOException {
        FScanner fs = new FScanner(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        n = fs.nextInt();
        long[] a = fs.larr(n);
        long[] b = fs.larr(n);
        tree = new HashMap[n];
        for (int i = 0; i<n; i++)
            tree[i] = new HashMap<>();
        for (int i = 1; i<n; i++) {
            int to = fs.nextInt();
            long cost = fs.nextLong();
            tree[i].put(to-1, 1L);
            tree[to-1].put(i, cost);
        }
        used = new boolean[n];
        Pair[] deep = new Pair[n];
        dfs(0, deep, 0);
        Arrays.sort(deep);
        for (int i =0 ; i<n; i++)
            used[i] = false;
        for (int i = n-1; i>0; i--) {
            used[deep[i].y] = true;
            int v = deep[i].y;
            int up = -1;
            long cost = -1;
            for (Map.Entry<Integer, Long> x : tree[v].entrySet())
                if (!used[x.getKey()]) {
                    up = x.getKey();
                    cost = x.getValue();
                }
            if (a[v]>=b[v]) {
                a[up]+=(a[v]-b[v])/cost;
                if (a[up]>1e17 || a[up]<-1e17)
                {
                    System.out.println("No");
                    System.exit(0);
                }
            } else
            {
                int size = Long.toString(b[v]-a[v] >=0 ? b[v]-a[v] : (b[v]-a[v])/10).length()+Long.toString(tree[up].get(v)).length();
                if (size>17) {
                    System.out.println("No");
                    System.exit(0);
                }
                if (size>17) {
                    System.out.println("No");
                    System.exit(0);
                }
                a[up]-=(b[v]-a[v])*tree[up].get(v);
                if (a[up]>1e17 || a[up]<-1e17)
                {
                    System.out.println("No");
                    System.exit(0);
                }
            }
        }
        if (a[0]>=b[0])
            pw.println("YES");
        else pw.println("NO");
        pw.close();
    }

    void dfs(int v, Pair[] deep, int q) {
        used[v] = true;
        deep[v] = new Pair(q, v);
        for (Map.Entry<Integer, Long> x : tree[v].entrySet())
            if (!used[x.getKey()])
                dfs(x.getKey(), deep, q+1);
    }

    void dfs_combo(int cur, int it,  int[] p, int[] q) {
        used[cur] = true;
        if (q[cur] == -1 || q[cur] == p[cur]);
    }

    void dfs(int cur, int[] mas, HashMap<Integer, Integer> numofv, HashMap<Integer, HashSet<Integer>> fullis, HashSet<Integer> currents, ArrayList<Integer>[] bin) {
        used[cur] = true;
        if (bin[mas[cur]].size() == 0)
            primes++;
        else {
            currents.add(mas[cur]);
            for (int i = 0; i<bin[cur].size(); i+=2) {
                int val = bin[cur].get(i);
                int how = bin[cur].get(i+1);
                if (numofv.containsKey(val)) {

                }
            }
        }


    }

    boolean upper(int a, int b) {
        return tin[a]<=tin[b] && tout[a]>=tout[b];
    }

    int lca(int a, int b) {
        if (upper(a, b)) return a;
        if (upper(b, a)) return b;
        for (int i = logn-1; i>=0; i--) {
            if (!upper(up[a][i], b))
                a = up[a][i];
        }
        return up[a][0];
    }



    int log_2(int g) {
        int s = 1;
        int ans = 0;
        while (g>=s)
        {
            ans++;
            s*=2;
        }
        return ans;
    }

    int dsu_get(int v) {
        return p[v] == v? v : (p[v] = dsu_get(p[v]));
    }

    void dsu_unit(int a, int b) { // a or dsu_get(a)? what's your choice?
        if (a!=b) {
            if (size[b]>size[a])
            {
                int q = a;
                a = b;
                b = q;
            }
            p[b] = a;
            size[a]+=size[b];
        }
    }
    int gcd (int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd (b, a % b);
    }
}

class forStr {
    int a, b, size;
    forStr(int a1, int b1, int size1) {
        a = a1;
        b = b1;
        size = size1;
    }
}
class Pair implements Comparable<Pair> {
    int x, y;
    Pair(int x1, int y1) {
        x = x1;
        y = y1;
    }

    @Override
    public int compareTo(Pair o) {
        return Integer.compare(x, o.x);
    }
}

class Lines implements Comparable<Lines> {
    int pos;
    boolean start;
    Lines(int x, boolean f) {
        pos = x;
        start = f;
    }

    @Override
    public int compareTo(Lines o) {
       return Integer.compare(pos, o.pos);
    }
}

class Vertex implements Comparable<Vertex> {
    int  b, c;
    int a;
    Vertex(int a1, int b1, int c1) {
        a = a1;
        b = b1;
        c = c1;
    }

    @Override
    public int compareTo(Vertex o) {
        return Long.compare(c, o.c);
    }
}

class FUCKINGVERTEX implements Comparable<FUCKINGVERTEX> {
    int a, b, c, d;
    FUCKINGVERTEX(int a1, int b1, int c1, int d1) {
        a = a1;
        b = b1;
        c = c1;
        d = d1;
    }

    @Override
    public int compareTo(FUCKINGVERTEX o) {
        return Integer.compare(a, o.a);
    }
}
class FScanner {
    StringTokenizer st;
    BufferedReader reader;
    FScanner(InputStreamReader isr) throws IOException {
        reader = new BufferedReader(isr);
    }

    String nextLine() throws IOException {
        return reader.readLine();
    }

    String nextToken() throws IOException{
        while (st == null || !st.hasMoreTokens()) {
            String s = reader.readLine();
            if (s == null)
                return null;
            st = new StringTokenizer(s);
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    char nextChar() throws IOException {
        return (char) reader.read();
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
    int[] iarr(int n) throws IOException {
        int[] mas = new int[n];
        for (int i =0 ; i<n; i++)
            mas[i] = nextInt();
        return mas;
    }
    double[] darr(int n) throws IOException {
        double[] mas = new double[n];
        for (int i =0 ; i<n; i++)
            mas[i] = nextDouble();
        return mas;
    }
    char[][] cmas2 (int n, int m) throws IOException {
        char[][] mas = new char[n][m];
        for (int i =0 ; i<n; i++)
            mas[i] = nextLine().toCharArray();
        return mas;
    }
    long[] larr(int n) throws IOException {
        long[] mas = new long[n];
        for (int i =0 ; i<n; i++)
            mas[i] = nextLong();
        return mas;
    }

}
