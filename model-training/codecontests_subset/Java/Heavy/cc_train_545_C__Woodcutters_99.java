import java.io.*;
import java.util.*;

public class A {
    static FastReader f = new FastReader();

    public static void main(String[] args) {
        int n = f.nextInt();
        Pair[] arr = new Pair[n];
        for(int i=0;i<n;i++) {
            arr[i] = new Pair(f.nextInt(), f.nextInt());
        }

        int ans = 0;
        long last = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            if(last < arr[i].x-arr[i].h) {
                ans++;
                last = arr[i].x;
            } else {
                if(i+1 == n) {
                    ans++;
                } else if(arr[i].x+arr[i].h < arr[i+1].x) {
                    ans++;
                    last = arr[i].x+arr[i].h;
                } else {
                    last = arr[i].x;
                }
            }
        }

        System.out.println(ans);
    }

    static class Pair {
        long x;
        long h;

        Pair(int x, int h) {
            this.x = x;
            this.h = h;
        }

    }


    //fast input reader
    static class FastReader
    {
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
                catch (IOException e)
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