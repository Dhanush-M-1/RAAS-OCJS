import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * http://codeforces.com/contest/1334/problem/D
 */
public class TaskD {

    public static void main(String[] arg) {
        final FastScanner in = new FastScanner(System.in);
        final PrintWriter out = new PrintWriter(System.out);
        final int T = in.nextInt();
        for(int t=0;t<T;t++){
            final int n = in.nextInt();
            final long l = in.nextLong();
            final long r = in.nextLong();
            //final int []  result = naive(n, l, r);
            final int [] result = sol(n, l, r);
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<result.length;i++){
                sb.append(result[i]).append(" ");
            }
            out.printf("%s%n",sb.toString());
        }
        out.close();
        in.close();
    }

    private static int [] sol(final int n, final long l, final long r){
        final int [] result = new int[(int)(r-l+1)];
        long ind = 1;
        long s = 1;
        for(int i=1;i<n;i++){
            long e = s+2*(n-i)-1;
            if(s<=l&&e>=l){
                ind = s;
                while(ind<=r&&i<n) {
                    for (int j = i + 1; j <= n; j++) {
                        if (ind >= l && ind <= r) {
                            result[(int) (ind - l)] = i;
                        }
                        ind++;
                        if (ind >= l && ind <= r) {
                            result[(int) (ind - l)] = j;
                        }
                        ind++;
                    }
                    i++;
                }
                break;
            }
            s=e+1;
        }
        if(result[result.length-1]==0){
            result[result.length-1]=1;
        }
        return result;
    }

    private static int [] naive(final int n, final long l, final long r){
        final int [] result = new int[(int)(r-l+1)];
        long ind = 1;
        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                if(ind>=l&&ind<=r){
                    result[(int)(ind-l)]=i;
                }
                ind++;
                if(ind>=l&&ind<=r){
                    result[(int)(ind-l)]=j;
                }
                ind++;
            }
        }
        if(ind>=l&&ind<=r){
            result[(int)(ind-l)]=1;
        }
        ind++;
        return result;
    }

    private static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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

        int[] readIntArr(int n) {
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = Integer.parseInt(next());
            }
            return result;
        }

        void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        long nextLong() {
            return Long.parseLong(next());
        }

    }
}
