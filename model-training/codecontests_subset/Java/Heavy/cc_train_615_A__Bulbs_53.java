//package CodeForces.Round338;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by ilya on 08.01.16.
 */

public class A615 {
    public static void main(String[] args) {
        sc sc = new sc();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] l = new int[m];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            for (int j = 0; j < x; j++) {
                l[sc.nextInt()-1]++;
            }
        }
        Arrays.sort(l);
        if (l[0] == 0) out.println("NO");
        else out.print("YES");
        out.close();
    }

    public static class sc {
        BufferedReader br;
        StringTokenizer st;

        public sc() {
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

        Integer nextInt() {
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

