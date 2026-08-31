import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int T = 0, type = 1;
        if(type == 0) T = fs.nextInt();
        else if(type == 1) T = 1;
        for(int t=0;t<T;t++) algo(fs);
    }

    public static void algo(FastScanner fs) {
        int E = 1000000007;
        int N = fs.nextInt();
        long ans1 = 1;
        long ans2 = 1;
        for(int i=1;i<=N-1;i++) {
            ans1 = (ans1 * i)%E;
            ans2 = (ans2 * 2)%E;
        }
        ans1 = (ans1 * N)%E;
        long ans = (ans1 - ans2);
        if(ans < 0) ans += E;
        System.out.println(ans);
    }

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
