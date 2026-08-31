import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Laba {
    FScanner fs;
    PrintWriter pw;
    int n;
    boolean[] used;
    int[][] g;
    int[][] dst;
    long[] t;

    public static void main(String[] args) throws IOException {
        new Laba().start();
    }

    public void start() throws IOException {
        fs = new FScanner(new InputStreamReader(System.in));
        // reader = new FScanner(new FileReader("input"));
        //pw = new PrintWriter("input.txt");
        pw = new PrintWriter(System.out);
        int n = fs.nextInt();
        long[] arr = fs.larr(n);
        long[] ss = new long[n + 1];
        long ann = 1;
        t = new long[(n+1) * 4];
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0l, 1);
        map.put(1l, 2);
        for (int i = 2; i < ss.length; i++) {
            map.put(ann + i, i + 1);
            ann += i;
        }
        long[] ar = new long[n + 1];
        for (int i = 1; i < n+1; i++)
            ar[i] = i;
        build(ar, 1, 0, n);
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            //pw.println(sum(1, 0, n, 0, 3));
            ans[i] = findss(1, 0, n, arr[i]) ;
            update(1, 0, n, ans[i], 0);
        }
        for (int i =0 ; i <n; i++)
            pw.print(ans[i] + " ");
        pw.close();
    }


    void build (long a[], int v, int tl, int tr) {
        if (tl == tr)
            t[v] = a[tl];
        else {
            int tm = (tl + tr) / 2;
            build (a, v*2, tl, tm);
            build (a, v*2+1, tm+1, tr);
            t[v] = t[v*2] + t[v*2+1];
        }
    }

    void update (int v, int tl, int tr, int pos, long new_val) {
        if (tl == tr)
            t[v] = new_val;
        else {
            int tm = (tl + tr) / 2;
            if (pos <= tm)
                update (v*2, tl, tm, pos, new_val);
            else
                update (v*2+1, tm+1, tr, pos, new_val);
            t[v] = t[v*2] + t[v*2+1];
        }
    }

    long sum (int v, int tl, int tr, int l, int r) {
        if (l > r)
            return 0;
        if (l == tl && r == tr)
            return t[v];
        int tm = (tl + tr) / 2;
        return sum (v*2, tl, tm, l, Math.min(r,tm))
                + sum (v*2+1, tm+1, tr, Math.max(l,tm+1), r);
    }

    int findss(int v, int tl, int tr, long sum) {
        if (sum > t[v])
            return -1;
        if (tl == tr)
            return tl;
        int tm = (tl + tr) /2;
        if (t[v*2] > sum) {
            return findss(v * 2, tl, tm, sum);
        } else {
            return findss(v * 2 + 1, tm + 1, tr, sum - t[v*2]);
        }
    }

}

class pair {
    long x, y, c;

    pair(long  x1, long  y1) {
        x = x1;
        y = y1;
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

    String nextToken() throws IOException {
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
        for (int i = 0; i < n; i++)
            mas[i] = nextInt();
        return mas;
    }

    double[] darr(int n) throws IOException {
        double[] mas = new double[n];
        for (int i = 0; i < n; i++)
            mas[i] = nextDouble();
        return mas;
    }

    char[][] cmas2(int n, int m) throws IOException {
        char[][] mas = new char[n][m];
        for (int i = 0; i < n; i++)
            mas[i] = nextLine().toCharArray();
        return mas;
    }

    long[] larr(int n) throws IOException {
        long[] mas = new long[n];
        for (int i = 0; i < n; i++)
            mas[i] = nextLong();
        return mas;
    }
}