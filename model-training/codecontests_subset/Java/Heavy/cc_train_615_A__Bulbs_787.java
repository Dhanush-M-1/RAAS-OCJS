/**
 * Created by shambala on 08/01/16.
 */

import java.util.*;
import java.io.*;

public class TaskA {

    FastScanner in;
    PrintWriter out;


    public void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] count = new int[m];
        for (int i = 0; i<n; i++) {
            int x = in.nextInt();
            for (int j = 0; j<x; j++) {
                int l = in.nextInt()-1;
                count[l]+=1;
            }
        }
        for (int v : count) {
            if (v==0) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public void run() {
        try {
            in = new FastScanner();
            //out = new PrintWriter(new File(".out"));

            solve();

            //out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
    }

    public static void main(String[] arg) {
        new TaskA().run();
    }
}
