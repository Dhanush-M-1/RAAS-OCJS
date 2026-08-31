import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    private static int KvoElem = 131072 * 2;
    private static int KvoForSum = 262144 * 2;
    private static int tree[] = new int[KvoForSum];
    private static long t[] = new long[KvoForSum * 2];
    private static int arr[] = new int[KvoElem + 1];
    private static int Result = 0;
    public static PrintWriter out;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        Main user = new Main();
        for (int i = KvoElem; i < KvoForSum; i++)
            user.update(i - KvoElem, 1);

        int n = sc.nextInt();
        for (int i = 0; i < KvoElem; i++) {
            arr[i] = 0;
        }
        build(1, 0, KvoElem);
        long[] value = new long[n];
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextLong();
        }
        List <Integer> list = new ArrayList <>();
        for (int i = n - 1; i >= 0; i--) {
            long x = user.find_need(value[i]);
            user.searchNext((int) x);
            list.add(Result);
            update(1, 0, KvoElem, Result, Result);
        }
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }

    private long find_need(long x) {
        int l = 0;
        int r = 200005;
        while (r > l) {
            long mid = (l + r) / 2;
            long val = get_sum(mid);
            if (val == x) {
                return mid + 1;
            } else if (val > x) {
                r = (int) mid;
            } else {
                l = (int) (mid + 1);
            }
        }
        return l + 1;
    }

    private static long get_sum(long x) {
        return x * (x + 1) / 2 - sum1(1, 0, KvoElem, 0, (int) x);
    }

    private static int sum(int index) {
        index += KvoElem;
        int res = tree[index];
        while (index > 1) {
            if (index % 2 == 1)
                res += tree[index - 1];

            index /= 2;
        }
        return res;
    }

    private void searchNext(int index) {
        index += KvoElem;
        if (tree[index] == 1) {
            update(index - KvoElem, 0);
            Result = index - KvoElem;
        } else {
            int SearcInd = sum(index - KvoElem) + 1;
            index = 1;
            while (Main.tree[index] != SearcInd && (index * 2 + 1) < Main.KvoForSum) {
                if (Main.tree[index] > SearcInd) {
                    index *= 2;
                } else if (Main.tree[index] < SearcInd) {
                    SearcInd -= Main.tree[index];
                    index++;
                }
            }
            UpdateIfRavno(index);
        }
    }

    private void UpdateIfRavno(int index) {
        while ((index * 2 + 1) < Main.KvoForSum) {
            if (Main.tree[index * 2 + 1] == 0)
                index *= 2;
            else
                index = index * 2 + 1;
        }
        Result = index - KvoElem;
        update(index - Main.KvoElem, 0);
    }

    private void update(int index, int value) {
        index += Main.KvoElem;
        int a = value - Main.tree[index];
        while (index >= 1) {
            Main.tree[index] += a;
            index /= 2;
        }
    }

    public static void build(int v, int tl, int tr) {
        if (tl == tr)
            t[v] = arr[tl];
        else {
            int tm = (tl + tr) / 2;
            build(v * 2, tl, tm);
            build(v * 2 + 1, tm + 1, tr);
            t[v] = t[v * 2] + t[v * 2 + 1];
        }
    }

    public static long sum1(int v, int tl, int tr, int l, int r) {
        if (l > r)
            return 0;
        if (l == tl && r == tr)
            return t[v];
        int tm = (tl + tr) / 2;
        return sum1(v * 2, tl, tm, l, Math.min(r, tm))
                + sum1(v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r);
    }

    public static void update(int v, int tl, int tr, int pos, int new_val) {
        if (tl == tr)
            t[v] = new_val;
        else {
            int tm = (tl + tr) / 2;
            if (pos <= tm)
                update(v * 2, tl, tm, pos, new_val);
            else
                update(v * 2 + 1, tm + 1, tr, pos, new_val);
            t[v] = t[v * 2] + t[v * 2 + 1];
        }
    }


    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}