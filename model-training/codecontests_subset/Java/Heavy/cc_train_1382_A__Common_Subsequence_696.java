

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int tt = sc.nextInt();
        while (tt-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; ++i){
                int a = sc.nextInt();
                set.add(a);
            }
            int item = -1;
            boolean found = false;
            for (int i = 0; i < m; ++i){
                int a = sc.nextInt();
                if(!found && set.contains(a)){
                    item = a;
                    found = true;
                }
            }

            if(found)
                System.out.println("YES\n1 " + item );
            else
                System.out.println("NO");
        }
    }

    private static class FastReader {
        private BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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
