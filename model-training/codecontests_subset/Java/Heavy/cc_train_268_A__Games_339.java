//package Round_164;

import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class a {

    int a[][];
    int n;
    
    void r(){
        int ans = 0;
        for (int i = 0; i<n; i++)
            for (int j = 0; j<n; j++){
                if (i == j) continue;
                if (a[i][0] == a[j][1]) ans++;
            }
        
        out.println(ans);

    }
    
    void solve() throws Exception {
        n = in.nextInt();
        a = new int[n][2];
        for (int i = 0; i<n; i++){
            a[i][0] =in.nextInt();
            a[i][1] = in.nextInt();
        }
                
        r();
        
        
        
        

    }

    FastScanner in;
    PrintWriter out;

    String input = "";
    String output = "";

    void run() {
        try {
            if (input.length() > 0) {
                in = new FastScanner(new BufferedReader(new FileReader(input)));
            } else
                in = new FastScanner(new BufferedReader(new InputStreamReader(
                        System.in)));
            if (output.length() > 0)
                out = new PrintWriter(new FileWriter(output));
            else
                out = new PrintWriter(System.out);

            solve();

            out.flush();
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            out.flush();
            out.close();
        } finally {
            out.close();
        }
    }

    public static void main(String[] args) {
        new a().run();
    }

    class FastScanner {
        BufferedReader bf;
        StringTokenizer st;

        public FastScanner(BufferedReader bf) {
            this.bf = bf;
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(bf.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public String nextLine() throws IOException {
            return bf.readLine();
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

    }

}
