import java.io.*;
import java.util.*;

public class c {
    public static void main(final String[] args) {
        final FastReader s=new FastReader();
        int r1 = s.nextInt();
        int r2 = s.nextInt();
        int c1 = s.nextInt();
        int c2 = s.nextInt();
        int d1 = s.nextInt();
        int d2 = s.nextInt();
        
        int[][] res;
        for(int i=1;i<=9;i++) {
            res = check(i, r1, r2, c1, c2, d1, d2);
            if(res!=null) {
                print(res);
                return;
            }
        }
        System.out.println("-1");
    }

    private static int[][] check(int i, int r1, int r2, int c1, int c2, int d1, int d2) {
        int[][] res = new int[2][2];
        res[0][0] = i;
        res[0][1] = r1 - i;
        res[1][1] = c2 - res[0][1];
        res[1][0] = r2 - res[1][1];
        if(res[0][0]<10 && res[0][0]>0
            && res[0][1]<10 && res[0][1]>0
            && res[1][0]<10 && res[1][0]>0
            && res[1][1]<10 && res[1][1]>0
            && res[0][0]+res[1][0] == c1
            && res[0][0]+res[1][1] == d1
            && res[0][1]+res[1][0] == d2
            && res[0][0] != res[0][1]
            && res[0][0] != res[1][0]
            && res[0][0] != res[1][1]
            && res[0][1] != res[1][0]
            && res[0][1] != res[1][1]
            && res[1][0] != res[1][1])
                return res;
        return null;
    }

    private static void print(int[][] res) {
        System.out.println(res[0][0]+" "+res[0][1]);
        System.out.println(res[1][0]+" "+res[1][1]);
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (final IOException  e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch (final IOException e) { e.printStackTrace(); }
            return str;
        }
    }
}