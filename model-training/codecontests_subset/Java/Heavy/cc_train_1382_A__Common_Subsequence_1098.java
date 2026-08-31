//package Practice_L1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_1382A {
    static final FS sc = new FS();
    static final PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = sc.nextArray(n);
            int[] b = sc.nextArray(m);
            Arrays.sort(a);
            Arrays.sort(b);
            int p = 0, q = 0;
            int val = 0;
            StringBuilder sb = new StringBuilder();
            while(p<n && q<m){
                if(a[p]==b[q]){
                    val++;
                    sb.append(a[p]+" ");
                    break;
                }
                else{
                    if(a[p]<b[q]) p++;
                    else if(a[p]>b[q]) q++;
                }
            }
            if(val==0) System.out.println("NO");
            else{
                System.out.println("YES");
                System.out.println(val+" "+sb.toString());
            }
        }
    }

    static class FS {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception ignored) {
                }
            }
            return st.nextToken();
        }

        int[] nextArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
