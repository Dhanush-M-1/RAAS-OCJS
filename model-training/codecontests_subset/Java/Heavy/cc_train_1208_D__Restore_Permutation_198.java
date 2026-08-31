
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy Phan
 */
public class d {

    public static void main(String[] args) {
        FS in = new FS(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        
        BIT bit = new BIT(n+1);
        for(int i = 1; i <= n; i++) bit.update(i, i);
        int[] perm = new int[n];
        for(int i = n-1; i >= 0; i--) {
            int ind = bit.getKth(arr[i]);
            perm[i] = ind;
            bit.update(ind, -ind);
        }

        for(int i = 0; i < n; i++) out.print(perm[i] + " ");
        out.println();
        out.close();
    }//@

    static class BIT {

        int n;
        long[] tree;

        public BIT(int n) {
            this.n = n;
            tree = new long[n + 1];
        }

        int read(int i) {
            i++;
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }

        void update(int i, long val) {
            i++;
            while (i <= n) {
                tree[i] += val;
                i += i & -i;
            }
        }

        // if the BIT is a freq array, returns the
        // index of the kth item, or n if there are fewer
        // than k items.
        
        int getKth(long k) {
            int e = Integer.highestOneBit(n), o = 0;
            for (; e != 0; e >>= 1) {
                if (e + o <= n && tree[e + o] <= k) {
                    k -= tree[e + o];
                    o += e;
                }
            }
            return o;
        }

    }

    static class FS {

        BufferedReader in;
        StringTokenizer token;

        public FS(InputStream str) {
            in = new BufferedReader(new InputStreamReader(str));
        }

        public String next() {
            if (token == null || !token.hasMoreElements()) {
                try {
                    token = new StringTokenizer(in.readLine());
                } catch (IOException ex) {
                }
                return next();
            }
            return token.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
