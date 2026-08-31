import java.io.*;
import java.util.*;

public class Solver {

    public static void main(String[] args) {
        FastReader in = new FastReader();

        int t = in.nextInt();
        while (t-- > 0) {
            solve(in);
        }
    }

    public static void solve(FastReader in) {
        int n=in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i]=in.nextInt();
        }

        System.out.println(a[0]+a[1]<=a[n-1]? (1+" "+2+" "+n):-1);
    }

    public static void printArray(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    static class Pair {
        public int a, b;

        Pair(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        private FastReader() {
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