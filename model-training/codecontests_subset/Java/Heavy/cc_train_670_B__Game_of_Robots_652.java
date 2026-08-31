// package y2019.m10.d22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B670 {
    public static void main(String[] args) {
        FastReader s = new FastReader();
        int n = s.nextInt();
        int k = s.nextInt();
        int[] id = new int[n];
        int sum_i=0, res=0;
        boolean fountIt=false;
        for (int i = 0; i < n; i++) {
            id[i] = s.nextInt();
            sum_i+=(i+1);
            if(!fountIt && sum_i>=k)
            {
                res=id[i-(sum_i-k)];
                fountIt = true;
            }
        }
        System.out.println(res);
    }

    //////////////////////////////////////////


    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine() {
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
