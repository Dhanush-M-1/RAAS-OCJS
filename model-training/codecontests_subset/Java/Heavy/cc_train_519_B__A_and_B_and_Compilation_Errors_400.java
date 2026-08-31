

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class dsal2 {
    static class coordinates {
        int x, y;

        coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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

    static class friends {
        int a, b, t;

        friends(int t, int a, int b) {
            this.t = t;
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
//        Scan = new Scanner(System.in);
        FastReader fr = new FastReader();
        StringBuffer ans = new StringBuffer();
//        int t = fr.nextInt();
////
//        while (t-- > 0)
//        {
//
//        }
        int n=fr.nextInt();
        long sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=fr.nextLong();
        }
        long sum2=0;
        for(int i=0;i<n-1;i++)
        {
            long t=fr.nextLong();
            sum2+=t;
            sum-=t;
        }
        for(int i=0;i<n-2;i++)
        {
            long t=fr.nextLong();

            sum2-=t;
        }
        System.out.println(sum+"\n"+sum2);
//        System.out.println(ans);

    }


}
